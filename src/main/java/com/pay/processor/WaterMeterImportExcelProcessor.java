package com.pay.processor;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import com.bstek.bdf2.core.business.IUser;
import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.bdf2.importexcel.ImportExcelJdbcDao;
import com.bstek.bdf2.importexcel.model.CellWrapper;
import com.bstek.bdf2.importexcel.model.ExcelDataWrapper;
import com.bstek.bdf2.importexcel.model.RowWrapper;
import com.bstek.bdf2.importexcel.processor.IExcelProcessor;
import com.pay.exception.BusinessException;
import com.pay.pojo.waterpay.PayWaterMeterInputDetail;

/**
 * 打版批次导入,单表解析入库处理类
 * @author tai.liang
 */
@Component("waterMeterImportExcelProcessor")
public class WaterMeterImportExcelProcessor extends ImportExcelJdbcDao implements IExcelProcessor {
	public final Log LOGGER = LogFactory.getLog(WaterMeterImportExcelProcessor.class);
	
	public String getName() {
		return "waterMeterImportExcelProcessor";
	}
	
	private void getColumnList(Collection<RowWrapper> rowWrappers, List<PayWaterMeterInputDetail> detailList){
		//获取Excel的所有数据,并保存到rowValueList中（rowValueList=每一行的数据集，columnValueList=每一个单元格的数据集）
		for (RowWrapper rowWrapper : rowWrappers) {
			Collection<CellWrapper> cellWrappers = rowWrapper.getCellWrappers();
			PayWaterMeterInputDetail detail = new PayWaterMeterInputDetail();
			detail.setNotExistsStatus("2");
			
			int cellNum = 1;
			for (CellWrapper cellWrapper : cellWrappers) {
				Object columnValue = cellWrapper.getValue();
				
				switch (cellNum) {
				case 1://月度
					
//					DecimalFormat df = new DecimalFormat("######0"); //四色五入转换成整数 
					detail.setMonthlyCycle(Integer.parseInt((String)columnValue));
					break;
				case 2://楼宇
					detail.setBuildingCode(((String)columnValue).substring(0, 6));
					detail.setRoomNo(((String)columnValue).substring(6, 9));
					break;
				case 3://当前吨数
					detail.setCurrentQty(new BigDecimal((String)columnValue));
					break;
//				case 5://垃圾费
//					detail.setGarbagePrice(BigDecimal.valueOf((Double)columnValue));
//					break;
//				case 6://网费
//					detail.setNetworkPrice(BigDecimal.valueOf((Double)columnValue));
//					break;
//				case 7://排污费
//					detail.setSewagePrice(BigDecimal.valueOf((Double)columnValue));
//					break;
//				case 8://其他费用
//					detail.setOtherPrice(BigDecimal.valueOf((Double)columnValue));
//					break;
//				case 9://备注
//					detail.setRemark((String)columnValue);
//					break;

				default:
					break;
				}
				cellNum++;
			}
			detailList.add(detail);
		}
	}

