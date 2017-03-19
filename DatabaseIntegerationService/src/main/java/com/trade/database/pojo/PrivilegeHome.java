package com.trade.database.pojo;

// Generated Mar 19, 2017 4:34:58 PM by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Privilege.
 * @see com.trade.database.pojo.Privilege
 * @author Hibernate Tools
 */
@Stateless
public class PrivilegeHome {

	private static final Log log = LogFactory.getLog(PrivilegeHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Privilege transientInstance) {
		log.debug("persisting Privilege instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Privilege persistentInstance) {
		log.debug("removing Privilege instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Privilege merge(Privilege detachedInstance) {
		log.debug("merging Privilege instance");
		try {
			Privilege result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Privilege findById(Integer id) {
		log.debug("getting Privilege instance with id: " + id);
		try {
			Privilege instance = entityManager.find(Privilege.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
