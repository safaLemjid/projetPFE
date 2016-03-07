package com.pfe.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.pfe.persistance.Compte;
import com.pfe.services.CompteService;

@ManagedBean(name = "connectBean")
@SessionScoped
public class ConnectBean {
	private String login;
	private String motPasse;
	private String action;

	public String getAction() {
		return action;
	}
	

	public void setAction(String action) {
		this.action = action;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotPasse() {
		return motPasse;
	}

	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}
	
	public  void ajout(){
		login=null;
		motPasse=null;
		action="Ajout";
	}

	public boolean existeCompte(String login, String motpass) {
		CompteService dao = new CompteService();
		Compte cmp = new Compte();
		cmp = dao.rechercheParUtilisateurMotPasse(login, motpass);
		if (cmp != null)
			// System.out.println(cmp.getMotDePasse());
			return true;

		else
			// System.out.println("compte nexiste pas");
			return false;
	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public String connecter() {
		FacesContext faces = FacesContext.getCurrentInstance();
		if ((login.equals("") && motPasse.equals("")))
		{	
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_WARN, "erreur",
					"Vous dever remplire tout les champs "));
	    }
		else if (login.equals("admin") && motPasse.equals("admin")) {
			return "/tableau_bord.xhtml";
		}
		else if (existeCompte(login, motPasse)) {
			return "/tableau_bord.xhtml";
		} 
		else
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "erreur",
					"Les informations saisie sont invalides "));
		return "/Index.xhtml";
	}

	public void valider() {
		Compte cpt = new Compte();
		CompteService servi = new CompteService();
		cpt.setLogin(login);
		cpt.setMotDePasse(motPasse);
		if ((action != null) && (action.equals("Ajout"))) {
			
			servi.ajouterCompte(cpt);
			System.out.print("ok");
		}
	}

//	public String init() {
//		login = null;
//		motPasse = null;
//		action = "Ajout";
//		return null;
//	}

	public void ClosDig(){
		login=null;
		motPasse=null;
			
	}
}