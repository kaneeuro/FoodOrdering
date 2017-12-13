package com.sadic.myfastfood.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sadic.myfastfood.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long> {

	public Compte findByLogin(String login);
	public Compte findByLoginAndPassword(String login, String password);
}
