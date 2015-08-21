import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
 
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
 
@ManagedBean(name = "upload")
@SessionScoped
public class Upload {
 
    public void handleFileUpload(FileUploadEvent event) {
         FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage("Stai visualizzando il riepilogo per aliquota"));
    }
}
