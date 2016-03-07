package com.pfe.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.pfe.dao.HibernateUtil;
import com.pfe.dao.SousTypeEntretienHome;
import com.pfe.persistance.SousTypeEntretien;

public class SousTypeEntretienService {

	private SousTypeEntretienHome dao;
	 
	public SousTypeEntretienService() {
		dao = new SousTypeEntretienHome();
	}
	public void ajouterSousTypeEntretien(SousTypeEntretien SoustypeE) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			dao.persist(SoustypeE);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}
	
	public void supprimerSousTypeEntretien(SousTypeEntretien SoustypeE) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			dao.delete(SoustypeE);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public SousTypeEntretien modifierSousTypeEntretien(SousTypeEntretien SoustypeE) {
		SousTypeEntretien SousTent = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			SousTent = dao.merge(SoustypeE);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return SousTent;
	}

	public SousTypeEntretien rechercheSousTypeEntretienParId(Integer id) {
		SousTypeEntretien SoustypeE = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			SoustypeE = dao.findById(id);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return SoustypeE;

	}
	
	////////liste sous type entretien/////////////
	public List<SousTypeEntretien> rechercheTousSousTypeEntretien() {
		List<SousTypeEntretien> liste = null;
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
