package com.pfe.persistance;

import java.util.HashSet;
import java.util.Set;

public class Etat {
	
	private Integer numero_etat;
	private String nom_etat;
	
	private Set<Vehicule> vehicules1 = new HashSet<Vehicule>(0);
	
	
	public Integer getNumero_etat() {
		return numero_etat;
	}
	public void setNumero_etat(Integer numero_etat) {
		this.numero_etat = numero_etat;
	}
	public String getNom_etat() {
		return nom_etat;
	}
	public void setNom_etat(String nom_etat) {
		this.nom_etat = nom_etat;
	}
	public Set<Vehicule> getVehicules1() {
		return vehicules1;
	}
	public void setVehicules1(Set<Vehicule> vehicules1) {
		this.vehicules1 = vehicules1;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nom_etat == null) ? 0 : nom_etat.hashCode());
		result = prime * result
				+ ((numero_etat == null) ? 0 : numero_etat.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Etat other = (Etat) obj;
		if (nom_etat == null) {
			if (other.nom_etat != null)
				return false;
		} else if (!nom_etat.equals(other.nom_etat))
			return false;
		if (numero_etat == null) {
			if (other.numero_etat != null)
				return false;
		} else if (!numero_etat.equals(other.numero_etat))
			return false;
		return true;
	}
	
	
     
}
