package com.ithe.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="produce_comment")
public class Comment implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="com_id")
	private Integer comId;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="com_user_id")
	private User user_comment;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="com_goods_id")
	private Goods goodsCom;
	
	@Column(name="com_content")
	private String comContent;
	
	@Column(name="com_audit_time")
	private Date comAuditTime;

	public Integer getComId() {
		return comId;
	}

	public void setComId(Integer comId) {
		this.comId = comId;
	}

	public User getUser_comment() {
		return user_comment;
	}

	public void setUser_comment(User user_comment) {
		this.user_comment = user_comment;
	}

	public Goods getGoodsCom() {
		return goodsCom;
	}

	public void setGoodsCom(Goods goodsCom) {
		this.goodsCom = goodsCom;
	}

	public String getComContent() {
		return comContent;
	}

	public void setComContent(String comContent) {
		this.comContent = comContent;
	}

	public Date getComAuditTime() {
		return comAuditTime;
	}

	public void setComAuditTime(Date comAuditTime) {
		this.comAuditTime = comAuditTime;
	}

	@Override
	public String toString() {
		return "Comment [comId=" + comId + ", comContent=" + comContent + ", comAuditTime=" + comAuditTime + "]";
	}
	
}
