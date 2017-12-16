package com.sadic.myfastfood.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sadic.myfastfood.dao.CommandeArticleRepository;
import com.sadic.myfastfood.dao.CommandeRepository;
import com.sadic.myfastfood.dao.TablesRepository;
import com.sadic.myfastfood.entities.Commande;
import com.sadic.myfastfood.entities.CommandeArticle;

@RestController
public class CommandeArticleController {

	@Autowired
	CommandeArticleRepository commandeArticleRepository;
	@Autowired
	CommandeRepository commandeRepository;
	@Autowired
	TablesRepository tablesRepository;

	@RequestMapping(value="/commandearticles", method=RequestMethod.GET)
	public List<CommandeArticle> findAll() {
		return commandeArticleRepository.findAll();
	}
	
	@RequestMapping(value="/commandearticles/{id}", method=RequestMethod.GET)
	public CommandeArticle findOne(@PathVariable Long id) {
		return commandeArticleRepository.findOne(id);
	}
	
	@RequestMapping(value="/articlesbycommande/{id}", method=RequestMethod.GET)
	public List<CommandeArticle> findByCommande(@PathVariable Long id) {
		return commandeArticleRepository.findByCommande(commandeRepository.findByNumero(id));
	}

	@RequestMapping(value="/commandearticles", method=RequestMethod.POST)
	@Transactional
	public List<CommandeArticle> save(@RequestBody List<CommandeArticle> commandeArticles) {
		commandeArticles.get(0).getCommande().setDate(new Date());
		commandeArticles.get(0).getCommande().setTable(tablesRepository.findByNumero(1));
		Commande commande = commandeRepository.save(commandeArticles.get(0).getCommande());
		for (CommandeArticle commandeArticle : commandeArticles) {
			commandeArticle.setCommande(commande);
		}
		return commandeArticleRepository.save(commandeArticles);
	}
	
	@RequestMapping(value="/commandearticles/{id}", method=RequestMethod.PUT)
	public CommandeArticle update(@PathVariable Long id, @RequestBody CommandeArticle commandeArticle) {
		commandeArticle.setIdCommandeArticle(id);
		return commandeArticleRepository.save(commandeArticle);
	}
	
	@RequestMapping(value="/commandearticles/{id}", method=RequestMethod.DELETE)
	public boolean delete(@PathVariable Long id) {
		try {
			commandeArticleRepository.delete(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
