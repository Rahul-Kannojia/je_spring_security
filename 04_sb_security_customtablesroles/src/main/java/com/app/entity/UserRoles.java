package com.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="roles")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRoles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	private String name;
	
}
