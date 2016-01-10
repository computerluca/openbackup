

public class AC02_BENI{
	
	public int id_bene;
	public String codice_bene;
	public String descrizione;
	
		public AC02_BENI (){
	
	
		}
		
	public AC01_ANAGRAFICHE(int id_bene, String codice_bene, String descrizione) {
        this.id_bene = id_bene;
        this.codice_bene = codice_bene;
        this.descrizione = descrizione;
        
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

   
}

