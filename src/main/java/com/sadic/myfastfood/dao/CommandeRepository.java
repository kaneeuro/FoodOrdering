package com.sadic.myfastfood.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sadic.myfastfood.entities.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {

	public Commande findByNumero(Long numero);
	public List<Commande> findByStatut(int statut);
}
