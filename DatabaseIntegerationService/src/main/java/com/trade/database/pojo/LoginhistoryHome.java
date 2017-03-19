package com.trade.database.pojo;

// Generated Mar 19, 2017 4:34:58 PM by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Loginhistory.
 * @see com.trade.database.pojo.Loginhistory
 * @author Hibernate Tools
 */
@Stateless
public class LoginhistoryHome {

	private static final Log log = LogFactory.getLog(LoginhistoryHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Loginhistory transientInstance) {
		log.debug("persisting Loginhistory instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Loginhistory persistentInstance) {
		log.debug("removing Loginhistory instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Loginhistory merge(Loginhistory detachedInstance) {
		log.debug("merging Loginhistory instance");
		try {
			Loginhistory result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Loginhistory findById(Integer id) {
		log.debug("getting Loginhistory instance with id: " + id);
		try {
			Loginhistory instance = entityManager.find(Loginhistory.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
