package com.draconomicon.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.draconomicon.api.model.StockEquipement;
import com.draconomicon.api.repository.StockEquipementRepository;

import lombok.Data;

@Data
@Service
public class StockEquipementService {
	@Autowired
	private StockEquipementRepository stockEquipementRepository;
	
	public Optional<StockEquipement> getStockEquipement(final Long id){
		return stockEquipementRepository.findById(id);
	}
	public Iterable<StockEquipement> getStockEquipement() {
		return stockEquipementRepository.findAll();
	}
	public void deleteStockEquipement(final Long id) {
		stockEquipementRepository.deleteById(id);
	}
	public StockEquipement saveStockEquipement(StockEquipement stockEquipement) {
		StockEquipement savedStockEquipement = stockEquipementRepository.save(stockEquipement);
		return savedStockEquipement;
	}
}
