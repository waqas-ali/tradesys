package com.trade.database.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trade.database.pojo.Product;
import com.trade.database.pojo.User;

/**
 * This class is used to access data for the User entity. Repository
 * annotation allows the component scanning support to find and configure the
 * DAO wihtout any XML configuration and also provide the Spring exceptiom
 * translation. Since we've setup setPackagesToScan and transaction manager on
 * DatabaseConfig, any bean method annotated with Transactional will cause
 * Spring to magically call begin() and commit() at the start/end of the method.
 * If exception occurs it will also call rollback().
 */
@Repository
@Transactional
public class UserDAO {

	// An EntityManager will be automatically injected from entityManagerFactory
	// setup on DatabaseConfig class.
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Save the User in the database.
	 */
	public void create(User user) {
		entityManager.persist(user);
		return;
	}

	/**
	 * Delete the User from the database.
	 */
	public void delete(User user) {
		if (entityManager.contains(user))
			entityManager.remove(user);
		else
			entityManager.remove(entityManager.merge(user));
		return;
	}

	/**
	 * Return all the Users stored in the database.
	 */
	public List<User> getAll() {
		TypedQuery<User>  query =entityManager.createQuery("from User",User.class);
		List<User> list = query.getResultList(); 
		return list;		
	}

	/**
	 * Return the User having the passed user name.
	 */
	public User getByUsername(String userName) {
		TypedQuery<User>  query =entityManager.createQuery("from User where user_name = :user_name",User.class);
		query.setParameter("user_name", userName);
		User product = query.getSingleResult();
		return product;
	}

	/**
	 * Return the User having the passed id.
	 */
	public User getById(long id) {
		return entityManager.find(User.class, id);
	}

	/**
	 * Update the passed User in the database.
	 */
	public void update(User user) {
		entityManager.merge(user);
		return;
	}

}
