package com.javacodegeeks.jsfcomplisteners;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import java.util.List;import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.xml.xpath.XPathExpressionException;


@ManagedBean(name = "javaVersion", eager = true)
@SessionScoped

public class JavaVersion {

 private Double iva;
 private Double somma_iva_dettaglio;
 private String file;
 private List<String> lista_anomalie;
 public JavaVersion(){
	 
this.lista_anomalie = new ArrayList<String>();

	
	}
 public void setfile(String file) {
  this.file = file;
 }

 public String getfile() {
  return file;
 }
 public List<String> getLista_anomalie() {
        return lista_anomalie;
    }

    public void setLista_anomalie(List<String> lista_anomalie) {
        this.lista_anomalie = lista_anomalie;
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
  somma_iva_dettaglio= comm.return_somma_imponibili();  AnomalieQuadratura nuovo2 = new AnomalieQuadratura(this.file);

  try{
   nuovo2.verifica_quadratura_imponibile();
                nuovo2.verifica_quadratura_iva();
                nuovo2.verifica_quadratura_prezzo_unitario_prezzototale();
                lista_anomalie = nuovo2.return_lista_anomalie();
}
catch (XPathExpressionException ex) {
               
            }
               
 }

}
