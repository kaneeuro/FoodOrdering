package com.sadic.myfastfood.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sadic.myfastfood.dao.CategorieRepository;
import com.sadic.myfastfood.entities.Categorie;

@RestController
public class CategorieController {

	@Autowired
	CategorieRepository categorieRepository;

	@RequestMapping(value="/categories", method=RequestMethod.GET)
	public List<Categorie> findAll() {
		return categorieRepository.findAll();
	}
	
	@RequestMapping(value="/categories/{id}", method=RequestMethod.GET)
	public Categorie findOne(@PathVariable Long id) {
		return categorieRepository.findOne(id);
	}
	
	@RequestMapping(value="/categories", method=RequestMethod.POST)
	public Categorie save(@RequestBody Categorie catalogue) {
		return categorieRepository.save(catalogue);
	}
	
	@RequestMapping(value="/categories/{id}", method=RequestMethod.PUT)
	public Categorie update(@PathVariable Long id, @RequestBody Categorie categorie) {
		categorie.setIdCategorie(id);
		return categorieRepository.save(categorie);
	}
	
	@RequestMapping(value="/categories/{id}", method=RequestMethod.DELETE)
	public boolean delete(@PathVariable Long id) {
		try {
			categorieRepository.delete(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
