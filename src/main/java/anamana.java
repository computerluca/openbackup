import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
 
@ManagedBean
@SessionScoped
public class anamana implements Serializable {
 
	private static final long serialVersionUID = 1L;
	public AC01_ANAGRAFICHE_UTILITIES lista_anagrafiche = new AC01_ANAGRAFICHE_UTILITIES();
	public List lista_anagrafiche_lista;
	public List inizializza(){
		this.lista_anagrafiche_lista=lista_anagrafiche.select_all_ac01_anagrafiche();
	}
	public String newana(){
		return "success";
	}
	
	public String configurazione(){
		return "success";
	}
}

