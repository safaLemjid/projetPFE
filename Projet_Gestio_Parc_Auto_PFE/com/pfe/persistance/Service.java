package com.pfe.persistance;

// Generated 29 f�vr. 2016 10:10:56 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Service generated by hbm2java
 */
public class Service implements java.io.Serializable {

	private Integer numeroService;
	private String nomService;
	private Set<Personnel> personnels = new HashSet<Personnel>(0);

	public Service() {
	}

	public Service(String nomService, Set<Personnel> personnels) {
		this.nomService = nomService;
		this.personnels = personnels;
	}

	public Integer getNumeroService() {
		return this.numeroService;
	}

	public void setNumeroService(Integer numeroService) {
		this.numeroService = numeroService;
	}

	public String getNomService() {
		return this.nomService;
	}

	public void setNomService(String nomService) {
		this.nomService = nomService;
	}

	public Set<Personnel> getPersonnels() {
		return this.personnels;
	}

	public void setPersonnels(Set<Personnel> personnels) {
		this.personnels = personnels;
	}

}
