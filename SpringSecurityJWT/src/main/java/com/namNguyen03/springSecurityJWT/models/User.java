package com.namNguyen03.springSecurityJWT.models;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.*;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
	@Id
	private int id;
	private String username;
	private String password;
	private String fullname;
	private String email;
	private String phone;
	private String address;
	@ManyToOne()
    @JoinColumn(name="role")
    private Role role;
}
