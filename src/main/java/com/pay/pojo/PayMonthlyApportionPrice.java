package com.pay.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * pay_apportion_type:
 */
@Entity
@Table(name = "monthly_apportion_price")
public class PayMonthlyApportionPrice extends AbstractPojo implements Serializable{


	private Integer monthly;
	private BigDecimal price;
	private String remark;
	private Date createTime;
	private String createUser;
	
	@Id
	@Column(name = "monthly", nullable = false)
	public Integer getMonthly() {
		return monthly;
	}
	public void setMonthly(Integer monthly) {
		this.monthly = monthly;
	}
	@Column(name = "price", nullable = false)
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	@Column(name = "remark", nullable = false)
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Column(name = "create_time", nullable = false)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Column(name = "create_user", nullable = false)
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	
	
}
