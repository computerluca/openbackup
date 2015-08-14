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

 public void setiva(Double iva) {
  JavaVersion.iva = iva;
 }

 public Double getiva() {
  return iva;
 }
 public void setsomma_iva_dettagli(Double sid) {
  JavaVersion.somma_iva_dettagli = 10.0;
 }

 public Double getsomma_iva_dettagli() {
  return somma_iva_dettagli;
 }
 public void ivacambiata(ValueChangeEvent event) {
  iva = event.getNewValue().toString();
 }

}
