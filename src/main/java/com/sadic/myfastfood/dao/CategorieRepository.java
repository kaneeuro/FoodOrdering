package com.sadic.myfastfood.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sadic.myfastfood.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {

}
