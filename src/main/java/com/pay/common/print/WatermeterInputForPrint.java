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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.pay.pojo.waterpay.PayWaterMeterInputDetail;

/**
 * 打印布局类
 * 实现Printable接口 用于创建打印内容 
 */
public class WatermeterInputForPrint implements Printable {
	
	private String companyName="白水塘实业有限公司";
	private String orderNo;
	private String buildingCode;
	private String addr;
	private String houseMaster;
	private Map<String, List<PayWaterMeterInputDetail>> detailMap;
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getBuildingCode() {
		return buildingCode;
	}

	public void setBuildingCode(String buildingCode) {
		this.buildingCode = buildingCode;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public String getHouseMaster() {
		return houseMaster;
	}

	public void setHouseMaster(String houseMaster) {
		this.houseMaster = houseMaster;
	}

	public Map<String, List<PayWaterMeterInputDetail>> getDetailMap() {
		return detailMap;
	}

	public void setDetailMap(Map<String, List<PayWaterMeterInputDetail>> detailMap) {
		this.detailMap = detailMap;
	}

	public WatermeterInputForPrint(){};

	public WatermeterInputForPrint(String companyName, String orderNo,
			String buildingCode, String addr, Map<String, List<PayWaterMeterInputDetail>> detailMap,String houseMaster) {
		super();
		this.companyName = companyName;
		this.orderNo = orderNo;
		this.buildingCode = buildingCode;
		this.addr = addr;
		this.detailMap = detailMap;
		this.houseMaster=houseMaster;
	}

	@Override
	public String toString() {
		return "WatermeterInputForPrint [companyName=" + companyName
				+ ", orderNo=" + orderNo + ", buildingCode=" + buildingCode 
				+ ", addr=" + addr + ", detailMap=" + detailMap + "]";
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
		Font gridTitleFont = new Font("宋体", Font.BOLD, 11); //表格标题字体大小
		Font gridFont = new Font("宋体", Font.PLAIN, 10); //表格字体大小
		Font gridFootFont = new Font("宋体", Font.BOLD, 9); //表格尾字体大小
		
		float titleFontHeight = gridFont.getSize2D(); //标题字体高度
		float gridTitleFontHeight = gridTitleFont.getSize2D() + 6; //表格标题字体高度
		float gridFontHeight = gridFont.getSize2D() + 7; //表格字体高度

		int rowHight = 25; //自定义行高
		int rowHightFoot = 20; //自定义行高
		int line = (int) y;
		
		int leftPointX = (int) x + 15;
		int rightPointX = (int) x + 561;
		
		System.out.println("X = " + (rightPointX-leftPointX));
		
		//设置标题
		g2.setFont(titleFont); // 设置字体  
		g2.drawString(companyName+"水费抄表单", (float) leftPointX + 160, (float) y + titleFontHeight + 10);
		g2.setFont(gridTitleFont); // 设置字体  
		g2.drawString("楼宇编号:", (float) leftPointX + 5, (float) y + titleFontHeight*4 + 10);
		g2.drawString("楼宇地址:", (float) leftPointX + 100, (float) y + titleFontHeight*4 + 10);
		g2.drawString("户主:", (float) leftPointX + 300, (float) y + titleFontHeight*4 + 10);
		g2.drawString("No:", (float) leftPointX + 410, (float) y );
		g2.setFont(gridFont); // 设置字体  
		g2.drawString(this.buildingCode, (float) leftPointX + 60, (float) y + titleFontHeight*4 + 10);
		g2.drawString(this.addr, (float) leftPointX + 160, (float) y + titleFontHeight*4 + 10);
		g2.drawString(this.houseMaster, (float) leftPointX + 330, (float) y + titleFontHeight*4 + 10);
		g2.drawString(this.orderNo, (float) leftPointX + 430, (float) y );

		line += titleFontHeight*5 + 10;
		
		int lineSpace = (int) 55;	//间距
		
		// 设置打印颜色为黑色  
		g2.setColor(Color.black); 
		g2.setFont(gridFont); // 设置字体
		g2.drawLine(leftPointX, (int) line, leftPointX, (int) (line + rowHight)); //左竖线
		g2.drawLine(rightPointX, (int) line, rightPointX, (int) (line + rowHight)); //右竖线
		
		//第一条横线
		g2.drawLine(leftPointX, (int) line, rightPointX, (int) line); //横线
		
		//第1行-------------------------开始------------------------------
		g2.setFont(gridTitleFont); // 设置字体  
		g2.drawString("房间号", (float)leftPointX + 4, (float) (line + gridTitleFontHeight));
		g2.drawString("水表编号", (float)leftPointX + lineSpace+5, (float) (line + gridTitleFontHeight));
		
		int[] monthArry={1,3,5,7,9,11};
		
		int titleLineSpace = (int) 28;	//间距
		int h=2;
		for(int j = 0; j < monthArry.length; j++){
			
			g2.drawString(monthArry[j]+"月", (float)(leftPointX + lineSpace*(h+1) - titleLineSpace), (float) line + gridTitleFontHeight);
//			if(j == 9){
//				titleLineSpace = 32;
//			}
			h++;
		}
		g2.drawString("备注", (float)(leftPointX + lineSpace*(h+1) - titleLineSpace), (float) line + gridTitleFontHeight);
		
		g2.setFont(gridFont); // 设置字体  
		g2.drawLine(leftPointX + lineSpace, (int) line, leftPointX + lineSpace, (int) (line + rowHight)); //中竖线
		h=1;
		for(int j = 0; j < monthArry.length; j++){
			g2.drawLine(leftPointX + lineSpace*(h+1), (int) line, leftPointX + lineSpace*(h+1), (int) (line + rowHight)); //中竖线
			h++;
		}
		g2.drawLine(leftPointX + lineSpace*(h+1), (int) line, leftPointX + lineSpace*(h+1), (int) (line + rowHight)); //中竖线
		line += rowHight;
		//第1行-------------------------结束------------------------------
		
		titleLineSpace = (int) 28;	//间距
		List<String> keyList = new ArrayList<String>(this.detailMap.keySet());
		Collections.sort(keyList, new Comparator<String>() {
			public int compare(String str1, String str2) {
				return str1.compareTo(str2);
			}
		});
		//System.out.println("keyList = " + keyList.toString());
	
		for(String room : keyList){
			g2.setFont(gridFont); // 设置字体
			g2.drawLine(leftPointX, (int) line, rightPointX, (int) line); //横线
			g2.drawLine(leftPointX, (int) line, leftPointX, (int) (line + rowHight)); //左竖线
			g2.drawLine(rightPointX, (int) line, rightPointX, (int) (line + rowHight)); //右竖线
			
			List<PayWaterMeterInputDetail> detailList = this.detailMap.get(room);
			String[] roomArry=room.split("\\|");
			//System.out.println(room);
			String roomNo=roomArry[0];
			//System.out.println(roomNo);
			String waterMeterCode=roomArry[1];
			//System.out.println(waterMeterCode);
			//房间编号
			g2.setFont(gridTitleFont); // 设置字体  
			g2.drawString(roomNo, (float)leftPointX + 10, (float) (line + gridTitleFontHeight));
			g2.setFont(gridFont); // 设置字体  
			g2.drawLine(leftPointX + lineSpace, (int) line, leftPointX + lineSpace, (int) (line + rowHight)); //中竖线
			//水表编号
			g2.setFont(gridTitleFont); // 设置字体  
			g2.drawString(waterMeterCode, (float)leftPointX + lineSpace+3, (float) (line + gridTitleFontHeight));
			g2.setFont(gridFont); // 设置字体  
			g2.drawLine(leftPointX + lineSpace, (int) line, leftPointX + lineSpace, (int) (line + rowHight)); //中竖线
			h=2;
			for(int j = 1; j < detailList.size()+1; j++){
				PayWaterMeterInputDetail detail = detailList.get(j-1);
				
				g2.setFont(gridTitleFont); // 设置字体  

				if(detail == null || detail.getCurrentQty().compareTo(new BigDecimal(0))==0){
					g2.drawString("", (float)(leftPointX + lineSpace*(h+1) - titleLineSpace), (float) line + gridTitleFontHeight);
				}else{
					g2.drawString(String.valueOf(new DecimalFormat("#.####").format(detail.getCurrentQty())), (float)(leftPointX + lineSpace*(h+1) - titleLineSpace), (float) line + gridTitleFontHeight);
				}
				

				g2.setFont(gridFont); // 设置字体  
				g2.drawLine(leftPointX + lineSpace*h, (int) line, leftPointX + lineSpace*h, (int) (line + rowHight)); //中竖线
				h++;
			}
			//备注
			g2.setFont(gridTitleFont); // 设置字体  
			g2.drawString("", (float)(leftPointX + lineSpace*(h+1) - titleLineSpace), (float) line + gridTitleFontHeight);
			g2.setFont(gridFont); // 设置字体  
			g2.drawLine(leftPointX + lineSpace*h, (int) line, leftPointX + lineSpace*h, (int) (line + rowHight)); //中竖线
			
			line += rowHight;
		}
		g2.drawLine(leftPointX, (int) line, rightPointX, (int) line); //底线
        
        switch (pageIndex) {  
        case 0: 
            return PAGE_EXISTS;  
        default: 
            return NO_SUCH_PAGE;  
        }  
	}
	

	
	public static void main(String[] args) { 
		WatermeterInputForPrint headers = new WatermeterInputForPrint();
		headers.setOrderNo("20171017001010101101");
		headers.setBuildingCode("10");
		headers.setAddr("西街31号（69栋南座）");
		headers.setHouseMaster("asdfasdfs");
		Map<String, List<PayWaterMeterInputDetail>> detailMap = new HashMap<String, List<PayWaterMeterInputDetail>>();
		
		int roomNo = 100;
		String year = "2017";
		for(int j = 1; j < 10; j++){
			String month = ("0"+j);
			month = month.substring(month.length()-2, month.length());
			List<PayWaterMeterInputDetail> details = new ArrayList<PayWaterMeterInputDetail>();
			roomNo += 1;
			for(int i = 1; i < 7; i++){
				PayWaterMeterInputDetail detail = new PayWaterMeterInputDetail();
				detail.setCode("20171017001010101101");
				detail.setCode("10");
				detail.setRoomNo(String.valueOf(roomNo));
				detail.setBeforeQty(BigDecimal.valueOf(roomNo));
				detail.setCurrentQty(BigDecimal.valueOf(i));
				detail.setGarbagePrice(BigDecimal.valueOf(15));
				detail.setNetworkPrice(BigDecimal.valueOf(50));
				detail.setSewagePrice(BigDecimal.valueOf(20));
				detail.setOtherPrice(BigDecimal.valueOf(18));
				detail.setWaterMeterCode("280"+roomNo);
				details.add(detail);
			}
			detailMap.put(String.valueOf(roomNo)+"|"+"203", details);
		}
		headers.setDetailMap(detailMap);
		
		System.out.println("headers = "+headers.toString());
		
		// 通俗理解就是书、文档
		Book book = new Book();
		// 设置成竖打
		PageFormat pf = new PageFormat();
		pf.setOrientation(PageFormat.PORTRAIT);
		// 通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。  
		Paper p = new Paper();  
		p.setSize(590, 840); // Warranty Paper Size,A4 590, 840  
		p.setImageableArea(10, 10, 590, 840); // Print Area  
		pf.setPaper(p);  
		

		// 把 PageFormat 和 Printable 添加到书中，组成一个页面
		book.append(headers, pf);
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
