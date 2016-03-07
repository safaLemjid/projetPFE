package com.pfe.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pfe.dao.CompteHome;
import com.pfe.dao.HibernateUtil;
import com.pfe.persistance.Compte;


public class CompteService {
	private CompteHome dao;

	public CompteService() {
		dao = new CompteHome();
	}

	public void ajouterCompte(Compte c) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			dao.persist(c);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}
	
	public Compte recherchePersonneParId(Integer id) {
		Compte p = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			p = dao.findById(id);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return p;

	}
	public Compte rechercheParUtilisateurMotPasse(String l, String m) {
		Compte p = new Compte();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			p = dao.findByUtilisateurAndPassword(l, m);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (p);

	}

	public List<Compte> rechercheTousCompte() {
		List<Compte> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findAll();
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);

	}
}

