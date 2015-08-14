package com.javacodegeeks.jsfcomplisteners;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import java.io.IOException;
import org.xml.sax.SAXException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;
import javax.xml.xpath.XPathExpressionException;

public class Commerciale{
	public DocumentBuilderFactory builderFactory;
	public DocumentBuilder builder;
	public String file;
	public Document xmlDocument;
	public XPath xPath;
 public Commerciale (String file_xml){
	this.builderFactory = DocumentBuilderFactory.newInstance();
	this.builder = null;
try {
    this.builder = builderFactory.newDocumentBuilder();
} catch (ParserConfigurationException e) {
    e.printStackTrace();  
}
	this.file=file_xml;
	try {
    this.xmlDocument = this.builder.parse(new ByteArrayInputStream(this.file.getBytes()));
} catch (SAXException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}
this.xPath = XPathFactory.newInstance().newXPath();
}
public Double somma_iva_dettagli(){
 
        String prezzo_totale = null;
        Double prezzo_tot = 0.00;

        String expression2 = "sum(FatturaElettronica/FatturaElettronicaBody/DatiBeniServizi/DettaglioLinee/PrezzoTotale)";
        try {
            prezzo_totale = this.xPath.compile(expression2).evaluate(this.xmlDocument);

        } 
        catch (XPathExpressionException ex) {
        }

        prezzo_tot = Double.parseDouble(prezzo_totale);

        return prezzo_tot;
}

}
