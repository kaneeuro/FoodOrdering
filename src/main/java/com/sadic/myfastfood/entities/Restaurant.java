package com.sadic.myfastfood.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Restaurant implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long idResto;
	private String code;
	private String designation;
	private String adresse;
	private String telephone;
	private String email;
	private String imageUrl;
	
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Restaurant(String code, String designation, String adresse, String telephone, String email) {
		super();
		this.code = code;
		this.designation = designation;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
	}

	public Long getIdResto() {
		return idResto;
	}

	public void setIdResto(Long idResto) {
		this.idResto = idResto;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Restaurant(String code, String designation, String adresse, String telephone, String email,
			String imageUrl) {
		super();
		this.code = code;
		this.designation = designation;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		this.imageUrl = imageUrl;
	}

}
