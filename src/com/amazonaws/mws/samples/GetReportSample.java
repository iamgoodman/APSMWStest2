/******************************************************************************* 
 *  Copyright 2009 Amazon Services.
 *  Licensed under the Apache License, Version 2.0 (the "License"); 
 *  
 *  You may not use this file except in compliance with the License. 
 *  You may obtain a copy of the License at: http://aws.amazon.com/apache2.0
 *  This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR 
 *  CONDITIONS OF ANY KIND, either express or implied. See the License for the 
 *  specific language governing permissions and limitations under the License.
 * ***************************************************************************** 
 *
 *  Marketplace Web Service Java Library
 *  API Version: 2009-01-01
 *  Generated: Wed Feb 18 13:28:48 PST 2009 
 * 
 */



package com.amazonaws.mws.samples;

import java.util.List;



import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.soap.Node;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.amazonaws.mws.*;
import com.amazonaws.mws.model.*;

import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;
import com.amazonaws.mws.mock.MarketplaceWebServiceMock;

/**
 *
 * Get Report  Samples
 *
 *
 */
public class GetReportSample {

    /**
     * Just add a few required parameters, and try the service
     * Get Report functionality
     *
     * @param args unused
     * @throws FileNotFoundException 
     * @throws NamingException 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    public static void main(String... args) throws FileNotFoundException, NamingException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {

        /************************************************************************
         * Access Key ID and Secret Access Key ID, obtained from:
         * http://aws.amazon.com
         ***********************************************************************/
    	final String accessKeyId = "****";
        final String secretAccessKey = "****";

        final String appName = "Myawesomeapp";
        final String appVersion = "1.1.0";


        MarketplaceWebServiceConfig config = new MarketplaceWebServiceConfig();

        /************************************************************************
         * Uncomment to set the appropriate MWS endpoint.
         ************************************************************************/
        // US
         config.setServiceURL("https://mws.amazonservices.com");
        // UK
        // config.setServiceURL("https://mws.amazonservices.co.uk");
        // Germany
        // config.setServiceURL("https://mws.amazonservices.de");
        // France
        // config.setServiceURL("https://mws.amazonservices.fr");
        // Italy
        // config.setServiceURL("https://mws.amazonservices.it");
        // Japan
        // config.setServiceURL("https://mws.amazonservices.jp");
        // China
        // config.setServiceURL("https://mws.amazonservices.com.cn");
        // Canada
        // config.setServiceURL("https://mws.amazonservices.ca");
        // India
        // config.setServiceURL("https://mws.amazonservices.in");

        /************************************************************************
         * You can also try advanced configuration options. Available options are:
         *
         *  - Signature Version
         *  - Proxy Host and Proxy Port
         *  - User Agent String to be sent to Marketplace Web Service
         *
         ***********************************************************************/

        /************************************************************************
         * Instantiate Http Client Implementation of Marketplace Web Service        
         ***********************************************************************/

        MarketplaceWebService service = new MarketplaceWebServiceClient(
                accessKeyId, secretAccessKey, appName, appVersion, config);

        /************************************************************************
         * Setup request parameters and uncomment invoke to try out 
         * sample for Get Report 
         ***********************************************************************/

        /************************************************************************
         * Marketplace and Merchant IDs are required parameters for all 
         * Marketplace Web Service calls.
         ***********************************************************************/
        final String merchantId = "****";
        final String sellerDevAuthToken =  "****";

        GetReportRequest request = new GetReportRequest();
        request.setMerchant( merchantId );
        request.setMWSAuthToken(sellerDevAuthToken);

        request.setReportId( "2600845429017028" );

        // Note that depending on the type of report being downloaded, a report can reach 
        // sizes greater than 1GB. For this reason we recommend that you _always_ program to
        // MWS in a streaming fashion. Otherwise, as your business grows you may silently reach
        // the in-memory size limit and have to re-work your solution.
        //
         OutputStream report ;
         
	    report = new FileOutputStream( "Y:\\Staffs\\Joey\\Developer\\JoeyAdvisor\\Orderready.xml" );
		
         request.setReportOutputStream( report );
          
        invokeGetReport(service, request);
       
        
        //use DOM to parse XML, write amazon order id, Asin, sku, product name to DB
        
