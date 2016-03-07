package com.pfe.test;

import org.hibernate.Session;
import com.pfe.dao.CompteHome;
import com.pfe.dao.HibernateUtil;
import com.pfe.persistance.Compte;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompteHome dao=new  CompteHome();
	       Session session=HibernateUtil.getSessionFactory().getCurrentSession();
	       session.beginTransaction();
	        Compte cpt=new Compte();
            cpt.setLogin("test");
            cpt.setMotDePasse("test");
            dao.persist(cpt);
        session.getTransaction().commit(); 

	}

}
