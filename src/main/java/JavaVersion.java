
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;import java.util.ArrayList;
import java.util.*;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*; 
import org.w3c.dom.*;

@ManagedBean(name = "javaVersion")
@SessionScoped

public class JavaVersion implements Serializable{
 
 private Double iva;
 private String file;
 private List<String> lista_anomalie;
 private List<Double> lista_aliquote;
 private Double aliquota;
 private Double somma_iva_dettaglio;
 private Double somma_iva_riepilogo;
 private Double somma_dettaglio;
 private Double somma_imponibile_riepilogo;
 private String tipo_dg;
 private String esigibilita_iva;
 private String numero_documento;
 private String data_documento;
 private String descrizione;
 public List<User> lista_somme= new ArrayList<User>();

 public  class User
{
    public Double Aliquota;
    
public String giorno;
    public Double somma;

    public User(Double Aliquota, String giorno, Double somma) {
        this.Aliquota = Aliquota;
        this.giorno = giorno;
        this.somma = somma;
    }

    public Double getAliquota() {
        return Aliquota;
    }

    public void setAliquota(Double Aliquota) {
        this.Aliquota = Aliquota;
    }

    public String getGiorno() {
        return giorno;
    }

    public void setGiorno(String giorno) {
        this.giorno = giorno;
    }

    public Double getSomma() {
        return somma;
    }

