package com.sadic.myfastfood.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sadic.myfastfood.entities.CommandeArticle;

public interface CommandeArticleRepository extends JpaRepository<CommandeArticle, Long> {

}
