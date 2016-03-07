package com.pfe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import com.pfe.persistance.Typeentretien;

public class TypeEntretienHome {
	
	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {

			return HibernateUtil.getSessionFactory();
		} catch (Exception e) {

			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}
	
	public void persist(Typeentretien typeE) {
		try {
			sessionFactory.getCurrentSession().persist(typeE);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public void delete(Typeentretien typeE) {
		try {
			sessionFactory.getCurrentSession().delete(typeE);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	public Typeentretien merge(Typeentretien typeE) {
		try {
			Typeentretien  result = (Typeentretien) sessionFactory.getCurrentSession()
					.merge(typeE);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public Typeentretien  findById(Integer id) {
		try {
			Typeentretien  instance = (Typeentretien) sessionFactory.getCurrentSession()
					.get(Typeentretien.class, id);

			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	// Méthode retourne la liste de tous les personnes
		@SuppressWarnings("unchecked")
		public List<Typeentretien> findAll() {
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(
					Typeentretien.class);
			return crit.list();

		}
}
