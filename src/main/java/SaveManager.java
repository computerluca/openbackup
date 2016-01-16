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
		StringBuilder ciao2 = new StringBuilder();
		        Set<String> keys = this.campi_modificati.keySet();
		        ciao2.append("(");
	for(String key:keys){
	
	ciao2.append(key);
	ciao2.append(",");
}	
	ciao2.append("id_configurazione");
       
ciao2.append(")");
ciao2.append("VALUES (");

for(String key:keys){
	ciao2.append("'");
	ciao2.append(this.campi_modificati.get(key));
	ciao2.append("'");
	ciao2.append(",");
}
ciao2.append("'3'");
ciao2.append(")");
	          return ciao2.toString();
 
	}
	public String componi_campi3(){
		StringBuilder ciao3= new StringBuilder();
		        Set<String> keys = this.campi_modificati.keySet();
	
       

for(String key:keys){
	ciao3.append("'");
	ciao3.append(this.campi_modificati.get(key));
	ciao3.append("'");
	ciao3.append(",");
}
System.out.println(ciao3);
	          return ciao3.toString();
 
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
	public void Salva3(){
		

		if(this.campi_modificati.size()>0){
			
			String USERNAME = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
String PASSWORD = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");

String URL = "jdbc:mysql://127.13.47.2:3306/computerlucaworld";
Connection conn = null;
try{
	conn = DriverManager.getConnection(URL , USERNAME , PASSWORD); 

String insertTableSQL = "INSERT INTO AC02_BENI"
		+ "(codice_bene, descrizione) VALUES"
		+ "(?,?)";
PreparedStatement preparedStatement = conn.prepareStatement(insertTableSQL);
preparedStatement.setString(1, this.campi_modificati.get("codice_bene"));
preparedStatement.setString(2, this.campi_modificati.get("descrizione"));
// execute insert SQL stetement
preparedStatement .executeUpdate();
        this.campi_modificati.clear();
}
catch(SQLException e){
	System.out.println(e.toString());
	
}  
		}
		
		
	}
	public String Salva4(){
		
String risultato="";
		if(this.campi_modificati.size()>0){
			
			String USERNAME = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
String PASSWORD = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");

String URL = "jdbc:mysql://127.13.47.2:3306/computerlucaworld";
Connection conn = null;
try{
	conn = DriverManager.getConnection(URL , USERNAME , PASSWORD); 

String insertTableSQL = "INSERT INTO AC03_CODICI_IVA"
		+ "(codice_iva, descrizione,aliquota) VALUES"
		+ "(?,?,?)";
PreparedStatement preparedStatement = conn.prepareStatement(insertTableSQL);
preparedStatement.setString(1, this.campi_modificati.get("codice_iva"));
preparedStatement.setString(2, this.campi_modificati.get("descrizione"));
preparedStatement.setString(3, this.campi_modificati.get("aliquota"));

// execute insert SQL stetement
preparedStatement .executeUpdate();
        this.campi_modificati.clear();
        risultato = "vero";
}
catch(SQLException e){
	System.out.println(e.toString());
	risultato=e.toString();
}  
		}
		
		return risultato;
	}
	public void Salva2(){
		
		String ciao = componi_campi2();
		String query = "INSERT INTO AC01_ANAGRAFICHE" +ciao;

		if(this.campi_modificati.size()>0){
			
			String USERNAME = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
String PASSWORD = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");

String URL = "jdbc:mysql://127.13.47.2:3306/computerlucaworld";
Connection conn = null;
try{
	conn = DriverManager.getConnection(URL , USERNAME , PASSWORD); 

PreparedStatement pstmt = conn.prepareStatement(query);
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
