
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
				

	public assanacoge(){
			this.list_ana = new ArrayList<AC01_ANAGRAFICHE>();
			this.list_coge = new ArrayList<C002_PDC_COGE>();
			valorizza_liste();
	}
	public void valorizza_liste(){
		AC01_ANAGRAFICHE_UTILITIES anautil = new AC01_ANAGRAFICHE_UTILITIES();
		C002_PDC_COGE_UTILITIES cogeutil = new C002_PDC_COGE_UTILITIES();
		this.list_ana = anautil.select_all_ac01_anagrafiche();
		this.list_coge = cogeutil.get_all();
		for(int i=0;i<this.list_coge.size();i++){
			System.out.println(this.list_coge.getdenominazione());
		}
	
	}
	public void annulla(){
		
				
		

	
}
	public void salva(){

	}
   
}



