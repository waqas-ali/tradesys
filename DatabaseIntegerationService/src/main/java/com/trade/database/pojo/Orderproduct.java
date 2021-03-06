package com.trade.database.pojo;

// Generated Apr 24, 2017 6:58:03 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Orderproduct generated by hbm2java
 */
@Entity
@Table(name = "orderproduct", catalog = "tradesys")
public class Orderproduct implements java.io.Serializable {

	private Integer id;
	private Order order;
	private Pricesslot pricesslot;
	private Product product;
	private Double prodQuantity;
	private Double price;
	private Set<Orderproductstatus> orderproductstatuses = new HashSet<Orderproductstatus>(
			0);

	public Orderproduct() {
	}

	public Orderproduct(Order order, Pricesslot pricesslot, Product product,
			Double prodQuantity, Double price,
			Set<Orderproductstatus> orderproductstatuses) {
		this.order = order;
		this.pricesslot = pricesslot;
		this.product = product;
		this.prodQuantity = prodQuantity;
		this.price = price;
		this.orderproductstatuses = orderproductstatuses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ord_id")
	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "price_id")
	public Pricesslot getPricesslot() {
		return this.pricesslot;
	}

	public void setPricesslot(Pricesslot pricesslot) {
		this.pricesslot = pricesslot;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prod_id")
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name = "prod_quantity", precision = 22, scale = 0)
	public Double getProdQuantity() {
		return this.prodQuantity;
	}

	public void setProdQuantity(Double prodQuantity) {
		this.prodQuantity = prodQuantity;
	}

	@Column(name = "price", precision = 22, scale = 0)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orderproduct")
	public Set<Orderproductstatus> getOrderproductstatuses() {
		return this.orderproductstatuses;
	}

	public void setOrderproductstatuses(
			Set<Orderproductstatus> orderproductstatuses) {
		this.orderproductstatuses = orderproductstatuses;
	}

}
