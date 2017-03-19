package com.trade.database.pojo;

// Generated Mar 19, 2017 4:34:58 PM by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Bet.
 * @see com.trade.database.pojo.Bet
 * @author Hibernate Tools
 */
@Stateless
public class BetHome {

	private static final Log log = LogFactory.getLog(BetHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Bet transientInstance) {
		log.debug("persisting Bet instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Bet persistentInstance) {
		log.debug("removing Bet instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Bet merge(Bet detachedInstance) {
		log.debug("merging Bet instance");
		try {
			Bet result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Bet findById(Integer id) {
		log.debug("getting Bet instance with id: " + id);
		try {
			Bet instance = entityManager.find(Bet.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
