package com.pay.pojo.waterpay;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * pay_water_meter_info:
 */
@Entity
@Table(name = "pay_water_meter_info")
public class PayWaterMeterInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * water_meter_code:
	 */
	@PropertyDef(label = "water_meter_code", description = "water_meter_code:")
	private String waterMeterCode;

	/**
	 * open_date:
	 */
	@PropertyDef(label = "open_date", description = "open_date:")
	private Date openDate;

	/**
	 * close_date:
	 */
	@PropertyDef(label = "close_date", description = "close_date:")
	private Date closeDate;

	/**
	 * current_qty:
	 */
	@PropertyDef(label = "current_qty", description = "current_qty:")
	private int currentQty;

	/**
	 * status:
	 */
	@PropertyDef(label = "status", description = "status:")
	private int status;

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
	@PropertyDef(label = "remark", description = "remark:")
	private String remark;

	public PayWaterMeterInfo() {
		super();
	}

	public PayWaterMeterInfo(String waterMeterCode, Date openDate,
			Date closeDate, int currentQty, int status, String createUser,
			Date createTime, String lastModifyUser, Date lastModifyTime) {
		super();
		this.waterMeterCode = waterMeterCode;
		this.openDate = openDate;
		this.closeDate = closeDate;
		this.currentQty = currentQty;
		this.status = status;
		this.createUser = createUser;
		this.createTime = createTime;
		this.lastModifyUser = lastModifyUser;
		this.lastModifyTime = lastModifyTime;
	}

	public void setWaterMeterCode(String waterMeterCode) {
		this.waterMeterCode = waterMeterCode;
	}

	@Id
	@Column(name = "water_meter_code", length = 45, nullable = false)
	public String getWaterMeterCode() {
		return waterMeterCode;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "open_date")
	public Date getOpenDate() {
		return openDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "close_date")
	public Date getCloseDate() {
		return closeDate;
	}

	public void setCurrentQty(int currentQty) {
		this.currentQty = currentQty;
	}

	@Column(name = "current_qty")
	public int getCurrentQty() {
		return currentQty;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name = "status")
	public int getStatus() {
		return status;
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
	
	@Column(name = "remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String toString() {
		return "PayWaterMeterInfo [waterMeterCode=" + waterMeterCode
				+ ",openDate=" + openDate + ",closeDate=" + closeDate
				+ ",currentQty=" + currentQty + ",status=" + status
				+ ",createUser=" + createUser + ",createTime=" + createTime
				+ ",lastModifyUser=" + lastModifyUser + ",lastModifyTime="
				+ lastModifyTime + "]";
	}

}
