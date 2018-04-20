package com.pay.pojo;
import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;
import java.util.Date;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * pay_replace_water_meter_history:
 */
@Entity
@Table(name = "pay_replace_water_meter_history")
public class PayReplaceWaterMeterHistory implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id:
	 */
	@PropertyDef(label = "id", description = "id:")
	private int id;

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
	 * old_water_meter_code:
	 */
	@PropertyDef(label = "old_water_meter_code", description = "old_water_meter_code:")
	private String oldWaterMeterCode;
	
	@PropertyDef(label = "qty", description = "qty:")
	private BigDecimal qty;

	/**
	 * new_water_meter_code:
	 */
	@PropertyDef(label = "new_water_meter_code", description = "new_water_meter_code:")
	private String newWaterMeterCode;

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

	public PayReplaceWaterMeterHistory() {
		super();
	}

	public PayReplaceWaterMeterHistory(int id, String buildingCode,
			String roomNo, String oldWaterMeterCode, String newWaterMeterCode,
			String remark, String createUser, Date createTime,
			String lastModifyUser, Date lastModifyTime,BigDecimal qty) {
		super();
		this.id = id;
		this.buildingCode = buildingCode;
		this.roomNo = roomNo;
		this.oldWaterMeterCode = oldWaterMeterCode;
		this.newWaterMeterCode = newWaterMeterCode;
		this.remark = remark;
		this.createUser = createUser;
		this.createTime = createTime;
		this.lastModifyUser = lastModifyUser;
		this.lastModifyTime = lastModifyTime;
		this.qty=qty;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setBuildingCode(String buildingCode) {
		this.buildingCode = buildingCode;
	}

	@Column(name = "building_code", length = 45)
	public String getBuildingCode() {
		return buildingCode;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	@Column(name = "room_no", length = 45)
	public String getRoomNo() {
		return roomNo;
	}

	public void setOldWaterMeterCode(String oldWaterMeterCode) {
		this.oldWaterMeterCode = oldWaterMeterCode;
	}

	@Column(name = "old_water_meter_code", length = 45)
	public String getOldWaterMeterCode() {
		return oldWaterMeterCode;
	}
	
	@Column(name = "qty")
	public BigDecimal getQty() {
		return qty;
	}

	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}

	public void setNewWaterMeterCode(String newWaterMeterCode) {
		this.newWaterMeterCode = newWaterMeterCode;
	}

	@Column(name = "new_water_meter_code", length = 45)
	public String getNewWaterMeterCode() {
		return newWaterMeterCode;
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

	public String toString() {
		return "PayReplaceWaterMeterHistory [id=" + id + ",buildingCode="
				+ buildingCode + ",roomNo=" + roomNo + ",oldWaterMeterCode="
				+ oldWaterMeterCode + ",newWaterMeterCode=" + newWaterMeterCode
				+ ",remark=" + remark + ",createUser=" + createUser
				+ ",createTime=" + createTime + ",lastModifyUser="
				+ lastModifyUser + ",lastModifyTime=" + lastModifyTime +",qty=" + qty + "]";
	}

}
