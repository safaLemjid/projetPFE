package com.pfe.bean;


import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.pfe.persistance.Personnel;
import com.pfe.persistance.Reclamation;
import com.pfe.services.PersonnelService;
import com.pfe.services.ReclamationService;

@ManagedBean(name = "reclamationbean")
@SessionScoped
public class ReclamationBean {
	
	private Integer num_rec;
	private String description;
	private String action;
	private Integer numero_personnel;
	List<Reclamation> reclamtions=new ArrayList<Reclamation>();

	
	public List<Reclamation> getReclamtions() {
		reclamtions=new ReclamationService().rechercheTousReclamation();
		return reclamtions;
	}
	public void setReclamtions(List<Reclamation> reclamtions) {
		this.reclamtions = reclamtions;
	}
	
	List<Personnel> personnes=new ArrayList<Personnel>();
	
	
	
	public List<Personnel> getPersonnes() {
		personnes=new PersonnelService().rechercheTousPersonne();
		return personnes;
	}
	public void setPersonnes(List<Personnel> personnes) {
		this.personnes = personnes;
	}
	
	
	
	public Integer getNumero_personnel() {
		return numero_personnel;
	}
	public void setNumero_personnel(Integer numero_personnel) {
		this.numero_personnel = numero_personnel;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Integer getNum_rec() {
		return num_rec;
	}
	public void setNum_rec(Integer num_rec) {
		this.num_rec = num_rec;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void Ajout(){
	    num_rec=null;
		description=null;
		action="Ajouter";
	}
	
	public void Modifier(Reclamation r)
	 { 
		 num_rec=r.getNum_rec();
		 description=r.getDescription();
		 if(r.getPersonnel() != null)
			 numero_personnel=r.getPersonnel().getMatricule();
		 action="Modification";
		 
		 
	 }
	
	public void Validation()
	 { 
		FacesContext faces = FacesContext.getCurrentInstance();
		  Reclamation r=new Reclamation();
		     r.setDescription(description);
		     
		     
		     
		  	if(action!= null && action.equals("Ajouter")) 
			  { 
		  		
		  		 new ReclamationService().ajouterReclamation(r);
		  		faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Reclamation ajoutée avec succès.", "")); 
			  }
				  
		  		if (action != null && action.equals("Modification")) {
					r.setNum_rec(num_rec);
					new ReclamationService().modifierReclamation(r);
					faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Reclamation modifiée avec succès.", ""));
				}
		

	 }
	
	
	public void supprimer(Reclamation r ) {
		 ReclamationService ser=new  ReclamationService();
   	 ser.supprimerReclamation(r);
   	addMessage("suppression avec succee", ".");
	    }
	 
	     
	    public void addMessage(String summary, String detail) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	
	
	
		 public void closeDiag() {
				num_rec = null;
				description = null;
		
			}
}
