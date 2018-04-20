package com.pay.pojo.waterpay;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class PayOrderInfoPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * order_code:
	 */
	
	private String orderCode;

	/**
	 * building_code:
	 */

	private String buildingCode;

	/**
	 * room_no:
	 */

	private String roomNo;
	
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	@Id
	@Column(name = "order_code", length = 45, nullable = false)
	public String getOrderCode() {
		return orderCode;
	}

	public void setBuildingCode(String buildingCode) {
		this.buildingCode = buildingCode;
	}

	@Id
	@Column(name = "building_code", length = 45, nullable = false)
	public String getBuildingCode() {
		return buildingCode;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	@Id
	@Column(name = "room_no", length = 45, nullable = false)
	public String getRoomNo() {
		return roomNo;
	}
}
