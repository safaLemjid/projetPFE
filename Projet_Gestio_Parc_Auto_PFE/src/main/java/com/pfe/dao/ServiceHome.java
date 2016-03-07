package com.pfe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import com.pfe.persistance.Service;

public class ServiceHome {
	
	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {

			return HibernateUtil.getSessionFactory();
		} catch (Exception e) {

			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}
	
	public void persist(Service s) {
		try {
			sessionFactory.getCurrentSession().persist(s);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public void delete(Service s) {
		try {
			sessionFactory.getCurrentSession().delete(s);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	public Service merge(Service s) {
		try {
			Service  result = (Service ) sessionFactory.getCurrentSession()
					.merge(s);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public Service  findById(Integer id) {
		try {
			Service  instance = (Service ) sessionFactory.getCurrentSession()
					.get(Service .class, id);

			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	// Méthode retourne la liste de tous les service
		@SuppressWarnings("unchecked")
		public List<Service > findAll() {
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(
					Service.class);
			return crit.list();

		}
}
