package com.pfe.persistance;

// Generated 29 f�vr. 2016 10:10:56 by Hibernate Tools 3.4.0.CR1




/**
 * SousTypeEntretien generated by hbm2java
 */
public class SousTypeEntretien {

	private Integer numeroSousType;
	private String description;
	private Float prixSousType;
	private Typeentretien typeentretien;

	

	public SousTypeEntretien(String description, Float prixSousType,
			Typeentretien typeentretien) {
		this.description = description;
		this.prixSousType = prixSousType;
		this.typeentretien = typeentretien;
	}

	public Integer getNumeroSousType() {
		return this.numeroSousType;
	}

	public void setNumeroSousType(Integer numeroSousType) {
		this.numeroSousType = numeroSousType;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrixSousType() {
		return this.prixSousType;
	}

	public void setPrixSousType(Float prixSousType) {
		this.prixSousType = prixSousType;
	}

	

	public Typeentretien getTypeentretien() {
		return typeentretien;
	}

	public void setTypeentretien(Typeentretien typeentretien) {
		this.typeentretien = typeentretien;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((numeroSousType == null) ? 0 : numeroSousType.hashCode());
		result = prime * result
				+ ((prixSousType == null) ? 0 : prixSousType.hashCode());
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
		SousTypeEntretien other = (SousTypeEntretien) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (numeroSousType == null) {
			if (other.numeroSousType != null)
				return false;
		} else if (!numeroSousType.equals(other.numeroSousType))
			return false;
		if (prixSousType == null) {
			if (other.prixSousType != null)
				return false;
		} else if (!prixSousType.equals(other.prixSousType))
			return false;
		return true;
	}
  
}
