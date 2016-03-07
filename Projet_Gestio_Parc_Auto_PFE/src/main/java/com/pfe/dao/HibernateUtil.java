package com.pfe.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	// C'est la m�thode qui nous permet d'ouvrire une session
	// sur la base selon la configuration d�crite dans faces.cfg.xml
	private static SessionFactory buildSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure();

		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();

		return configuration.buildSessionFactory(sr);
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}