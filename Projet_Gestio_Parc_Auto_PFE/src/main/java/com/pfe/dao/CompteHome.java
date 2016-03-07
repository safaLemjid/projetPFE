package com.pfe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.pfe.persistance.Compte;


public class CompteHome {
	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {

			return HibernateUtil.getSessionFactory();
		} catch (Exception e) {

			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}
	 
	public void persist(Compte c) {
		try {
			sessionFactory.getCurrentSession().persist(c);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(Compte c) {
		try {
			sessionFactory.getCurrentSession().delete(c);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public Compte  merge(Compte c) {
		try {
			Compte  result = (Compte ) sessionFactory.getCurrentSession()
					.merge(c);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	public Compte findById(Integer id) {
		try {
			Compte instance = (Compte) sessionFactory.getCurrentSession()
					.get(Compte.class, id);

			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	// Méthode retourne la liste de tous les personnes
			@SuppressWarnings("unchecked")
			public List<Compte> findAll() {
				Criteria crit = sessionFactory.getCurrentSession().createCriteria(
						Compte.class);
				return crit.list();

			}

			public Compte findByUtilisateurAndPassword(String l , String m) {
				Criteria crit = sessionFactory.getCurrentSession().createCriteria(
						Compte.class).add(Restrictions.and(Restrictions.eq("login", l),(Restrictions.eq("motDePasse",m))));
				return (Compte) crit.uniqueResult();

			}
				 

}
