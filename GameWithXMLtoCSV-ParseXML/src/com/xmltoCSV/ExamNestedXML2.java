package com.xmltoCSV;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.writer.CSVWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ExamNestedXML2 {
	

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		System.out.println("reading of xml started");
		
		File file = new File("E:/XML File/Batch.xml");
   		
   	           	
         	  
    	   DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    	   DocumentBuilder db = dbf.newDocumentBuilder();
    	   Document doc = db.parse(file);
    	   doc.getDocumentElement().normalize();
    	   System.out.println("Root element " + doc.getDocumentElement().getNodeName());
		

		NodeList labTestList = doc.getElementsByTagName("Document");
		System.out.println(doc);
		System.out.println(labTestList + "      started");
		for (int i = 0; i < labTestList.getLength(); ++i)
		{
			System.out.println("stated");
		    Element labTest = (Element) labTestList.item(i);
		    String labTestType = labTest.getAttribute("Identifier");
		    System.out.println(labTestType);
		    Element labTest2 = (Element) labTestList.item(i);
		    String labTestType2 = labTest2.getAttribute("Confidence");
		    System.out.println(labTestType2);

		    NodeList valueList = labTest.getElementsByTagName("Page");
		    for (int j = 0; j < valueList.getLength(); ++j)
		    {
		        Element value = (Element) valueList.item(j);
		        String valueType = value.getAttribute("Identifier");
		        System.out.println(valueType);
		        NodeList conditionList = value.getElementsByTagName("PageLevelField");
		        for (int k = 0; k < conditionList.getLength(); ++k)
		        {
		            Element condition = (Element) conditionList.item(k);
		            String conditionText = condition.getAttribute("Value");
		        }
		       
		    }
		}
		
	}
	
}


