package com.pay.handler;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.bstek.bdf2.swfviewer.controller.PdfToSwfConverter;
import com.bstek.bdf2.swfviewer.handler.ISwfFileHandler;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class TestPdfToSwfHandler implements ISwfFileHandler {
	public String getHandlerName() {
		return "test.pdf2swfHandler";
	}

	public String getHandlerDesc() {
		return "在线预览打印pdf文件";
	}

	public File execute(Map<String, Object> varMap) throws Exception {
		System.out.println(varMap.get("testParameter1"));
		System.out.println(varMap.get("testParameter2"));
		createPdfFile();
		File pdfFile = new File("d:/test.pdf");
		String sourcePdf = pdfFile.getAbsolutePath();
		PdfToSwfConverter pdfToSwfConverter = new PdfToSwfConverter();
		String swf = pdfToSwfConverter.execute(sourcePdf, null);
		return new File(swf);
	}
	
	private void createPdfFile(){
		// 1.新建document对象
				Document document = new Document();
		try{
		
		 
		// 2.建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中。
		// 创建 PdfWriter 对象 第一个参数是对文档对象的引用，第二个参数是文件的实际名称，在该名称中还会给出其输出路径。
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("d:/test.pdf"));
		
		// 3.打开文档
		document.open();
		  
		// 4.添加一个内容段落
		document.add(new Paragraph("Hello World!"));
		
		// 5.关闭文档
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			document.close();
		}
	}
}