    public void setSomma(Double somma) {
        this.somma = somma;
    }
    

    
} 

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
	public String calcola_esigibilita_iva(){
		
		Commerciale comm = new Commerciale(this.file);
		List<String> nl = comm.return_lista_imponibili_riepilogo();
		String esigibilita=null;
		System.out.println("ciao");
		int count = 0;
		int count2 = 0;
		for (String es: nl) {
				if(es.equals("I")){
				count ++;
				}
				if(es.equals("S")){
					count2++;
				}
            
            }
            if(count==0 && count2 >0){
				System.out.println("La fattura è split payment");
				esigibilita="Split Payment";
				
			}
			if(count>0 && count2 >0){
				System.out.println("La fattura presenta sia dettagli split che non split payment");
				esigibilita="Sia split payment che non split payment";
			}
			if(count>0 && count2 == 0){
				System.out.println("La fattura non è soggetta a split payment");
				esigibilita="Non soggetta a Split Payment";
				
			}
			return esigibilita;
		
	}
 public  String calcola_tipo_dg(){
		Commerciale comm = new Commerciale(this.file);	
		String tipo_dg=null;
		calcola_esigibilita_iva();
			tipo_dg = comm.return_tipo_dg();
			if (tipo_dg.equals("TD04")){
				tipo_dg = "Nota Credito Acquisto";
			}
			if (tipo_dg.equals("TD01")){
				if(comm.return_somma_iva_riepilogo() >0 && comm.return_somma_imponibili_riepilogo() >0){
					tipo_dg = "Fattura Acquisto";
				}
				if(comm.return_somma_iva_riepilogo() <0 && comm.return_somma_imponibili_riepilogo() ==0){
					tipo_dg = "Nota Credito Acquisto";
				}
				if(comm.return_somma_iva_riepilogo() ==0 && comm.return_somma_imponibili_riepilogo() <0){
					tipo_dg = "Nota Credito Acquisto";
				}
				if(comm.return_somma_iva_riepilogo() <0 && comm.return_somma_imponibili_riepilogo() <0){
					tipo_dg = "Nota Credito Acquisto";
				}
			}
		
		return tipo_dg;
	 
	 
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
		for (User p:this.lista_somme){
			if((p.getAliquota()==Double.parseDouble(event.getNewValue().toString())) && (p.getGiorno()=="SOMMA_IMPONIBILI")){
				this.somma_imponibile_riepilogo = p.getSomma();
			}
			if((p.getAliquota()==Double.parseDouble(event.getNewValue().toString())) && (p.getGiorno()=="SOMMA_DETTAGLI")){
				this.somma_dettaglio = p.getSomma();
			}
			if((p.getAliquota()==Double.parseDouble(event.getNewValue().toString())) && (p.getGiorno()=="IVA_DETTAGLI")){
				this.somma_iva_dettaglio = p.getSomma();
			}
			if((p.getAliquota()==Double.parseDouble(event.getNewValue().toString())) && (p.getGiorno()=="IVA_IMPONIBILE")){
				this.somma_iva_riepilogo = p.getSomma();
			}
    //che si traduce esattamente in "per ogni Person p in listaPersone"
}

		/*
  this.somma_imponibile_riepilogo= comm.round(comm.return_somma_imponibili_riepilogo_per_aliquota(Double.parseDouble(event.getNewValue().toString())));
  this.somma_dettaglio = comm.round(comm.return_somma_dett_per_aliquota(Double.parseDouble(event.getNewValue().toString())));
   this.somma_iva_dettaglio = comm.round(comm.return_somma_iva_dett_per_aliquota(Double.parseDouble(event.getNewValue().toString())));
   this.somma_iva_riepilogo = comm.round(comm.return_somma_iva_riepilogo_per_aliquota(Double.parseDouble(event.getNewValue().toString())));
    
sognoesondesto2
    */            
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
		this.tipo_dg = calcola_tipo_dg();
		this.numero_documento = comm.return_numero_documento();
		this.esigibilita_iva=calcola_esigibilita_iva();
		this.data_documento = comm.return_data_documento();
		this.descrizione = comm.return_descrizione();
  somma_iva_dettaglio= comm.return_somma_imponibili();
              this.lista_anomalie.clear();

	    AnomalieQuadratura nuovo2 = new AnomalieQuadratura(event.getNewValue().toString());

   nuovo2.verifica_quadratura_imponibile();
                nuovo2.verifica_quadratura_iva();
                nuovo2.verifica_quadratura_prezzo_unitario_prezzototale();
                RigheDettaglio userData = (RigheDettaglio) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("righedettaglio"); 
            userData.inizializza();
                this.lista_anomalie = nuovo2.return_lista_anomalie();
                this.lista_aliquote = comm.return_lista_aliquote();
                for(Double aliquote : this.lista_aliquote){
                    lista_somme.add(new User(aliquote,"SOMMA_IMPONIBILI", comm.round(comm.return_somma_imponibili_riepilogo_per_aliquota(aliquote))));
                    lista_somme.add(new User(aliquote, "SOMMA_DETTAGLI", comm.round(comm.return_somma_dett_per_aliquota(aliquote))));
					lista_somme.add(new User(aliquote, "IVA_DETTAGLI",comm.round(comm.return_somma_iva_dett_per_aliquota(aliquote))));
					lista_somme.add(new User(aliquote,"IVA_IMPONIBILE",comm.round(comm.return_somma_iva_riepilogo_per_aliquota(aliquote))));
  /*this.somma_imponibile_riepilogo= comm.round(comm.return_somma_imponibili_riepilogo_per_aliquota(Double.parseDouble(event.getNewValue().toString())));
  this.somma_dettaglio = comm.round(comm.return_somma_dett_per_aliquota(Double.parseDouble(event.getNewValue().toString())));
   this.somma_iva_dettaglio = comm.round(comm.return_somma_iva_dett_per_aliquota(Double.parseDouble(event.getNewValue().toString())));
   this.somma_iva_riepilogo = comm.round(comm.return_somma_iva_riepilogo_per_aliquota(Double.parseDouble(event.getNewValue().toString())));
	*/		    }
           	
                
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
	 FormatXML formatter = new FormatXML();
	  String book =  this.file.toString();
	  if(this.file ==""){
		  FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage("E' necessario valorizzare il file xml"));
	}
	else{
	  String ciao = formatter.format(book);
     this.file = ciao;  
 }

}
catch(IOException e){
	
	
}

}
/**
 * @return the tipo_dg
 */
public String getTipo_dg() {
	return tipo_dg;
}
/**
 * @param tipo_dg the tipo_dg to set
 */
public void setTipo_dg(String tipo_dg) {
	this.tipo_dg = tipo_dg;
}
/**
 * @return the tipo_dg
 */
public String getnumero_documento() {
	return numero_documento;
}
/**
 * 
 * @param tipo_dg the tipo_dg to set
 */
public void setnumero_documento(String numero_documento) {
	this.numero_documento = numero_documento;
}
public String getdata_documento() {
	return data_documento;
}
/**
 * @param tipo_dg the tipo_dg to set
 */
public void setdata_documento(String data_documento) {
	this.data_documento = data_documento;
}
public String getdescrizione() {
	return descrizione;
}
/**
 * @param tipo_dg the tipo_dg to set
 */
public void setdescrizione(String descrizione) {
	this.descrizione = descrizione;
}
/**
 * @return the esigibilita_iva
 */
public String getEsigibilita_iva() {
	return esigibilita_iva;
}
/**
 * @param esigibilita_iva the esigibilita_iva to set
 */
public void setEsigibilita_iva(String esigibilita_iva) {
	this.esigibilita_iva = esigibilita_iva;
}

}

