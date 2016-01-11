import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 import java.util.*;
@ManagedBean
@SessionScoped
public class anabene implements Serializable {
 	private static final long serialVersionUID = 1L;

	public AC02_BENI_UTILITIES beni = new AC02_BENI_UTILITIES();
	public List lista_beni;
	public void anabeni(){
		inizializza();
	}
	 public List getlista_beni() {
        return lista_beni;
    }

    public void setlista_beni(List id_bene) {
        this.lista_beni = id_bene;
    } 
	
	public void inizializza(){
		this.lista_beni=beni.select_all_ac02_beni();
	}
	public String newbene(){
		return "dd";
	}
	
	
}


