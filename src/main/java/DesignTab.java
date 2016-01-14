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
	
	public List<Tab> tabs;
	public DesignTab(){
		this.tabs = new ArrayList<Tab>(); 
		this.tabs.add(new Tab("dddd","222"));
		this.tabs.add(new Tab("dddddd","22ddd2"));



	}
	public List<Tab> gettabs(){
		return this.tabs;
		
	}
	public void settabs(List<Tab> tabs){
		this.tabs = tabs;
	}
	
	
	
	
	
	
	
}
