package com.sadic.myfastfood.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Catalogue implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long idCatalogue;
	private String nom;
	private String imageUrl;
	@ManyToOne()
	@JoinColumn(name="id_resto", nullable=false)
	private Restaurant restaurant;
	
	public Catalogue() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Catalogue(String nom, Restaurant restaurant) {
		super();
		this.nom = nom;
		this.restaurant = restaurant;
	}
	public Long getIdCatalogue() {
		return idCatalogue;
	}
	public void setIdCatalogue(Long idCatalogue) {
		this.idCatalogue = idCatalogue;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Catalogue(String nom, String imageUrl, Restaurant restaurant) {
		super();
		this.nom = nom;
		this.imageUrl = imageUrl;
		this.restaurant = restaurant;
	}

}
