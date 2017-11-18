package com.sadic.myfastfood.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sadic.myfastfood.entities.Catalogue;

public interface CatalogueRepository extends JpaRepository<Catalogue, Long> {

}
