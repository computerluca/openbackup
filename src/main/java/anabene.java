import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
 import java.util.*;
@ManagedBean
@SessionScoped
public class anamana implements Serializable {
 
	private static final long serialVersionUID = 1L;
	public AC02_BENI beni = new AC02_BENI_UTILITIES();
	public List lista_beni;
	public void anabeni(){
		inizializza();
	}
	 public List getlista_beni() {
        return lista_beni;
    }

    public void setlista_beni(List id_bene) {
        this.id_bene = id_bene;
    } 
	
	public void inizializza(){
		this.lista_beni=lista_beni.select_all_ac02_beni();
	}
	public String newana(){
		return "success";
	}
	
	public String configurazione(){
		return "success";
	}
}


