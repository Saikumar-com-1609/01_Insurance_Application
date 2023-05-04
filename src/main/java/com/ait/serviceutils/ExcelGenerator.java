package com.ait.serviceutils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import com.ait.entity.CitizenPlan;

@Component
public class ExcelGenerator {
	
	public void generateExcel(HttpServletResponse response, List<CitizenPlan> plans, File file) throws Exception{
		
		 Workbook workbook = new HSSFWorkbook();
	      Sheet sheet = workbook.createSheet("plans-record");
	      Row headerRow = sheet.createRow(0);
	      
	      headerRow.createCell(0).setCellValue("CITIZEN ID");
	      headerRow.createCell(1).setCellValue("CITIZEN NAME");
	      headerRow.createCell(2).setCellValue("PLAN NAME");
	      headerRow.createCell(3).setCellValue("PLAN STATUS");
	      headerRow.createCell(4).setCellValue("PLAN START DATE");
	      headerRow.createCell(5).setCellValue("PLAN END DATE");
	      headerRow.createCell(6).setCellValue("BENEFIT AMOUNT");
	      
	     
	      
	      int dataRowIndex = 1;
	      
	      for(CitizenPlan plan : plans) {
	    	  Row dataRow = sheet.createRow(dataRowIndex);
	    	  
	    	  dataRow.createCell(0).setCellValue(plan.getCITIZEN_ID());
	    	  dataRow.createCell(1).setCellValue(plan.getCITIZEN_NAME());
	    	  dataRow.createCell(2).setCellValue(plan.getPLAN_NAME());
	    	  dataRow.createCell(3).setCellValue(plan.getPLAN_STATUS());
	    	  if(null != plan.getPLAN_START_DATE()) {
	    	  dataRow.createCell(4).setCellValue(plan.getPLAN_START_DATE()+"");
	    	  } else {
	          dataRow.createCell(4).setCellValue("N/A");
	          }
	    	  if(null != plan.getPLAN_END_DATE()) {
	    	  dataRow.createCell(5).setCellValue(plan.getPLAN_END_DATE()+"");
	    	  } else {
	          dataRow.createCell(5).setCellValue("N/A");
	          }
	    	  if(null != plan.getBENEFIT_AMOUNT()) {
	    	  dataRow.createCell(6).setCellValue(plan.getBENEFIT_AMOUNT());
	    	  }else {
	        	  dataRow.createCell(6).setCellValue("N/A");
	          }
	    	 
	    	  
	    	  dataRowIndex++;
	    }
	       //difference between FileOutputStream and ServletOutputStream
	      //FileOutputStream will create file in current project folder
	      FileOutputStream fos = new FileOutputStream(file);
	      workbook.write(fos);
	      fos.close();
	      
	      //ServletOutputStream  will send the file to the browser
	      ServletOutputStream outputStream = response.getOutputStream();
	      workbook.write(outputStream);
	      workbook.close();
	      
	      
		
	}

}