	public int execute(ExcelDataWrapper excelDataWrapper) throws Exception {
		try{
			if (!excelDataWrapper.isValidate()) {
				throw new RuntimeException("当前数据没有通过验证,不能解析入库！");
			}
			IUser user=ContextHolder.getLoginUser();
			//获取Excel记录
			Collection<RowWrapper> rowWrappers = excelDataWrapper.getRowWrappers();
			
			//每行的数据
			List<PayWaterMeterInputDetail> detailList = new ArrayList<PayWaterMeterInputDetail>();
			
			//解析每行数据到list
			getColumnList(rowWrappers, detailList);
			
			//查询唯一主键
			List<Map<String, Object>> resultList = new ArrayList<Map<String,Object>>();
			
			int count = 0;
			for(int i = 0; i<detailList.size(); i++){
				PayWaterMeterInputDetail detail = detailList.get(i);
				//更新明细:pay_water_meter_input_detail
				StringBuffer sbSql = new StringBuffer();
				sbSql.append("update pay_water_meter_input_detail set ");
				sbSql.append("	current_qty = ?, ");
//				sbSql.append("	garbage_price = ?, ");
//				sbSql.append("	network_price = ?, ");
//				sbSql.append("	sewage_price = ?, ");
//				sbSql.append("	other_price = ?, ");
//				sbSql.append("	remark = ?, ");
				sbSql.append("	last_modify_user = ?, ");
				sbSql.append("	last_modify_time = now(), ");
				sbSql.append("	status = 1 ");
				sbSql.append("where monthly_cycle = ? ");
				sbSql.append("	and building_code = ? ");
				sbSql.append("	and room_no = ? ");
				sbSql.append("	and status <> 2 ");
				this.getJdbcTemplate().update(sbSql.toString(), new Object[]{
					detail.getCurrentQty(),
//					detail.getGarbagePrice(),
//					detail.getNetworkPrice(),
//					detail.getSewagePrice(),
//					detail.getOtherPrice(),
//					detail.getRemark(),
					user.getUsername(),
					detail.getMonthlyCycle(),
					detail.getBuildingCode(),
					detail.getRoomNo()
				});
				
				//获取唯一识别字段code，用于更新pay_water_meter_input_header和pay_water_meter_input_building
				sbSql = new StringBuffer();
				sbSql.append("select code, building_code from pay_water_meter_input_detail ");
				sbSql.append("where monthly_cycle = ? and building_code = ? and room_no = ? and status <> 2 ");
				sbSql.append("order by code ");
				
				resultList = this.getJdbcTemplate().queryForList(sbSql.toString(), new Object[]{detail.getMonthlyCycle(), detail.getBuildingCode(), detail.getRoomNo()});
				if(CollectionUtils.isEmpty(resultList)){
					throw new BusinessException("导入的Excel数据找不到对应的抄表记录，请先初始化抄表数据！");
				}
				
				Set<String> set = new HashSet<String>();
				//更新pay_water_meter_input_header和pay_water_meter_input_building
				for(Map<String, Object> map : resultList){
					String uniqueCode = (String)map.get("code");
					String buildingCode = (String)map.get("building_code");
					
					//更新pay_water_meter_input_building
					sbSql = new StringBuffer();
					sbSql.append("update pay_water_meter_input_building A set ");
					sbSql.append("	A.current_qty = ( ");
					sbSql.append("		select ");
					sbSql.append("			sum(B.current_qty) ");
					sbSql.append("		from easypay.pay_water_meter_input_detail B ");
					sbSql.append("		where B.code = ? and A.code = B.code ");
					sbSql.append("			and A.monthly_cycle = B.monthly_cycle and A.building_code = B.building_code ");
					sbSql.append("		group by B.code, B.monthly_cycle, B.building_code ");
					sbSql.append("	), ");
					sbSql.append("	A.last_modify_user = ?, ");
					sbSql.append("	A.last_modify_time = now(), ");
					sbSql.append("	A.status = 1 ");
					sbSql.append("where A.code = ? and A.building_code = ? and A.status <> 2 ");
					this.getJdbcTemplate().update(sbSql.toString(), new Object[]{ uniqueCode, user.getUsername(), uniqueCode, buildingCode});
					
					if(!set.contains(uniqueCode)){
						//更新pay_water_meter_input_header
						sbSql = new StringBuffer();
						sbSql.append("update pay_water_meter_input_header A set ");
						sbSql.append("	A.current_qty = ( ");
						sbSql.append("		select ");
						sbSql.append("			sum(B.current_qty) ");
						sbSql.append("		from easypay.pay_water_meter_input_detail B ");
						sbSql.append("		where B.code = ? and A.code = B.code and A.monthly_cycle = B.monthly_cycle ");
						sbSql.append("		group by B.code, B.monthly_cycle ");
						sbSql.append("	), ");
						sbSql.append("	A.last_modify_user = ?, ");
						sbSql.append("	A.last_modify_time = now(), ");
						sbSql.append("	A.status = 1 ");
						sbSql.append("where A.code = ? and A.status <> 2 ");
						this.getJdbcTemplate().update(sbSql.toString(), new Object[]{ uniqueCode, user.getUsername(), uniqueCode});
						
						set.add((String) map.get("code"));
					}
				}
				
				count += 1;
			}
			
			LOGGER.info("解析excel入库成功，导入[" + count + "]条数据！");
			return count;
		}catch(Exception e){
			LOGGER.error("解析Excel导入数据库时出错！出错类名：WaterMeterImportExcelProcessor。" + e.getMessage());
			throw new BusinessException("解析Excel导入数据库时出错！出错类名：WaterMeterImportExcelProcessor。" + e.getMessage());
		}
	}
	
	public static void main(String[] args){
		String userCode="292070401";
		System.out.println(userCode.substring(0, 6));
		System.out.println(userCode.substring(6, 9));
	}
}
