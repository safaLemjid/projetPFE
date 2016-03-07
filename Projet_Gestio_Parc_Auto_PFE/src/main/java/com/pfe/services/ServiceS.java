package com.pfe.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.pfe.dao.HibernateUtil;
import com.pfe.dao.ServiceHome;
import com.pfe.persistance.Service;

public class ServiceS {
	 private ServiceHome dao;
	 
		public ServiceS() {
			dao = new ServiceHome();
		}
		public void ajouterService(Service s) {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = null;
			try {

				tx = session.beginTransaction();

				dao.persist(s);
				tx.commit();

			} catch (RuntimeException ex) {

				if (tx != null)
					tx.rollback();
				ex.printStackTrace();
			}
		}
		
		public void supprimerService(Service s) {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = null;
			try {

				tx = session.beginTransaction();

				dao.delete(s);
				tx.commit();

			} catch (RuntimeException ex) {

				if (tx != null)
					tx.rollback();
				ex.printStackTrace();
			}
		}

		public Service modifierService(Service s) {
			Service ss = null;
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = null;
			try {

				tx = session.beginTransaction();

				ss = dao.merge(s);
				tx.commit();

			} catch (RuntimeException ex) {

				if (tx != null)
					tx.rollback();
				ex.printStackTrace();
			}
			return ss;
		}

		public Service rechercheServiceParId(Integer id) {
			Service s = null;
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = null;
			try {

				tx = session.beginTransaction();

				s = dao.findById(id);
				tx.commit();

			} catch (RuntimeException ex) {

				if (tx != null)
					tx.rollback();
				ex.printStackTrace();
			}
			return s;

		}
		
		////////liste personnel/////////////
		public List<Service> rechercheTousService() {
			List<Service> liste = null;
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
