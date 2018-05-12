package com.sadic.myfastfood.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sadic.myfastfood.entities.Commande;
import com.sadic.myfastfood.entities.CommandeArticle;
import com.sadic.myfastfood.entities.Employe;

public interface CommandeArticleRepository extends JpaRepository<CommandeArticle, Long> {

	public List<CommandeArticle> findByCommande(Commande commande);
	public List<CommandeArticle> findByStatutAndCommande(int statut, Commande commande);
	
	@Query("select ca from CommandeArticle ca, Commande c where c.idCommande=ca.commande"
			+ " and c.serveur like :serveur and c.date like :date")
	public List<CommandeArticle> serveurCommandesDuJour(@Param("serveur") Employe serveur, @Param("date") String date);
	
	@Query("select ca from CommandeArticle ca, Commande c where c.idCommande=ca.commande"
			+ " and ca.cuisinier like :cuisinier and c.date like :date")
	public List<CommandeArticle> cuisinierCommandesDuJour(@Param("cuisinier") Employe cuisinier, @Param("date") String date);
}
