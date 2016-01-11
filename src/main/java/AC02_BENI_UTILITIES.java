 
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AC02_BENI_UTILITIES{
	
	/* Classe con metodi riutilizzabili nei managed beans */
	public static Connection get_connection (){
 
        String USERNAME = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
String PASSWORD = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");

String URL = "jdbc:mysql://127.13.47.2:3306/computerlucaworld";
Connection m_connection = null;
try{
m_connection = DriverManager.getConnection(URL , USERNAME , PASSWORD); 

}
catch(SQLException e){
	System.out.println(e.toString());
}   
return m_connection;

}  
public static List select_all_ac02_beni(){
	Connection conn = get_connection();
	
	List<AC02_BENI> cars = new ArrayList<AC02_BENI>();
try{
        PreparedStatement pstmt = conn.prepareStatement("select * from AC02_BENI");
System.out.println(pstmt.toString());
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {

            AC02_BENI car = new AC02_BENI();
            //per ogni riga nella tabella aggiungi
            //un elemento a una lista

          
			car.setcodice_bene(rs.getString("codice_bene"));
			car.setdescrizione(rs.getString("descrizione"));
			
			cars.add(car);
			System.out.println("car");
        }
        

        rs.close();

        pstmt.close();

        conn.close();}
catch(SQLException e){
	
}
        return cars;

    

}

    public static void main(String[] args) 
{
	AC02_BENI_UTILITIES  Lista_beni= new AC02_BENI_UTILITIES();
	System.out.println(Lista_beni.select_all_ac02_beni().toString());
	  
}

}
