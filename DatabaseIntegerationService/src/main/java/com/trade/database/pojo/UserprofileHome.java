package com.trade.database.pojo;

// Generated Mar 19, 2017 4:34:58 PM by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Userprofile.
 * @see com.trade.database.pojo.Userprofile
 * @author Hibernate Tools
 */
@Stateless
public class UserprofileHome {

	private static final Log log = LogFactory.getLog(UserprofileHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Userprofile transientInstance) {
		log.debug("persisting Userprofile instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Userprofile persistentInstance) {
		log.debug("removing Userprofile instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Userprofile merge(Userprofile detachedInstance) {
		log.debug("merging Userprofile instance");
		try {
			Userprofile result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Userprofile findById(int id) {
		log.debug("getting Userprofile instance with id: " + id);
		try {
			Userprofile instance = entityManager.find(Userprofile.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
