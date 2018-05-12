package com.sadic.myfastfood.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CommandeArticle implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long idCommandeArticle;
	@ManyToOne()
	@JoinColumn(name="id_article", nullable=false)
	private Article article;
	@ManyToOne()
	@JoinColumn(name="id_commande", nullable=false)
	private Commande commande;
	@ManyToOne()
	@JoinColumn(name="id_cuisinier")
	private Employe cuisinier;
	private Long quantite;
	private double prixUnitaire;
	private double prixTotal;
	private int statut;
	
	public CommandeArticle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommandeArticle(Article article, Commande commande, Long quantite, double prixUnitaire, double prixTotal) {
		super();
		this.article = article;
		this.commande = commande;
		this.quantite = quantite;
		this.prixUnitaire = prixUnitaire;
		this.prixTotal = prixTotal;
	}

	public CommandeArticle(Article article, Commande commande, Long quantite, double prixUnitaire, double prixTotal, int statut) {
		super();
		this.article = article;
		this.commande = commande;
		this.quantite = quantite;
		this.prixUnitaire = prixUnitaire;
		this.prixTotal = prixTotal;
		this.statut = statut;
	}

	public Long getIdCommandeArticle() {
		return idCommandeArticle;
	}

	public void setIdCommandeArticle(Long idCommandeArticle) {
		this.idCommandeArticle = idCommandeArticle;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Long getQuantite() {
		return quantite;
	}

	public void setQuantite(Long quantite) {
		this.quantite = quantite;
	}

	public double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}
	public int getStatut() {
		return statut;
	}
	public void setStatut(int statut) {
		this.statut = statut;
	}

	public Employe getCuisinier() {
		return cuisinier;
	}

	public void setCuisinier(Employe cuisinier) {
		this.cuisinier = cuisinier;
	}
	
}
