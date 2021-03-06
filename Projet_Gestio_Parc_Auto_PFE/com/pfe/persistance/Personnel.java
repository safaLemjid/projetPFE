package com.pfe.persistance;

// Generated 29 f�vr. 2016 10:10:56 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Personnel generated by hbm2java
 */
public class Personnel implements java.io.Serializable {

	private Integer matricule;
	private Compte compte;
	private Departement departement;
	private Typepersonnel typepersonnel;
	private Service service;
	private String nom;
	private String prenom;
	private String cin;
	private String telephone;
	private Date dateNaissance;
	private String adresse;
	private String email;
	private Set<Compte> comptes = new HashSet<Compte>(0);

	public Personnel() {
	}

	public Personnel(Compte compte, Departement departement,
			Typepersonnel typepersonnel, Service service, String nom,
			String prenom, String cin, String telephone, Date dateNaissance,
			String adresse, String email, Set<Compte> comptes) {
		this.compte = compte;
		this.departement = departement;
		this.typepersonnel = typepersonnel;
		this.service = service;
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.telephone = telephone;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.email = email;
		this.comptes = comptes;
	}

	public Integer getMatricule() {
		return this.matricule;
	}

	public void setMatricule(Integer matricule) {
		this.matricule = matricule;
	}

	public Compte getCompte() {
		return this.compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Departement getDepartement() {
		return this.departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Typepersonnel getTypepersonnel() {
		return this.typepersonnel;
	}

	public void setTypepersonnel(Typepersonnel typepersonnel) {
		this.typepersonnel = typepersonnel;
	}

	public Service getService() {
		return this.service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCin() {
		return this.cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Compte> getComptes() {
		return this.comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

}
