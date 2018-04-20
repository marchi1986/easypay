import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * water_meter_info:
 */
@Entity
@Table(name = "water_meter_info")
public class WaterMeterInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id:
	 */
	@PropertyDef(label = "id", description = "id:")
	private int id;

	/**
	 * water_meter_code:
	 */
	@PropertyDef(label = "water_meter_code", description = "water_meter_code:")
	private String waterMeterCode;

	/**
	 * water_meter_user_id:
	 */
	@PropertyDef(label = "water_meter_user_id", description = "water_meter_user_id:")
	private int waterMeterUserId;

	/**
	 * pricing_type_id:
	 */
	@PropertyDef(label = "pricing_type_id", description = "pricing_type_id:")
	private int pricingTypeId;

	/**
	 * apportion_type_id:
	 */
	@PropertyDef(label = "apportion_type_id", description = "apportion_type_id:")
	private int apportionTypeId;

	/**
	 * building_id:
	 */
	@PropertyDef(label = "building_id", description = "building_id:")
	private int buildingId;

	/**
	 * room_no:
	 */
	@PropertyDef(label = "room_no", description = "room_no:")
	private String roomNo;

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
	 * is_main:
	 */
	@PropertyDef(label = "is_main", description = "is_main:")
	private int isMain;

	/**
	 * main_code:
	 */
	@PropertyDef(label = "main_code", description = "main_code:")
	private String mainCode;

	public WaterMeterInfo() {
		super();
	}

	public WaterMeterInfo(int id, String waterMeterCode, int waterMeterUserId,
			int pricingTypeId, int apportionTypeId, int buildingId,
			String roomNo, String remark, int status, String createUser,
			Date createTime, String lastModifyUser, Date lastModifyTime,
			int isMain, String mainCode) {
		super();
		this.id = id;
		this.waterMeterCode = waterMeterCode;
		this.waterMeterUserId = waterMeterUserId;
		this.pricingTypeId = pricingTypeId;
		this.apportionTypeId = apportionTypeId;
		this.buildingId = buildingId;
		this.roomNo = roomNo;
		this.remark = remark;
		this.status = status;
		this.createUser = createUser;
		this.createTime = createTime;
		this.lastModifyUser = lastModifyUser;
		this.lastModifyTime = lastModifyTime;
		this.isMain = isMain;
		this.mainCode = mainCode;
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

	public void setWaterMeterCode(String waterMeterCode) {
		this.waterMeterCode = waterMeterCode;
	}

	@Column(name = "water_meter_code", length = 45, nullable = false)
	public String getWaterMeterCode() {
		return waterMeterCode;
	}

	public void setWaterMeterUserId(int waterMeterUserId) {
		this.waterMeterUserId = waterMeterUserId;
	}

	@Column(name = "water_meter_user_id")
	public int getWaterMeterUserId() {
		return waterMeterUserId;
	}

	public void setPricingTypeId(int pricingTypeId) {
		this.pricingTypeId = pricingTypeId;
	}

	@Column(name = "pricing_type_id")
	public int getPricingTypeId() {
		return pricingTypeId;
	}

	public void setApportionTypeId(int apportionTypeId) {
		this.apportionTypeId = apportionTypeId;
	}

	@Column(name = "apportion_type_id")
	public int getApportionTypeId() {
		return apportionTypeId;
	}

	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}

	@Column(name = "building_id")
	public int getBuildingId() {
		return buildingId;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	@Column(name = "room_no", length = 45)
	public String getRoomNo() {
		return roomNo;
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

	public void setIsMain(int isMain) {
		this.isMain = isMain;
	}

	@Column(name = "is_main")
	public int getIsMain() {
		return isMain;
	}

	public void setMainCode(String mainCode) {
		this.mainCode = mainCode;
	}

	@Column(name = "main_code", length = 45)
	public String getMainCode() {
		return mainCode;
	}

	public String toString() {
		return "WaterMeterInfo [id=" + id + ",waterMeterCode=" + waterMeterCode
				+ ",waterMeterUserId=" + waterMeterUserId + ",pricingTypeId="
				+ pricingTypeId + ",apportionTypeId=" + apportionTypeId
				+ ",buildingId=" + buildingId + ",roomNo=" + roomNo
				+ ",remark=" + remark + ",status=" + status + ",createUser="
				+ createUser + ",createTime=" + createTime + ",lastModifyUser="
				+ lastModifyUser + ",lastModifyTime=" + lastModifyTime
				+ ",isMain=" + isMain + ",mainCode=" + mainCode + "]";
	}

}
