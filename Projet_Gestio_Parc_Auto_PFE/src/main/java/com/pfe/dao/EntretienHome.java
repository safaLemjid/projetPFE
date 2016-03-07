package com.pfe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import com.pfe.persistance.Entretien;


public class EntretienHome {
	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {

			return HibernateUtil.getSessionFactory();
		} catch (Exception e) {

			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}
	
	public void persist(Entretien ent) {
		try {
			sessionFactory.getCurrentSession().persist(ent);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public void delete(Entretien ent) {
		try {
			sessionFactory.getCurrentSession().delete(ent);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	public Entretien  merge(Entretien ent) {
		try {
			Entretien  result = (Entretien ) sessionFactory.getCurrentSession()
					.merge(ent);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public Entretien  findById(Integer id) {
		try {
			Entretien  instance = (Entretien ) sessionFactory.getCurrentSession()
					.get(Entretien.class, id);

			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	// Méthode retourne la liste de tous les personnes
		@SuppressWarnings("unchecked")
		public List<Entretien > findAll() {
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(
					Entretien.class);
			return crit.list();

		}
		
		// Méthode retourne la liste de tous les entretien avec jointure
		// avec typeentretien
		@SuppressWarnings("unchecked")
		public List<Entretien > findAllWithJoin() {
			Criteria crit = sessionFactory.getCurrentSession()
					.createCriteria(Entretien .class)
					.setFetchMode("typeentretien", FetchMode.JOIN);
			return crit.list();

		}
}
