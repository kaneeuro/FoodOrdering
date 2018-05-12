package com.sadic.myfastfood.metier;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.sadic.myfastfood.dao.CompteRepository;
import com.sadic.myfastfood.dao.TablesRepository;
import com.sadic.myfastfood.entities.Commande;
import com.sadic.myfastfood.entities.CommandeArticle;
import com.sadic.myfastfood.entities.Employe;
import com.sadic.myfastfood.entities.Tables;

@RestController
public class CommandeArticleController {

	@Autowired
	CommandeArticleRepository commandeArticleRepository;
	@Autowired
	CommandeRepository commandeRepository;
	@Autowired
	TablesRepository tablesRepository;
	@Autowired
	CompteRepository compteRepository;

	@RequestMapping(value="/commandearticles", method=RequestMethod.GET)
	public List<CommandeArticle> findAll() {
		return commandeArticleRepository.findAll();
	}
	
	@RequestMapping(value="/commandearticles/{id}", method=RequestMethod.GET)
	public CommandeArticle findOne(@PathVariable Long id) {
		return commandeArticleRepository.findOne(id);
	}
	
	@RequestMapping(value="/articlesbycommande/{numero}", method=RequestMethod.GET)
	public List<CommandeArticle> findByCommande(@PathVariable Long numero) {
		return commandeArticleRepository.findByCommande(commandeRepository.findByNumero(numero));
	}
	
	@RequestMapping(value="/articlesbystatutcommande/{statut}", method=RequestMethod.GET)
	public List<CommandeArticle> findByStatutCommande(@PathVariable int statut) {
		List<CommandeArticle> commandeArticles = new ArrayList<>();
		List<Commande> commandes = commandeRepository.findByStatut(statut);
		if (!commandes.isEmpty()) {
			for (Commande commande : commandes) {
				commandeArticles.addAll(commandeArticleRepository.findByCommande(commande));
			}
		}
		return commandeArticles;
	}

	@RequestMapping(value="/articlesbystatutandstatutcommande/{statut}/{statutcommande}", method=RequestMethod.GET)
	public List<CommandeArticle> findByStatutAndStatutCommande(@PathVariable int statut, @PathVariable int statutcommande) {
		List<CommandeArticle> commandeArticles = new ArrayList<>();
		List<Commande> commandes = commandeRepository.findByStatut(statutcommande);
		if (!commandes.isEmpty()) {
			for (Commande commande : commandes) {
				commandeArticles.addAll(commandeArticleRepository.findByStatutAndCommande(statut, commande));
			}
		}
		return commandeArticles;
	}

	@Transactional
	@RequestMapping(value="/commandearticles", method=RequestMethod.POST)
	public List<CommandeArticle> save(@RequestBody List<CommandeArticle> commandeArticles) {
		Tables table = tablesRepository.findByNumero(commandeArticles.get(0).getCommande().getTable().getNumero());
		if (table!=null) {
			commandeArticles.get(0).getCommande().setTable(table);
		} else {
			table = tablesRepository.save(commandeArticles.get(0).getCommande().getTable());
		}
		SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		commandeArticles.get(0).getCommande().setDate(sf.format(new Date()));
		Commande commande = commandeRepository.save(commandeArticles.get(0).getCommande());
		for (CommandeArticle commandeArticle : commandeArticles) {
			commandeArticle.setCommande(commande);
		}
		return commandeArticleRepository.save(commandeArticles);
	}
	
	@RequestMapping(value="/commandearticlesbyserveur", method=RequestMethod.POST)
	public List<CommandeArticle> findByServeur(@RequestBody Employe serveur) {
		List<Commande> commandes = commandeRepository.findByServeur(serveur);
		List<CommandeArticle> commandeArticles = new ArrayList<>();
		for (Commande commande : commandes) {
			commandeArticles.addAll(commandeArticleRepository.findByCommande(commande));
		}
		return commandeArticles;
	}
	
	@RequestMapping(value="/serveurCommandesDuJour/{serveur}", method=RequestMethod.GET)
	public List<CommandeArticle> serveurCommandesDuJour(@PathVariable(name="serveur") String login) {
		SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
		String date = sf.format(new Date()).substring(0, 10);
		return commandeArticleRepository.serveurCommandesDuJour(compteRepository.findByLogin(login).getEmploye(), date+"%");
	}
	
	@RequestMapping(value="/cuisinierCommandesDuJour/{cuisinier}", method=RequestMethod.GET)
	public List<CommandeArticle> cuisinierCommandesDuJour(@PathVariable(name="cuisinier") String login) {
		SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
		String date = sf.format(new Date()).substring(0, 10);
		return commandeArticleRepository.cuisinierCommandesDuJour(compteRepository.findByLogin(login).getEmploye(), date+"%");
	}
	
	@RequestMapping(value="/commandearticlesbycuisinier", method=RequestMethod.POST)
	public List<CommandeArticle> findByCuisinier(@RequestBody Employe cuisinier) {
		List<Commande> commandes = commandeRepository.findByCuisinier(cuisinier);
		List<CommandeArticle> commandeArticles = new ArrayList<>();
		for (Commande commande : commandes) {
			commandeArticles.addAll(commandeArticleRepository.findByCommande(commande));
		}
		return commandeArticles;
	}
	
	@RequestMapping(value="/commandearticles/{id}", method=RequestMethod.PUT)
	public CommandeArticle update(@PathVariable Long id, @RequestBody CommandeArticle commandeArticle) {
		commandeArticle.setIdCommandeArticle(id);
		commandeRepository.save(commandeArticle.getCommande());
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