        try {	
        	
        	//Initialize new Obj to add retrieved data to DB each time it is being retreived 
        	Amazonorders orders = new Amazonorders(sellerDevAuthToken, sellerDevAuthToken, sellerDevAuthToken, sellerDevAuthToken, sellerDevAuthToken, sellerDevAuthToken, sellerDevAuthToken, sellerDevAuthToken, sellerDevAuthToken, sellerDevAuthToken, sellerDevAuthToken, sellerDevAuthToken, sellerDevAuthToken, sellerDevAuthToken, sellerDevAuthToken, sellerDevAuthToken, sellerDevAuthToken, sellerDevAuthToken, sellerDevAuthToken, sellerDevAuthToken, sellerDevAuthToken, sellerDevAuthToken, sellerDevAuthToken, sellerDevAuthToken, sellerDevAuthToken, sellerDevAuthToken, sellerDevAuthToken, sellerDevAuthToken, sellerDevAuthToken, sellerDevAuthToken, sellerDevAuthToken, null, sellerDevAuthToken, sellerDevAuthToken, sellerDevAuthToken);
           
            //Does not work, input is a string, only takes afile 
              File inputFile = new File("Y:\\Staffs\\Joey\\Developer\\JoeyAdvisor\\Orderready.xml");
        
            
            DocumentBuilderFactory dbFactory 
            
               = DocumentBuilderFactory.newInstance();
            
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            
            org.w3c.dom.Document doc = dBuilder.parse(inputFile);
            
            doc.getDocumentElement().normalize();
            
            System.out.println("Root element :" 
               + doc.getDocumentElement().getNodeName());
            
            NodeList nList = doc.getElementsByTagName("Order");
            
            System.out.println("----------------------------");
            
            for (int temp = 0; temp < nList.getLength(); temp++) {
            	
               org.w3c.dom.Node nNode = nList.item(temp);
               
               System.out.println("\nCurrent Element :" 
            		   
                  + nNode.getNodeName());
               
               if (nNode.getNodeType() == Node.ELEMENT_NODE) {
            	   
            	   /*System.out.println("im Here");*/
            	   
                /* 
                 //**Critical Error, Node can not be cast to type element
                  Node eElement = (Element) nNode;*/
                  
            	   org.w3c.dom.Node eElement =  nNode;
                 
                  
                  /*System.out.println("Im inside of an order");*/
                  
                  System.out.println("AmazonOrderId : " 
                		  
                     + ((org.w3c.dom.Element) eElement)
                     
                     .getElementsByTagName("AmazonOrderID")
                     .item(0)
                     .getTextContent());
                  
                  
                  
             
                  //set order id to orders obj
                  orders.setAmazonorderid(
                		  ((org.w3c.dom.Element) eElement) 
                     .getElementsByTagName("AmazonOrderID")
                     .item(0)
                     .getTextContent());
                  
                  
        
        
                  //set Asin to orders 
                  try{     
                	  
                	  
                     System.out.println("here");
                     
                     
                     
                 
                     
                     
                      String as = (((org.w3c.dom.Element) eElement) 
                      .getElementsByTagName("ASIN")
                      .item(0)
                      .getTextContent());
                      
                      
                      
                      orders.setAsin(
                        		 as);
                      
                      
                      System.out.println(orders.getAsin());
                      System.out.println("Did u see?");
                  }
                  catch(NullPointerException e){
                      
                
                     
                     	 
                     	 System.out.println("Canceled Order");
                     	 
                     	 orders.setAsin(
                            		 "");
                         	 
                     	 
                    
                      
                      
                  };
                  
                   
                       
             
                    //set sku   
                   try{
                  
                       String sku = (((org.w3c.dom.Element) eElement) 
                               .getElementsByTagName("SKU")
                               .item(0)
                               .getTextContent());
                       
                       
                       orders.setSku(sku);
                       
                       
                   }
                      
                      catch (NullPointerException e)
                       {
                      	 
                      	 orders.setSku(
                             		 "" );
                          	 
                      	 
                       }
                    
                       
                     
                     
                     
                       //set ProductName
                       
                       try{
                     	  
                       String pr = (((org.w3c.dom.Element) eElement) 
                               .getElementsByTagName("ProductName")
                               .item(0)
                               .getTextContent());
                       
                       
                 	  orders.setProductname(pr);
                       
                       
                       }
                       catch(NullPointerException e)
                       {
                     	
                                   
                     
                     	  
                     	  orders.setProductname(
                         		"" );
                     	  
                     	  
                       }
                       
                       
                       
                       
                       
                       //write to db
                       
                       String url = "000";
                       String username = "000";
                       String password = "000";
                       
                       System.out.println("Loading driver...");
                       try {
                           Class.forName("com.mysql.jdbc.Driver");
                           System.out.println("Driver loaded!");
                       } catch (ClassNotFoundException e) {
                           throw new IllegalStateException("Cannot find the driver in the classpath!", e);
                       }
                       
                       
                       
                       System.out.println("Connecting database...");
                       
                       try (Connection connection = DriverManager.getConnection(url, username, password)) {
                       	
                       	
                           System.out.println("Database connected!");
                           
                           
                           
                           //When first used this program Amazon Order ids are not avaiable, Insert all order ids to db first, for testing purposes, amazon order id already exists.
             
                          
                          
                       /*    String query = " insert into AmazonOrders (OrderNumbers)"
                                   + " values (?)";
                           
                           
                           PreparedStatement preparedStmt = (PreparedStatement) connection.prepareStatement(query);
                           preparedStmt.setString (1, orders.getAmazonorderid());
                           
                        // execute the preparedstatement
                           preparedStmt.execute();
                           System.out.println("inserted");*/
                           
                           
                           
                           
                           	
                           
                           // Update DB
                           String query = "UPDATE AmazonOrders SET SKU = ?, ASIN = ?, ProductName = ? "
                           		
                           		+ " WHERE OrderNumbers = ?";
                             
                           
                           
                           //create the mysql insert preparedstatement
                           
                           PreparedStatement preparedStmt = (PreparedStatement) connection.prepareStatement(query);
                          
                           //insert values to be updated to statement 
                           
                           preparedStmt.setString(1,orders.getSku());
                           
                           preparedStmt.setString(2,orders.getAsin());
                           
                           preparedStmt.setString(3,orders.getProductname());
                           
                           preparedStmt.setString(4,orders.getAmazonorderid());
                           
                      
                           System.out.println(query);
                           
                        // execute the preparedstatement
                           preparedStmt.execute();
                           System.out.println("Updated");
                           
                           
                           
                           //after inserting, close the connection
                           connection.close();
                           
                       } catch (SQLException e) {
                           throw new IllegalStateException("Cannot connect the database!", e);
                       }
                       
                       
                       
                       
                       
                       
                    }
                 }
              } catch (Exception e) {
             	 
             	 System.out.println("here is the canceled Order");
             	 

                 e.printStackTrace();
                 
                 
                 
                 
                 
                 
              }
        
        
        
        

        
        
