package com.unla.grupo1oo22020.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.io.Serializable;

import com.unla.grupo1oo22020.entities.SolicitudStock;

@Repository("solicitudStockRepository")
public interface ISolicitudStockRepository extends JpaRepository<SolicitudStock, Serializable> {
	
	public abstract SolicitudStock findByIdSolicitudStock(long idSolicitudStock);
}
