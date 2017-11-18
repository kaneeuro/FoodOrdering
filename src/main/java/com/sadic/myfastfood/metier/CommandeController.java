package com.sadic.myfastfood.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sadic.myfastfood.dao.CommandeRepository;
import com.sadic.myfastfood.entities.Commande;

@RestController
public class CommandeController {

	@Autowired
	CommandeRepository commandeRepository;

	@RequestMapping(value="/commandes", method=RequestMethod.GET)
	public List<Commande> findAll() {
		return commandeRepository.findAll();
	}
	
	@RequestMapping(value="/commandes/{id}", method=RequestMethod.GET)
	public Commande findOne(@PathVariable Long id) {
		return commandeRepository.findOne(id);
	}
	
	@RequestMapping(value="/commandes", method=RequestMethod.POST)
	public Commande save(@RequestBody Commande commande) {
		return commandeRepository.save(commande);
	}
	
	@RequestMapping(value="/commandes/{id}", method=RequestMethod.PUT)
	public Commande update(@PathVariable Long id, @RequestBody Commande commande) {
		commande.setIdCommande(id);
		return commandeRepository.save(commande);
	}
	
	@RequestMapping(value="/commandes/{id}", method=RequestMethod.DELETE)
	public boolean delete(@PathVariable Long id) {
		try {
			commandeRepository.delete(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
