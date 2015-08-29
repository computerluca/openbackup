

public class AC01_ANAGRAFICHE{
	
	public int id_anagrafica;
	public String partita_iva;
	public String codice_fiscale;
	public String denominazione;
	public String indirizzo;
	public String cap;
	public String comune;
	public String provincia;
	public String nazione;
	public int id_configurazione;
public AC01_ANAGRAFICHE (){
	
	
}
public AC01_ANAGRAFICHE(int id_anagrafica, String partita_iva, String codice_fiscale, String denominazione, String indirizzo, String cap, String comune, String provincia, String nazione, int id_configurazione) {
        this.id_anagrafica = id_anagrafica;
        this.partita_iva = partita_iva;
        this.codice_fiscale = codice_fiscale;
        this.denominazione = denominazione;
        this.indirizzo = indirizzo;
        this.cap = cap;
        this.comune = comune;
        this.provincia = provincia;
        this.nazione = nazione;
        this.id_configurazione = id_configurazione;
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
}
