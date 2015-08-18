import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

public class JavaVersionActionListener implements ActionListener{

	@Override
	public void processAction(ActionEvent event)
		throws AbortProcessingException {
		
		JavaVersion jv = new JavaVersion();
		jv.resetta();
	
	}
	
}
