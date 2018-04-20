import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * pay_water_meter_input_building:
 */
@Entity
@Table(name = "pay_water_meter_input_building")
public class PayWaterMeterInputBuilding implements Serializable {

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

	public PayWaterMeterInputBuilding() {
		super();
	}

	public PayWaterMeterInputBuilding(String code, int monthlyCycle,
			String buildingCode, BigDecimal beforeQty, BigDecimal currentQty,
			int status, String createUser, Date createTime,
			String lastModifyUser, Date lastModifyTime) {
		super();
		this.code = code;
		this.monthlyCycle = monthlyCycle;
		this.buildingCode = buildingCode;
		this.beforeQty = beforeQty;
		this.currentQty = currentQty;
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
		return "PayWaterMeterInputBuilding [code=" + code + ",monthlyCycle="
				+ monthlyCycle + ",buildingCode=" + buildingCode
				+ ",beforeQty=" + beforeQty + ",currentQty=" + currentQty
				+ ",status=" + status + ",createUser=" + createUser
				+ ",createTime=" + createTime + ",lastModifyUser="
				+ lastModifyUser + ",lastModifyTime=" + lastModifyTime + "]";
	}

}
