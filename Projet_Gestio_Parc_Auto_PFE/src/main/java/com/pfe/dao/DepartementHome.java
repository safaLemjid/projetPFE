package com.pfe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import com.pfe.persistance.Departement;

public class DepartementHome {
	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {

			return HibernateUtil.getSessionFactory();
		} catch (Exception e) {

			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}
	
	public void persist(Departement d) {
		try {
			sessionFactory.getCurrentSession().persist(d);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public void delete(Departement d) {
		try {
			sessionFactory.getCurrentSession().delete(d);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	public Departement merge(Departement d) {
		try {
			Departement  result = (Departement ) sessionFactory.getCurrentSession()
					.merge(d);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public Departement  findById(Integer id) {
		try {
			Departement instance = (Departement) sessionFactory.getCurrentSession()
					.get(Departement.class, id);

			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	// Méthode retourne la liste de tous les personnes
		@SuppressWarnings("unchecked")
		public List<Departement> findAll() {
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(
					Departement.class);
			return crit.list();

		}
}
