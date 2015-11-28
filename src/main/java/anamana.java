import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
 import java.util.*;
@ManagedBean
@SessionScoped
public class anamana implements Serializable {
 
	private static final long serialVersionUID = 1L;
	public AC01_ANAGRAFICHE_UTILITIES lista_anagrafiche = new AC01_ANAGRAFICHE_UTILITIES();
	public List lista_anagrafiche_lista;
	public anamana(){
		inizializza();
	}
	 public List getlista_anagrafiche_lista() {
        return lista_anagrafiche_lista;
    }

    public void setlista_anagrafiche_lista(List id_anagrafica) {
        this.lista_anagrafiche_lista = id_anagrafica;
    } 
	
	public void inizializza(){
		this.lista_anagrafiche_lista=lista_anagrafiche.select_all_ac01_anagrafiche();
	}
	public String newana(){
		return "success";
	}
	
	public String configurazione(){
		return "success";
	}
}

