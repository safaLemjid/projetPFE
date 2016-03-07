package com.pfe.persistance;

public class Vehicule {

	private int immatricule;
	private int nombre_place;
	private String puissance;
	private int kelometrage;
	private int capacite_bagage;
	private Etat  etat;
	private Categorie categorie;
	
	
	public int getImmatricule() {
		return immatricule;
	}
	public void setImmatricule(int immatricule) {
		this.immatricule = immatricule;
	}
	public int getNombre_place() {
		return nombre_place;
	}
	public void setNombre_place(int nombre_place) {
		this.nombre_place = nombre_place;
	}
	public String getPuissance() {
		return puissance;
	}
	public void setPuissance(String puissance) {
		this.puissance = puissance;
	}
	public int getKelometrage() {
		return kelometrage;
	}
	public void setKelometrage(int kelometrage) {
		this.kelometrage = kelometrage;
	}
	public int getCapacite_bagage() {
		return capacite_bagage;
	}
	public void setCapacite_bagage(int capacite_bagage) {
		this.capacite_bagage = capacite_bagage;
	}
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacite_bagage;
		result = prime * result + immatricule;
		result = prime * result + kelometrage;
		result = prime * result + nombre_place;
		result = prime * result
				+ ((puissance == null) ? 0 : puissance.hashCode());
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
		Vehicule other = (Vehicule) obj;
		if (capacite_bagage != other.capacite_bagage)
			return false;
		if (immatricule != other.immatricule)
			return false;
		if (kelometrage != other.kelometrage)
			return false;
		if (nombre_place != other.nombre_place)
			return false;
		if (puissance == null) {
			if (other.puissance != null)
				return false;
		} else if (!puissance.equals(other.puissance))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Vehicule [immatricule=" + immatricule + ", nombre_place="
				+ nombre_place + ", puissance=" + puissance + ", kelometrage="
				+ kelometrage + ", capacite_bagage=" + capacite_bagage + "]";
	}
	
	
	
}
