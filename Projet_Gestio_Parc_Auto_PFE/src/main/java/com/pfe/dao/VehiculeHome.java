package com.pfe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import com.pfe.persistance.Vehicule;

public class VehiculeHome {
	
	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {

			return HibernateUtil.getSessionFactory();
		} catch (Exception e) {

			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}
	
	public void persist(Vehicule v) {
		try {
			sessionFactory.getCurrentSession().persist(v);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public void delete(Vehicule v) {
		try {
			sessionFactory.getCurrentSession().delete(v);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	public Vehicule merge(Vehicule v) {
		try {
			Vehicule result = (Vehicule) sessionFactory.getCurrentSession()
					.merge(v);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public Vehicule findById(Integer id) {
		try {
			Vehicule instance = (Vehicule) sessionFactory.getCurrentSession()
					.get(Vehicule.class, id);

			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	// Méthode retourne la liste de tous les personnes
		@SuppressWarnings("unchecked")
		public List<Vehicule> findAll() {
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(
					Vehicule.class);
			return crit.list();

		}
		
		

}
