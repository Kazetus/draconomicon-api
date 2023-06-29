package com.draconomicon.api.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.draconomicon.api.model.Profil;
import com.draconomicon.api.repository.ProfilRepository;

import lombok.Data;

@Data
@Service
public class ProfilService {
	
	@Autowired
	private ProfilRepository profilRepository;
	
	public Optional<Profil> getProfil(final Long id){
		return profilRepository.findById(id);
	}
	public Iterable<Profil> getProfil() {
		return profilRepository.findAll();
	}
	public void deleteProfil(final Long id) {
		profilRepository.deleteById(id);
	}
	public Profil saveProfil(Profil profil) {
		Profil savedProfil = profilRepository.save(profil);
		return savedProfil;
	}
}
