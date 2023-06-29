package com.draconomicon.api.model;

import jakarta.persistence.Column;
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
@Table(name = "profil")
public class Profil {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long idProfil;
	
	@Column(name="mineur_majeur")
	 private Boolean mineurMajeur;
	

	
	@Column(name="genre_profil")
	 private Boolean genreProfil;
	
	@Column(name="id_role")
	 private int idRole;
	
	 private String pseudo;
	 private int age;
	 private String mail;
	 private String password;
}
