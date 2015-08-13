package com.javacodegeeks.jsfcomplisteners;

import java.util.Calendar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "userProfile", eager = true)
@SessionScoped
public class UserProfile {

 private String label = "Click here for Today's Greeting ";
 private String greeting = "Hello, have a nice";

 public String getGreeting() {
  return greeting;
 }

 public String getLabel() {
 return label;
 }

 public void setLabel(String label) {
  this.label = label;
 }

 public void setGreeting(String greeting) {
  this.greeting = greeting;
 }

 public void updateGreeting(ActionEvent event) {
  greeting = greeting + " "
    + getDayUtil(Calendar.getInstance().get(Calendar.DAY_OF_WEEK))
    + "!!";
 }

 private String getDayUtil(int day) {
   String dayOfWeek = "Sunday";
   switch (day) {
    case 1:
     dayOfWeek = "Sunday";
     break;
    case 2:
     dayOfWeek = "Monday";
     break;
    case 3:
     dayOfWeek = "Tuesday";
     break;
    case 4:
     dayOfWeek = "Wednesday";
     break;
    case 5:
     dayOfWeek = "Thursday";
     break;
    case 6:
     dayOfWeek = "Friday";
     break;
    case 7:
     dayOfWeek = "Saturday";
     break;
  }
  return dayOfWeek;
 }

}