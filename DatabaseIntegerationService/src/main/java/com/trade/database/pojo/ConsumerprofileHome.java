package com.trade.database.pojo;

// Generated Mar 19, 2017 4:34:58 PM by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Consumerprofile.
 * @see com.trade.database.pojo.Consumerprofile
 * @author Hibernate Tools
 */
@Stateless
public class ConsumerprofileHome {

	private static final Log log = LogFactory.getLog(ConsumerprofileHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Consumerprofile transientInstance) {
		log.debug("persisting Consumerprofile instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Consumerprofile persistentInstance) {
		log.debug("removing Consumerprofile instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Consumerprofile merge(Consumerprofile detachedInstance) {
		log.debug("merging Consumerprofile instance");
		try {
			Consumerprofile result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Consumerprofile findById(Integer id) {
		log.debug("getting Consumerprofile instance with id: " + id);
		try {
			Consumerprofile instance = entityManager.find(
					Consumerprofile.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
