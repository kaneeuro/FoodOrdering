package com.sadic.myfastfood.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sadic.myfastfood.dao.CommandeArticleTemporaireRepository;
import com.sadic.myfastfood.dao.TablesRepository;
import com.sadic.myfastfood.entities.CommandeArticleTemporaire;
import com.sadic.myfastfood.entities.Employe;

@RestController
public class CommandeArticleTemporaireController {

	@Autowired
	CommandeArticleTemporaireRepository temporaireRepository;
	@Autowired
	TablesRepository tablesRepository;
	
	@RequestMapping(value="/temporaires", method=RequestMethod.GET)
	public List<CommandeArticleTemporaire> findAll() {
		return temporaireRepository.findAll();
	}
	
	@RequestMapping(value="/temporaires/{id}", method=RequestMethod.GET)
	public CommandeArticleTemporaire findOne(@PathVariable Long id) {
		return temporaireRepository.findOne(id);
	}
	
	@RequestMapping(value="/articlestemporaires", method=RequestMethod.POST)
	public List<CommandeArticleTemporaire> findByEmploye(@RequestBody Employe employe) {
		return temporaireRepository.findByEmploye(employe);
	}
	
	@RequestMapping(value="/temporaires", method=RequestMethod.POST)
	public CommandeArticleTemporaire save(@RequestBody CommandeArticleTemporaire articleTemporaire) {
		return temporaireRepository.save(articleTemporaire);
	}
	
	@RequestMapping(value="/temporaires/{id}", method=RequestMethod.PUT)
	public CommandeArticleTemporaire update(@PathVariable Long id, @RequestBody CommandeArticleTemporaire articleTemporaire) {
		articleTemporaire.setIdCommandeArticleTemporaire(id);
		return temporaireRepository.save(articleTemporaire);
	}
	
	@RequestMapping(value="/temporaires/{id}", method=RequestMethod.DELETE)
	public boolean delete(@PathVariable Long id) {
		try {
			temporaireRepository.delete(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@RequestMapping(value="/temporaires", method=RequestMethod.DELETE)
	public boolean deleteAll(@RequestBody List<CommandeArticleTemporaire> temporaires) {
		try {
			temporaireRepository.delete(temporaires);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
