package com.unla.grupo1oo22020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo1oo22020.helpers.ViewRouteHelpers;
import com.unla.grupo1oo22020.models.PedidoModel;
import com.unla.grupo1oo22020.models.SolicitudStockModel;
import com.unla.grupo1oo22020.services.ILocalService;
import com.unla.grupo1oo22020.services.IPedidoService;
import com.unla.grupo1oo22020.services.IProductoService;
import com.unla.grupo1oo22020.services.ISolicitudStockService;


@Controller
@RequestMapping("/solicitudStock")
public class SolicitudStockController {

	@Autowired
	@Qualifier("solicitudStockService")
	private ISolicitudStockService solicitudStockService;
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
	
	@Autowired
	@Qualifier("localService")
	private ILocalService localService;
	
	@Autowired
	@Qualifier("pedidoService")
	private IPedidoService pedidoService;
	
	@GetMapping("")
	public ModelAndView index() {
		
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.SOLICITUDSTOCK_INDEX);
		mAV.addObject("solicitudStock", solicitudStockService.getAll());
		mAV.addObject("local", localService.getAll());
		mAV.addObject("producto", localService.getAll());
		return mAV;
	}
	
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.SOLICITUDSTOCK_NEW);
		mAV.addObject("solicitudStock", new SolicitudStockModel());
		mAV.addObject("local", localService.getAll());
		mAV.addObject("producto", productoService.getAll());
		return mAV;
	}
	
	//-------------------------Generar pedido con stock
	@GetMapping("/create/")
	public RedirectView create(
			@RequestParam(value = "idVenta", required = false) long idVenta,
			@RequestParam(value = "idSucursal", required = false) long idSucursal,
			@RequestParam(value = "idProducto", required = false) long idProducto,
			@RequestParam(value = "cantidad", required = false) int cantidad) {
		
		//ventaService.generarPedidoConStockPropio(ventaService.findById(idVenta), productoService.findByIdProducto(idProducto), sucursalService.findById(idSucursal), cantidad);
		
		return new RedirectView(ViewRouteHelpers.PEDIDO_ROOT);
	}
	
	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") long id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.PEDIDO_UPDATE);
		mAV.addObject("pedido", pedidoService.findByIdPedido(id));
		mAV.addObject("productos", productoService.getAll());
		return mAV;
		
	}
	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("pedido") PedidoModel pedidoModel) {
		
		pedidoService.update(pedidoModel);
		return new RedirectView(ViewRouteHelpers.PEDIDO_ROOT);
	}
	
	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id")long id) {
		pedidoService.remove(id);
		return new RedirectView(ViewRouteHelpers.PEDIDO_ROOT);
	}
}

