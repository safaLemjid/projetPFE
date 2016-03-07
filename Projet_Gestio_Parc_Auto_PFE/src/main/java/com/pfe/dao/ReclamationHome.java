package com.pfe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import com.pfe.persistance.Reclamation;

public class ReclamationHome {

	

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {

			return HibernateUtil.getSessionFactory();
		} catch (Exception e) {

			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}
	
	public void persist(Reclamation R) {
		try {
			sessionFactory.getCurrentSession().persist(R);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public void delete(Reclamation R) {
		try {
			sessionFactory.getCurrentSession().delete(R);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	public Reclamation  merge(Reclamation R) {
		try {
			Reclamation  result = (Reclamation) sessionFactory.getCurrentSession()
					.merge(R);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public Reclamation findById(Integer id) {
		try {
			Reclamation  instance = (Reclamation) sessionFactory.getCurrentSession()
					.get(Reclamation.class, id);

			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	// Méthode retourne la liste de tous les reclamations
		@SuppressWarnings("unchecked")
		public List<Reclamation> findAll() {
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(
					Reclamation.class);
			return crit.list();

		}
		
		// Méthode retourne la liste de tous les personnes avec jointure
		// avec compte
		@SuppressWarnings("unchecked")
		public List<Reclamation> findAllWithJoin() {
			Criteria crit = sessionFactory.getCurrentSession()
					.createCriteria(Reclamation.class)
					.setFetchMode("personnel", FetchMode.JOIN);
			return crit.list();

		}
}
