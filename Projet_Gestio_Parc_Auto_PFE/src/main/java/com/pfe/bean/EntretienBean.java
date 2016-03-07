package com.pfe.bean;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.pfe.persistance.Entretien;
import com.pfe.persistance.Mecanicien;
import com.pfe.persistance.Typeentretien;
import com.pfe.services.EntretienService;
import com.pfe.services.MecanicienService;
import com.pfe.services.TypeEntretienService;


@ManagedBean(name = "entretienbean")
@SessionScoped
public class EntretienBean {
	
	private Integer numeroEntretien;
	private Typeentretien typeentretien;
	private Date dateArrive;
	private Date dateDepart;
	private Float coutTotal;
	private Integer dureeEntretien;
	private Integer numeroTypeEntretien;
	private String date_dep;
	private String date_arriv;
	private Integer numeroMecanicien;
	private String action;
	
			    List<Entretien> entrets=new ArrayList<Entretien>();
				
				public List<Entretien> getEntrets() {
					entrets=new EntretienService().rechercheTousEntretien();
					return entrets;
				}
				public void setEntrets(List<Entretien> entrets) {
					this.entrets = entrets;
				}

	List<Mecanicien> mecs=new ArrayList<Mecanicien>();
	 
	
	public List<Mecanicien> getMecs() {
		mecs=new MecanicienService().rechercheTousMecanicien();
		return mecs;
}
	public void setMecs(List<Mecanicien> mecs) {
		this.mecs = mecs;
	}

				List<Typeentretien> typeentretiens=new ArrayList<Typeentretien>();
				
				public List<Typeentretien> getTypeentretiens() {
					typeentretiens=new TypeEntretienService().rechercheTousTypeEntretien();
					return typeentretiens;
				}
				public void setTypeentretiens(List<Typeentretien> typeentretiens) {
					this.typeentretiens = typeentretiens;
				}
	
	
	       public Integer getNumeroMecanicien() {
					return numeroMecanicien;
				}
				public void setNumeroMecanicien(Integer numeroMecanicien) {
					this.numeroMecanicien = numeroMecanicien;
				}
	public String getDate_arriv() {
		return date_arriv;
	}
	public void setDate_arriv(String date_arriv) {
		this.date_arriv = date_arriv;
	}
	public String getDate_dep() {
		return date_dep;
	}
	public void setDate_dep(String date_dep) {
		this.date_dep = date_dep;
	}
	public Integer getNumeroTypeEntretien() {
		return numeroTypeEntretien;
	}
	public void setNumeroTypeEntretien(Integer numeroTypeEntretien) {
		this.numeroTypeEntretien = numeroTypeEntretien;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Integer getNumeroEntretien() {
		return numeroEntretien;
	}
	public void setNumeroEntretien(Integer numeroEntretien) {
		this.numeroEntretien = numeroEntretien;
	}
	public Typeentretien getTypeentretien() {
		return typeentretien;
	}
	public void setTypeentretien(Typeentretien typeentretien) {
		this.typeentretien = typeentretien;
	}
	public Date getDateArrive() {
		return dateArrive;
	}
	public void setDateArrive(Date dateArrive) {
		this.dateArrive = dateArrive;
	}
	public Date getDateDepart() {
		return dateDepart;
	}
	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}
	public Float getCoutTotal() {
		return coutTotal;
	}
	public void setCoutTotal(Float coutTotal) {
		this.coutTotal = coutTotal;
	}
	public Integer getDureeEntretien() {
		return dureeEntretien;
	}
	public void setDureeEntretien(Integer dureeEntretien) {
		this.dureeEntretien = dureeEntretien;
	}
	
	public void Ajout(){
		 numeroEntretien=null;
		 dateArrive=null;
		 dateDepart=null;
		 coutTotal=null;
		 dureeEntretien=null;
		 numeroTypeEntretien=null;
	     numeroMecanicien=null;
		 date_dep=null;
		 date_arriv=null;
		 action="Ajouter";
		
	}
	public void Modifier(Entretien e)
	 { 
		 numeroEntretien=e.getNumeroEntretien();
		 dureeEntretien=e.getDureeEntretien();
		 
		 if(e.getTypeentretien() != null)
			  numeroTypeEntretien=e.getTypeentretien().getNumeroTypeE();
		  
	 if(e.getMecanicien() != null)
			 numeroMecanicien=e.getMecanicien().getNumero_mec();
		 
		 
		 dateDepart=e.getDateDepart();
		 DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		 if(dateDepart!= null)
			 date_dep= sdf.format(dateDepart);
		 
		 dateArrive=e.getDateArrive();
		 DateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		 if(dateArrive!= null)
			 date_arriv= sdf1.format(dateArrive);
		 
		 action="Modification";
	 }
	
	
	public void validation(){
		FacesContext faces = FacesContext.getCurrentInstance();
		   Entretien ent=new  Entretien();
		    ent.setCoutTotal(coutTotal);
		    ent.setDureeEntretien(dureeEntretien);
	
		  Typeentretien typeE=new Typeentretien();
		    typeE.setNumeroTypeE(numeroTypeEntretien);
		    
     	  Mecanicien me=new Mecanicien();
     	  me.setNumero_mec(numeroMecanicien);
		    
		      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			       if(date_arriv != null) 
		           try {
				   dateArrive = sdf.parse(date_arriv);
			       } catch (ParseException e) {
				    e.printStackTrace();
			       }
			   SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
			       if(date_dep != null) 
		           try {
				   dateDepart = sdf1.parse(date_dep);
			        } catch (ParseException e) {
				  e.printStackTrace();
			     }
		     ent.setDateArrive(dateArrive);
		     ent.setDateDepart(dateDepart);
		   
		   ent.setTypeentretien(typeE);
		   
		  	if(action!= null && action.equals("Ajouter")) 
			  { 
		  		
		  		 new EntretienService().ajouterEntretien(ent);
		  		faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Personne ajoutée avec succès.", "")); 
			  }
				  
		  		if (action != null && action.equals("Modification")) {
					ent.setNumeroEntretien(numeroEntretien);
					new EntretienService().modifierEntretien(ent);
					faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Personne modifiée avec succès.", ""));
				}
		
   
	}
	
	public void supprimer(Entretien ent ) {
		EntretienService ser=new EntretienService();
   	 ser.supprimerEntretien(ent);
   	addMessage("suppression avec succee", ".");
	    }
	 
	     
	    public void addMessage(String summary, String detail) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	    
	public void closD(){
		 numeroEntretien=null;
		 dateArrive=null;
		 dateDepart=null;
		 coutTotal=null;
		 dureeEntretien=null;
		 numeroTypeEntretien=null;
		 numeroMecanicien=null;
		 date_arriv=null;
		 date_dep=null;
	}
}
