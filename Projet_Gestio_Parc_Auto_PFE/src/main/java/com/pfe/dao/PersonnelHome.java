package com.pfe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import com.pfe.persistance.Personnel;


public class PersonnelHome {

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {

			return HibernateUtil.getSessionFactory();
		} catch (Exception e) {

			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}
	
	public void persist(Personnel p) {
		try {
			sessionFactory.getCurrentSession().persist(p);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public void delete(Personnel p) {
		try {
			sessionFactory.getCurrentSession().delete(p);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	public Personnel merge(Personnel p) {
		try {
			Personnel result = (Personnel) sessionFactory.getCurrentSession()
					.merge(p);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public Personnel findById(Integer id) {
		try {
			Personnel instance = (Personnel) sessionFactory.getCurrentSession()
					.get(Personnel.class, id);

			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	// Méthode retourne la liste de tous les personnes
		@SuppressWarnings("unchecked")
		public List<Personnel> findAll() {
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(
					Personnel.class);
			return crit.list();

		}
		
		// Méthode retourne la liste de tous les personnes avec jointure
		// avec compte
		@SuppressWarnings("unchecked")
		public List<Personnel> findAllWithJoin() {
			Criteria crit = sessionFactory.getCurrentSession()
					.createCriteria(Personnel.class)
					.setFetchMode("compte", FetchMode.JOIN);
			return crit.list();

		}
}
