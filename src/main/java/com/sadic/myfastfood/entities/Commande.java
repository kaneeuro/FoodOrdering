package com.sadic.myfastfood.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Commande implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long idCommande;
	private Long numero;
	//@Temporal(TemporalType.TIMESTAMP)
	private String date;
	private int statut;
	@ManyToOne()
	@JoinColumn(name="id_serveur", nullable=false)
	private Employe serveur;
	@ManyToOne()
	@JoinColumn(name="id_cuisinier")
	private Employe cuisinier;
	@ManyToOne()
	@JoinColumn(name="id_comptable")
	private Employe comptable;
	@ManyToOne()
	@JoinColumn(name="id_table", nullable=false)
	private Tables table;
	
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Commande(Long numero, String date, Employe serveur, Tables table) {
		super();
		this.numero = numero;
		this.date = date;
		this.serveur = serveur;
		this.table = table;
	}
	
	public Commande(Long numero, String date,int statut, Employe serveur, Tables table) {
		super();
		this.numero = numero;
		this.date = date;
		this.statut = statut;
		this.serveur = serveur;
		this.table = table;
	}
	public Long getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Employe getServeur() {
		return serveur;
	}
	public void setServeur(Employe serveur) {
		this.serveur = serveur;
	}
	public Employe getCuisinier() {
		return cuisinier;
	}
	public void setCuisinier(Employe cuisinier) {
		this.cuisinier = cuisinier;
	}
	public Employe getComptable() {
		return comptable;
	}
	public void setComptable(Employe comptable) {
		this.comptable = comptable;
	}
	public Tables getTable() {
		return table;
	}
	public void setTable(Tables table) {
		this.table = table;
	}
	public int getStatut() {
		return statut;
	}
	public void setStatut(int statut) {
		this.statut = statut;
	}
	
}
