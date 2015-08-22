

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;import java.util.ArrayList;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;


@ManagedBean(name = "javaVersion")
@SessionScoped

public class JavaVersion {

 private Double iva;
 private String file;
 private List<String> lista_anomalie;
 private List<Double> lista_aliquote;
 private Double aliquota;
 private Double somma_iva_dettaglio;
 private Double somma_iva_riepilogo;
 private Double somma_dettaglio;
 private Double somma_imponibile_riepilogo;

 public JavaVersion(){
	 
this.lista_anomalie = new ArrayList<String>();
this.lista_aliquote = new ArrayList<Double>();
this.lista_aliquote.add(-1.0);
this.somma_dettaglio = 0.00;
this.somma_imponibile_riepilogo = 0.00;
this.somma_iva_dettaglio = 0.00;
this.somma_iva_riepilogo = 0.00;
this.file = "";

	
	}
 public  String getfile() {
		return file;
	}
	public void setfile(String file) {
		this.file = file;
	}

	 public Double getSomma_iva_dettaglio() {
        return somma_iva_dettaglio;
    }

    public void setSomma_iva_dettaglio(Double somma_iva_dettaglio) {
        this.somma_iva_dettaglio = somma_iva_dettaglio;
    }

    public Double getSomma_iva_riepilogo() {
        return somma_iva_riepilogo;
    }

    public void setSomma_iva_riepilogo(Double somma_iva_riepilogo) {
        this.somma_iva_riepilogo = somma_iva_riepilogo;
    }

    public Double getSomma_dettaglio() {
        return somma_dettaglio;
    }

    public void setSomma_dettaglio(Double somma_dettaglio) {
        this.somma_dettaglio = somma_dettaglio;
    }

    public Double getSomma_imponibile_riepilogo() {
        return somma_imponibile_riepilogo;
    }

    public void setSomma_imponibile_riepilogo(Double somma_imponibile_riepilogo) {
        this.somma_imponibile_riepilogo = somma_imponibile_riepilogo;
    }
	
	public List<Double> getlista_aliquote() {
        return lista_aliquote;
    }

    public void setLista_aliquote(List<Double> lista_aliquote) {
        this.lista_aliquote = lista_aliquote;
    }
    public void setAliquota(Double aliquota) {
  this.aliquota = aliquota;
 }

 public Double getAliquota() {
  return aliquota;
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
 public void aliquotacambiata(ValueChangeEvent event ) {
	         
  

  try{
	  if(Double.parseDouble(event.getNewValue().toString())==-1.0){
		  this.somma_dettaglio = 0.00;
	        this.somma_imponibile_riepilogo = 0.00;
	        this.somma_iva_dettaglio = 0.00;
	        this.somma_iva_riepilogo = 0.00;
	  }
	  else{
	  this.aliquota = Double.parseDouble(event.getNewValue().toString());
		Commerciale comm = new Commerciale(this.file);
  this.somma_imponibile_riepilogo= comm.round(comm.return_somma_imponibili_riepilogo_per_aliquota(Double.parseDouble(event.getNewValue().toString())));
  this.somma_dettaglio = comm.round(comm.return_somma_dett_per_aliquota(Double.parseDouble(event.getNewValue().toString())));
   this.somma_iva_dettaglio = comm.round(comm.return_somma_iva_dett_per_aliquota(Double.parseDouble(event.getNewValue().toString())));
   this.somma_iva_riepilogo = comm.round(comm.return_somma_iva_riepilogo_per_aliquota(Double.parseDouble(event.getNewValue().toString())));
   
                
           throw new XPathExpressionException("Errore nell'elaborazione del file xml");         
         
	  }   
                
}
catch (XPathExpressionException ex) {
	                                FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage("Stai visualizzando il riepilogo per aliquota"+this.aliquota.toString()));
            }
               
 }
 public void ivacambiata(ValueChangeEvent event) {
	         
  

  try{
	  if((event.getNewValue().toString()) != ""){
	  this.file= (event.getNewValue().toString());
		Commerciale comm = new Commerciale(this.file);
  somma_iva_dettaglio= comm.return_somma_imponibili();
	    AnomalieQuadratura nuovo2 = new AnomalieQuadratura(event.getNewValue().toString());

   nuovo2.verifica_quadratura_imponibile();
                nuovo2.verifica_quadratura_iva();
                nuovo2.verifica_quadratura_prezzo_unitario_prezzototale();
                this.lista_anomalie = nuovo2.return_lista_anomalie();
                this.lista_aliquote = comm.return_lista_aliquote();
                
           	RigheDettaglio userData = (RigheDettaglio) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("righedettaglio"); 
            userData.inizializza();
                
     }           
}
catch (XPathExpressionException ex) {
               
            }
               
 }
	public void resetta(){
	this.somma_iva_dettaglio = 0.00;
	this.somma_iva_riepilogo = 0.00;
	this.lista_aliquote.clear();
	this.lista_anomalie.clear();
	this.file = "";
	this.lista_aliquote.add(-1.0);
        this.somma_dettaglio = 0.00;
        this.somma_imponibile_riepilogo = 0.00;
        this.somma_iva_dettaglio = 0.00;
        this.somma_iva_riepilogo = 0.00;
	 
 
	 

	 
 }
 public void format(){
	 try{
	 FormatXML formatter = new
    
    
    
    
     FormatXML();
	  String book =  this.file.toString();
	  
     String ciao = formatter.format(book);
     this.file = ciao;  
	 
}
catch(IOException e){
	
	
}

}

}
