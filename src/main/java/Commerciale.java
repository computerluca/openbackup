package com.javacodegeeks.jsfcomplisteners;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import java.io.IOException;
import org.xml.sax.SAXException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
public class Commerciale{
	public DocumentBuilderFactory builderFactory;
	public DocumentBuilder builder;
	public String file;
	public Document xmlDocument;
	public XPath xPath;
 public Commerciale (String file_xml){
	builderFactory = DocumentBuilderFactory.newInstance();
	builder = null;
try {
    builder = builderFactory.newDocumentBuilder();
} catch (ParserConfigurationException e) {
    e.printStackTrace();  
}
	this.file=file_xml;
	try {
    xmlDocument = builder.parse(new ByteArrayInputStream(file.getBytes()));
} catch (SAXException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}
xpath = XPathFactory.newInstance().newXPath();
}
public Double somma_iva_dettagli(){
 
        String prezzo_totale = null;
        Double prezzo_tot = 0.00;

        String expression2 = "sum(FatturaElettronica/FatturaElettronicaBody/DatiBeniServizi/DettaglioLinee/PrezzoTotale)";
        try {
            prezzo_totale = xpath.compile(expression2).evaluate(this.xmlDocument);

        } 
        catch (XPathExpressionException ex) {
        }

        prezzo_tot = Double.parseDouble(prezzo_totale);

        return prezzo_tot;
}
public Double somma_iva_riepilogo(){
	
}
}
