package com.trade.database.pojo;

// Generated Mar 19, 2017 4:34:58 PM by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Courierservice.
 * @see com.trade.database.pojo.Courierservice
 * @author Hibernate Tools
 */
@Stateless
public class CourierserviceHome {

	private static final Log log = LogFactory.getLog(CourierserviceHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Courierservice transientInstance) {
		log.debug("persisting Courierservice instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Courierservice persistentInstance) {
		log.debug("removing Courierservice instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Courierservice merge(Courierservice detachedInstance) {
		log.debug("merging Courierservice instance");
		try {
			Courierservice result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Courierservice findById(Integer id) {
		log.debug("getting Courierservice instance with id: " + id);
		try {
			Courierservice instance = entityManager.find(Courierservice.class,
					id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
