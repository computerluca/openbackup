
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;
@ManagedBean(name = "configurazione")

@RequestScoped
public class Configurazione {
	public int id_anagrafica;
	 @Size(min = 11, max=11, message = "Il campo deve essere di 11 caratteri")
	public String partita_iva;
	public String codice_fiscale;
	public String denominazione;
	public String indirizzo;
	public String cap;
	public String comune;
	public String provincia;
	public String nazione;
	public int id_configurazione;
	public String titolo;
	public String requiredMessage;
				public SaveManager sm;

	public Configurazione(){
		sm = new SaveManager();
			List<AC01_ANAGRAFICHE> cars = new ArrayList<AC01_ANAGRAFICHE>();
			cars.addAll(AC01_ANAGRAFICHE_UTILITIES.select_all_ac01_anagrafiche_tipo_principale());
			if(cars.size()==1){
			for (AC01_ANAGRAFICHE car:cars){
				this.codice_fiscale = car.getCodice_fiscale();
				this.partita_iva = car.getPartita_iva();
				this.denominazione = car.getDenominazione();
				this.indirizzo = car.getIndirizzo();
				this.cap = car.getCap();
				this.comune = car.getComune();
				this.provincia = car.getProvincia();
				this.nazione = car.getNazione();
				this.titolo = "Configurazione -> Modifica";
				this.requiredMessage ="Campo non definito";
			}
		}
		else{
			this.titolo = "Configurazione -> Nuovo";
		}	
	}
	public void annulla(){
		
	}
	public void salva(){
		this.sm.Salva();
	}
    public int getId_anagrafica() {
        return id_anagrafica;
    }

    public void setId_anagrafica(int id_anagrafica) {
        this.id_anagrafica = id_anagrafica;
    }

    public String getPartita_iva() {
        return partita_iva;
    }

    public void setPartita_iva(String partita_iva) {
        this.partita_iva = partita_iva;
    }
    public String getrequiredMessage() {
        return requiredMessage;
    }

    public void setrequiredMessage(String requiredMessage) {
        this.requiredMessage = requiredMessage;
    }
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getCodice_fiscale() {
        return codice_fiscale;
    }

    public void setCodice_fiscale(String codice_fiscale) {
        this.codice_fiscale = codice_fiscale;
    }

    public String getDenominazione() {
        return denominazione;
    }

    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getComune() {
        return comune;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getNazione() {
        return nazione;
    }

    public void setNazione(String nazione) {
        this.nazione = nazione;
    }

    public int getId_configurazione() {
        return id_configurazione;
    }

    public void setId_configurazione(int id_configurazione) {
        this.id_configurazione = id_configurazione;
    }
    public void valueChangeMethod(ValueChangeEvent e){
		
 String componentId = e.getComponent().getClientId();
 String[] parts = componentId.split(":");
        System.out.println(parts[parts.length-1]);
        	String campo = parts[parts.length-1].toString();
        	String valore = e.getNewValue().toString();
        	this.sm.aggiungi_campo(campo,valore);
        	}
}


