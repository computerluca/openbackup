import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
 import java.util.*;
 import java.io.Serializable;
@ManagedBean
@RequestScoped
public class anaiva implements Serializable {
 	private static final long serialVersionUID = 1L;

	public AC03_CODICI_IVA_UTILITIES ive = new AC03_CODICI_IVA_UTILITIES();
	public List lista_ive;
	public anaiva(){
		inizializza();
	}
	 public List getlista_ive() {
        return lista_ive;
    }

    public void setlista_ive(List id_codice_iva) {
        this.lista_ive = id_codice_iva;
    } 
	
	public void inizializza(){
		this.lista_ive=ive.select_all_ac03_codici_iva();
	}
	public String newiva(){
		return "dd";
	}
	
	
}


