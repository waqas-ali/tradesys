package com.trade.database.pojo;

// Generated Mar 19, 2017 4:34:58 PM by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Producerprofile.
 * @see com.trade.database.pojo.Producerprofile
 * @author Hibernate Tools
 */
@Stateless
public class ProducerprofileHome {

	private static final Log log = LogFactory.getLog(ProducerprofileHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Producerprofile transientInstance) {
		log.debug("persisting Producerprofile instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Producerprofile persistentInstance) {
		log.debug("removing Producerprofile instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Producerprofile merge(Producerprofile detachedInstance) {
		log.debug("merging Producerprofile instance");
		try {
			Producerprofile result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Producerprofile findById(Integer id) {
		log.debug("getting Producerprofile instance with id: " + id);
		try {
			Producerprofile instance = entityManager.find(
					Producerprofile.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
