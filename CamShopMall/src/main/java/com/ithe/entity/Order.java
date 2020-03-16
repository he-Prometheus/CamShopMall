package com.ithe.entity;


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="order_detail")
public class Order implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
	private Integer ordeId;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="order_user_id")
    private User user_orders;
    
	@OneToMany(mappedBy="orders",fetch=FetchType.EAGER)
	private Set<Goods> orderGoodsSet = new HashSet<Goods>();
	
	@Column(name="order_modified_time")
	private Date orderModifiedTime;

	public Integer getOrdeId() {
		return ordeId;
	}

	public void setOrdeId(Integer ordeId) {
		this.ordeId = ordeId;
	}




	public User getUser_orders() {
		return user_orders;
	}

	public void setUser_orders(User user_orders) {
		this.user_orders = user_orders;
	}

	public Set<Goods> getOrderGoodsSet() {
		return orderGoodsSet;
	}


	public void setOrderGoodsSet(Set<Goods> orderGoodsSet) {
		this.orderGoodsSet = orderGoodsSet;
	}

	public Date getOrderModifiedTime() {
		return orderModifiedTime;
	}


	public void setOrderModifiedTime(Date orderModifiedTime) {
		this.orderModifiedTime = orderModifiedTime;
	}


	@Override
	public String toString() {
		return "Order [ordeId=" + ordeId + ", orderModifiedTime=" + orderModifiedTime + "]";
	}



}
