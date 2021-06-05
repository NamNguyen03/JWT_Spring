package com.namNguyen03.springSecurityJWT.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import com.namNguyen03.springSecurityJWT.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	Optional<User> findByUsername(String username);

	boolean existsByUsername(String username);

}
