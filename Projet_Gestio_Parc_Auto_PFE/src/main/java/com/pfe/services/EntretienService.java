package com.pfe.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pfe.dao.EntretienHome;
import com.pfe.dao.HibernateUtil;
import com.pfe.persistance.Entretien;

public class EntretienService {
	private EntretienHome dao;
	 
	public EntretienService() {
		dao = new EntretienHome();
	}
	public void ajouterEntretien(Entretien e) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			dao.persist(e);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}
	
	public void supprimerEntretien(Entretien e) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			dao.delete(e);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public Entretien modifierEntretien(Entretien e) {
		Entretien ent = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			ent = dao.merge(e);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return ent;
	}

	public Entretien rechercheEntretienParId(Integer id) {
		Entretien e = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			e = dao.findById(id);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return e;

	}
	
	////////liste personnel/////////////
	public List<Entretien> rechercheTousEntretien() {
		List<Entretien> liste = null;
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
