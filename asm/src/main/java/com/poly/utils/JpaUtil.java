package com.poly.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	private static EntityManagerFactory emf;
	public static EntityManager getEntityManager() {
		if(emf == null || !emf.isOpen()) {
			emf = Persistence.createEntityManagerFactory("OE");
		}
		return emf.createEntityManager();
	}
	public void shutDown() {
		if(emf != null || emf.isOpen()) {
			emf.close();
		}
		emf = null;
	}
}
