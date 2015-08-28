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

public class ReadingBatchXML {
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
	NodeList nodelist = doc.getElementsByTagName("Document");
	System.out.println("Document information");
	for (int i = 0; i < nodelist.getLength(); i++) {
		Node node = nodelist.item(i);
		if (node.getNodeType()==node.ELEMENT_NODE) {
			Element nodeelement = (Element) node;
			NodeList nodeelementfist = nodeelement.getElementsByTagName("Identifier");
		
			Element firstnum = (Element) nodeelementfist.item(0);
			NodeList nodenum = firstnum.getChildNodes();
			System.out.println("firstname  " +nodenum.item(0).getNodeValue());
			
	//		csvOutput.write("firstname  " +nodenum.item(0).getNodeValue());
			csvOutput.append(nodenum.item(0).getNodeValue());
			csvOutput.append(",");
			
			NodeList nodelastelement = nodeelement.getElementsByTagName("Confidence");
			
			Element lastnum = (Element) nodelastelement.item(0);
			NodeList lastnodenum = lastnum.getChildNodes();
			System.out.println("lastname    " +lastnodenum.item(0).getNodeValue());
			
		//	csvOutput.write("lastname   " +lastnodenum.item(0).getNodeValue());
			csvOutput.append(lastnodenum.item(0).getNodeValue());
			csvOutput.append("\n");
	//		fwrter.append(lastnodenum.item(0).getNodeValue());
			
			
		//	System.out.println(nodeelementfist+"@@@@@@@@@@    "+nodelastelement);
		}
		
	}
	csvOutput.close();
	//fwrter.close();
	}

}
