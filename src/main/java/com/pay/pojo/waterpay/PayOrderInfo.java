package com.pay.pojo.waterpay;
import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * pay_order_info:
 */
@Entity
@Table(name = "pay_order_info")
public class PayOrderInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * order_code:
	 */
	@PropertyDef(label = "order_code", description = "order_code:")
	private String orderCode;

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
	 * monthly_cycle:
	 */
	@PropertyDef(label = "monthly_cycle", description = "monthly_cycle:")
	private int monthlyCycle;

	/**
	 * water_before_qty:
	 */
	@PropertyDef(label = "water_before_qty", description = "water_before_qty:")
	private BigDecimal waterBeforeQty;

	/**
	 * water_current_qty:
	 */
	@PropertyDef(label = "water_current_qty", description = "water_current_qty:")
	private BigDecimal waterCurrentQty;

	@PropertyDef(label = "actual_qty", description = "actual_qty:")
	private BigDecimal actualQty;
	
	/**
	 * water_apportion_qty:
	 */
	@PropertyDef(label = "water_apportion_qty", description = "water_apportion_qty:")
	private BigDecimal waterApportionQty;
	
	/**
	 * price:
	 */
	@PropertyDef(label = "price", description = "price:")
	private BigDecimal price;

	/**
	 * water_price:
	 */
	@PropertyDef(label = "water_price", description = "water_price:")
	private BigDecimal waterPrice;

	/**
	 * garbage_price:
	 */
	@PropertyDef(label = "garbage_price", description = "garbage_price:")
	private BigDecimal garbagePrice;


	/**
	 * late_fee:
	 */
	@PropertyDef(label = "late_fee", description = "late_fee:")
	private BigDecimal lateFee;

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
	 * total_price:
	 */
	@PropertyDef(label = "total_price", description = "total_price:")
	private BigDecimal totalPrice;

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
	
	@PropertyDef(label = "pay_date", description = "pay_date:")
	private Date payDate;
	
	@PropertyDef(label = "last_pay_date", description = "last_pay_date:")
	private Date lastPayDate;
	
	@PropertyDef(label = "toll_collector", description = "toll_collector:")
	private String tollCollector;

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
	
	private String payCode;
	
	private String userCode;
	
	private String userName;
	
	private String addr;
	
	private String waterMeterCode;

	public PayOrderInfo() {
		super();
	}

	

	public PayOrderInfo(String orderCode, String buildingCode, String roomNo, int monthlyCycle,
			BigDecimal waterBeforeQty, BigDecimal waterCurrentQty, BigDecimal actualQty, BigDecimal waterApportionQty,
			BigDecimal price, BigDecimal waterPrice, BigDecimal garbagePrice,
			BigDecimal lateFee, BigDecimal networkPrice, BigDecimal sewagePrice, BigDecimal otherPrice,
			BigDecimal totalPrice, int status, String remark, Date payDate, Date lastPayDate, String tollCollector,
			String createUser, Date createTime, String lastModifyUser, Date lastModifyTime, String payCode) {
		super();
		this.orderCode = orderCode;
		this.buildingCode = buildingCode;
		this.roomNo = roomNo;
		this.monthlyCycle = monthlyCycle;
		this.waterBeforeQty = waterBeforeQty;
		this.waterCurrentQty = waterCurrentQty;
		this.actualQty = actualQty;
		this.waterApportionQty = waterApportionQty;
		this.price = price;
		this.waterPrice = waterPrice;
		this.garbagePrice = garbagePrice;
		this.lateFee = lateFee;
		this.networkPrice = networkPrice;
		this.sewagePrice = sewagePrice;
		this.otherPrice = otherPrice;
		this.totalPrice = totalPrice;
		this.status = status;
		this.remark = remark;
		this.payDate = payDate;
		this.lastPayDate = lastPayDate;
		this.tollCollector = tollCollector;
		this.createUser = createUser;
		this.createTime = createTime;
		this.lastModifyUser = lastModifyUser;
		this.lastModifyTime = lastModifyTime;
		this.payCode = payCode;
	}



	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	@Id
	@Column(name = "order_code", length = 45, nullable = false)
	public String getOrderCode() {
		return orderCode;
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

	public void setMonthlyCycle(int monthlyCycle) {
		this.monthlyCycle = monthlyCycle;
	}

	@Column(name = "monthly_cycle")
	public int getMonthlyCycle() {
		return monthlyCycle;
	}

	public void setWaterBeforeQty(BigDecimal waterBeforeQty) {
		this.waterBeforeQty = waterBeforeQty;
	}

	@Column(name = "water_before_qty")
	public BigDecimal getWaterBeforeQty() {
		return waterBeforeQty;
	}

	public void setWaterCurrentQty(BigDecimal waterCurrentQty) {
		this.waterCurrentQty = waterCurrentQty;
	}

	@Column(name = "water_current_qty")
	public BigDecimal getWaterCurrentQty() {
		return waterCurrentQty;
	}
	
	@Column(name = "actual_qty")
	public BigDecimal getActualQty() {
		return actualQty;
	}

	public void setActualQty(BigDecimal actualQty) {
		this.actualQty = actualQty;
	}

	public void setWaterApportionQty(BigDecimal waterApportionQty) {
		this.waterApportionQty = waterApportionQty;
	}
	
	

	@Column(name = "water_apportion_qty")
	public BigDecimal getWaterApportionQty() {
		return waterApportionQty;
	}

	public void setWaterPrice(BigDecimal waterPrice) {
		this.waterPrice = waterPrice;
	}

	@Column(name = "water_price")
	public BigDecimal getWaterPrice() {
		return waterPrice;
	}

	public void setGarbagePrice(BigDecimal garbagePrice) {
		this.garbagePrice = garbagePrice;
	}

	@Column(name = "garbage_price")
	public BigDecimal getGarbagePrice() {
		return garbagePrice;
	}


	public void setLateFee(BigDecimal lateFee) {
		this.lateFee = lateFee;
	}

	@Column(name = "late_fee")
	public BigDecimal getLateFee() {
		return lateFee;
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

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Column(name = "total_price")
	public BigDecimal getTotalPrice() {
		return totalPrice;
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
	@Column(name = "last_modify_time")
	public Date getLastModifyTime() {
		return lastModifyTime;
	}
	
	
	@Column(name = "price")
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "pay_date")
	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_pay_date")
	public Date getLastPayDate() {
		return lastPayDate;
	}

	public void setLastPayDate(Date lastPayDate) {
		this.lastPayDate = lastPayDate;
	}

	@Column(name = "toll_collector")
	public String getTollCollector() {
		return tollCollector;
	}

	public void setTollCollector(String tollCollector) {
		this.tollCollector = tollCollector;
	}
	
	@Column(name = "pay_code")
	public String getPayCode() {
		return payCode;
	}

	public void setPayCode(String payCode) {
		this.payCode = payCode;
	}
	
	


	@Column(name = "user_code")
	public String getUserCode() {
		return userCode;
	}



	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	


	@Column(name = "user_name")
	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}


	@Column(name = "addr")
	public String getAddr() {
		return addr;
	}



	public void setAddr(String addr) {
		this.addr = addr;
	}


	@Column(name = "water_meter_code")
	public String getWaterMeterCode() {
		return waterMeterCode;
	}



	public void setWaterMeterCode(String waterMeterCode) {
		this.waterMeterCode = waterMeterCode;
	}



	@Override
	public String toString() {
		return "PayOrderInfo [orderCode=" + orderCode + ", buildingCode=" + buildingCode + ", roomNo=" + roomNo
				+ ", monthlyCycle=" + monthlyCycle + ", waterBeforeQty=" + waterBeforeQty + ", waterCurrentQty="
				+ waterCurrentQty + ", actualQty=" + actualQty + ", waterApportionQty=" + waterApportionQty + ", price="
				+ price + ", waterPrice=" + waterPrice + ", garbagePrice=" + garbagePrice + ", lateFee=" + lateFee
				+ ", networkPrice=" + networkPrice + ", sewagePrice=" + sewagePrice + ", otherPrice=" + otherPrice
				+ ", totalPrice=" + totalPrice + ", status=" + status + ", remark=" + remark + ", payDate=" + payDate
				+ ", lastPayDate=" + lastPayDate + ", tollCollector=" + tollCollector + ", createUser=" + createUser
				+ ", createTime=" + createTime + ", lastModifyUser=" + lastModifyUser + ", lastModifyTime="
				+ lastModifyTime + ", payCode=" + payCode + ", userCode=" + userCode + ", userName=" + userName
				+ ", addr=" + addr + ", waterMeterCode=" + waterMeterCode + "]";
	}












	

}
