package com.ithe.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
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

import org.springframework.data.repository.query.Param;

import com.ithe.entity.Admin;


@Entity
@Table(name="goods")
public class Goods implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="goods_id")
	private Integer goodsId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_goods_id")
	private User user_goods;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="adm_goods_id")
	private Admin adm;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="order_goods_id")
	private Order orders;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="goods_category_id")
	private Category category;
	
	@OneToMany(mappedBy="goods",fetch=FetchType.EAGER)
	private Set<Imgs> imgs = new HashSet<Imgs>();
	
	@OneToMany(mappedBy="goodsCom",fetch=FetchType.EAGER)
	private Set<Comment> goodsComments = new HashSet<Comment>();
	
	@Column(name="goods_name")
	private String goodsName;
	
	@Column(name="goods_price")
	private BigDecimal goodsPrice;
	
	@Column(name="goods_desc")
	private String goodsDesc;
	
	@Column(name="goods_modified_time")
	private Date goodsModifiedTime;
	
	@Column(name="belong")
	private Integer belong;

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Admin getAdm() {
		return adm;
	}

	public void setAdm(Admin adm) {
		this.adm = adm;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getGoodsDesc() {
		return goodsDesc;
	}

	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}

	public Integer getBelong() {
		return belong;
	}

	public void setBelong(Integer belong) {
		this.belong = belong;
	}
	
	public User getUser_goods() {
		return user_goods;
	}

	public void setUser_goods(User user_goods) {
		this.user_goods = user_goods;
	}

	public Set<Comment> getGoodsComments() {
		return goodsComments;
	}

	public void setGoodsComments(Set<Comment> goodsComments) {
		this.goodsComments = goodsComments;
	}

	public Date getGoodsModifiedTime() {
		return goodsModifiedTime;
	}

	public void setGoodsModifiedTime(Date goodsModifiedTime) {
		this.goodsModifiedTime = goodsModifiedTime;
	}

	public Order getOrders() {
		return orders;
	}

	public void setOrders(Order orders) {
		this.orders = orders;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Imgs> getImgs() {
		return imgs;
	}

	public void setImgs(Set<Imgs> imgs) {
		this.imgs = imgs;
	}

	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName + ", goodsPrice=" + goodsPrice + ", goodsDesc="
				+ goodsDesc + ", belong=" + belong + "]";
	}

}
