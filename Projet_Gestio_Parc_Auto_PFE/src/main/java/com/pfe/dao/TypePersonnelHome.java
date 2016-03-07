package com.pfe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;

import com.pfe.persistance.Typepersonnel;

public class TypePersonnelHome {
	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {

			return HibernateUtil.getSessionFactory();
		} catch (Exception e) {

			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}
	
	public void persist(Typepersonnel type) {
		try {
			sessionFactory.getCurrentSession().persist(type);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public void delete(Typepersonnel type) {
		try {
			sessionFactory.getCurrentSession().delete(type);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	public Typepersonnel merge(Typepersonnel p) {
		try {
			Typepersonnel result = (Typepersonnel) sessionFactory.getCurrentSession()
					.merge(p);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public Typepersonnel  findById(Integer id) {
		try {
			Typepersonnel instance = (Typepersonnel) sessionFactory.getCurrentSession()
					.get(Typepersonnel.class, id);

			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	// Méthode retourne la liste de tous les typepersonnels
		@SuppressWarnings("unchecked")
		public List<Typepersonnel> findAll() {
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(
					Typepersonnel.class);
			return crit.list();

		}
		
		
}
