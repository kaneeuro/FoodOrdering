package com.sadic.myfastfood.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sadic.myfastfood.entities.CommandeArticleTemporaire;
import com.sadic.myfastfood.entities.Employe;

public interface CommandeArticleTemporaireRepository extends JpaRepository<CommandeArticleTemporaire, Long>{

	public List<CommandeArticleTemporaire> findByEmploye(Employe employe);
}
