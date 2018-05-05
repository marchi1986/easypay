package com.pay.pojo;
import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * pay_pricing_type:
 */
@Entity
@Table(name = "pay_pricing_type")
public class PayPricingType implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id:
	 */
	@PropertyDef(label = "id", description = "id:")
	private int id;

	/**
	 * pricing_name:
	 */
	@PropertyDef(label = "pricing_name", description = "pricing_name:")
	private String pricingName;

	/**
	 * pricing_desc:
	 */
	@PropertyDef(label = "pricing_desc", description = "pricing_desc:")
	private String pricingDesc;

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
	
	private BigDecimal garbagePrice;
	
	private BigDecimal networkPrice;

	public PayPricingType() {
		super();
	}

	public PayPricingType(int id, String pricingName, String pricingDesc,
			BigDecimal price, String createUser, Date createTime,
			String lastModifyUser, Date lastModifyTime,BigDecimal garbagePrice,BigDecimal networkPrice) {
		super();
		this.id = id;
		this.pricingName = pricingName;
		this.pricingDesc = pricingDesc;
		this.price = price;
		this.createUser = createUser;
		this.createTime = createTime;
		this.lastModifyUser = lastModifyUser;
		this.lastModifyTime = lastModifyTime;
		this.garbagePrice=garbagePrice;
		this.networkPrice=networkPrice;
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

	public void setPricingName(String pricingName) {
		this.pricingName = pricingName;
	}

	@Column(name = "pricing_name", length = 30, nullable = false)
	public String getPricingName() {
		return pricingName;
	}

	public void setPricingDesc(String pricingDesc) {
		this.pricingDesc = pricingDesc;
	}

	@Column(name = "pricing_desc", length = 200, nullable = false)
	public String getPricingDesc() {
		return pricingDesc;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name = "water_unit_price")
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
	
	@Column(name = "garbage_price")
	public BigDecimal getGarbagePrice() {
		return garbagePrice;
	}

	public void setGarbagePrice(BigDecimal garbagePrice) {
		this.garbagePrice = garbagePrice;
	}
	@Column(name = "network_price")
	public BigDecimal getNetworkPrice() {
		return networkPrice;
	}

	public void setNetworkPrice(BigDecimal networkPrice) {
		this.networkPrice = networkPrice;
	}

	public String toString() {
		return "PayPricingType [id=" + id + ",pricingName=" + pricingName
				+ ",pricingDesc=" + pricingDesc + ",price=" + price
				+ ",createUser=" + createUser + ",createTime=" + createTime
				+ ",lastModifyUser=" + lastModifyUser + ",lastModifyTime="
				+ lastModifyTime + garbagePrice +",networkPrice=" + networkPrice+"]";
	}

}
