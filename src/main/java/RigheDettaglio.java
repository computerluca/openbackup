
import java.io.Serializable;
import java.math.BigDecimal;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 
@ManagedBean(name="righedettaglio")
@SessionScoped
public class RigheDettaglioBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private static final Order[] orderList = new Order[] {
		
		new Order("A0001", "Intel CPU");
				
		new Order("A0002", "Harddisk 10TB"); 
				
		
	};
	 
	public Order[] getOrderList() {
 
		return orderList;
 
	}
	
	public static class Order{
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
