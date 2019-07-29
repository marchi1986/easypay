package com.pay.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class PayBuildingDetailPK extends AbstractPojo implements Serializable{


	private static final long serialVersionUID = 1L;

	private String code;
	
	private String roomNo;

	@Id
	@Column(name = "code", length = 45, nullable = false)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Id
	@Column(name = "room_no", length = 45)
	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	
	
}
