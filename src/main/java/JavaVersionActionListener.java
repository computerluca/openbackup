import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

public class JavaVersionActionListener implements ActionListener{
	public String buttonId; 
         @Override
	 public void processAction(ActionEvent arg0) 
   throws AbortProcessingException {
      //access userData bean directly
      JavaVersion userData = (JavaVersion) FacesContext.getCurrentInstance().
         getExternalContext().getSessionMap().get("javaVersion"); 
         		buttonId = event.getComponent().getClientId().toString();
			if(buttonId=="reset"){
				userData.resetta();
			}
			if(buttonId=="format"){
				userData.format();
			}
   }
   
	
}
