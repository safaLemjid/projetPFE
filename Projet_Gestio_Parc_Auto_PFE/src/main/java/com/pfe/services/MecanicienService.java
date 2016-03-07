package com.pfe.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pfe.dao.HibernateUtil;
import com.pfe.dao.MecanicienHome;
import com.pfe.persistance.Mecanicien;


public class MecanicienService {

	 private MecanicienHome dao;
	 
		public MecanicienService() {
			dao = new MecanicienHome();
		}
		public void ajouterMecanicien(Mecanicien m) {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = null;
			try {

				tx = session.beginTransaction();

				dao.persist(m);
				tx.commit();

			} catch (RuntimeException ex) {

				if (tx != null)
					tx.rollback();
				ex.printStackTrace();
			}
		}
		
		public void supprimerMecanicien(Mecanicien m) {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = null;
			try {

				tx = session.beginTransaction();

				dao.delete(m);
				tx.commit();

			} catch (RuntimeException ex) {

				if (tx != null)
					tx.rollback();
				ex.printStackTrace();
			}
		}

		public Mecanicien modifierMecanicien(Mecanicien m) {
			Mecanicien mec = null;
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = null;
			try {

				tx = session.beginTransaction();

				mec= dao.merge(m);
				tx.commit();

			} catch (RuntimeException ex) {

				if (tx != null)
					tx.rollback();
				ex.printStackTrace();
			}
			return mec;
		}

		public Mecanicien rechercheMecanicienParId(Integer id) {
			Mecanicien m = null;
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = null;
			try {

				tx = session.beginTransaction();

				m = dao.findById(id);
				tx.commit();

			} catch (RuntimeException ex) {

				if (tx != null)
					tx.rollback();
				ex.printStackTrace();
			}
			return m;

		}
		
		////////liste personnel/////////////
		public List<Mecanicien> rechercheTousMecanicien() {
			List<Mecanicien> liste = null;
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
