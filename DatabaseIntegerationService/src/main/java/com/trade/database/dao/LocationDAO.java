package com.trade.database.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trade.database.pojo.Location;

/**
 * This class is used to access data for the Location entity. Repository
 * annotation allows the component scanning support to find and configure the
 * DAO wihtout any XML configuration and also provide the Spring exceptiom
 * translation. Since we've setup setPackagesToScan and transaction manager on
 * DatabaseConfig, any bean method annotated with Transactional will cause
 * Spring to magically call begin() and commit() at the start/end of the method.
 * If exception occurs it will also call rollback().
 */
@Repository
@Transactional
public class LocationDAO {

	// An EntityManager will be automatically injected from entityManagerFactory
	// setup on DatabaseConfig class.
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Save the Location in the database.
	 */
	public void create(Location location) {
		entityManager.persist(location);
		return;
	}

	/**
	 * Delete the Location from the database.
	 */
	public void delete(Location location) {
		if (entityManager.contains(location))
			entityManager.remove(location);
		else
			entityManager.remove(entityManager.merge(location));
		return;
	}

	/**
	 * Return all the Locations stored in the database.
	 */
	@SuppressWarnings("unchecked")
	public List getAll() {
		return entityManager.createQuery("from Location").getResultList();
	}

	/**
	 * Return the Location having the passed email.
	 */
	public Location getByEmail(String email) {
		return (Location) entityManager
				.createQuery("from Location where email = :email")
				.setParameter("email", email).getSingleResult();
	}

	/**
	 * Return the Location having the passed id.
	 */
	public Location getById(long id) {
		return entityManager.find(Location.class, id);
	}

	/**
	 * Update the passed Location in the database.
	 */
	public void update(Location location) {
		entityManager.merge(location);
		return;
	}

}
