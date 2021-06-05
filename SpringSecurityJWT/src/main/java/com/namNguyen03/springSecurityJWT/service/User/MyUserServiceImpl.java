package com.namNguyen03.springSecurityJWT.service.User;

import java.util.Random;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.namNguyen03.springSecurityJWT.MyException.BusinessException;
import com.namNguyen03.springSecurityJWT.models.Role;
import com.namNguyen03.springSecurityJWT.models.User;
import com.namNguyen03.springSecurityJWT.models.Enum.ERole;
import com.namNguyen03.springSecurityJWT.repositories.RoleRepository;
import com.namNguyen03.springSecurityJWT.repositories.UserRepository;
import com.namNguyen03.springSecurityJWT.security.jwt.JwtUtils;
import com.namNguyen03.springSecurityJWT.service.User.MyUserRequestModels.Register;

@Service
public class MyUserServiceImpl implements MyUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	AuthenticationManager authenticationManager;

	public MyUserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public MyUserResponseModels.JWT authenticateUser(@Valid MyUserRequestModels.Login loginRequest) throws BusinessException {
		if(!userRepository.existsByUsername(loginRequest.getUsername())) {
			throw new BusinessException("username or password incorrect");
		}
		if(!encoder.matches(loginRequest.getPassword(),userRepository.findByUsername(loginRequest.getUsername()).get().getPassword())){
			throw new BusinessException("username or password incorrect");
		}
		User user = userRepository.findByUsername(loginRequest.getUsername()).get();
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		return new MyUserResponseModels.JWT(user.getId(),
				user.getUsername(),
				user.getFullname(),
				user.getEmail(),
				user.getPhone(),
				user.getAddress(),
				user.getRole().getName().name(), jwt);
	}

	@Override
	public int register(Register rq) throws BusinessException {
		User user = mapper.map(rq, User.class);
		Random rn = new Random();
		user.setId(rn.nextInt()%100000);
		if(userRepository.existsByUsername(rq.getUsername())) {
			throw new BusinessException("username exists");
		}
		int roleId = 2;
		Role role;
		if(rq.getRole()!=null) {
			if(rq.getRole().equals(ERole.ADMIN_TRAINEE.toString())) {
				roleId = 1;
			}
			if(rq.getRole().equals(ERole.ADMIN.toString())) {
				roleId = 0;
			}
		}
		role = roleRepository.findById(roleId).get();
		user.setRole(role);
		user.setPassword( encoder.encode(rq.getPassword()));
		userRepository.save(user);
		return user.getId();
	}

}
