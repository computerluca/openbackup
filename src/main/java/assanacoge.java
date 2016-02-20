
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.bean.*;
import javax.validation.constraints.*;
@ManagedBean(name = "assanacoge")

@RequestScoped
public class assanacoge {
	public List<AC01_ANAGRAFICHE> list_ana;
	public List<C002_PDC_COGE> list_coge;
		public int scelta_coge;
		public int scelta_ana;
				public String ds_scelta_ana;
		public String ds_scelta_coge;
		public List<AC01_ANAGRAFICHE> risultati_ricerca;

public void cercacoge(){
	
}
public void cercaana(){
			AC01_ANAGRAFICHE_UTILITIES anautil = new AC01_ANAGRAFICHE_UTILITIES();
			this.risultati_ricerca = new ArrayList<AC01_ANAGRAFICHE>();
			this.risultati_ricerca = anautil.cercaana(this.scelta_ana);
	        
}
	public assanacoge(){
			this.list_ana = new ArrayList<AC01_ANAGRAFICHE>();
			this.list_coge = new ArrayList<C002_PDC_COGE>();
			valorizza_liste();
	}
	 public List<AC01_ANAGRAFICHE> getrisultati_ricerca() {
        return risultati_ricerca;
    }
	 public void setrisultati_ricerca(List<AC01_ANAGRAFICHE> risultati_ricerca) {
		this.risultati_ricerca = risultati_ricerca;
    }
	 public String getds_scelta_ana() {
        return ds_scelta_ana;
    }
	 public void setds_scelta_ana(String ds_scelta_ana) {
		this.ds_scelta_ana = ds_scelta_ana;
    }
    public String getds_scelta_coge() {
        return ds_scelta_coge;
    }
	 public void setds_scelta_coge(String ds_scelta_coge) {
		this.ds_scelta_coge = ds_scelta_coge;
    }
	  public int getscelta_coge() {
        return scelta_coge;
    }
	 public void setscelta_coge(int scelta_coge) {
		this.scelta_coge = scelta_coge;
    }
     public int getscelta_ana() {
        return scelta_ana;
    }
	 public void setscelta_ana(int scelta_ana) {
		this.scelta_ana = scelta_ana;
    }

	public void valorizza_liste(){
		AC01_ANAGRAFICHE_UTILITIES anautil = new AC01_ANAGRAFICHE_UTILITIES();
		C002_PDC_COGE_UTILITIES cogeutil = new C002_PDC_COGE_UTILITIES();
		this.list_ana = anautil.select_all_ac01_anagrafiche();
		this.list_coge = cogeutil.get_all();
		
	
	}
   
}



