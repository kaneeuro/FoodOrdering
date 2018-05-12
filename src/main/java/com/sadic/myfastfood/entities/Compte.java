package com.sadic.myfastfood.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Compte implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long idCompte;
	@Column(unique = true, nullable = false)
	private String login;
	@Column(nullable = false)
	private String password;
	private String role;
	private String token;
	@OneToOne()
	@JoinColumn(name="id_employe", nullable=false)
	private Employe employe;
	
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compte(String login, String password, String role, Employe employe) {
		super();
		this.login = login;
		this.password = password;
		this.role = role;
		this.employe = employe;
	}
	public Long getIdCompte() {
		return idCompte;
	}
	public void setIdCompte(Long idCompte) {
		this.idCompte = idCompte;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
}