    /*  //sax parser to parser the outputed xml report
        
     //fetch amazon order id and write it to DB
        
    	 // Location of the source file
        String sourceFilePath = "Y:\\Staffs\\Joey\\Developer\\JoeyAdvisor\\order report.txt";
        
        
  	   
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
              

            for(int i = 0; i<excelData.size();i++)
            {
           	 
           	 
           	String a = (excelData.get(i).toString().split(",")[0]);
           	
           	System.out.println(a.substring(1, a.length()));
           	
           	str.add(a.substring(1, a.length()));
           	 
            }
            
            
           System.out.println(str.get(0));
           
           str.remove(0);
           
           System.out.println("the list with id is " + str.get(0));
           
           
           
           
           
            //remove duplicate, should  have used hash to reduce complexity, will optimize later
            for(int i = 0; i<str.size();i++)
            {
         	   
          	  for(int j = i+1; j< str.size(); j++){
          		  
          		  
          		if(str.get(i) == str.get(j))
          		{
          			
          			str.remove(j);
          			
          		}
          		  
          		  
          	  }
         	   
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
          
        //write to db
        
        String url = "***";
        String username = "***";
        String password = "***";
        
        System.out.println("Loading driver...");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }
        
        System.out.println("Connecting database...");
        
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
        	
        	
            System.out.println("Database connected!");
            
            
            
            
            //if successful begin to insert into Amazon order# to DB
           
            for(int i = 0; i<str.size();i++)
            {
            	System.out.println("Imhere");
            	System.out.println("we are about to insert" +" "+ str.get(i));
            // the mysql insert statement
            String query = " insert into AmazonOrders (OrderNumbers)"
              + " values (?)";
            
            
            //create the mysql insert preparedstatement
            
            PreparedStatement preparedStmt = (PreparedStatement) connection.prepareStatement(query);
            preparedStmt.setString (1, str.get(i));
            
         // execute the preparedstatement
            preparedStmt.execute();
            System.out.println("inserted");
            
            }
            
            //after inserting, close the connection
            connection.close();
            
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }*/
        
        
       
        
        
        
    }



    /**
     * Get Report  request sample
     * The GetReport operation returns the contents of a report. Reports can potentially be
     * very large (>100MB) which is why we only return one report at a time, and in a
     * streaming fashion.
     *   
     * @param service instance of MarketplaceWebService service
     * @param request Action to invoke
     */
    public static void invokeGetReport(MarketplaceWebService service, GetReportRequest request) {
        try {

            GetReportResponse response = service.getReport(request);


            System.out.println ("GetReport Action Response");
            System.out.println ("=============================================================================");
            System.out.println ();

            System.out.print("    GetReportResponse");
            System.out.println();
            System.out.print("    GetReportResult");
            System.out.println();
            System.out.print("            MD5Checksum");
            System.out.println();
            System.out.print("                " + response.getGetReportResult().getMD5Checksum());
            System.out.println();
            if (response.isSetResponseMetadata()) {
                System.out.print("        ResponseMetadata");
                System.out.println();
                ResponseMetadata  responseMetadata = response.getResponseMetadata();
                if (responseMetadata.isSetRequestId()) {
                    System.out.print("            RequestId");
                    System.out.println();
                    System.out.print("                " + responseMetadata.getRequestId());
                    System.out.println();
                }
            } 
            System.out.println();

            System.out.println("Report");
            System.out.println ("=============================================================================");
            System.out.println();
            System.out.println( request.getReportOutputStream().toString() );
            System.out.println();

            System.out.println(response.getResponseHeaderMetadata());
            System.out.println();


        } catch (MarketplaceWebServiceException ex) {

            System.out.println("Caught Exception: " + ex.getMessage());
            System.out.println("Response Status Code: " + ex.getStatusCode());
            System.out.println("Error Code: " + ex.getErrorCode());
            System.out.println("Error Type: " + ex.getErrorType());
            System.out.println("Request ID: " + ex.getRequestId());
            System.out.print("XML: " + ex.getXML());
            System.out.println("ResponseHeaderMetadata: " + ex.getResponseHeaderMetadata());
        }
    }

}
