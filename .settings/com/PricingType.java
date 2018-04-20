import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * pricing_type:
 */
@Entity
@Table(name = "pricing_type")
public class PricingType implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id:
	 */
	@PropertyDef(label = "id", description = "id:")
	private int id;

	/**
	 * name:
	 */
	@PropertyDef(label = "name", description = "name:")
	private String name;

	/**
	 * desc:
	 */
	@PropertyDef(label = "desc", description = "desc:")
	private String desc;

	/**
	 * price:
	 */
	@PropertyDef(label = "price", description = "price:")
	private BigDecimal price;

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

	public PricingType() {
		super();
	}

	public PricingType(int id, String name, String desc, BigDecimal price,
			String createUser, Date createTime, String lastModifyUser,
			Date lastModifyTime) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.price = price;
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

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "name", length = 30, nullable = false)
	public String getName() {
		return name;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Column(name = "desc", length = 200, nullable = false)
	public String getDesc() {
		return desc;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name = "price")
	public BigDecimal getPrice() {
		return price;
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
		return "PricingType [id=" + id + ",name=" + name + ",desc=" + desc
				+ ",price=" + price + ",createUser=" + createUser
				+ ",createTime=" + createTime + ",lastModifyUser="
				+ lastModifyUser + ",lastModifyTime=" + lastModifyTime + "]";
	}

}
