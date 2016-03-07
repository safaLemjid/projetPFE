package com.pfe.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.pfe.persistance.Compte;
import com.pfe.persistance.Departement;
import com.pfe.persistance.Personnel;
import com.pfe.persistance.Service;
import com.pfe.persistance.Typepersonnel;
import com.pfe.services.CompteService;
import com.pfe.services.DepartementService;
import com.pfe.services.PersonnelService;
import com.pfe.services.ServiceS;
import com.pfe.services.TypePersonnelService;

@ManagedBean(name = "personnelbean")
@SessionScoped
public class PersonnelBean {
	private Integer matricule;
	private Compte compte;
	private String nom;
	private String prenom;
	private String telephone;
	private String cin;
	private Date dateNaissance;
	private String email;
	private String adresse ;
	private String date_nai;
	private Integer numerocompte;
	private Integer numerodepartement;
	private Integer numeroservice;
	private Integer numerotypeP;
	private String action;
	
	
	List<Personnel> pls=new ArrayList<Personnel>();
    
	public List<Personnel> getPls() {
		pls=new PersonnelService().rechercheTousPersonne();
		return pls;
	}
	public void setPls(List<Personnel> pls) {
		this.pls = pls;
	}

	List<Compte> comptes=new ArrayList<Compte>();
	List<Departement> departements=new ArrayList<Departement>();
	List<Service> services=new ArrayList<Service>();
	List<Typepersonnel> typepersonnels=new ArrayList<Typepersonnel>();
	
	public List<Service> getServices() {
		services=new ServiceS().rechercheTousService();
		return services;
	}
	public void setServices(List<Service> services) {
		this.services = services;
	}
	public List<Typepersonnel> getTypepersonnels() {
		typepersonnels=new TypePersonnelService().rechercheTousTypePersonne();
		return typepersonnels;
	}
	public void setTypepersonnels(List<Typepersonnel> typepersonnels) {
		this.typepersonnels = typepersonnels;
	}

	public List<Departement> getDepartements() {
		departements=new DepartementService().rechercheTousDepartement();
		return departements;
	}
	public void setDepartements(List<Departement> departements) {
		this.departements = departements;
	}
	public List<Compte> getComptes() {
		comptes= new CompteService().rechercheTousCompte();
		return comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	

	public Integer getNumerocompte() {
		return numerocompte;
	}
	public void setNumerocompte(Integer numerocompte) {
		this.numerocompte = numerocompte;
	}
	public String getDate_nai() {
		return date_nai;
	}
	public void setDate_nai(String date_nai) {
		this.date_nai = date_nai;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	

	public Integer getMatricule() {
		return matricule;
	}
	public void setMatricule(Integer matricule) {
		this.matricule = matricule;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getNumerodepartement() {
		return numerodepartement;
	}
	public void setNumerodepartement(Integer numerodepartement) {
		this.numerodepartement = numerodepartement;
	}
	public Integer getNumeroservice() {
		return numeroservice;
	}
	public void setNumeroservice(Integer numeroservice) {
		this.numeroservice = numeroservice;
	}
	public Integer getNumerotypeP() {
		return numerotypeP;
	}
	public void setNumerotypeP(Integer numerotypeP) {
		this.numerotypeP = numerotypeP;
	}

	public void Ajout(){
	    matricule=null;
		nom=null;
		prenom=null;
		telephone=null;
		cin=null;
		email=null;
		adresse=null;
		date_nai= null;
		numerocompte=null;
		numerodepartement=null;
		numeroservice=null;
		numerotypeP=null;
		action="Ajouter";
	}
	public void Modifier(Personnel p)
	 { 
		 matricule=p.getMatricule();
		 nom=p.getNom();
		 prenom=p.getPrenom();
		 telephone=p.getTelephone();
		 cin=p.getCin();
		 email=p.getEmail();
		 adresse=p.getAdresse();
		 
		 if(p.getCompte() != null)
			  numerocompte=p.getCompte().getNumeroCompte();
		 
		 if(p.getDepartement() != null)
			 numerodepartement=p.getDepartement().getNumeroDepartement();
		
		 if(p.getService() != null)
			 numeroservice=p.getService().getNumeroService();
		 
		 if(p.getTypepersonnel() != null)
			 numerotypeP=p.getTypepersonnel().getNumeroTypeP();
		 
		 dateNaissance=p.getDateNaissance();
		 DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		 if(dateNaissance!= null)
			 date_nai= sdf.format(dateNaissance);
		 action="Modification";
	 }
	
	public void Validation()
	 { FacesContext faces = FacesContext.getCurrentInstance();
	   Personnel p=new Personnel();
	   if((nom =="")||(prenom =="")||(email =="")||(adresse =="")||(cin =="")||(telephone==""))
	   { 
		   faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"vous dever remplire tous les champs !! ", "")); 
	   }
	   else if ((telephone.length() > 8)||((telephone.length() < 8)))
	   {  
		   faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
				"Le numero du telephone est invalide !! ", "")); 
	   }
	   else if ((cin.length() > 8)||((cin.length() < 8)))
	   {  
		   faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
				"Le numero du carte d'identité est invalide !! ", "")); 
	   }
	   else
	 {   
		p.setNom(nom);
		p.setPrenom(prenom);
		p.setEmail(email);
		p.setCin(cin);
		p.setTelephone(telephone);
		p.setAdresse(adresse);
		Compte cmpt = new Compte();
		cmpt.setNumeroCompte(numerocompte);
		   Departement dep = new Departement();
		dep.setNumeroDepartement(numerodepartement);
		   Service s = new Service();
		s.setNumeroService(numeroservice);
		   Typepersonnel typeP = new Typepersonnel();
		typeP.setNumeroTypeP(numerotypeP);
		p.setDateNaissance(dateNaissance);
		p.setCompte(cmpt);
		p.setDepartement(dep);
		p.setService(s);
		p.setTypepersonnel(typeP);
	  	if(action!= null && action.equals("Ajouter")) 
		  { 
	  		new PersonnelService().ajouterPersonnel(p);
	  		faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Personne ajoutée avec succès.", "")); 
		  }
		if (action != null && action.equals("Modification")) {
				p.setMatricule(matricule);
				new PersonnelService().modifierPersonnel(p);
				faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Personne modifiée avec succès.", ""));
		  }
	 }

	 }
	
	
	
	public void supprimer(Personnel p ) {
		 PersonnelService ser=new PersonnelService ();
    	 ser.supprimerPersonnel(p);
    	addMessage("suppression avec succee", ".");
	    }
	 
	     
	    public void addMessage(String summary, String detail) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	
	
	
		 public void closeDiag() {
				matricule = null;
				nom = null;
				prenom= null;
				dateNaissance = null;
				telephone=null;
				cin=null;
				email = null;
				adresse = null;
				numerocompte=null;
				numerodepartement=null;
				numeroservice=null;
				numerotypeP=null;
			
				
			}
	  	 
	   
	
}
