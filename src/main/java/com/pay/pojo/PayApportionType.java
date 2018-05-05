package com.pay.pojo;
import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * pay_apportion_type:
 */
@Entity
@Table(name = "pay_apportion_type")
public class PayApportionType implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id:
	 */
	@PropertyDef(label = "id", description = "id:")
	private int id;

	/**
	 * apportion_name:
	 */
	@PropertyDef(label = "apportion_name", description = "apportion_name:")
	private String apportionName;

	/**
	 * percent:
	 */
	@PropertyDef(label = "percent", description = "percent:")
	private BigDecimal percent;

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
	
	

	public PayApportionType() {
		super();
	}

	public PayApportionType(int id, String apportionName, BigDecimal percent,
			String remark, String createUser, Date createTime,
			String lastModifyUser, Date lastModifyTime) {
		super();
		this.id = id;
		this.apportionName = apportionName;
		this.percent = percent;
		this.remark = remark;
		this.createUser = createUser;
		this.createTime = createTime;
		this.lastModifyUser = lastModifyUser;
		this.lastModifyTime = lastModifyTime;
		
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

	public void setApportionName(String apportionName) {
		this.apportionName = apportionName;
	}

	@Column(name = "apportion_name", length = 45)
	public String getApportionName() {
		return apportionName;
	}

	public void setPercent(BigDecimal percent) {
		this.percent = percent;
	}

	@Column(name = "percent")
	public BigDecimal getPercent() {
		return percent;
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
		return "PayApportionType [id=" + id + ",apportionName=" + apportionName
				+ ",percent=" + percent + ",remark=" + remark + ",createUser="
				+ createUser + ",createTime=" + createTime + ",lastModifyUser="
				+ lastModifyUser + ",lastModifyTime=" + lastModifyTime 
				+",garbagePrice=" + "]";
	}

}
