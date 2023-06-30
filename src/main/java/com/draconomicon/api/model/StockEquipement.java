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
@Table(name = "stock_equipement")
public class StockEquipement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long idStockEquipement;
	
	@Column(name="id_stock")
	 private int idStock;
	

	
	@Column(name="id_equipement")
	 private int idEquipement;
}
