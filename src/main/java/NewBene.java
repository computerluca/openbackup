
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.bean.*;
import javax.validation.constraints.*;
@ManagedBean(name = "newbene")

@RequestScoped
public class NewBene {
	public int id_bene;
	public String codice_bene;
	public String descrizione;

	public SaveManager sm;

	public NewBene(){
		sm = new SaveManager();
			this.titolo = "Bene/Servizio -> Creazione";
			
			
	}
	public void annulla(){
		
				this.id_bene = " ";
				this.codice_bene = " ";
				this.descrizione = " ";
				
		

	
}
	public void salva(){
		this.sm.Salva2();
	}
    public int getId_bene() {
        return id_bene;
    }

    public void setId_bene(int id_bene) {
        this.id_bene = id_bene;
    }

    public String getcodice_bene() {
        return codice_bene;
    }

    public void setcodice_bene(String codice_bene) {
        this.codice_bene = codice_bene;
    }
   
    public String getdescrizione() {
        return descrizione;
    }

    public void setdescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    
    public synchronized void valueChangeMethod(ValueChangeEvent e){
		
 String componentId = e.getComponent().getClientId();
 String[] parts = componentId.split(":");
        System.out.println(parts[parts.length-1]);
        	String campo = parts[parts.length-1].toString();
        	String valore = e.getNewValue().toString();
        	this.sm.aggiungi_campo(campo,valore);
        	}
}


