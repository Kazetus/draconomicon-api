package com.draconomicon.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.draconomicon.api.model.Profil;

public interface ProfilRepository extends JpaRepository<Profil, Long> {
	Optional<Profil> findByUsername(String username);
}
