package com.pay.pojo.waterpay;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.math.BigDecimal;



@Entity
@Table(name = "pay_info")
public class PayInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	
	
	
	
	public PayInfo() {
		super();
	}



	@Id
	@Column(name = "pay_code")
	private String payCode;
	@Column(name = "water_price")
	private BigDecimal waterPrice;
	@Column(name = "garbage_price")
	private BigDecimal garbagePrice;
	@Column(name = "actual_garbage_price")
	private BigDecimal actualGarbagePrice;
	@Column(name = "network_price")
	private BigDecimal networkPrice;
	@Column(name = "actual_network_price")
	private BigDecimal actualNetworkPrice;
	@Column(name = "sewage_price")
	private BigDecimal sewagePrice;
	@Column(name = "other_price")
	private BigDecimal otherPrice;
	@Column(name = "late_fee")
	private BigDecimal lateFee;
	@Column(name = "total_price")
	private BigDecimal totalPrice;
	@Column(name = "actual_total_price")
	private BigDecimal actualTotalPrice;
	@Column(name = "status")
	private Integer status;
	@Column(name = "remark")
	private String remark;
	@Column(name = "pay_date")
	private Date payDate;
	@Column(name = "toll_collector")
	private String tollCollector;
	@Column(name = "create_user")
	private String createUser;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time")
	private Date createTime;
	@Column(name = "last_modify_user")
	private String lastModifyUser;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_modify_time")
	private Date lastModifyTime;

	/**
	 * 设置：
	 */
	public void setPayCode(String payCode) {
		this.payCode = payCode;
	}
	/**
	 * 获取：
	 */
	public String getPayCode() {
		return payCode;
	}

	
	/**
	 * 设置：
	 */
	public void setActualGarbagePrice(BigDecimal actualGarbagePrice) {
		this.actualGarbagePrice = actualGarbagePrice;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getActualGarbagePrice() {
		return actualGarbagePrice;
	}

	/**
	 * 设置：
	 */
	public void setActualNetworkPrice(BigDecimal actualNetworkPrice) {
		this.actualNetworkPrice = actualNetworkPrice;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getActualNetworkPrice() {
		return actualNetworkPrice;
	}

	
	/**
	 * 设置：
	 */
	public void setActualTotalPrice(BigDecimal actualTotalPrice) {
		this.actualTotalPrice = actualTotalPrice;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getActualTotalPrice() {
		return actualTotalPrice;
	}
	/**
	 * 设置：
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：
	 */
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	/**
	 * 获取：
	 */
	public Date getPayDate() {
		return payDate;
	}
	/**
	 * 设置：
	 */
	public void setTollCollector(String tollCollector) {
		this.tollCollector = tollCollector;
	}
	/**
	 * 获取：
	 */
	public String getTollCollector() {
		return tollCollector;
	}
	/**
	 * 设置：
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：
	 */
	public void setLastModifyUser(String lastModifyUser) {
		this.lastModifyUser = lastModifyUser;
	}
	/**
	 * 获取：
	 */
	public String getLastModifyUser() {
		return lastModifyUser;
	}
	/**
	 * 设置：
	 */
	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}
	/**
	 * 获取：
	 */
	public Date getLastModifyTime() {
		return lastModifyTime;
	}
	public BigDecimal getWaterPrice() {
		return waterPrice;
	}
	public void setWaterPrice(BigDecimal waterPrice) {
		this.waterPrice = waterPrice;
	}
	public BigDecimal getGarbagePrice() {
		return garbagePrice;
	}
	public void setGarbagePrice(BigDecimal garbagePrice) {
		this.garbagePrice = garbagePrice;
	}
	public BigDecimal getNetworkPrice() {
		return networkPrice;
	}
	public void setNetworkPrice(BigDecimal networkPrice) {
		this.networkPrice = networkPrice;
	}
	public BigDecimal getSewagePrice() {
		return sewagePrice;
	}
	public void setSewagePrice(BigDecimal sewagePrice) {
		this.sewagePrice = sewagePrice;
	}
	public BigDecimal getOtherPrice() {
		return otherPrice;
	}
	public void setOtherPrice(BigDecimal otherPrice) {
		this.otherPrice = otherPrice;
	}
	public BigDecimal getLateFee() {
		return lateFee;
	}
	public void setLateFee(BigDecimal lateFee) {
		this.lateFee = lateFee;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "PayPaymentInfo [payCode=" + payCode + ", waterPrice=" + waterPrice + ", garbagePrice=" + garbagePrice
				+ ", actualGarbagePrice=" + actualGarbagePrice + ", networkPrice=" + networkPrice
				+ ", actualNetworkPrice=" + actualNetworkPrice + ", sewagePrice=" + sewagePrice + ", otherPrice="
				+ otherPrice + ", lateFee=" + lateFee + ", totalPrice=" + totalPrice + ", actualTotalPrice="
				+ actualTotalPrice + ", status=" + status + ", remark=" + remark + ", payDate=" + payDate
				+ ", tollCollector=" + tollCollector + ", createUser=" + createUser + ", createTime=" + createTime
				+ ", lastModifyUser=" + lastModifyUser + ", lastModifyTime=" + lastModifyTime + "]";
	}


	
	
	
}
