package com.sadic.myfastfood.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sadic.myfastfood.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

	public Article findByDesignation(String designation);
}
