package com.sadic.myfastfood.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sadic.myfastfood.entities.Commande;
import com.sadic.myfastfood.entities.Employe;

public interface CommandeRepository extends JpaRepository<Commande, Long> {

	public Commande findByNumero(Long numero);
	public List<Commande> findByStatut(int statut);
	public List<Commande> findByServeur(Employe serveur);
	public List<Commande> findByCuisinier(Employe cuisinier);
	public List<Commande> findByComptable(Employe comptable);
	
	@Query("select c from Commande c where c.comptable like :comptable and c.date like :date")
	public List<Commande> comptableCommandesDuJour(@Param("comptable") Employe comptable, @Param("date") String date);
}
