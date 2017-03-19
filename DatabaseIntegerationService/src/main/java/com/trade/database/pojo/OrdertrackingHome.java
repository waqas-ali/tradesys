package com.trade.database.pojo;

// Generated Mar 19, 2017 4:34:58 PM by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Ordertracking.
 * @see com.trade.database.pojo.Ordertracking
 * @author Hibernate Tools
 */
@Stateless
public class OrdertrackingHome {

	private static final Log log = LogFactory.getLog(OrdertrackingHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Ordertracking transientInstance) {
		log.debug("persisting Ordertracking instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Ordertracking persistentInstance) {
		log.debug("removing Ordertracking instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Ordertracking merge(Ordertracking detachedInstance) {
		log.debug("merging Ordertracking instance");
		try {
			Ordertracking result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Ordertracking findById(Integer id) {
		log.debug("getting Ordertracking instance with id: " + id);
		try {
			Ordertracking instance = entityManager
					.find(Ordertracking.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
