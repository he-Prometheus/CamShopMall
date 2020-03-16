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

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy = false)
@Table(name="admin")
public class Admin implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//strategy=GenerationType.IDENTITY 自增长
	@Column(name="adm_id")
	private Integer admId;
	
	@Column(name="adm_name")
	private String admName;
	
	@Column(name="adm_password")
	private String admPassword;
	
	@OneToMany(mappedBy="adm",fetch=FetchType.EAGER)
	private Set<Goods> admGoodsSet = new HashSet<Goods>();

	public Integer getAdmId() {
		return admId;
	}

	public void setAdmId(Integer admId) {
		this.admId = admId;
	}

	public String getAdmName() {
		return admName;
	}

	public void setAdmName(String admName) {
		this.admName = admName;
	}

	public String getAdmPassword() {
		return admPassword;
	}

	public void setAdmPassword(String admPassword) {
		this.admPassword = admPassword;
	}

	public Set<Goods> getAdmGoodsSet() {
		return admGoodsSet;
	}

	public void setAdmGoodsSet(Set<Goods> admGoodsSet) {
		this.admGoodsSet = admGoodsSet;
	}

	@Override
	public String toString() {
		return "Admin [admId=" + admId + ", admName=" + admName + ", admPassword=" + admPassword + "]";
	}

	
}
