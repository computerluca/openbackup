package com.javacodegeeks.jsfcomplisteners;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import java.util.List;import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ManagedBean(name = "javaVersion", eager = true)
@SessionScoped

public class JavaVersion {

 private Double iva;
 private Double somma_iva_dettaglio;
 private String file;
 public List<String> lista_anomalie;
 public JavaVersion(){
	 
this.lista_anomalie = new ArrayList<String>();

	 this.lista_anomalie.add("Prima anomalia");
	 this.lista_anomalie.add("Seconda anomalia");
	}
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
 
 public void setsomma_iva_dettaglio(Double sid) {
  this.somma_iva_dettaglio = 10.0;
 }

 public Double getsomma_iva_dettaglio() {
  return somma_iva_dettaglio;
 }
 public void ivacambiata(ValueChangeEvent event) {
	         
  this.file = event.getNewValue().toString();
  Commerciale comm = new Commerciale(this.file);
  somma_iva_dettaglio= comm.return_somma_imponibili();
 }

}
