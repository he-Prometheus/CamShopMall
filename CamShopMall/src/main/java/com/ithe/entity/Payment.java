package com.ithe.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="payment_records")
public class Payment implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pay_id")
	private Integer payId;
//	卖方
	@Column(name="pay_sell_id")
	private Integer paySellId;
	
	@Column(name="pay_sell_name")
	private String paySellName;
//	买方
	@Column(name="pay_buy_id")
	private Integer payBuyId;
	
	@Column(name="pay_buy_name")
	private String payBuyName;
	
	@Column(name="pay_goods_id")
	private Integer payGoodsId;
	
	@Column(name="pay_goods_name")
	private String payGoodsName;
	
	@Column(name="pay_price")
	private BigDecimal payPrice;
	
	@Column(name="pay_records_time")
	private Date payRecordsTime;

	public Integer getPayId() {
		return payId;
	}

	public void setPayId(Integer payId) {
		this.payId = payId;
	}

	public Integer getPaySellId() {
		return paySellId;
	}

	public void setPaySellId(Integer paySellId) {
		this.paySellId = paySellId;
	}

	public String getPaySellName() {
		return paySellName;
	}

	public void setPaySellName(String paySellName) {
		this.paySellName = paySellName;
	}

	public Integer getPayBuyId() {
		return payBuyId;
	}

	public void setPayBuyId(Integer payBuyId) {
		this.payBuyId = payBuyId;
	}

	public String getPayBuyName() {
		return payBuyName;
	}

	public void setPayBuyName(String payBuyName) {
		this.payBuyName = payBuyName;
	}

	public Integer getPayGoodsId() {
		return payGoodsId;
	}

	public void setPayGoodsId(Integer payGoodsId) {
		this.payGoodsId = payGoodsId;
	}

	public String getPayGoodsName() {
		return payGoodsName;
	}

	public void setPayGoodsName(String payGoodsName) {
		this.payGoodsName = payGoodsName;
	}

	public BigDecimal getPayPrice() {
		return payPrice;
	}

	public void setPayPrice(BigDecimal payPrice) {
		this.payPrice = payPrice;
	}

	public Date getPayRecordsTime() {
		return payRecordsTime;
	}

	public void setPayRecordsTime(Date payRecordsTime) {
		this.payRecordsTime = payRecordsTime;
	}

	@Override
	public String toString() {
		return "Payment [payId=" + payId + ", paySellId=" + paySellId + ", paySellName=" + paySellName + ", payBuyId="
				+ payBuyId + ", payBuyName=" + payBuyName + ", payGoodsId=" + payGoodsId + ", payGoodsName="
				+ payGoodsName + ", payPrice=" + payPrice + ", payRecordsTime=" + payRecordsTime + "]";
	}
	
}
