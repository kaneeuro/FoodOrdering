package com.sadic.myfastfood.metier;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sadic.myfastfood.dao.CommandeRepository;
import com.sadic.myfastfood.dao.CompteRepository;
import com.sadic.myfastfood.dao.EmployeRepository;
import com.sadic.myfastfood.entities.Commande;
import com.sadic.myfastfood.entities.Employe;

@RestController
public class CommandeController {

	@Autowired
	CommandeRepository commandeRepository;
	@Autowired
	CompteRepository compteRepository;

	@RequestMapping(value="/commandes", method=RequestMethod.GET)
	public List<Commande> findAll() {
		return commandeRepository.findAll();
	}
	
	@RequestMapping(value="/commandes/{id}", method=RequestMethod.GET)
	public Commande findOne(@PathVariable Long id) {
		return commandeRepository.findOne(id);
	}
	
	@RequestMapping(value="/commandesbystatut/{statut}", method=RequestMethod.GET)
	public List<Commande> findByStatut(@PathVariable int statut) {
		return commandeRepository.findByStatut(statut);
	}
	
	@RequestMapping(value="/commandesbycomptable", method=RequestMethod.POST)
	public List<Commande> findByComptable(@RequestBody Employe comptable) {
		return commandeRepository.findByComptable(comptable);
	}
	
	@RequestMapping(value="/comptableCommandesDuJour/{comptable}", method=RequestMethod.GET)
	public List<Commande> comptableCommandesDuJour(@PathVariable(name="comptable") String login) {
		SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
		String date = sf.format(new Date()).substring(0, 10);
		return commandeRepository.comptableCommandesDuJour(compteRepository.findByLogin(login).getEmploye(), date+"%");
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
