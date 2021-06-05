package com.namNguyen03.springSecurityJWT.models;



import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.namNguyen03.springSecurityJWT.models.Enum.ERole;

import lombok.*;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "roles")
public class Role {
	@Id
    private int id;
	@Enumerated(EnumType.STRING)
    private ERole name;
}
