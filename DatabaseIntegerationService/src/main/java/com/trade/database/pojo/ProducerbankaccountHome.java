package com.trade.database.pojo;

// Generated Mar 19, 2017 4:34:58 PM by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Producerbankaccount.
 * @see com.trade.database.pojo.Producerbankaccount
 * @author Hibernate Tools
 */
@Stateless
public class ProducerbankaccountHome {

	private static final Log log = LogFactory
			.getLog(ProducerbankaccountHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Producerbankaccount transientInstance) {
		log.debug("persisting Producerbankaccount instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Producerbankaccount persistentInstance) {
		log.debug("removing Producerbankaccount instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Producerbankaccount merge(Producerbankaccount detachedInstance) {
		log.debug("merging Producerbankaccount instance");
		try {
			Producerbankaccount result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Producerbankaccount findById(Integer id) {
		log.debug("getting Producerbankaccount instance with id: " + id);
		try {
			Producerbankaccount instance = entityManager.find(
					Producerbankaccount.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
