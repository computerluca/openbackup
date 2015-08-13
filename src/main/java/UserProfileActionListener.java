package com.javacodegeeks.jsfcomplisteners;

import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

public class UserProfileActionListener implements ActionListener {

 public void processAction(ActionEvent event)
  throws AbortProcessingException {
   UserProfile userProfile = (UserProfile) FacesContext
    .getCurrentInstance().getExternalContext().getSessionMap()
    .get("userProfile");
   userProfile.updateGreeting(event);
 }
}