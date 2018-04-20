package com.pay.common;


import java.util.Date;

public class DateUtils {

	/**
	 * 日期相差天数
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static long getDaySub(Date beginDate, Date endDate) {

		long day = (endDate.getTime() - beginDate.getTime())/ (24 * 60 * 60 * 1000);

		return day;
	}
}
