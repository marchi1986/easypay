package com.pay.pojo;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * pay_building_info:
 */
@Entity
@Table(name = "pay_building_info")
public class PayBuildingInfo extends AbstractPojo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * code:
	 */
	private String code;

	/**
	 * housemaster:
	 */
	private String housemaster;

	/**
	 * mobile:
	 */
	@PropertyDef(label = "mobile", description = "mobile:")	
	private String mobile;


	/**
	 * addr:
	 */

	private String addr;

	/**
	 * remark:
	 */
	@PropertyDef(label = "remark", description = "remark:")
	private String remark;

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
	
	/**
	 * last_modify_time:
	 */
	@PropertyDef(label = "user_count", description = "user_count:")
	private Integer userCount;

	public PayBuildingInfo() {
		super();
	}

	public PayBuildingInfo(String code, String name, String doorplate,
			int floor, String housemaster, String mobile, String idNo,
			String nature, String addr, String remark, int status,
			String createUser, Date createTime, String lastModifyUser,
			Date lastModifyTime) {
		super();
		this.code = code;
		this.housemaster = housemaster;
		this.mobile = mobile;
		this.addr = addr;
		this.remark = remark;
		this.status = status;
		this.createUser = createUser;
		this.createTime = createTime;
		this.lastModifyUser = lastModifyUser;
		this.lastModifyTime = lastModifyTime;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Id
	@Column(name = "code", length = 45, nullable = false)
	public String getCode() {
		return code;
	}


	public void setHousemaster(String housemaster) {
		this.housemaster = housemaster;
	}

	@Column(name = "housemaster", length = 100)
	public String getHousemaster() {
		return housemaster;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "mobile", length = 100)
	public String getMobile() {
		return mobile;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Column(name = "addr", length = 200)
	public String getAddr() {
		return addr;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "remark", length = 500)
	public String getRemark() {
		return remark;
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

	@Column(name = "user_count")
	public Integer getUserCount() {
		return userCount;
	}

	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}
	
	


}
