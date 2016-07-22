package com.amazonaws.mws.samples;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;



public class GetSellingprice {
	
	
	
	
	
	
	
	
	
	 public static void main(String[] args) {
	    	

	    	
	    	
		    
	    	//To read input ASINs as excel formatt and parse into java, stored as arrayList
	    	
	    	 // Location of the source file
	       String sourceFilePath = "Y:\\Staffs\\Joey\\rep.xls";
	       
	      
	    		   
	       FileInputStream fileInputStream = null;
	         
	       // Array List to store the excel sheet data
	       ArrayList excelData = new ArrayList();
	       
	       
	     //String array to store SKUs to get price
	       List<String> str = new ArrayList<String>();

	         
	       //A more robust importing method for importing excel data to arrays
	       try {
	             
	           // FileInputStream to read the excel file
	           fileInputStream = new FileInputStream(sourceFilePath);

	           // Create an excel workbook
	           HSSFWorkbook excelWorkBook = new HSSFWorkbook(fileInputStream);
	             
	           // Retrieve the first sheet of the workbook.
	           HSSFSheet excelSheet = excelWorkBook.getSheetAt(0);
                 
             
	           // Iterate through the sheet rows and cells. 
	           // Store the retrieved data in an arrayList
	           java.util.Iterator<Row> rows = excelSheet.rowIterator();
	           while (rows.hasNext()) {
	               HSSFRow row = (HSSFRow) rows.next();
	               java.util.Iterator<Cell> cells = row.cellIterator();

	               ArrayList cellData = new ArrayList();
	               while (cells.hasNext()) {
	                   HSSFCell cell = (HSSFCell) cells.next();
	                   cellData.add(cell);
	               }

	               excelData .add(cellData);
	           }
	             
	           // Print retrieved data to the console
	    /*     for (int rowNum = 0; rowNum < excelData.size(); rowNum++) {
	                 
	               ArrayList list = (ArrayList) excelData.get(rowNum);
	                 
	               for (int cellNum = 0; cellNum < list.size(); cellNum++) {
	                     
	                   HSSFCell cell = (HSSFCell) list.get(cellNum);
	                     
	                 
	               }
	               
	           }
	         */
	   /*      for(int i = 0; i<excelData.size();i++)
	         {
	        	 
	        	 
	        	str.add(excelData.get(i).toString().split(",")[0]);
	        	 
	         }
	         
	         for(int j =0;j<str.size();j++)
	         {
	        	 
	        	 //remove brackets of skus
	        	 
	        	 System.out.println(str.get(j).substring(1, str.get(j).toString().length()));

	         }
	         */
	           
	           for(int i = 0; i<excelData.size();i++)
	           {
	          	 
	          	 
	          	String a = (excelData.get(i).toString().split(",")[0]);
	          	
	          	System.out.println(a.substring(1, a.length()));
	          	
	          	str.add(a.substring(1, a.length()));
	          	 
	           }
	           
	           
	           for(int i = 0; i<str.size();i++)
	           {
	        	   
	        	   
	        	   System.out.println(str.get(i));
	        	   
	        	   
	           }
	           
	           
	         
	       } catch (IOException e) {
	           e.printStackTrace();
	       } finally {
	           if (fileInputStream != null) {
	               try {
					fileInputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	           }
	       }
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       

}
}
