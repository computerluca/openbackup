import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
 
@ManagedBean
@SessionScoped
public class anamana implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	public String newana(){
		return "success";
	}
	
	public String configurazione(){
		return "success";
	}
}

