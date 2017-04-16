package com.trade.database.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trade.database.pojo.Category;

/**
 * This class is used to access data for the Category entity. Repository
 * annotation allows the component scanning support to find and configure the
 * DAO wihtout any XML configuration and also provide the Spring exceptiom
 * translation. Since we've setup setPackagesToScan and transaction manager on
 * DatabaseConfig, any bean method annotated with Transactional will cause
 * Spring to magically call begin() and commit() at the start/end of the method.
 * If exception occurs it will also call rollback().
 */
@Repository
@Transactional
public class CategoryDAO {

	// An EntityManager will be automatically injected from entityManagerFactory
	// setup on DatabaseConfig class.
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Save the Category in the database.
	 */
	public void create(Category category) {
		entityManager.persist(category);
		return;
	}

	/**
	 * Delete the Category from the database.
	 */
	public void delete(Category category) {
		if (entityManager.contains(category))
			entityManager.remove(category);
		else
			entityManager.remove(entityManager.merge(category));
		return;
	}

	/**
	 * Return all the Categorys stored in the database.
	 */
	
	public List<Category> getAll() {
		TypedQuery<Category>  query =entityManager.createQuery("from Category",Category.class);
		List<Category> list = query.getResultList(); 
		return list;
	}

	/**
	 * Return all the Categorys stored in the database.
	 */
	
	public Category getCategoryDetail(int categoryId) {
		TypedQuery<Category>  query =entityManager.createQuery("from Category where id = :prodId",Category.class);
		query.setParameter("prodId", categoryId);
		Category category = query.getSingleResult(); 
		return category;
	}
	/**
	 * Return the Category having the passed email.
	 */
	public Category getByEmail(String email) {
		return (Category) entityManager
				.createQuery("from Category where email = :email")
				.setParameter("email", email).getSingleResult();
	}

	/**
	 * Return the Category having the passed id.
	 */
	public Category getById(long id) {
		return entityManager.find(Category.class, id);
	}

	/**
	 * Update the passed Category in the database.
	 */
	public void update(Category category) {
		entityManager.merge(category);
		return;
	}

}
