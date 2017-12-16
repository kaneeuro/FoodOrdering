package com.sadic.myfastfood.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CommandeArticleTemporaire {
	@Id
	@GeneratedValue
	private Long idCommandeArticleTemporaire;
	@ManyToOne()
	@JoinColumn(name="id_compte")
	private Compte compte;
	@ManyToOne()
	@JoinColumn(name="id_employe")
	private Employe employe;
	@ManyToOne()
	@JoinColumn(name="id_article")
	private Article article;
	@ManyToOne()
	@JoinColumn(name="id_table")
	private Tables table;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	public CommandeArticleTemporaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommandeArticleTemporaire(Employe employe, Article article, Tables table) {
		super();
		this.employe = employe;
		this.article = article;
		this.table = table;
	}

	public CommandeArticleTemporaire(Compte compte, Employe employe, Article article, Tables table, Date date) {
		super();
		this.compte = compte;
		this.employe = employe;
		this.article = article;
		this.table = table;
		this.date = date;
	}

	public Long getIdCommandeArticleTemporaire() {
		return idCommandeArticleTemporaire;
	}

	public void setIdCommandeArticleTemporaire(Long idCommandeArticleTemporaire) {
		this.idCommandeArticleTemporaire = idCommandeArticleTemporaire;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Tables getTable() {
		return table;
	}

	public void setTable(Tables table) {
		this.table = table;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
