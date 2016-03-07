package com.pfe.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pfe.dao.DepartementHome;
import com.pfe.dao.HibernateUtil;
import com.pfe.persistance.Departement;


public class DepartementService {
	
	private DepartementHome dao;
	 
	public DepartementService() {
		dao = new DepartementHome();
	}
	public void ajouterDepartement( Departement d) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			dao.persist(d);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}
	
	public void supprimerDepartement(Departement d) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			dao.delete(d);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public Departement modifierDepartement(Departement d) {
		Departement dp = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			dp = dao.merge(d);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return dp;
	}

	public Departement rechercheDepartementParId(Integer id) {
		Departement d = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			d = dao.findById(id);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return d;

	}
	
	////////liste Departement/////////////
	public List<Departement> rechercheTousDepartement() {
		List<Departement> liste = null;
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
