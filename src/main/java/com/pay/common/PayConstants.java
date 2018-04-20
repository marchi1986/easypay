package com.pay.common;

public class PayConstants {
	
	//启用
	public static final int ENABLED_STATUS=1;
	//停用
	public static final int DISABLED_STATUS=0;
	
	//新单
	public static final int INPUT_DATA_STATUS_NEW=0;
	//录入中
	public static final int INPUT_DATA_STATUS_INPUT=1;
	//确认
	public static final int INPUT_DATA_STATUS_CONFIRM=2;
	//完成
	public static final int INPUT_DATA_STATUS_COMPLETE=3;
	//完成
	public static final int INPUT_DATA_STATUS_CANCEL=9;
	
	//新单
	public static final int INPUT_DATA_BUILDING_STATUS_NEW=0;
	//录入中
	public static final int INPUT_DATA_BUILDING_STATUS_INPUT=1;
	//全部录入
	public static final int INPUT_DATA_BUILDING_STATUS_ALLINPUT=2;
	
	//新单
	public static final int INPUT_DATA_DETAIL_STATUS_NEW=0;
	//录入
	public static final int INPUT_DATA_DETAIL_STATUS_INPUT=1;

	
	//未收费
	public static final int ORDER_STATUS_UNPAY=0;
	//已收费
	public static final int ORDER_STATUS_PAY=1;

}
