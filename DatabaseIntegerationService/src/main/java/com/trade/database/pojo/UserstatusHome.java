package com.trade.database.pojo;

// Generated Mar 19, 2017 4:34:58 PM by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Userstatus.
 * @see com.trade.database.pojo.Userstatus
 * @author Hibernate Tools
 */
@Stateless
public class UserstatusHome {

	private static final Log log = LogFactory.getLog(UserstatusHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Userstatus transientInstance) {
		log.debug("persisting Userstatus instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Userstatus persistentInstance) {
		log.debug("removing Userstatus instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Userstatus merge(Userstatus detachedInstance) {
		log.debug("merging Userstatus instance");
		try {
			Userstatus result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Userstatus findById(Integer id) {
		log.debug("getting Userstatus instance with id: " + id);
		try {
			Userstatus instance = entityManager.find(Userstatus.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
