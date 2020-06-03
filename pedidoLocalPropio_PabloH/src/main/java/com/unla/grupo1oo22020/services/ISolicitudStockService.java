package com.unla.grupo1oo22020.services;

import com.unla.grupo1oo22020.models.SolicitudStockModel;

import java.util.List;

import com.unla.grupo1oo22020.entities.SolicitudStock;

public interface ISolicitudStockService {
	
	// HACER INSERT, UPDATE, GETALL, REMOVE

	public List<SolicitudStock> getAll();
	
	public SolicitudStockModel insert(SolicitudStockModel solicitudStockModel);
	
	public SolicitudStockModel update(SolicitudStockModel solicitudStockModel);
	
	public boolean remove(long idSolicitudStock);
	

}
