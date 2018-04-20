import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * building_info:
 */
@Entity
@Table(name = "building_info")
public class BuildingInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id:
	 */
	@PropertyDef(label = "id", description = "id:")
	private int id;

	/**
	 * code:
	 */
	@PropertyDef(label = "code", description = "code:")
	private String code;

	/**
	 * name:
	 */
	@PropertyDef(label = "name", description = "name:")
	private String name;

	/**
	 * housemaster:
	 */
	@PropertyDef(label = "housemaster", description = "housemaster:")
	private String housemaster;

	/**
	 * mobile:
	 */
	@PropertyDef(label = "mobile", description = "mobile:")
	private String mobile;

	/**
	 * addr1:
	 */
	@PropertyDef(label = "addr1", description = "addr1:")
	private String addr1;

	/**
	 * addr2:
	 */
	@PropertyDef(label = "addr2", description = "addr2:")
	private String addr2;

	/**
	 * addr3:
	 */
	@PropertyDef(label = "addr3", description = "addr3:")
	private String addr3;

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

	public BuildingInfo() {
		super();
	}

	public BuildingInfo(int id, String code, String name, String housemaster,
			String mobile, String addr1, String addr2, String addr3,
			String remark, int status, String createUser, Date createTime,
			String lastModifyUser, Date lastModifyTime) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.housemaster = housemaster;
		this.mobile = mobile;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.addr3 = addr3;
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

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "code", length = 45)
	public String getCode() {
		return code;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return name;
	}

	public void setHousemaster(String housemaster) {
		this.housemaster = housemaster;
	}

	@Column(name = "housemaster", length = 45)
	public String getHousemaster() {
		return housemaster;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "mobile", length = 45)
	public String getMobile() {
		return mobile;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	@Column(name = "addr1", length = 200)
	public String getAddr1() {
		return addr1;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	@Column(name = "addr2", length = 200)
	public String getAddr2() {
		return addr2;
	}

	public void setAddr3(String addr3) {
		this.addr3 = addr3;
	}

	@Column(name = "addr3", length = 200)
	public String getAddr3() {
		return addr3;
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

	public String toString() {
		return "BuildingInfo [id=" + id + ",code=" + code + ",name=" + name
				+ ",housemaster=" + housemaster + ",mobile=" + mobile
				+ ",addr1=" + addr1 + ",addr2=" + addr2 + ",addr3=" + addr3
				+ ",remark=" + remark + ",status=" + status + ",createUser="
				+ createUser + ",createTime=" + createTime + ",lastModifyUser="
				+ lastModifyUser + ",lastModifyTime=" + lastModifyTime + "]";
	}

}
