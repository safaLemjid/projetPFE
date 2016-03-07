package com.pfe.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.pfe.dao.HibernateUtil;
import com.pfe.dao.TypePersonnelHome;
import com.pfe.persistance.Typepersonnel;

public class TypePersonnelService {
	 private TypePersonnelHome dao;
	 
		public TypePersonnelService() {
			dao = new TypePersonnelHome();
		}
		public void ajouterTypeP(Typepersonnel tp) {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = null;
			try {

				tx = session.beginTransaction();

				dao.persist(tp);
				tx.commit();

			} catch (RuntimeException ex) {

				if (tx != null)
					tx.rollback();
				ex.printStackTrace();
			}
		}
		
		public void supprimerTypePersonnel(Typepersonnel  tp) {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = null;
			try {

				tx = session.beginTransaction();

				dao.delete(tp);
				tx.commit();

			} catch (RuntimeException ex) {

				if (tx != null)
					tx.rollback();
				ex.printStackTrace();
			}
		}

		public Typepersonnel modifierTypePersonnel(Typepersonnel typ) {
			Typepersonnel tp = null;
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = null;
			try {

				tx = session.beginTransaction();

				tp = dao.merge(typ);
				tx.commit();

			} catch (RuntimeException ex) {

				if (tx != null)
					tx.rollback();
				ex.printStackTrace();
			}
			return tp;
		}

		public Typepersonnel rechercheTypePersonnelParId(Integer id) {
			Typepersonnel tp = null;
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = null;
			try {

				tx = session.beginTransaction();

				tp = dao.findById(id);
				tx.commit();

			} catch (RuntimeException ex) {

				if (tx != null)
					tx.rollback();
				ex.printStackTrace();
			}
			return tp;

		}
		
		////////liste personnel/////////////
		public List<Typepersonnel> rechercheTousTypePersonne() {
			List<Typepersonnel> liste = null;
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
