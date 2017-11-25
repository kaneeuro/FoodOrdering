package com.sadic.myfastfood.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	private int statut;
	@ManyToOne()
	@JoinColumn(name="id_employe", nullable=false)
	private Employe employe;
	@ManyToOne()
	@JoinColumn(name="id_table", nullable=false)
	private Tables table;
	
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Commande(Long numero, Date date, Employe employe, Tables table) {
		super();
		this.numero = numero;
		this.date = date;
		this.employe = employe;
		this.table = table;
	}
	
	public Commande(Long numero, Date date,int statut, Employe employe, Tables table) {
		super();
		this.numero = numero;
		this.date = date;
		this.statut = statut;
		this.employe = employe;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
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
