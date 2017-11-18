package com.sadic.myfastfood.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cuisine implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long idCuisine;
	private String nom;
	private String type;
	@ManyToOne()
	@JoinColumn(name="id_resto", nullable=false)
	private Restaurant restaurant;
	
	public Cuisine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cuisine(String nom, String type, Restaurant restaurant) {
		super();
		this.nom = nom;
		this.type = type;
		this.restaurant = restaurant;
	}
	public Long getIdCuisine() {
		return idCuisine;
	}
	public void setIdCuisine(Long idCuisine) {
		this.idCuisine = idCuisine;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}
