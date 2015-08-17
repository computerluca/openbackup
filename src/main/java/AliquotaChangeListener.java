import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

public class AliquotaChangeListener implements ValueChangeListener{

 public void processValueChange(ValueChangeEvent event)
  throws AbortProcessingException {
   javaVersion javaVersion= (JavaVersion) FacesContext.getCurrentInstance().
    getExternalContext().getSessionMap().get("javaVersion");
   javaVersion.setfile(Double.parseDouble(event.getNewValue()));
 
 }
 

}

