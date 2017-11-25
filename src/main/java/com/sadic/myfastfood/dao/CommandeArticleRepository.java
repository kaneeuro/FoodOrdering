package com.sadic.myfastfood.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sadic.myfastfood.entities.Commande;
import com.sadic.myfastfood.entities.CommandeArticle;

public interface CommandeArticleRepository extends JpaRepository<CommandeArticle, Long> {

	public List<CommandeArticle> findByCommande(Commande commande);
}
