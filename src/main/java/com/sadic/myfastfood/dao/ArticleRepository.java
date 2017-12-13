package com.sadic.myfastfood.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sadic.myfastfood.entities.Article;
import com.sadic.myfastfood.entities.Categorie;

public interface ArticleRepository extends JpaRepository<Article, Long> {

	public Article findByDesignation(String designation);
	public List<Article> findByCategorie(Categorie categorie);
}
