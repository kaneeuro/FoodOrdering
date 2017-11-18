package com.sadic.myfastfood.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sadic.myfastfood.dao.CompteRepository;
import com.sadic.myfastfood.entities.Compte;

@RestController
public class CompteController {

	@Autowired
	CompteRepository compteRepository;

	@RequestMapping(value="/comptes", method=RequestMethod.GET)
	public List<Compte> findAll() {
		return compteRepository.findAll();
	}
	
	@RequestMapping(value="/comptes/{id}", method=RequestMethod.GET)
	public Compte findOne(@PathVariable Long id) {
		return compteRepository.findOne(id);
	}
	
	@RequestMapping(value="/comptes", method=RequestMethod.POST)
	public Compte save(@RequestBody Compte comptable) {
		return compteRepository.save(comptable);
	}
	
	@RequestMapping(value="/comptes/{id}", method=RequestMethod.PUT)
	public Compte update(@PathVariable Long id, @RequestBody Compte compte) {
		compte.setIdCompte(id);
		return compteRepository.save(compte);
	}
	
	@RequestMapping(value="/comptes/{id}", method=RequestMethod.DELETE)
	public boolean delete(@PathVariable Long id) {
		try {
			compteRepository.delete(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
