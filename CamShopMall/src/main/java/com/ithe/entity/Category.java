package com.ithe.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="produce_category")
public class Category implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pro_id")
	private Integer proId;
	
	@Column(name="pro_name")
	private String proName;
	
	@OneToMany(mappedBy="category",fetch=FetchType.EAGER)
	private Set<Goods> goodsSet = new HashSet<Goods>();

	
	
	public Integer getProId() {
		return proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public Set<Goods> getGoodsSet() {
		return goodsSet;
	}

	public void setGoodsSet(Set<Goods> goodsSet) {
		this.goodsSet = goodsSet;
	}

	@Override
	public String toString() {
		return "Category [proId=" + proId + ", proName=" + proName + "]";
	}

	
	
}
