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

public class BatchXMLtoCSVWorkingTesting {
	

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		System.out.println("reading of xml started");
		
		File file = new File("E:/XML File/Batch.xml");
   		
		   File csvfile = new File( "E:/XML File/Batcheeeee.csv");  
  	      //  if ( !csvfile.exists() )
  	        //	csvfile.createNewFile();
  	       
  	       Writer csvOutput = new FileWriter(csvfile );
  	    	
  	     csvOutput.append("\n");
  	   csvOutput.append("\n");
         	  
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
			 Node fstNode = labTestList.item(i);

    	     if (fstNode.getNodeType() == Node.ELEMENT_NODE) {

    	       Element fstElmnt = (Element) fstNode;

    	       NodeList msgNameElmntLst = fstElmnt.getElementsByTagName("Identifier");
    	       Element msgNameElmnt = (Element) msgNameElmntLst.item(0); 
    	       NodeList msgName = msgNameElmnt.getChildNodes();
    	       System.out.println("Doc filed Identifier : "  + ((Node) msgName.item(0)).getNodeValue());
    	       csvOutput.append("Doc Identifier "+((Node) msgName.item(0)).getNodeValue());
    	       csvOutput.append(",");

    	       NodeList trMode = fstElmnt.getElementsByTagName("Confidence");
    	       Element trModeElmnt = (Element) trMode.item(0);
    	       NodeList tr = trModeElmnt.getChildNodes();
    	       System.out.println("Doc confidence " + ((Node) tr.item(0)).getNodeValue());
    	       csvOutput.append("Doc Confidence"+((Node) tr.item(0)).getNodeValue());
    	       csvOutput.append(",");

		    NodeList valueList = fstElmnt.getElementsByTagName("Page");
		    for (int j = 0; j < valueList.getLength(); ++j)
		    {
		    	Node CfstNode = valueList.item(j);
		    	 Element CfstElmnt = (Element) CfstNode;

	    	       NodeList CmsgNameElmntLst = CfstElmnt.getElementsByTagName("Identifier");
	    	       Element CmsgNameElmnt = (Element) CmsgNameElmntLst.item(0); 
	    	       NodeList CmsgName = CmsgNameElmnt.getChildNodes();
	    	       System.out.println("Page filed Identifier : "  + ((Node) CmsgName.item(0)).getNodeValue());
	    	       csvOutput.append("page Identifier "+((Node) CmsgName.item(0)).getNodeValue());
	    	       csvOutput.append(",");
	    	  
		       
		        NodeList conditionList = CfstElmnt.getElementsByTagName("PageLevelField");
		        for (int k = 0; k < conditionList.getLength(); ++k)
		        {
		           
		            Node PfstNode = conditionList.item(k);
			    	 Element PfstElmnt = (Element) PfstNode;

		    	       NodeList PmsgNameElmntLst = PfstElmnt.getElementsByTagName("Confidence");
		    	       Element PmsgNameElmnt = (Element) PmsgNameElmntLst.item(0); 
		    	       NodeList PmsgName = PmsgNameElmnt.getChildNodes();
		    	       System.out.println("Page filed Identifier : "  + ((Node) PmsgName.item(0)).getNodeValue());
		    	       csvOutput.append("page Confidence "+((Node) PmsgName.item(0)).getNodeValue());
		    	       csvOutput.append(",");

		        }
		       
		    }
		}
		
    	     csvOutput.append("\n");
    	    
	}
	csvOutput.close();
	}
	
}


