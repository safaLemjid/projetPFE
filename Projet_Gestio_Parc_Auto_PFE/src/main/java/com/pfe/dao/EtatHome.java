package com.pfe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import com.pfe.persistance.Etat;


public class EtatHome {

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {

			return HibernateUtil.getSessionFactory();
		} catch (Exception e) {

			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}
	
	public void persist(Etat e) {
		try {
			sessionFactory.getCurrentSession().persist(e);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public void delete(Etat e) {
		try {
			sessionFactory.getCurrentSession().delete(e);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	public Etat merge(Etat e) {
		try {
			Etat result = (Etat) sessionFactory.getCurrentSession()
					.merge(e);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public Etat findById(Integer id) {
		try {
			Etat instance = (Etat) sessionFactory.getCurrentSession()
					.get(Etat.class, id);

			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	// Méthode retourne la liste de tous les personnes
		@SuppressWarnings("unchecked")
		public List<Etat> findAll() {
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(
					Etat.class);
			return crit.list();

		}
		
}
