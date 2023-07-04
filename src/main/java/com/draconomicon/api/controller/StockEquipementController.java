package com.draconomicon.api.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.draconomicon.api.model.StockEquipement;
import com.draconomicon.api.service.StockEquipementService;

@RestController
public class StockEquipementController {
	@Autowired
	private StockEquipementService stockEquipementService;
	
	@GetMapping("/stockEquipements")
	public Iterable<StockEquipement> getStockEquipement() {
		return stockEquipementService.getStockEquipement();
	}
	
	@GetMapping("/stockEquipements/{id}")
	public StockEquipement getStockEquipement(@PathVariable("id") final Long id){
		Optional<StockEquipement> stockEquipement = stockEquipementService.getStockEquipement(id);
		if(stockEquipement.isPresent()) {
			return stockEquipement.get();
		} else {
			return null;
		}
	}
	@PostMapping("/stockEquipements")
	public StockEquipement createStockEquipement(@RequestBody StockEquipement stockEquipement) {
		//stockEquipement.setPassword(passwordEncoder.encode(stockEquipement.getPassword()));
		return stockEquipementService.saveStockEquipement(stockEquipement);
	}
	@PutMapping("/stockEquipements/{id}")
	public StockEquipement updateStockEquipement(@PathVariable("id") final Long id, @RequestBody StockEquipement stockEquipement) {
		//stockEquipement.setPassword(passwordEncoder.encode(stockEquipement.getPassword()));
		Optional<StockEquipement> e = stockEquipementService.getStockEquipement(id);
		if(e.isPresent()) {
			StockEquipement currentStockEquipement = e.get();
			
			int idEquipement = stockEquipement.getIdEquipement();
			if(idEquipement != 0) {
				currentStockEquipement.setIdEquipement(idEquipement);
			}
			int IdStock = stockEquipement.getIdStock();
			if(IdStock != 0) {
				currentStockEquipement.setIdStock(IdStock);
			}
			stockEquipementService.saveStockEquipement(currentStockEquipement);
			return currentStockEquipement;
		} else {
			return null;
		}
	}
	@PatchMapping("/stockEquipements/{id}")
	public StockEquipement patchStockEquipement(@PathVariable("id") final Long id, @RequestBody StockEquipement stockEquipement){
		//stockEquipement.setPassword(passwordEncoder.encode(stockEquipement.getPassword()));		
		Optional<StockEquipement> e = stockEquipementService.getStockEquipement(id);
		if(e.isPresent()) {
			StockEquipement currentStockEquipement = e.get();
			
			int idEquipement = stockEquipement.getIdEquipement();
			int idStock = stockEquipement.getIdStock();
			if(idEquipement != 0 && idStock != 0) {
				currentStockEquipement.setIdEquipement(idEquipement);
				currentStockEquipement.setIdStock(idStock);
				stockEquipementService.saveStockEquipement(currentStockEquipement);
			return currentStockEquipement;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	@DeleteMapping("/stockEquipements/{id}")
	public void deleteStockEquipement(@PathVariable("id") final Long id) {
		stockEquipementService.deleteStockEquipement(id);
	}
}
