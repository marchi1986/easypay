package com.pay.pojo;
import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

import java.util.Date;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * pay_building_detail:
 */
@Entity
@IdClass(PayBuildingDetailPK.class)
@Table(name = "pay_building_detail")
public class PayBuildingDetail extends AbstractPojo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * code:
	 */
	@PropertyDef(label = "code", description = "code:")
	private String code;

	/**
	 * room_no:
	 */
	@PropertyDef(label = "room_no", description = "room_no:")
	private String roomNo;

	/**
	 * user_id:
	 */
	@PropertyDef(label = "user_name", description = "user_name:")
	private String userName;

	/**
	 * water_meter_code:
	 */
	@PropertyDef(label = "water_meter_code", description = "water_meter_code:")
	private String waterMeterCode;

	/**
	 * apportion_type_id:
	 */
	@PropertyDef(label = "apportion_type_id", description = "apportion_type_id:")
	private Integer apportionTypeId;

	/**
	 * pricing_type_id:
	 */
	@PropertyDef(label = "pricing_type_id", description = "pricing_type_id:")
	private Integer pricingTypeId;

	/**
	 * contractor_id:
	 */
	@PropertyDef(label = "contractor_name", description = "contractor_name:")
	private String contractorName;

	/**
	 * status:
	 */
	@PropertyDef(label = "status", description = "status:")
	private Integer status;

	/**
	 * remark:
	 */
	@PropertyDef(label = "remark", description = "remark:")
	private String remark;
	
	/**
	 * group_id:
	 */
	@PropertyDef(label = "group_id", description = "group_id:")
	private Integer groupId;

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
	
	private String name;
	private String addr;
	private String addrShortDesc;
	private String mobile;
	private Integer networkPrice;
	private Integer garbagePrice;
	

	
	
	
	@PropertyDef(label = "monthly_qty", description = "monthly_qty:")
	private BigDecimal monthlyQty;
	
	private String userCode;
	
	private Integer isCountApportion;
	private Integer userCount;

	public void setCode(String code) {
		this.code = code;
	}

	@Id
	@Column(name = "code", length = 45, nullable = false)
	public String getCode() {
		return code;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	@Id
	@Column(name = "room_no", length = 45)
	public String getRoomNo() {
		return roomNo;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "user_name")
	public String getUserName() {
		return this.userName;
	}

	public void setWaterMeterCode(String waterMeterCode) {
		this.waterMeterCode = waterMeterCode;
	}

	@Column(name = "water_meter_code", length = 45)
	public String getWaterMeterCode() {
		return waterMeterCode;
	}

	public void setApportionTypeId(Integer apportionTypeId) {
		this.apportionTypeId = apportionTypeId;
	}

	@Column(name = "apportion_type_id")
	public Integer getApportionTypeId() {
		return apportionTypeId;
	}

	public void setPricingTypeId(Integer pricingTypeId) {
		this.pricingTypeId = pricingTypeId;
	}

	@Column(name = "pricing_type_id")
	public Integer getPricingTypeId() {
		return pricingTypeId;
	}

	public void setContractorName(String contractorName) {
		this.contractorName = contractorName;
	}

	@Column(name = "contractor_name")
	public String getContractorName() {
		return contractorName;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "status")
	public Integer getStatus() {
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
	
	
	@Transient
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "addr")
	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
	@Column(name = "monthly_qty")
	public BigDecimal getMonthlyQty() {
		return monthlyQty;
	}

	public void setMonthlyQty(BigDecimal monthlyQty) {
		this.monthlyQty = monthlyQty;
	}
	
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	@Column(name = "group_id")
	public Integer getGroupId() {
		return groupId;
	}
	
	
	@Column(name = "mobile")
	public String getMobile() {
		return mobile;
	}




	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	@Column(name = "addr_short_desc")
	public String getAddrShortDesc() {
		return addrShortDesc;
	}




	public void setAddrShortDesc(String addrShortDesc) {
		this.addrShortDesc = addrShortDesc;
	}

	


	@Column(name = "network_price")
	public Integer getNetworkPrice() {
		return networkPrice;
	}




	public void setNetworkPrice(Integer networkPrice) {
		this.networkPrice = networkPrice;
	}



	@Column(name = "garbage_price")
	public Integer getGarbagePrice() {
		return garbagePrice;
	}




	public void setGarbagePrice(Integer garbagePrice) {
		this.garbagePrice = garbagePrice;
	}


	

	@Column(name = "user_code")
	public String getUserCode() {
		return userCode;
	}


	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	@Column(name = "is_count_apportion")
	public Integer getIsCountApportion() {
		return isCountApportion;
	}

	public void setIsCountApportion(Integer isCountApportion) {
		this.isCountApportion = isCountApportion;
	}

	@Column(name = "user_count")
	public Integer getUserCount() {
		return userCount;
	}

	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}








}
