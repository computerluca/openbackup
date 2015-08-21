import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

public class ResetActionListener implements ActionListener{
 
    /**
     *
     */
    private String buttonId; 
         @Override
	 public void processAction(ActionEvent event) 
   throws AbortProcessingException {
      //access userData bean directly
      JavaVersion userData = (JavaVersion) FacesContext.getCurrentInstance().
         getExternalContext().getSessionMap().get("javaVersion"); 
userData.format();
   
	
}

    /**
     * @return the buttonId
     */
    public String getButtonId() {
        return buttonId;
    }

    /**
     * @param buttonId the buttonId to set
     */
    public void setButtonId(String buttonId) {
        this.buttonId = buttonId;
    }
         
}

