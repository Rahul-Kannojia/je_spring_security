package com.app.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users_info")
public class UserInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	private String username;
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<UserRoles> roles;
}
