
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

public class VersionChangeListener implements ValueChangeListener{

 public JavaVersion javaVersion = new JavaVersion();

public void processValueChange(ValueChangeEvent event)
  throws AbortProcessingException {
   javaVersion = ((JavaVersion) FacesContext.getCurrentInstance().
    getExternalContext().getSessionMap().get("javaVersion"));
   javaVersion.setfile((event.getNewValue().toString()));
 
 }


 

}
