package com.javacodegeeks.jsfcomplisteners;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

@ManagedBean(name = "javaVersion", eager = true)
@SessionScoped

public class JavaVersion {

 private Double iva;
 private Double somma_iva_dettagli;
 private String file;
 public void setfile(String file) {
  this.file = file;
 }

 public String getfile() {
  return file;
 }
  public void setiva(Double iva) {
  this.iva = iva;
 }

 public Double getiva() {
  return iva;
 }
 
 public void setsomma_iva_dettagli(Double sid) {
  this.somma_iva_dettagli = 10.0;
 }

 public Double getsomma_iva_dettagli() {
  return somma_iva_dettagli;
 }
 public void ivacambiata(ValueChangeEvent event) {
  iva = Double.parseDouble(event.getNewValue().toString());
  Commerciale comm = new Commerciale(this.file);
  somma_iva_dettagli= comm.somma_iva_dettagli();
 }

}
