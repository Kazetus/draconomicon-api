package com.draconomicon.api.controller;

import java.util.Optional;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.draconomicon.api.model.Profil;
import com.draconomicon.api.service.ProfilService;

@RestController
public class profilController {
	
	@Autowired
	private ProfilService profilService;
	
	@GetMapping("/profils")
	public String getProfil() {
		return new Gson().toJson(profilService.getProfil());
	}
	
	@GetMapping("/profils/{id}")
	public String getProfil(@PathVariable("id") final Long id){
		Optional<Profil> profil = profilService.getProfil(id);
		if(profil.isPresent()) {
			return new Gson().toJson(profil.get());
		} else {
			return null;
		}
	}
	@PostMapping("/profils")
	public Profil createProfil(@RequestBody Profil profil) {
		return profilService.saveProfil(profil);
	}
	@PutMapping("/profils/{id}")
	public Profil updateProfil(@PathVariable("id") final Long id, @RequestBody Profil profil) {
		Optional<Profil> e = profilService.getProfil(id);
		if(e.isPresent()) {
			Profil currentProfil = e.get();
			
			String pseudo = profil.getPseudo();
			if(pseudo != null) {
				currentProfil.setPseudo(pseudo);
			}
			String mail = profil.getMail();
			if(mail != null) {
				currentProfil.setMail(mail);;
			}
			boolean mineurMajeur = profil.getMineurMajeur();
			currentProfil.setMineurMajeur(mineurMajeur);
			String password = profil.getPassword();
			if(password != null) {
				currentProfil.setPassword(password);
			}
			int age = profil.getAge();
			if(age != 0) {
				currentProfil.setAge(age);
			}
			boolean genreProfil = profil.getGenreProfil();
			currentProfil.setGenreProfil(genreProfil);
			int idRole = profil.getIdRole();
			if(idRole != 0) {
				currentProfil.setIdRole(idRole);
			}
			profilService.saveProfil(currentProfil);
			return currentProfil;
		} else {
			return null;
		}
	}
	@PatchMapping("/profils/{id}")
	public Profil patchProfil(@PathVariable("id") final Long id, @RequestBody Profil profil){
		Optional<Profil> e = profilService.getProfil(id);
		if(e.isPresent()) {
			Profil currentProfil = e.get();
			
			String pseudo = profil.getPseudo();
			String mail = profil.getMail();
			String password = profil.getPassword();
			int age = profil.getAge();
			int idRole = profil.getIdRole();
			boolean genreProfil = profil.getGenreProfil();
			boolean mineurMajeur = profil.getMineurMajeur();
			if(pseudo != null && mail != null && password != null && age != 0 && idRole != 0) {
				currentProfil.setPseudo(pseudo);
				currentProfil.setMail(mail);
				currentProfil.setMineurMajeur(mineurMajeur);
				currentProfil.setPassword(password);
				currentProfil.setAge(age);
				currentProfil.setGenreProfil(genreProfil);
				profilService.saveProfil(currentProfil);
			return currentProfil;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	@DeleteMapping("/profils/{id}")
	public void deleteProfil(@PathVariable("id") final Long id) {
		profilService.deleteProfil(id);
	}
}