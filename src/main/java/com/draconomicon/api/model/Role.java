package com.draconomicon.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@Table(name = "role")
public class Role{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long idRole;
	 private String role;
}
