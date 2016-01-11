
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.bean.*;
import javax.validation.constraints.*;
@ManagedBean(name = "newiva")

@RequestScoped
public class NewIva extends AC03_CODICI_IVA{
	

	public SaveManager sm;
	public titolo;

	public NewIva(){
		super();
		sm = new SaveManager();
			this.titolo = "Codice IVA -> Creazione";
			
			
	}
	public void annulla(){
		
				this.descrizione = " ";
				this.aliquota = 0.00;
				
		

	
}
	public void salva(){
		this.sm.Salva4();
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



