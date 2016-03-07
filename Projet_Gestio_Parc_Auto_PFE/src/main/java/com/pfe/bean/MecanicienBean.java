package com.pfe.bean;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.pfe.persistance.Mecanicien;
import com.pfe.services.MecanicienService;

@ManagedBean(name = "mecanicienbean")
@SessionScoped
public class MecanicienBean {
	private Integer numero_mec;
	private String nom_mecanicien;
	private String adresse;
	private Integer telephone;
	private String action;
	
	List<Mecanicien> Mecns=new ArrayList<Mecanicien>();
	
	
	
	
	public List<Mecanicien> getMecns() {
		Mecns=new MecanicienService().rechercheTousMecanicien();
		return Mecns;
	}
	public void setMecns(List<Mecanicien> mecns) {
		Mecns = mecns;
	}
	public Integer getNumero_mec() {
		return numero_mec;
	}
	public void setNumero_mec(Integer numero_mec) {
		this.numero_mec = numero_mec;
	}
	public String getNom_mecanicien() {
		return nom_mecanicien;
	}
	public void setNom_mecanicien(String nom_mecanicien) {
		this.nom_mecanicien = nom_mecanicien;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Integer getTelephone() {
		return telephone;
	}
	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public void Ajout(){
		 numero_mec=null;
		 nom_mecanicien=null;
		 adresse=null;
		 telephone=null;
		 action="Ajouter";
		
	}
	
	public void Modifier(Mecanicien m)
	 { 
		numero_mec=m.getNumero_mec();
		nom_mecanicien=m.getNom_mecanicien();
		adresse=m.getAdresse();
		telephone=m.getTelephone();
		 
		 action="Modification";
	 }
	
	public void validation(){
		FacesContext faces = FacesContext.getCurrentInstance();
		   Mecanicien mec=new Mecanicien();
		   mec.setNom_mecanicien(nom_mecanicien);
		   mec.setAdresse(adresse);
		   mec.setTelephone(telephone);
		   
		   
		  	if(action!= null && action.equals("Ajouter")) 
		  	{
		  		if (numero_mec !=  null && nom_mecanicien != null && adresse != null && (telephone != null && telephone<=8 ) )
		  		 new MecanicienService().ajouterMecanicien(mec);
		  		faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Mecanicien ajoutée avec succès.", "")); 
			  }
				  
		  		if (action != null && action.equals("Modification")) {
					mec.setNumero_mec(numero_mec);
					 new MecanicienService().modifierMecanicien(mec);
					faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Mecanicien modifiée avec succès.", ""));
				}
		
	}
	
	
	public void supprimer(Mecanicien m ) {
		MecanicienService ser=new MecanicienService();
   	 ser.supprimerMecanicien(m);
   	addMessage("suppression avec succee", ".");
	    }
	 
	     
	    public void addMessage(String summary, String detail) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	    
	public void closD(){
		 numero_mec=null;
		 nom_mecanicien=null;
		 adresse=null;
		 telephone=null;
	}

}
