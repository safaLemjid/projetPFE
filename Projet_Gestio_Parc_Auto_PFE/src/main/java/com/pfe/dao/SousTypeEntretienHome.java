package com.pfe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import com.pfe.persistance.SousTypeEntretien;

public class SousTypeEntretienHome {
	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {

			return HibernateUtil.getSessionFactory();
		} catch (Exception e) {

			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}
	
	public void persist(SousTypeEntretien soustype) {
		try {
			sessionFactory.getCurrentSession().persist(soustype);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public void delete(SousTypeEntretien soustype) {
		try {
			sessionFactory.getCurrentSession().delete(soustype);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	public SousTypeEntretien  merge(SousTypeEntretien soustype) {
		try {
			SousTypeEntretien result = (SousTypeEntretien) sessionFactory.getCurrentSession()
					.merge(soustype);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public SousTypeEntretien  findById(Integer id) {
		try {
			SousTypeEntretien  instance = (SousTypeEntretien) sessionFactory.getCurrentSession()
					.get(SousTypeEntretien.class, id);

			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	// Méthode retourne la liste de tous les personnes
		@SuppressWarnings("unchecked")
		public List<SousTypeEntretien> findAll() {
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(
					SousTypeEntretien.class);
			return crit.list();

		}
		
}
