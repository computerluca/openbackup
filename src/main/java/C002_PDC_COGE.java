
public class C002_PDC_COGE {
	public int id_voce_coge;
	public String cd_voce_coge;
	public String denominazione;
	
	
	C002_PDC_COGE (){
	
	
		}
		
		 C002_PDC_COGE( int id_voce_coge, String cd_voce_coge, String denominazione) {
        this.id_voce_coge = id_voce_coge;
        this.cd_voce_coge = cd_voce_coge;
        this.denominazione = denominazione;
        
    }

    public int getid_voce_coge() {
        return id_voce_coge;
    }

    public void setid_voce_coge(int id_voce_coge) {
        this.id_voce_coge = id_voce_coge;
    }

    public String getcd_voce_coge() {
        return cd_voce_coge;
    }

    public void setcd_voce_coge(String cd_voce_coge) {
		this.cd_voce_coge = cd_voce_coge;
    }

    public String getdenominazione() {
        return denominazione;
    }

    public void setdenominazione(String denominazione) {
        this.denominazione = denominazione;
    }
    
	
	
	
	
	
	
	
	
	
	
}
