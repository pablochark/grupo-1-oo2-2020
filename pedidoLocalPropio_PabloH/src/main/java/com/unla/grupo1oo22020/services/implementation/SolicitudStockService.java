package com.unla.grupo1oo22020.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo1oo22020.converters.SolicitudStockConverter;
import com.unla.grupo1oo22020.entities.SolicitudStock;
import com.unla.grupo1oo22020.models.SolicitudStockModel;
import com.unla.grupo1oo22020.repositories.ISolicitudStockRepository;
import com.unla.grupo1oo22020.services.ISolicitudStockService;
import com.unla.grupo1oo22020.services.ILocalService;
import com.unla.grupo1oo22020.services.IProductoService;

@Service("solicitudStockService")
public class SolicitudStockService implements ISolicitudStockService{
	
	// HACER INSERT, UPDATE, GETALL, REMOVE
	
	@Autowired
	@Qualifier("solicitudStockService")
	private ISolicitudStockService solicitudStockService;
	
	@Autowired
	@Qualifier("localService")
	private ILocalService localService;
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
	
	@Autowired
	@Qualifier("solicitudStockRepository")
	private ISolicitudStockRepository solicitudStockRepository;
	
	@Autowired
	@Qualifier("solicitudStockConverter")
	private SolicitudStockConverter solicitudStockConverter;
	
	@Override
	public SolicitudStockModel insert(SolicitudStockModel solicitudStockModel) {
		solicitudStockModel.setLocal(localService.findByIdLocal(solicitudStockModel.getLocal().getIdLocal()));
		solicitudStockModel.setProducto(productoService.findByIdProducto(solicitudStockModel.getProducto().getIdProducto()));
		SolicitudStock solicitudStock = solicitudStockRepository.save(solicitudStockConverter.modelToEntity(solicitudStockModel));
		return solicitudStockConverter.entityToModel(solicitudStock);
	}

	@Override
	public List<SolicitudStock> getAll() {
		return solicitudStockRepository.findAll();
	}

	@Override
	public SolicitudStockModel update(SolicitudStockModel solicitudStockModel) {
		solicitudStockModel.setLocal(localService.findByIdLocal(solicitudStockModel.getLocal().getIdLocal()));
		solicitudStockModel.setProducto(productoService.findByIdProducto(solicitudStockModel.getProducto().getIdProducto()));
		SolicitudStock solicitudStock = solicitudStockRepository.save(solicitudStockConverter.modelToEntity(solicitudStockModel));
		return solicitudStockConverter.entityToModel(solicitudStock);
	}

	@Override
	public boolean remove(long idSolicitudStock) {
		try {
			solicitudStockRepository.deleteById(idSolicitudStock);
			return true;
		} catch (Exception e) {
			return false;

		}
	}

}
