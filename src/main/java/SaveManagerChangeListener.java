import javax.faces.context.FacesContext;

import javax.faces.event.AbortProcessingException;

import javax.faces.event.ValueChangeEvent;

import javax.faces.event.ValueChangeListener; 

/**

*

* @author vinod

*/

public class SaveManagerChangeListener implements ValueChangeListener { 

    @Override

    public void processValueChange(ValueChangeEvent event) throws AbortProcessingException {


        String componentId = event.getComponent().getClientId();
        System.out.println(componentId);


    }

}
