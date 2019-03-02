package com.pay.common.print;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.math.BigDecimal;

/**
 * 打印布局类
 * 实现Printable接口 用于创建打印内容 
 */
public class PaymentReceiptForPrint implements Printable {
	
	private String companyName="白水塘实业有限公司";
	private String orderNo;
	private String waterMeterCode;
	private String userId;
	private String userCode;
	private String billingPeriod;
	private String addr;
	private String userName;
	private BigDecimal beforeQty;
	private BigDecimal currentQty;
	private BigDecimal actualQty;
	private BigDecimal apportionQty;
	private BigDecimal totalQty;
	private BigDecimal price;
	private BigDecimal amount;//水费总计
	private BigDecimal amonut2;//杂费总计
	private BigDecimal garbagePrice; //垃圾费
	private BigDecimal networkPrice; //网费
	private BigDecimal sewagePrice; //排污费
	private BigDecimal otherPrice; //其他
	private String totalAmountCN;
	private BigDecimal overdueAmount;
	private BigDecimal totalAmountFoot;
	private String year;
	private String month;
	private String day;
	
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBillingPeriod() {
		return billingPeriod;
	}
	public void setBillingPeriod(String billingPeriod) {
		this.billingPeriod = billingPeriod;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public BigDecimal getBeforeQty() {
		return beforeQty;
	}
	public void setBeforeQty(BigDecimal beforeQty) {
		this.beforeQty = beforeQty;
	}
	public BigDecimal getCurrentQty() {
		return currentQty;
	}
	public void setCurrentQty(BigDecimal currentQty) {
		this.currentQty = currentQty;
	}
	public BigDecimal getActualQty() {
		return actualQty;
	}
	public void setActualQty(BigDecimal actualQty) {
		this.actualQty = actualQty;
	}
	public BigDecimal getApportionQty() {
		return apportionQty;
	}
	public void setApportionQty(BigDecimal apportionQty) {
		this.apportionQty = apportionQty;
	}
	public BigDecimal getTotalQty() {
		return totalQty;
	}
	public void setTotalQty(BigDecimal totalQty) {
		this.totalQty = totalQty;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getTotalAmountCN() {
		return totalAmountCN;
	}
	public void setTotalAmountCN(String totalAmountCN) {
		this.totalAmountCN = totalAmountCN;
	}
	public BigDecimal getOverdueAmount() {
		return overdueAmount;
	}
	public void setOverdueAmount(BigDecimal overdueAmount) {
		this.overdueAmount = overdueAmount;
	}
	public BigDecimal getTotalAmountFoot() {
		return totalAmountFoot;
	}
	public void setTotalAmountFoot(BigDecimal totalAmountFoot) {
		this.totalAmountFoot = totalAmountFoot;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public BigDecimal getGarbagePrice() {
		return garbagePrice;
	}
	public void setGarbagePrice(BigDecimal garbagePrice) {
		this.garbagePrice = garbagePrice;
	}
	public BigDecimal getNetworkPrice() {
		return networkPrice;
	}
	public void setNetworkPrice(BigDecimal networkPrice) {
		this.networkPrice = networkPrice;
	}
	public BigDecimal getSewagePrice() {
		return sewagePrice;
	}
	public void setSewagePrice(BigDecimal sewagePrice) {
		this.sewagePrice = sewagePrice;
	}
	public BigDecimal getOtherPrice() {
		return otherPrice;
	}
	public void setOtherPrice(BigDecimal otherPrice) {
		this.otherPrice = otherPrice;
	}
	
	
	public String getWaterMeterCode() {
		return waterMeterCode;
	}
	public void setWaterMeterCode(String waterMeterCode) {
		this.waterMeterCode = waterMeterCode;
	}
	
	
	public BigDecimal getAmonut2() {
		return amonut2;
	}
	public void setAmonut2(BigDecimal amonut2) {
		this.amonut2 = amonut2;
	}
	
	
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	@Override
	public String toString() {
		return "WaterBillForPrint [orderNo=" + orderNo + ", userId=" + userId
				+ ", billingPeriod=" + billingPeriod + ", addr=" + addr
				+ ", userName=" + userName + ", beforeQty=" + beforeQty
				+ ", currentQty=" + currentQty + ", actualQty=" + actualQty
				+ ", apportionQty=" + apportionQty + ", totalQty=" + totalQty
				+ ", price=" + price + ", amount=" + amount + ", garbagePrice="
				+ garbagePrice + ", networkPrice=" + networkPrice
				+ ", sewagePrice=" + sewagePrice + ", otherPrice=" + otherPrice
				+ ", totalAmountCN=" + totalAmountCN + ", overdueAmount="
				+ overdueAmount + ", totalAmountFoot=" + totalAmountFoot
				+ ", year=" + year + ", month=" + month + ", day=" + day + "]";
	}
	
	/**
	 * 排版
	 * @param Graphic指明打印的图形环境 
     * @param PageFormat指明打印页格式（页面大小以点为计量单位，1点为1英才的1/72，1英寸为25.4毫米。A4纸大致为595×842点） 
     * @param pageIndex指明页号 
	 */
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
			throws PrinterException {
		Component c = null;  
        // 转换成Graphics2D 拿到画笔  
		Graphics2D g2 = (Graphics2D) graphics;
		// 设置打印颜色为黑色  
		g2.setColor(Color.black);  
		// 打印起点坐标  
		double x = pageFormat.getImageableX();
		double y = pageFormat.getImageableY() + 20;
		
		// 设置打印字体（字体名称、样式和点大小）（字体名称可以是物理或者逻辑名称）
		Font titleFont = new Font("宋体", Font.BOLD, 16); //标题字体大小
		Font gridTitleFont = new Font("宋体", Font.BOLD, 10); //表格标题字体大小
		Font gridFont = new Font("宋体", Font.PLAIN, 9); //表格字体大小
		Font gridFootFont = new Font("宋体", Font.BOLD, 9); //表格尾字体大小
		
		float titleFontHeight = gridFont.getSize2D(); //标题字体高度
		float gridTitleFontHeight = gridTitleFont.getSize2D() + 7; //表格标题字体高度
		float gridFontHeight = gridFont.getSize2D() + 7; //表格字体高度

		int rowHight = 25; //自定义行高
		int rowHightFoot = 20; //自定义行高
		int line = (int) y;
		
		int leftPointX = (int) x + 15;
		int rightPointX = (int) x + 560;
		
		//System.out.println("X = " + (rightPointX - leftPointX));
		
		//设置标题
		g2.setFont(titleFont); // 设置字体  
		g2.drawString(companyName+"水费收费单", (float) leftPointX + 160, (float) y + titleFontHeight + 10);
		g2.setFont(gridTitleFont); // 设置字体  
		g2.drawString("No:", (float) leftPointX + 410, (float) y + titleFontHeight + 10);
		g2.setFont(gridFont); // 设置字体  
		g2.drawString(this.orderNo, (float) leftPointX + 430, (float) y + titleFontHeight + 10);
		line += titleFontHeight*2 + 10;
		
		int lineSpace = 68;	//间距
		
		for(int i = 1; i < 15; i++){
			// 设置打印颜色为黑色  
			g2.setColor(Color.black);  
			g2.setFont(gridFont); // 设置字体
			if(i<7){
				if(i==4 || i==6){
					g2.drawLine(leftPointX + lineSpace, (int) line, rightPointX, (int) line); //横线
				}else{
					g2.drawLine(leftPointX, (int) line, rightPointX, (int) line); //横线
				}
				g2.drawLine(leftPointX, (int) line, leftPointX, (int) (line + rowHight)); //左竖线
				g2.drawLine(rightPointX, (int) line, rightPointX, (int) (line + rowHight)); //右竖线
			}else if(i==7){
				//第5行
				g2.drawLine(leftPointX, (int) line, rightPointX, (int) line); //横线
				g2.drawLine(leftPointX, (int) line, leftPointX, (int) (line + rowHight*1.7)); //左竖线
				g2.drawLine(rightPointX, (int) line, rightPointX, (int) (line + rowHight*1.7)); //右竖线
				g2.drawLine(leftPointX, (int) (line + rowHight*1.7), rightPointX, (int) (line + rowHight*1.7));//底线
			}
			
			switch(i){
				//第1行
				case 1:
					g2.setFont(gridTitleFont); // 设置字体  
					g2.drawString("用户编号", (float)leftPointX + 13, (float) line + gridTitleFontHeight);
					g2.drawString("计费时段", (float) leftPointX + 255, (float) line + gridTitleFontHeight);
					g2.drawString("水表编号", (float) leftPointX + 370, (float) line + gridTitleFontHeight);
					
					g2.setFont(gridFont); // 设置字体  
					g2.drawString(this.userCode, (float)leftPointX + 87, (float) line + gridFontHeight);
					g2.drawString(this.billingPeriod, (float) leftPointX + 337, (float) line + gridFontHeight);
					g2.drawString(this.waterMeterCode, (float) leftPointX + 450, (float) line + gridFontHeight);
					
					g2.drawLine(leftPointX + lineSpace, (int) line, leftPointX + lineSpace, (int) (line + rowHight)); //中竖线
					g2.drawLine(leftPointX + 237, (int) line, leftPointX + 237, (int) (line + rowHight)); //中竖线
					g2.drawLine(leftPointX + 314, (int) line, leftPointX + 314, (int) (line + rowHight)); //中竖线
					g2.drawLine(leftPointX + 360, (int) line, leftPointX + 360, (int) (line + rowHight)); //中竖线
					g2.drawLine(leftPointX + 420, (int) line, leftPointX + 420, (int) (line + rowHight)); //中竖线
					break;
				//第2行
				case 2:
					g2.setFont(gridTitleFont); // 设置字体  
					g2.drawString("户名", (float)leftPointX + 23, (float) line + gridTitleFontHeight);
					g2.drawString("客户地址", (float) leftPointX + 255, (float) line + gridTitleFontHeight);
					
					g2.setFont(gridFont); // 设置字体  
					g2.drawString(this.userName, (float)leftPointX + 87, (float) line + gridFontHeight);
					g2.drawString(this.addr, (float) leftPointX + 337, (float) line + gridFontHeight);
					
					g2.drawLine(leftPointX + lineSpace, (int) line, leftPointX + lineSpace, (int) (line + rowHight)); //中竖线
					g2.drawLine(leftPointX + 237, (int) line, leftPointX + 237, (int) (line + rowHight)); //中竖线
					g2.drawLine(leftPointX + 314, (int) line, leftPointX + 314, (int) (line + rowHight)); //中竖线
					
					break;
				//第3行
				case 3:
					g2.setFont(gridTitleFont); // 设置字体  
					// 上次行度、本次行度、实际用水量、分摊、合计、单价、金额
					g2.drawString("水费", (float)leftPointX + 23, (float) (line + gridTitleFontHeight*1.7));
					g2.drawString("上次行度", (float)leftPointX + 80, (float) line + gridTitleFontHeight);
					g2.drawString("本次行度", (float)leftPointX + 150, (float) line + gridTitleFontHeight);
					g2.drawString("实际用水量", (float)leftPointX + 212, (float) line + gridTitleFontHeight);
					g2.drawString("损耗量", (float)leftPointX + 282, (float) line + gridTitleFontHeight);
					g2.drawString("合计(t)", (float)leftPointX + 355, (float) line + gridTitleFontHeight);
					g2.drawString("单价(元)", (float)leftPointX + 420, (float) line + gridTitleFontHeight);
					g2.drawString("金额(元)", (float)leftPointX + 490, (float) line + gridTitleFontHeight);
					
					g2.setFont(gridFont); // 设置字体
					g2.drawLine(leftPointX + lineSpace, (int) line, leftPointX + lineSpace, (int) (line + rowHight)); //中竖线
					g2.drawLine(leftPointX + lineSpace*2, (int) line, leftPointX + lineSpace*2, (int) (line + rowHight)); //中竖线
					g2.drawLine(leftPointX + lineSpace*3, (int) line, leftPointX + lineSpace*3, (int) (line + rowHight)); //中竖线
					g2.drawLine(leftPointX + lineSpace*4, (int) line, leftPointX + lineSpace*4, (int) (line + rowHight)); //中竖线
					g2.drawLine(leftPointX + lineSpace*5, (int) line, leftPointX + lineSpace*5, (int) (line + rowHight)); //中竖线
					g2.drawLine(leftPointX + lineSpace*6, (int) line, leftPointX + lineSpace*6, (int) (line + rowHight)); //中竖线
					g2.drawLine(leftPointX + lineSpace*7, (int) line, leftPointX + lineSpace*7, (int) (line + rowHight)); //中竖线
					
					break;
				//第4行
				case 4:
					g2.setFont(gridFont); // 设置字体  
					// 上次行度、本次行度、实际用水量、分摊、合计、单价、金额
					g2.drawString(String.valueOf(this.beforeQty), (float)leftPointX + 95, (float) line + gridTitleFontHeight);
					g2.drawString(String.valueOf(this.currentQty), (float)leftPointX + 165, (float) line + gridTitleFontHeight);
					g2.drawString(String.valueOf(this.actualQty), (float)leftPointX + 230, (float) line + gridTitleFontHeight);
					g2.drawString(String.valueOf(this.apportionQty), (float)leftPointX + 305, (float) line + gridTitleFontHeight);
					g2.drawString(String.valueOf(this.totalQty), (float)leftPointX + 365, (float) line + gridTitleFontHeight);
					g2.drawString(String.valueOf(this.price), (float)leftPointX + 435, (float) line + gridTitleFontHeight);
					g2.drawString(String.valueOf(this.amount), (float)leftPointX + 505, (float) line + gridTitleFontHeight);
					
					g2.setFont(gridFont); // 设置字体
					g2.drawLine(leftPointX + lineSpace, (int) line, leftPointX + lineSpace, (int) (line + rowHight)); //中竖线
					g2.drawLine(leftPointX + lineSpace*2, (int) line, leftPointX + lineSpace*2, (int) (line + rowHight)); //中竖线
					g2.drawLine(leftPointX + lineSpace*3, (int) line, leftPointX + lineSpace*3, (int) (line + rowHight)); //中竖线
					g2.drawLine(leftPointX + lineSpace*4, (int) line, leftPointX + lineSpace*4, (int) (line + rowHight)); //中竖线
					g2.drawLine(leftPointX + lineSpace*5, (int) line, leftPointX + lineSpace*5, (int) (line + rowHight)); //中竖线
					g2.drawLine(leftPointX + lineSpace*6, (int) line, leftPointX + lineSpace*6, (int) (line + rowHight)); //中竖线
					g2.drawLine(leftPointX + lineSpace*7, (int) line, leftPointX + lineSpace*7, (int) (line + rowHight)); //中竖线
					
					break;
				//第5行
				case 5:
					g2.setFont(gridTitleFont); // 设置字体  
					// 上次行度、本次行度、实际用水量、分摊、合计、单价、金额
					g2.drawString("杂项", (float)leftPointX + 23, (float) (line + gridTitleFontHeight*1.7));
					g2.drawString("垃圾费", (float)leftPointX + 85, (float) line + gridTitleFontHeight);
					g2.drawString("网管费", (float)leftPointX + 155, (float) line + gridTitleFontHeight);
					g2.drawString("排污费", (float)leftPointX + 223, (float) line + gridTitleFontHeight);
					g2.drawString("其他费用", (float)leftPointX + 285, (float) line + gridTitleFontHeight);
					g2.drawString("杂项金额(元)", (float)leftPointX + lineSpace*6, (float) line + gridTitleFontHeight);
					
					g2.setFont(gridFont); // 设置字体
					g2.drawLine(leftPointX + lineSpace, (int) line, leftPointX + lineSpace, (int) (line + rowHight)); //中竖线
					g2.drawLine(leftPointX + lineSpace*2, (int) line, leftPointX + lineSpace*2, (int) (line + rowHight)); //中竖线
					g2.drawLine(leftPointX + lineSpace*3, (int) line, leftPointX + lineSpace*3, (int) (line + rowHight)); //中竖线
					g2.drawLine(leftPointX + lineSpace*4, (int) line, leftPointX + lineSpace*4, (int) (line + rowHight)); //中竖线
					g2.drawLine(leftPointX + lineSpace*5, (int) line, leftPointX + lineSpace*5, (int) (line + rowHight)); //中竖线
					
					break;
				//第6行
				case 6:
					g2.setFont(gridFont); // 设置字体  
					// 垃圾费、网管费、排污费、其它费用、小计
					g2.drawString(String.valueOf(this.garbagePrice), (float)leftPointX + 95, (float) line + gridTitleFontHeight);
					g2.drawString(String.valueOf(this.networkPrice), (float)leftPointX + 165, (float) line + gridTitleFontHeight);
					g2.drawString(String.valueOf(this.getSewagePrice()), (float)leftPointX + 230, (float) line + gridTitleFontHeight);
					g2.drawString(String.valueOf(this.getOtherPrice()), (float)leftPointX + 305, (float) line + gridTitleFontHeight);
					g2.drawString(String.valueOf(this.amonut2), (float)leftPointX + 420, (float) line + gridTitleFontHeight);
					
					g2.setFont(gridFont); // 设置字体
					g2.drawLine(leftPointX + lineSpace, (int) line, leftPointX + lineSpace, (int) (line + rowHight)); //中竖线
					g2.drawLine(leftPointX + lineSpace*2, (int) line, leftPointX + lineSpace*2, (int) (line + rowHight)); //中竖线
					g2.drawLine(leftPointX + lineSpace*3, (int) line, leftPointX + lineSpace*3, (int) (line + rowHight)); //中竖线
					g2.drawLine(leftPointX + lineSpace*4, (int) line, leftPointX + lineSpace*4, (int) (line + rowHight)); //中竖线
					g2.drawLine(leftPointX + lineSpace*5, (int) line, leftPointX + lineSpace*5, (int) (line + rowHight)); //中竖线
					
					break;
				//第7行
				case 7:
					g2.setFont(gridTitleFont); // 设置字体
					g2.drawString("金额合计", (float)leftPointX + 13, (float) line + gridTitleFontHeight);
					g2.drawString("(大写)", (float)leftPointX + 16, (float) (line + gridTitleFontHeight*2));
					g2.setFont(gridFont); // 设置字体
					g2.drawString("滞纳金：", (float) leftPointX + 415, (float) (line + gridTitleFontHeight*1.5));
					
					g2.drawString(String.valueOf(this.totalAmountCN), (float)leftPointX + 87, (float) (line + gridFontHeight*1.5));
					g2.drawString(String.valueOf(this.overdueAmount), (float) leftPointX + 500, (float) (line + gridFontHeight*1.5));
					
					g2.drawLine(leftPointX + lineSpace, (int) line, leftPointX + lineSpace, (int) (line + rowHight*1.7)); //中竖线
					break;
				case 8:
					g2.setFont(gridFont); // 设置字体
					g2.drawString("合计：", (float) leftPointX + 415, (float) line + gridFontHeight);
					g2.drawString(String.valueOf(this.totalAmountFoot), (float) leftPointX + 500, (float) line + gridFontHeight);
					break;
				//第8行
				case 9:
					g2.setFont(gridFont); // 设置字体
					g2.drawString("注意事项：", (float)leftPointX + 5, (float) line + gridFontHeight);
					g2.drawString("1、用户凭用户编号直接到我收费处缴清水费、卫生费。涂改或未盖收费章的收据均属无效；", (float) leftPointX + 50, (float) line + gridFontHeight);
					
					
					
					break;
				//第9行
				case 10:
					g2.setFont(gridFont); // 设置字体
					g2.drawString("2、收费周期为两月一次，每逢单月的15日-20日为收费日（上午9:00-12:00，下午2:30-4:30，节假日不办公，收费顺延）", (float) leftPointX + 50, (float) line + gridFontHeight);
					
					break;
				//第10行
				case 11:
					g2.setFont(gridFont); // 设置字体
					g2.drawString("逾期将按每日水费千分之一加收滞纳金。若滞纳金赶超本金时，按照村规处罚；", (float) leftPointX + 64, (float) line + gridFontHeight);
					
					break;
				//第11行
				case 12:
					g2.setFont(gridFont); // 设置字体
					g2.drawString("3、收费处联系电话：020-37376948", (float) leftPointX + 50, (float) line + gridFontHeight);
					
					break;
				//第12行
				case 13:
					g2.setFont(gridFootFont); // 设置字体
					g2.drawString(companyName, (float) leftPointX + 400, (float) line + gridFontHeight);
					
					break;
				//第13行
				case 14:
					g2.setFont(gridFootFont); // 设置字体
					g2.drawString(this.year+" 年 "+this.month+1+" 月 "+this.day+" 日", (float) leftPointX + 420, (float) line + gridFontHeight);
					
					break;
			}
			
			if(i<7){
				line += rowHight;
			}else if(i==7){
				//第5行
				line += rowHight*1.7;
			}else{
				line += rowHightFoot;
			}
        }
        
        switch (pageIndex) {  
        case 0: 
            return PAGE_EXISTS;  
        default: 
            return NO_SUCH_PAGE;  
        }  
	}
	

	
	public static void main(String[] args) { 
		PaymentReceiptForPrint paymentReceiptForPrint = new PaymentReceiptForPrint();
		paymentReceiptForPrint.setOrderNo("20171017001010101101");
		paymentReceiptForPrint.setWaterMeterCode("001010101");
		paymentReceiptForPrint.setBillingPeriod("2017-01-31 - 2017-01-31");
		paymentReceiptForPrint.setAddr("西街31号（69栋南座）502房");
		paymentReceiptForPrint.setUserName("曾昌舜");
		paymentReceiptForPrint.setBeforeQty(BigDecimal.valueOf(123));
		paymentReceiptForPrint.setCurrentQty(BigDecimal.valueOf(234));
		paymentReceiptForPrint.setActualQty(BigDecimal.valueOf(111));
		paymentReceiptForPrint.setApportionQty(BigDecimal.valueOf(9));
		paymentReceiptForPrint.setTotalQty(BigDecimal.valueOf(120));
		paymentReceiptForPrint.setPrice(BigDecimal.valueOf(0.5));
		paymentReceiptForPrint.setAmount(BigDecimal.valueOf(60));
		paymentReceiptForPrint.setGarbagePrice(BigDecimal.valueOf(15));
		paymentReceiptForPrint.setNetworkPrice(BigDecimal.valueOf(50));
		paymentReceiptForPrint.setSewagePrice(BigDecimal.valueOf(20));
		paymentReceiptForPrint.setOtherPrice(BigDecimal.valueOf(18));
		paymentReceiptForPrint.setTotalAmountCN("陆十 元整");
		paymentReceiptForPrint.setOverdueAmount(BigDecimal.valueOf(40));
		paymentReceiptForPrint.setTotalAmountFoot(BigDecimal.valueOf(100));
		paymentReceiptForPrint.setYear("2017");
		paymentReceiptForPrint.setMonth("10");
		paymentReceiptForPrint.setDay("19");
		paymentReceiptForPrint.setAmonut2(BigDecimal.valueOf(123));
		
		// 通俗理解就是书、文档
				Book book = new Book();
				// 设置成竖打
				PageFormat pf = new PageFormat();
				pf.setOrientation(PageFormat.PORTRAIT);
				// 通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。
				Paper p = new Paper();
				p.setSize(590, 420); // A5纸张大小
				p.setImageableArea(10, 10, 590, 420); // A5
				pf.setPaper(p);
				

				// 把 PageFormat 和 Printable 添加到书中，组成一个页面
				book.append(paymentReceiptForPrint, pf);
				// 获取打印服务对象
				PrinterJob job = PrinterJob.getPrinterJob();
				// 设置打印类
				job.setPageable(book);
				try {
					// 可以用printDialog显示打印对话框，在用户确认后打印；也可以直接打印
					// boolean a=job.printDialog();
					// if(a)
					// {
					job.print();
					// }
				} catch (PrinterException e) {
					e.printStackTrace();
				}
	} 
}
