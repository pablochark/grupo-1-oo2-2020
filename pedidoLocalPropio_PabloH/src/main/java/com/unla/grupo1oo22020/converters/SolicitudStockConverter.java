package com.unla.grupo1oo22020.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.grupo1oo22020.entities.SolicitudStock;
import com.unla.grupo1oo22020.models.SolicitudStockModel;

@Component("solicitudStockConverter")
public class SolicitudStockConverter {

	@Autowired()
	@Qualifier("productoConverter")
	private ProductoConverter productoConverter;

	@Autowired()
	@Qualifier("localConverter")
	private LocalConverter localConverter;

	public SolicitudStockModel entityToModel(SolicitudStock solicitudStock) {
		return new SolicitudStockModel(solicitudStock.getIdSolicitudStock(), solicitudStock.getFechaSolicitudStock(),
				productoConverter.entityToModel(solicitudStock.getProducto()), solicitudStock.getCantidad(), solicitudStock.isAceptado(),
				localConverter.entityToModel(solicitudStock.getLocal()));
	}
	
	public SolicitudStock modelToEntity(SolicitudStockModel solicitudStockModel) {
		return new SolicitudStock(solicitudStockModel.getIdSolicitudStock(), solicitudStockModel.getFechaSolicitudStock(),
				productoConverter.modelToEntity(solicitudStockModel.getProducto()), solicitudStockModel.getCantidad(), localConverter.modelToEntity(solicitudStockModel.getLocal()));
	}

}
