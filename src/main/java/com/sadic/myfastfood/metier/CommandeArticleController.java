package com.sadic.myfastfood.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sadic.myfastfood.dao.CommandeArticleRepository;
import com.sadic.myfastfood.entities.CommandeArticle;

@RestController
public class CommandeArticleController {

	@Autowired
	CommandeArticleRepository commandeArticleRepository;

	@RequestMapping(value="/commandearticles", method=RequestMethod.GET)
	public List<CommandeArticle> findAll() {
		return commandeArticleRepository.findAll();
	}
	
	@RequestMapping(value="/commandearticles/{id}", method=RequestMethod.GET)
	public CommandeArticle findOne(@PathVariable Long id) {
		return commandeArticleRepository.findOne(id);
	}
	
	@RequestMapping(value="/commandearticles", method=RequestMethod.POST)
	public CommandeArticle save(@RequestBody CommandeArticle commandeArticle) {
		return commandeArticleRepository.save(commandeArticle);
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
