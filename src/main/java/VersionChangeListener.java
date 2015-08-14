package com.javacodegeeks.jsfcomplisteners;

import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

public class VersionChangeListener implements ValueChangeListener{

 public void processValueChange(ValueChangeEvent event)
  throws AbortProcessingException {
   JavaVersion javaVersion= (JavaVersion) FacesContext.getCurrentInstance().
    getExternalContext().getSessionMap().get("javaVersion");
   javaVersion.setSommaDettagli(event.getNewValue().toString());
 
 }
 

}
