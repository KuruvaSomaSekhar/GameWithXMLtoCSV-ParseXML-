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

public class ExamNestedXML {
	

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		System.out.println("reading of xml started");
		
		File file = new File("E:/XML File/Batch.xml");
   		//  DateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");  
   	        File csvfile = new File( "E:/XML File/StatisticsBatch.csv");  
   	        if ( !csvfile.exists() )
   	        	csvfile.createNewFile();
   	//        CSVWriter writer = new CSVPrinter(new FileWriter(csvfile));
   	       Writer csvOutput = new FileWriter(csvfile ).append(',');
   	
         	  
    	   DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    	   DocumentBuilder db = dbf.newDocumentBuilder();
    	   Document doc = db.parse(file);
    	   doc.getDocumentElement().normalize();
    	   System.out.println("Root element " + doc.getDocumentElement().getNodeName());

    	   NodeList nodeLst = doc.getElementsByTagName("Document");
    	   NodeList nodeLst_fields = doc.getElementsByTagName("Page");
    	   System.out.println(" node list fiels "+nodeLst_fields.getLength());

    	   for (int s = 0; s < nodeLst.getLength(); s++) {

    	     Node fstNode = nodeLst.item(s);

    	     if (fstNode.getNodeType() == Node.ELEMENT_NODE) {

    	       Element fstElmnt = (Element) fstNode;

    	       NodeList msgNameElmntLst = fstElmnt.getElementsByTagName("Identifier");
    	       Element msgNameElmnt = (Element) msgNameElmntLst.item(0); 
    	       NodeList msgName = msgNameElmnt.getChildNodes();
    	       System.out.println("Doc filed Identifier : "  + ((Node) msgName.item(0)).getNodeValue());

    	       NodeList trMode = fstElmnt.getElementsByTagName("Confidence");
    	       Element trModeElmnt = (Element) trMode.item(0);
    	       NodeList tr = trModeElmnt.getChildNodes();
    	       System.out.println("Doc confidence " + ((Node) tr.item(0)).getNodeValue());

    	 /***GET THE NAME OF FIELD NODE**/

    	        for (int i = 0; i < nodeLst_fields.getLength(); i++) {
System.out.println(nodeLst_fields.getLength());
    	         Node fstFieldNode = nodeLst_fields.item(i);

    	         if (fstFieldNode.getNodeType() == Node.ELEMENT_NODE) {

    	             Element fstFieldElmnt = (Element) fstFieldNode;

    	             NodeList fields = fstFieldElmnt.getElementsByTagName("Identifier");
    	             Element fieldNameElmnt = (Element) fields.item(0);
    	             NodeList field = fieldNameElmnt.getChildNodes();
    	             System.out.println("Page Identifier : " + ((Node) field.item(0)).getNodeValue());
    	         }

}
    	     }
    	   }
	}
}


