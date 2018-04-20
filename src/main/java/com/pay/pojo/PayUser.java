package com.pay.pojo;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * pay_user:
 */
@Entity
@Table(name = "pay_user")
public class PayUser implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id:
	 */
	@PropertyDef(label = "id", description = "id:")
	private int id;

	/**
	 * user_name:
	 */
	@PropertyDef(label = "user_name", description = "user_name:")
	private String userName;

	/**
	 * sex:
	 */
	@PropertyDef(label = "sex", description = "sex:")
	private int sex;

	/**
	 * id_card_no:
	 */
	@PropertyDef(label = "id_card_no", description = "id_card_no:")
	private String idCardNo;

	/**
	 * addr:
	 */
	@PropertyDef(label = "addr", description = "addr:")
	private String addr;

	/**
	 * print_name:
	 */
	@PropertyDef(label = "print_name", description = "print_name:")
	private String printName;

	/**
	 * tel:
	 */
	@PropertyDef(label = "tel", description = "tel:")
	private String tel;

	/**
	 * mobile:
	 */
	@PropertyDef(label = "mobile", description = "mobile:")
	private String mobile;

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

	public PayUser() {
		super();
	}

	public PayUser(int id, String userName, int sex, String idCardNo,
			String addr, String printName, String tel, String mobile,
			String remark, int status, String createUser, Date createTime,
			String lastModifyUser, Date lastModifyTime) {
		super();
		this.id = id;
		this.userName = userName;
		this.sex = sex;
		this.idCardNo = idCardNo;
		this.addr = addr;
		this.printName = printName;
		this.tel = tel;
		this.mobile = mobile;
		this.remark = remark;
		this.status = status;
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

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "user_name", length = 45)
	public String getUserName() {
		return userName;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	@Column(name = "sex")
	public int getSex() {
		return sex;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	@Column(name = "id_card_no", length = 45)
	public String getIdCardNo() {
		return idCardNo;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Column(name = "addr", length = 500)
	public String getAddr() {
		return addr;
	}

	public void setPrintName(String printName) {
		this.printName = printName;
	}

	@Column(name = "print_name", length = 45)
	public String getPrintName() {
		return printName;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "tel", length = 45)
	public String getTel() {
		return tel;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "mobile", length = 45)
	public String getMobile() {
		return mobile;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "remark", length = 45)
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

	public String toString() {
		return "PayUser [id=" + id + ",userName=" + userName + ",sex=" + sex
				+ ",idCardNo=" + idCardNo + ",addr=" + addr + ",printName="
				+ printName + ",tel=" + tel + ",mobile=" + mobile + ",remark="
				+ remark + ",status=" + status + ",createUser=" + createUser
				+ ",createTime=" + createTime + ",lastModifyUser="
				+ lastModifyUser + ",lastModifyTime=" + lastModifyTime + "]";
	}

}
