
package com.pfe.persistance;

import java.util.HashSet;
import java.util.Set;

public class Categorie {
	
	private Integer numero_categorie;
	private String nom_categorie;
	private String type_categorie;
	private Set<Vehicule> vehicules = new HashSet<Vehicule>(0);
	
	
	
	
	public Integer getNumero_categorie() {
		return numero_categorie;
	}
	public void setNumero_categorie(Integer numero_categorie) {
		this.numero_categorie = numero_categorie;
	}
	public String getNom_categorie() {
		return nom_categorie;
	}
	public void setNom_categorie(String nom_categorie) {
		this.nom_categorie = nom_categorie;
	}
	public String getType_categorie() {
		return type_categorie;
	}
	public void setType_categorie(String type_categorie) {
		this.type_categorie = type_categorie;
	}
	public Set<Vehicule> getVehicules() {
		return vehicules;
	}
	public void setVehicules(Set<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nom_categorie == null) ? 0 : nom_categorie.hashCode());
		result = prime
				* result
				+ ((numero_categorie == null) ? 0 : numero_categorie.hashCode());
		result = prime * result
				+ ((type_categorie == null) ? 0 : type_categorie.hashCode());
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
		Categorie other = (Categorie) obj;
		if (nom_categorie == null) {
			if (other.nom_categorie != null)
				return false;
		} else if (!nom_categorie.equals(other.nom_categorie))
			return false;
		if (numero_categorie == null) {
			if (other.numero_categorie != null)
				return false;
		} else if (!numero_categorie.equals(other.numero_categorie))
			return false;
		if (type_categorie == null) {
			if (other.type_categorie != null)
				return false;
		} else if (!type_categorie.equals(other.type_categorie))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Categorie [numero_categorie=" + numero_categorie
				+ ", nom_categorie=" + nom_categorie + ", type_categorie="
				+ type_categorie + "]";
	}
	
}
