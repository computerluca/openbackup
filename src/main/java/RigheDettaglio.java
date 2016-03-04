
import java.io.Serializable;
import java.math.BigDecimal;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
@ManagedBean(name="righedettaglio")
@SessionScoped
public class RigheDettaglio implements Serializable{

	private static final long serialVersionUID = 1L;
	public JavaVersion userData = (JavaVersion) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("javaVersion"); 
		public String file_xml;

	public Commerciale comm;
	NodeList righe_dettaglio;
	private List<Order>  orderList;
public void crea_dettagli_riepilogativi(){
	this.file_xml=this.userData.getfile();
			this.comm = new Commerciale(this.file_xml);
			this.righe_dettaglio=comm.return_lista_imponibili_riepilogo2();
		 	this.orderList = new ArrayList<Order>();
		 	for (int i = 0; i < righe_dettaglio.getLength(); i++) {
            Node nNode = righe_dettaglio.item(i);
            System.out.println("\n Current Element :"
                    + nNode.getNodeName());
                    int count =0;
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				count++;
                Element eElement = (Element) nNode;
                String nrlinea = "riga"+count;
                String descrizione = "dettaglio riepilogativo";
                Double prezzoUnitario;
                prezzoUnitario = Double.parseDouble(eElement.getElementsByTagName("ImponibileImporto").item(0).getTextContent().trim());
                Double quantita;
				quantita = 1.0;
                Double prezzo_totale = prezzoUnitario*quantita;
                Double aliquota = 0.00;
                aliquota = Double.parseDouble(eElement.getElementsByTagName("AliquotaIVA").item(0).getTextContent().trim());
                Double importo_iva = 0.00;
                importo_iva = Double.parseDouble(eElement.getElementsByTagName("Imposta").item(0).getTextContent().trim());
                Double totale = 0.00;
                totale = this.comm.round(prezzo_totale+importo_iva);
                		 	Order prova = new Order(nrlinea,descrizione,prezzoUnitario,quantita,prezzo_totale,aliquota,importo_iva,totale);
				
		 	this.orderList.add(prova);
	
	
}
}
}
	 public void inizializza(){
		 this.file_xml=this.userData.getfile();
			this.comm = new Commerciale(this.file_xml);
			this.righe_dettaglio=comm.get_righe_dettaglio();
		 	this.orderList = new ArrayList<Order>();
		 	for (int i = 0; i < righe_dettaglio.getLength(); i++) {
            Node nNode = righe_dettaglio.item(i);
            System.out.println("\n Current Element :"
                    + nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                String nrlinea = eElement.getElementsByTagName("NumeroLinea").item(0).getTextContent().trim();
                String descrizione = eElement.getElementsByTagName("Descrizione").item(0).getTextContent().trim();
                Double prezzoUnitario;
                prezzoUnitario = Double.parseDouble(eElement.getElementsByTagName("PrezzoUnitario").item(0).getTextContent().trim());
                Double quantita;
				quantita = Double.parseDouble(eElement.getElementsByTagName("Quantita").item(0).getTextContent().trim());
                Double prezzo_totale = Double.parseDouble(eElement.getElementsByTagName("PrezzoTotale").item(0).getTextContent().trim());
                Double aliquota = 0.00;
                aliquota = Double.parseDouble(eElement.getElementsByTagName("AliquotaIVA").item(0).getTextContent().trim());
                Double importo_iva = 0.00;
                importo_iva = this.comm.round((prezzo_totale*aliquota)/100);
                Double totale = 0.00;
                totale = this.comm.round(prezzo_totale+importo_iva);
                		 	Order prova = new Order(nrlinea,descrizione,prezzoUnitario,quantita,prezzo_totale,aliquota,importo_iva,totale);
				
		 	this.orderList.add(prova);

}
	
	
	
}
	
}
	    public void setorderList(List<Order> orderList) {
  this.orderList = orderList;
 }

 public List<Order> getorderList() {
  return orderList;
 }
 	 
	
		
	
	
	 public class Order{
		String orderNo;
		String productName;
		Double prezzo_unitario;
		Double quantita;
		Double prezzo_totale;
		Double aliquota_iva;
		Double importo_iva;
		Double totale;
		/*BigDecimal price;*/
		/*int qty;*/

		public Order(String orderNo, String productName, Double prezzo_unitario, Double quantita, Double prezzo_totale, Double aliquota_iva, Double importo_iva, Double totale) {
            this.orderNo = orderNo;
            this.productName = productName;
            this.prezzo_unitario = prezzo_unitario;
            this.quantita = quantita;
            this.prezzo_totale = prezzo_totale;
            this.aliquota_iva = aliquota_iva;
            this.importo_iva = importo_iva;
            this.totale = totale;
        }
		public Double getPrezzo_unitario() {
            return prezzo_unitario;
        }

        public void setPrezzo_unitario(Double prezzo_unitario) {
            this.prezzo_unitario = prezzo_unitario;
        }

        public Double getQuantita() {
            return quantita;
        }

        public void setQuantita(Double quantita) {
            this.quantita = quantita;
        }

        public Double getPrezzo_totale() {
            return prezzo_totale;
        }

        public void setPrezzo_totale(Double prezzo_totale) {
            this.prezzo_totale = prezzo_totale;
        }

        public Double getAliquota_iva() {
            return aliquota_iva;
        }

        public void setAliquota_iva(Double aliquota_iva) {
            this.aliquota_iva = aliquota_iva;
        }

        public Double getImporto_iva() {
            return importo_iva;
        }

        public void setImporto_iva(Double importo_iva) {
            this.importo_iva = importo_iva;
        }

        public Double getTotale() {
            return totale;
        }

        public void setTotale(Double totale) {
            this.totale = totale;
        }
		public Double getprezzo_unitario() {
			return prezzo_unitario;
		}
		public void setprezzo_unitario(Double prezzo_unitario) {
			this.prezzo_unitario = prezzo_unitario;
		}
		public String getOrderNo() {
			return orderNo;
		}
		public void setOrderNo(String orderNo) {
			this.orderNo = orderNo;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		/*public BigDecimal getPrice() {
			return price;
		}
		public void setPrice(BigDecimal price) {
			this.price = price;
		}
		public int getQty() {
			return qty;
		}
		public void setQty(int qty) {
			this.qty = qty;
		}*///getter and setter methods
	}
}
