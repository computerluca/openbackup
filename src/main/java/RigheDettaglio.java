
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
	NodeList righe_dettaglio = comm.get_righe_dettaglio();
	public List<Order>  orderList;


	 public RigheDettaglio(){
			this.file_xml=userData.getfile();
			this.comm = new Commerciale(this.file_xml);
		 	Order prova = new Order("dkjdl","sdlkjd");
		 	this.orderList.add(prova);
				
		
	};
		 
	
		
	
	
	 public class Order{
		String orderNo;
		String productName;
		/*BigDecimal price;*/
		/*int qty;*/

		public Order(String orderNo, String productName)
                                /*BigDecimal price, int qty*/ {

			this.orderNo = orderNo;
			this.productName = productName;
			/*this.price = price;
			this.qty = qty;*/
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
