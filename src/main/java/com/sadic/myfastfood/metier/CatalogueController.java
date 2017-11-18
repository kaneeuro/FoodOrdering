package com.sadic.myfastfood.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sadic.myfastfood.dao.CatalogueRepository;
import com.sadic.myfastfood.dao.RestaurantRepository;
import com.sadic.myfastfood.entities.Catalogue;

@RestController
public class CatalogueController {

	@Autowired
	CatalogueRepository catalogueRepository;
	@Autowired
	RestaurantRepository restaurantRepository;

	@RequestMapping(value="/catalogues", method=RequestMethod.GET)
	public List<Catalogue> findAll() {
		return catalogueRepository.findAll();
	}
	
	@RequestMapping(value="/catalogues/{id}", method=RequestMethod.GET)
	public Catalogue findOne(@PathVariable Long id) {
		return catalogueRepository.findOne(id);
	}
	
	@RequestMapping(value="/catalogues", method=RequestMethod.POST)
	public Catalogue save(@RequestBody Catalogue catalogue) {
		return catalogueRepository.save(catalogue);
	}
	
	@RequestMapping(value="/catalogues/{id}", method=RequestMethod.PUT)
	public Catalogue update(@PathVariable Long id, @RequestBody Catalogue catalogue) {
		catalogue.setIdCatalogue(id);
		return catalogueRepository.save(catalogue);
	}
	
	@RequestMapping(value="/catalogues/{id}", method=RequestMethod.DELETE)
	public boolean delete(@PathVariable Long id) {
		try {
			catalogueRepository.delete(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
