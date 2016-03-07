package com.pfe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import com.pfe.persistance.Categorie;

public class CategorieHome {

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {

			return HibernateUtil.getSessionFactory();
		} catch (Exception e) {

			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}
	
	public void persist(Categorie c) {
		try {
			sessionFactory.getCurrentSession().persist(c);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public void delete(Categorie c) {
		try {
			sessionFactory.getCurrentSession().delete(c);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	public Categorie merge(Categorie c) {
		try {
			Categorie result = (Categorie) sessionFactory.getCurrentSession()
					.merge(c);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public Categorie findById(Integer id) {
		try {
			Categorie instance = (Categorie) sessionFactory.getCurrentSession()
					.get(Categorie.class, id);

			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	// Méthode retourne la liste de tous les personnes
		@SuppressWarnings("unchecked")
		public List<Categorie> findAll() {
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(
					Categorie.class);
			return crit.list();

		}
}
