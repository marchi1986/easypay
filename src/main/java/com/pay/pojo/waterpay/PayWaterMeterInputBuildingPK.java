package com.pay.pojo.waterpay;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class PayWaterMeterInputBuildingPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String code;
	
	private int monthlyCycle;

	private String buildingCode;


	public void setCode(String code) {
		this.code = code;
	}

	@Id
	@Column(name = "code", length = 45, nullable = false)
	public String getCode() {
		return code;
	}
	
	@Id
	@Column(name = "monthly_cycle",  nullable = false)
	public int getMonthlyCycle() {
		return monthlyCycle;
	}

	public void setMonthlyCycle(int monthlyCycle) {
		this.monthlyCycle = monthlyCycle;
	}

	public void setBuildingCode(String buildingCode) {
		this.buildingCode = buildingCode;
	}

	@Id
	@Column(name = "building_code", length = 45, nullable = false)
	public String getBuildingCode() {
		return buildingCode;
	}

	
}
