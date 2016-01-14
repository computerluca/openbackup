import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.bean.*;
import javax.validation.constraints.*;
@ManagedBean(name = "tab")
@RequestScoped

public class DesignTab{
	
	public List<String> tabs;
	public DesignTab(){
		this.tabs = new ArrayList<String>(); 
		this.tabs.add("Ciao");
				
		this.tabs.add("Mao");
		this.tabs.add("Bao");


	}
	public List<String> gettabs(){
		return this.tabs;
		
	}
	public void settabs(List<String> tabs){
		this.tabs = tabs;
	}
	
	
	
	
	
	
	
}
