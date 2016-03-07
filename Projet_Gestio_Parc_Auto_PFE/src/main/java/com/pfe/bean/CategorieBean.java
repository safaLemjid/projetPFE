package com.pfe.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.pfe.persistance.Categorie;
import com.pfe.services.CategorieService;


@ManagedBean(name = "categoriebean")
@SessionScoped
public class CategorieBean {
	
	private Integer numero_categorie;
	private String nom_categorie;
	private String type_categorie;
	private String action;
	
	List<Categorie> categs=new ArrayList<Categorie>();
	
				public List<Categorie> getCategs() {
					categs=new CategorieService().rechercheTousCategorie();
					return categs;
				}
				public void setCategs(List<Categorie> categs) {
					this.categs = categs;
				}
    				
	public String getAction() {
					return action;
				}
   public void setAction(String action) {
					this.action = action;
				}
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
	
	public void Ajout(){
		numero_categorie=null;
		nom_categorie=null;
		type_categorie=null;
		action="Ajouter";
	}
				public void Modifier(Categorie c){
					numero_categorie=c.getNumero_categorie();
					nom_categorie=c.getNom_categorie();
					type_categorie=c.getType_categorie();
					action="Modification";
				}
				
    public void Valider (){
    	
    	FacesContext faces = FacesContext.getCurrentInstance();
 	    Categorie c=new  Categorie();
 	   c.setNom_categorie(nom_categorie);
 	   c.setType_categorie(type_categorie);
 	  
 	   
 	  	if(action!= null && action.equals("Ajouter")) 
 		  { 
 	  		
 	  		 new CategorieService().ajouterCategorie(c);
 	  		faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
 					"Categorie ajoutée avec succès.", "")); 
 		  }
 			  
 	  		if (action != null && action.equals("Modification")) {
 				c.setNumero_categorie(numero_categorie);
 				new CategorieService().modifierCategorie(c);
 				faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
 						"Categorie modifiée avec succès.", ""));
 			}
 	
        nom_categorie=null;
        type_categorie=null;
        
    }
    
    public void supprimer(Categorie c ) {
    	CategorieService ser=new CategorieService ();
		 ser.supprimerCategorie(c);
		addMessage("suppression avec succee", ".");
	 }
	
	  
	 public void addMessage(String summary, String detail) {
	     FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
	     FacesContext.getCurrentInstance().addMessage(null, message);
	}

    
    public void ClosDig(){
    	numero_categorie=null;
    	nom_categorie=null;
    	type_categorie=null;
    }
}
