package com.pfe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import com.pfe.persistance.Mecanicien;

public class MecanicienHome {

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {

			return HibernateUtil.getSessionFactory();
		} catch (Exception e) {

			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}
	
	public void persist(Mecanicien m) {
		try {
			sessionFactory.getCurrentSession().persist(m);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public void delete(Mecanicien m) {
		try {
			sessionFactory.getCurrentSession().delete(m);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	public Mecanicien merge(Mecanicien m) {
		try {
			Mecanicien result = (Mecanicien) sessionFactory.getCurrentSession()
					.merge(m);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public Mecanicien findById(Integer id) {
		try {
			Mecanicien instance = (Mecanicien) sessionFactory.getCurrentSession()
					.get(Mecanicien.class, id);

			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	// Méthode retourne la liste de tous les personnes
		@SuppressWarnings("unchecked")
		public List<Mecanicien> findAll() {
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(
					Mecanicien.class);
			return crit.list();

		}
}
