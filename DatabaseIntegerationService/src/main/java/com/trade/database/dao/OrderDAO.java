package com.trade.database.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trade.database.pojo.Order;

/**
 * This class is used to access data for the Order entity. Repository
 * annotation allows the component scanning support to find and configure the
 * DAO wihtout any XML configuration and also provide the Spring exceptiom
 * translation. Since we've setup setPackagesToScan and transaction manager on
 * DatabaseConfig, any bean method annotated with Transactional will cause
 * Spring to magically call begin() and commit() at the start/end of the method.
 * If exception occurs it will also call rollback().
 */
@Repository
@Transactional
public class OrderDAO {

	// An EntityManager will be automatically injected from entityManagerFactory
	// setup on DatabaseConfig class.
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Save the Order in the database.
	 */
	public void create(Order order) {
		entityManager.persist(order);
		return;
	}

	/**
	 * Delete the Order from the database.
	 */
	public void delete(Order order) {
		if (entityManager.contains(order))
			entityManager.remove(order);
		else
			entityManager.remove(entityManager.merge(order));
		return;
	}

	/**
	 * Return all the Orders stored in the database.
	 */
	@SuppressWarnings("unchecked")
	public List getAll() {
		return entityManager.createQuery("from Order").getResultList();
	}

	/**
	 * Return the Order having the passed email.
	 */
	public Order getByEmail(String email) {
		return (Order) entityManager
				.createQuery("from Order where email = :email")
				.setParameter("email", email).getSingleResult();
	}

	/**
	 * Return the Order having the passed id.
	 */
	public Order getById(long id) {
		return entityManager.find(Order.class, id);
	}

	/**
	 * Update the passed Order in the database.
	 */
	public void update(Order order) {
		entityManager.merge(order);
		return;
	}

}
