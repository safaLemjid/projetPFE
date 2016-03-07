package com.pfe.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.pfe.dao.CategorieHome;
import com.pfe.dao.HibernateUtil;
import com.pfe.persistance.Categorie;


public class CategorieService {



	private CategorieHome dao;
 
	public CategorieService() {
		
		dao = new CategorieHome();
	}
	public void ajouterCategorie(Categorie c) {
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
	
	public void supprimerCategorie(Categorie c) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			dao.delete(c);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public Categorie modifierCategorie(Categorie c) {
		Categorie cat = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			cat = dao.merge(c);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return cat;
	}

	public Categorie rechercheCategorieParId(Integer id) {
		Categorie c = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			c = dao.findById(id);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return c;

	}
	
	////////liste Categorie/////////////
	public List<Categorie> rechercheTousCategorie() {
		List<Categorie> liste = null;
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
