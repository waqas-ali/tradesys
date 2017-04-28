package com.trade.database.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trade.database.pojo.Product;

/**
 * This class is used to access data for the Product entity. Repository
 * annotation allows the component scanning support to find and configure the
 * DAO wihtout any XML configuration and also provide the Spring exceptiom
 * translation. Since we've setup setPackagesToScan and transaction manager on
 * DatabaseConfig, any bean method annotated with Transactional will cause
 * Spring to magically call begin() and commit() at the start/end of the method.
 * If exception occurs it will also call rollback().
 */
@Repository
@Transactional
public class ProductDAO {

	// An EntityManager will be automatically injected from entityManagerFactory
	// setup on DatabaseConfig class.
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Save the Product in the database.
	 */
	public void create(Product product) {
		entityManager.persist(product);
		return;
	}

	/**
	 * Delete the Product from the database.
	 */
	public void delete(Product product) {
		if (entityManager.contains(product))
			entityManager.remove(product);
		else
			entityManager.remove(entityManager.merge(product));
		return;
	}

	/**
	 * Return all the Products stored in the database.
	 */
	
	public List<Product> getAll() {
		TypedQuery<Product>  query =entityManager.createQuery("from Product",Product.class);
		List<Product> list = query.getResultList(); 
		return list;
	}

	/**
	 * Return all the Products stored in the database.
	 */
	
	public Product getProductDetail(int productId) {
		return entityManager.find(Product.class, productId);
	}
	/**
	 * Return the Product having the passed email.
	 */
	public List<Product> getByCategory(int categoryId) {
		TypedQuery<Product>  query =entityManager.createQuery("from Product where category_id = :category",Product.class);
		query.setParameter("category", categoryId);
		List<Product> list = query.getResultList();
		return list;
	}
	
	public List<Product> getByProducer(int UserId) {
		TypedQuery<Product>  query =entityManager.createQuery("from Product where user_id = :userId",Product.class);
		query.setParameter("userId", UserId);
		List<Product> list = query.getResultList();
		return list;
	}
	
	public List<Product> getByCriteria(String keyword) {
		TypedQuery<Product>  query =entityManager.createQuery("from Product where lower(prod_name) like :keyword",Product.class);
		query.setParameter("keyword", "%"+keyword.toLowerCase()+"%");
		List<Product> list = query.getResultList();
		return list;
	}

	/**
	 * Return the Product having the passed id.
	 */
	public Product getById(long id) {
		return entityManager.find(Product.class, id);
	}

	/**
	 * Update the passed Product in the database.
	 */
	public void update(Product product) {
		entityManager.merge(product);
		return;
	}

}
