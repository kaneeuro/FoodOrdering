package com.sadic.myfastfood.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sadic.myfastfood.entities.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {

}
