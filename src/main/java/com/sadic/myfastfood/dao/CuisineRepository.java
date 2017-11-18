package com.sadic.myfastfood.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sadic.myfastfood.entities.Cuisine;

public interface CuisineRepository extends JpaRepository<Cuisine, Long> {

}
