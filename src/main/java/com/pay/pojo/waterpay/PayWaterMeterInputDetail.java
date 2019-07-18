package com.pay.pojo.waterpay;
import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * pay_water_meter_input_detail:
 */
@Entity
@IdClass(PayWaterMeterInputDetailPK.class)
@Table(name = "pay_water_meter_input_detail")
public class PayWaterMeterInputDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * code:
	 */
	@PropertyDef(label = "code", description = "code:")
	private String code;

	/**
	 * monthly_cycle:
	 */
	@PropertyDef(label = "monthly_cycle", description = "monthly_cycle:")
	private int monthlyCycle;

	/**
	 * building_code:
	 */
	@PropertyDef(label = "building_code", description = "building_code:")
	private String buildingCode;

	/**
	 * room_no:
	 */
	@PropertyDef(label = "room_no", description = "room_no:")
	private String roomNo;

	/**
	 * water_meter_code:
	 */
	@PropertyDef(label = "water_meter_code", description = "water_meter_code:")
	private String waterMeterCode;

	/**
	 * before_qty:
	 */
	@PropertyDef(label = "before_qty", description = "before_qty:")
	private BigDecimal beforeQty;

	/**
	 * current_qty:
	 */
	@PropertyDef(label = "current_qty", description = "current_qty:")
	private BigDecimal currentQty;

	/**
	 * garbage_price:
	 */
	@PropertyDef(label = "garbage_price", description = "garbage_price:")
	private BigDecimal garbagePrice;

	/**
	 * network_price:
	 */
	@PropertyDef(label = "network_price", description = "network_price:")
	private BigDecimal networkPrice;

	/**
	 * sewage_price:
	 */
	@PropertyDef(label = "sewage_price", description = "sewage_price:")
	private BigDecimal sewagePrice;

	/**
	 * other_price:
	 */
	@PropertyDef(label = "other_price", description = "other_price:")
	private BigDecimal otherPrice;

	/**
	 * status:
	 */
	@PropertyDef(label = "status", description = "status:")
	private int status;

	/**
	 * remark:
	 */
	@PropertyDef(label = "remark", description = "remark:")
	private String remark;

	/**
	 * create_user:
	 */
	@PropertyDef(label = "create_user", description = "create_user:")
	private String createUser;

	/**
	 * create_time:
	 */
	@PropertyDef(label = "create_time", description = "create_time:")
	private Date createTime;

	/**
	 * last_modify_user:
	 */
	@PropertyDef(label = "last_modify_user", description = "last_modify_user:")
	private String lastModifyUser;

	/**
	 * last_modify_time:
	 */
	@PropertyDef(label = "last_modify_time", description = "last_modify_time:")
	private Date lastModifyTime;
	
	private String notExistsStatus;
	
	private String userCode;

	public PayWaterMeterInputDetail() {
		super();
	}



	public PayWaterMeterInputDetail(String code, int monthlyCycle, String buildingCode, String roomNo,
			String waterMeterCode, BigDecimal beforeQty, BigDecimal currentQty, BigDecimal garbagePrice,
			BigDecimal networkPrice, BigDecimal sewagePrice, BigDecimal otherPrice, int status, String remark,
			String createUser, Date createTime, String lastModifyUser, Date lastModifyTime, String notExistsStatus,
			String userCode) {
		super();
		this.code = code;
		this.monthlyCycle = monthlyCycle;
		this.buildingCode = buildingCode;
		this.roomNo = roomNo;
		this.waterMeterCode = waterMeterCode;
		this.beforeQty = beforeQty;
		this.currentQty = currentQty;
		this.garbagePrice = garbagePrice;
		this.networkPrice = networkPrice;
		this.sewagePrice = sewagePrice;
		this.otherPrice = otherPrice;
		this.status = status;
		this.remark = remark;
		this.createUser = createUser;
		this.createTime = createTime;
		this.lastModifyUser = lastModifyUser;
		this.lastModifyTime = lastModifyTime;
		this.notExistsStatus = notExistsStatus;
		this.userCode = userCode;
	}



	public void setCode(String code) {
		this.code = code;
	}

	@Id
	@Column(name = "code", length = 45, nullable = false)
	public String getCode() {
		return code;
	}

	public void setMonthlyCycle(int monthlyCycle) {
		this.monthlyCycle = monthlyCycle;
	}

	@Id
	@Column(name = "monthly_cycle", nullable = false)
	public int getMonthlyCycle() {
		return monthlyCycle;
	}

	public void setBuildingCode(String buildingCode) {
		this.buildingCode = buildingCode;
	}

	@Id
	@Column(name = "building_code", length = 45, nullable = false)
	public String getBuildingCode() {
		return buildingCode;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	@Id
	@Column(name = "room_no", length = 45, nullable = false)
	public String getRoomNo() {
		return roomNo;
	}

	public void setWaterMeterCode(String waterMeterCode) {
		this.waterMeterCode = waterMeterCode;
	}

	@Column(name = "water_meter_code", length = 45)
	public String getWaterMeterCode() {
		return waterMeterCode;
	}

	public void setBeforeQty(BigDecimal beforeQty) {
		this.beforeQty = beforeQty;
	}

	@Column(name = "before_qty")
	public BigDecimal getBeforeQty() {
		return beforeQty;
	}

	public void setCurrentQty(BigDecimal currentQty) {
		this.currentQty = currentQty;
	}

	@Column(name = "current_qty")
	public BigDecimal getCurrentQty() {
		return currentQty;
	}

	public void setGarbagePrice(BigDecimal garbagePrice) {
		this.garbagePrice = garbagePrice;
	}

	@Column(name = "garbage_price")
	public BigDecimal getGarbagePrice() {
		return garbagePrice;
	}

	public void setNetworkPrice(BigDecimal networkPrice) {
		this.networkPrice = networkPrice;
	}

	@Column(name = "network_price")
	public BigDecimal getNetworkPrice() {
		return networkPrice;
	}

	public void setSewagePrice(BigDecimal sewagePrice) {
		this.sewagePrice = sewagePrice;
	}

	@Column(name = "sewage_price")
	public BigDecimal getSewagePrice() {
		return sewagePrice;
	}

	public void setOtherPrice(BigDecimal otherPrice) {
		this.otherPrice = otherPrice;
	}

	@Column(name = "other_price")
	public BigDecimal getOtherPrice() {
		return otherPrice;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name = "status")
	public int getStatus() {
		return status;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "remark", length = 500)
	public String getRemark() {
		return remark;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Column(name = "create_user", length = 45)
	public String getCreateUser() {
		return createUser;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time")
	public Date getCreateTime() {
		return createTime;
	}

	public void setLastModifyUser(String lastModifyUser) {
		this.lastModifyUser = lastModifyUser;
	}

	@Column(name = "last_modify_user", length = 45)
	public String getLastModifyUser() {
		return lastModifyUser;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_modify_time",columnDefinition="timestamp default current_timestamp")
	public Date getLastModifyTime() {
		return lastModifyTime;
	}
	
	@Transient//不绑定Hibernate
	public String getNotExistsStatus() {
		return notExistsStatus;
	}

	public void setNotExistsStatus(String notExistsStatus) {
		this.notExistsStatus = notExistsStatus;
	}


	@Column(name = "user_code", length = 45)
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}



	@Override
	public String toString() {
		return "PayWaterMeterInputDetail [code=" + code + ", monthlyCycle=" + monthlyCycle + ", buildingCode="
				+ buildingCode + ", roomNo=" + roomNo + ", waterMeterCode=" + waterMeterCode + ", beforeQty="
				+ beforeQty + ", currentQty=" + currentQty + ", garbagePrice=" + garbagePrice + ", networkPrice="
				+ networkPrice + ", sewagePrice=" + sewagePrice + ", otherPrice=" + otherPrice + ", status=" + status
				+ ", remark=" + remark + ", createUser=" + createUser + ", createTime=" + createTime
				+ ", lastModifyUser=" + lastModifyUser + ", lastModifyTime=" + lastModifyTime + ", notExistsStatus="
				+ notExistsStatus + ", userCode=" + userCode + "]";
	}

	

}
