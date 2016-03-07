package com.pfe.bean;


import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.pfe.persistance.Etat;
import com.pfe.services.EtatService;


@ManagedBean(name = "etatbean")
@SessionScoped
public class EtatBean {
	
	private Integer numero_etat;
	private String nom_etat;
	private String action;
	
	List<Etat> ets=new ArrayList<Etat>();
			public List<Etat> getEts() {
				ets=new EtatService().rechercheTousEtat();
				return ets;
			}
			public void setEts(List<Etat> ets) {
				this.ets = ets;
			}
			
	
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
	
   public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
public void Ajout(){
	   numero_etat=null;
	   nom_etat=null;
	   action="Ajouter";
   }

				public void modifier(Etat e){
					numero_etat=e.getNumero_etat();
					nom_etat=e.getNom_etat();
					action="Modification";
				}

public void Validation(){
	
	FacesContext faces = FacesContext.getCurrentInstance();
	   Etat e=new Etat();
	   e.setNom_etat(nom_etat);
	  
	   
	  	if(action!= null && action.equals("Ajouter")) 
		  { 
	  		
	  		 new EtatService().ajouterEtat(e);
	  		faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Etat ajoutée avec succès.", "")); 
		  }
			  
	  		if (action != null && action.equals("Modification")) {
				e.setNumero_etat(numero_etat);
				new EtatService().modifierEtat(e);
				faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Etat modifiée avec succès.", ""));
			}
	
       nom_etat=null;
       
}



			public void supprimer(Etat e ) {
				 EtatService ser=new EtatService ();
				 ser.supprimerEtat(e);
				addMessage("suppression avec succee", ".");
			 }
			
			  
			 public void addMessage(String summary, String detail) {
			     FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
			     FacesContext.getCurrentInstance().addMessage(null, message);
			}

public void ClosDig(){
	 numero_etat=null;
	   nom_etat=null;
}
}
