import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

public class CRDActionListener implements ActionListener{
 
    /**
     *
     */
    private String buttonId; 
         @Override
	 public void processAction(ActionEvent event) 
   throws AbortProcessingException {
      //access userData bean directly
      RigheDettaglio userData = (RigheDettaglio) FacesContext.getCurrentInstance().
         getExternalContext().getSessionMap().get("righedettaglio"); 
userData.crea_dettagli_riepilogativi();
   
	
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


