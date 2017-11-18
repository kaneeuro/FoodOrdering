package com.sadic.myfastfood.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employe implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long idEmploye;
	@Column(unique = true, nullable = false)
	private String matricule;
	private String prenom;
	private String nom;
	private String telephone;
	private String email;
	private String fonction;
	@ManyToOne()
	@JoinColumn(name="id_resto", nullable=false)
	private Restaurant restaurant;
	@ManyToOne()
	@JoinColumn(name="id_cuisine", nullable=false)
	private Cuisine cuisine;
	
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employe(String matricule, String prenom, String nom, String telephone, String email, String fonction,
			Restaurant restaurant, Cuisine cuisine) {
		super();
		this.matricule = matricule;
		this.prenom = prenom;
		this.nom = nom;
		this.telephone = telephone;
		this.email = email;
		this.fonction = fonction;
		this.restaurant = restaurant;
		this.cuisine = cuisine;
	}

	public Long getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(Long idEmploye) {
		this.idEmploye = idEmploye;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Cuisine getCuisine() {
		return cuisine;
	}

	public void setCuisine(Cuisine cuisine) {
		this.cuisine = cuisine;
	}
	
}
