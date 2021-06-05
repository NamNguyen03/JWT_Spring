package com.namNguyen03.springSecurityJWT.models.Enum;

import java.util.Set;
import java.util.stream.Collectors;
import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum ERole {
	ADMIN(Sets.newHashSet(EPermission.ADMIN_READ,EPermission.ADMIN_WRITE,EPermission.CONSUMER)),
	ADMIN_TRAINEE(Sets.newHashSet(EPermission.ADMIN_READ,EPermission.CONSUMER)),
	CONSUMER(Sets.newHashSet(EPermission.CONSUMER));

	private final Set<EPermission> permissions;

	ERole(Set<EPermission> permissions){
		this.permissions = permissions;
	}

	Set<EPermission> getPermissions(){
		return permissions;
	}


	public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
		Set<SimpleGrantedAuthority> grants = getPermissions()
				.stream()
				.map(permission ->new SimpleGrantedAuthority(permission.getPermission()))
				.collect(Collectors.toSet());
		grants.add(new SimpleGrantedAuthority(this.name()));
		return grants;
	}

}
