import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
 import java.util.*;
 import java.io.Serializable;
@ManagedBean
@RequestScoped
public class anacoge implements Serializable {
 	private static final long serialVersionUID = 1L;

	public C002_PDC_COGE_UTILITIES coge = new CO02_PDC_COGE_UTILITIES();
	public List lista_coge;
	public anaiva(){
		inizializza();
	}
	 public List getlista_coge() {
        return lista_coge;
    }

    public void setlista_coge(List lista_coge) {
        this.lista_coge = lista_coge;
    } 
	
	public void inizializza(){
		this.lista_coge=lista_coge.getall();
	}

	
	
}



