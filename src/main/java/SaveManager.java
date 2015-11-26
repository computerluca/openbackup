/*
 * SaveManager class
 * definisci metodi
 * per effettuare il salvataggio
 */
 import java.util.Hashtable;
 import java.util.Set;
 import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 class SaveManager{
	  Hashtable<String, String> campi_modificati;
	  public SaveManager(){
		  this.campi_modificati = new Hashtable<String,String>();
		  
		  
	  }
	  public void aggiungi_campo(String campo, String valore){
		  
		this.campi_modificati.put(campo,valore);
		  
	}
	public String componi_campi(){
		StringBuilder ciao = new StringBuilder();
		        Set<String> keys = this.campi_modificati.keySet();
for(String key:keys){
            //System.out.println("Value of "+key+" is: "+hm.get(key));
ciao.append(key);
ciao.append("='");
ciao.append(campi_modificati.get(key));
ciao.append("',");
	}
	          return ciao.toString();

	 
	}
	public String componi_campi2(){
		StringBuilder ciao = new StringBuilder();
		        Set<String> keys = this.campi_modificati.keySet();
for(String key:keys){
	ciao.append(campi_modificati.get(key));
	ciao.append(",");
}
	          return ciao.toString();
 
	}
	public void Salva(){
		if(this.campi_modificati.size()>0){
			
			String query = componi_campi();
			String USERNAME = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
String PASSWORD = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");

String URL = "jdbc:mysql://127.13.47.2:3306/computerlucaworld";
Connection conn = null;
try{
conn = DriverManager.getConnection(URL , USERNAME , PASSWORD); 
PreparedStatement pstmt = conn.prepareStatement("update AC01_ANAGRAFICHE set "
+query + "id_configurazione =1 where id_configurazione = 1");
System.out.println(pstmt.toString());
        pstmt.executeUpdate();
        this.campi_modificati.clear();
}
catch(SQLException e){
	System.out.println(e.toString());
}  
		}
		
		
	}
	public void Salva2(){
		if(this.campi_modificati.size()>0){
			
			String USERNAME = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
String PASSWORD = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");

String URL = "jdbc:mysql://127.13.47.2:3306/computerlucaworld";
Connection conn = null;
String ciao = componi_campi2();
try{
PreparedStatement pstmt = conn.prepareStatement("INSERT INTO AC01_ANAGRAFICHE VALUES("+ciao+")");
		        pstmt.executeUpdate();
System.out.println(pstmt.toString());
        pstmt.executeUpdate();
        this.campi_modificati.clear();
}
catch(SQLException e){
	System.out.println(e.toString());
	
}  
		}
		
		
	}
	public void inserisci_nuova_configurazione_principale(){
		String USERNAME = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
String PASSWORD = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");

String URL = "jdbc:mysql://127.13.47.2:3306/computerlucaworld";
Connection conn = null;
try{
conn = DriverManager.getConnection(URL , USERNAME , PASSWORD); 


PreparedStatement pstmt = conn.prepareStatement("INSERT INTO AC01_ANAGRAFICHE (ID_ANAGRAFICA,ID_CONFIGURAZIONE)VALUES(NULL,1)");
		        pstmt.executeUpdate();
Salva();
	}
	catch(SQLException e){
	System.out.println(e.toString());
}
}
/* public void inserisci_nuova_anagrafica(){
		String USERNAME = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
String PASSWORD = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");

String URL = "jdbc:mysql://127.13.47.2:3306/computerlucaworld";
Connection conn = null;
try{
conn = DriverManager.getConnection(URL , USERNAME , PASSWORD); 


PreparedStatement pstmt = conn.prepareStatement("INSERT INTO AC01_ANAGRAFICHE (ID_ANAGRAFICA,ID_CONFIGURAZIONE)VALUES(NULL,1)");
		        pstmt.executeUpdate();
Salva2();
	}
	catch(SQLException e){
	System.out.println(e.toString());
}
}*/

}
