package com.unla.grupo1oo22020.controllers;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo1oo22020.converters.StockConverter;
import com.unla.grupo1oo22020.helpers.ViewRouteHelpers;
import com.unla.grupo1oo22020.models.LoteModel;
import com.unla.grupo1oo22020.services.ILocalService;
import com.unla.grupo1oo22020.services.ILoteService;
import com.unla.grupo1oo22020.services.implementation.ProductoService;
import com.unla.grupo1oo22020.services.implementation.StockService;

@Controller
@RequestMapping("/lote")
public class LoteController {
	
	@Autowired
	@Qualifier("loteService")
	private ILoteService loteService;
	
	@Autowired
	@Qualifier("productoService")
	private ProductoService productoService;
	
	@Autowired
	@Qualifier("stockService")
	private StockService stockService;
	
	@Autowired
	@Qualifier("localService")
	private ILocalService localService;
	
	@Autowired
	@Qualifier("stockConverter")
	private StockConverter stockConverter;

	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.LOTE_INDEX);
		//mAV.addObject("lote", loteService.getAll());
		mAV.addObject("lote", new LoteModel());
		mAV.addObject("locales", localService.getAll());

		return mAV;
		
	}
	
	@PostMapping("")
	public RedirectView redirect(@ModelAttribute("lote") LoteModel loteModel){
		return new RedirectView(ViewRouteHelpers.LOTE_INDEX);
		
	}
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.LOTE_NEW);
		mAV.addObject("lote", new LoteModel());
		mAV.addObject("producto", productoService.getAll());
		mAV.addObject("local", localService.getAll());
		return mAV;
	}
	
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("lote") LoteModel loteModel) {
		loteService.insert(loteModel);
		return new RedirectView(ViewRouteHelpers.LOTE_ROOT);
	}
	/*@PostMapping("/create")
	public RedirectView create(@ModelAttribute("lote") LoteModel loteModel) {
		loteModel.setCantidadIngreso(loteModel.getCantidadActual());
		loteService.insertOrUpdate(loteModel);
	StockModel stockModel =	stockService.findByIdStock(loteModel.getStock().getIdStock());
	System.out.println("Se trajo bien: " + stockService.findByIdStock(loteModel.getStock().getIdStock()).getIdStock());
		stockModel.getLotes().add(loteModel);
		stockService.insertOrUpdate(stockModel);
		System.out.println("TRAIDO: " + stockModel.getLotes().get(0).getCantidadActual());
		
		return new RedirectView(ViewRouteHelpers.LOTE_ROOT);
	}*/
	
	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") long idLote) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.LOTE_UPDATE);
		mAV.addObject("lote", loteService.findByIdLote(idLote));
		mAV.addObject("producto", productoService.getAll());
		//mAV.addObject("stocks", stockService.getAll());

		return mAV;
	}
	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("lote") LoteModel loteModel) {
	    loteService.update(loteModel);
	    return new RedirectView(ViewRouteHelpers.LOTE_ROOT);
	}

	
	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") long idLote) {
		loteService.remove(idLote);
		return new RedirectView(ViewRouteHelpers.LOTE_ROOT);
	}

	
	@PostMapping("/atras")
	public RedirectView atras() {
		
		return new RedirectView(ViewRouteHelpers.LOTE_ROOT);
	}
	



}