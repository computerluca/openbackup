

public class AC03_CODICI_IVA{
	
	public int id_codice_iva;
	public String codice_iva;
	public Double aliquota;
	public String descrizione;
	
		AC03_CODICI_IVA (){
	
	
		}
		
	 AC03_CODICI_IVA(int id_codice_iva, String codice_iva, Double aliquota, String descrizione) {
        this.id_codice_iva = id_codice_iva;
        this.codice_iva = codice_iva;
        this.aliquota = aliquota;
        this.descrizione = descrizione;
        
    }

    public int getId_codice_iva() {
        return id_codice_iva;
    }

    public void setId_codice_iva(int id_codice_iva) {
        this.id_codice_iva = id_codice_iva;
    }

    public String getcodice_iva() {
        return codice_iva;
    }

    public void setcodice_iva(String codice_iva) {
		this.codice_iva = codice_iva;
    }

    public String getdescrizione() {
        return descrizione;
    }

    public void setdescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    public Double getaliquota(){
		return aliquota;
	}
	public void setaliquota(Double aliquota){
		this.aliquota = aliquota;
	}

   
}

