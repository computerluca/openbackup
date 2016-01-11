 
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
public static List select_all_ac03_codici_iva(){
	Connection conn = get_connection();
	
	List<AC03_CODICI_IVA> cars = new ArrayList<AC03_CODICI_IVA>();
try{
        PreparedStatement pstmt = conn.prepareStatement("select * from AC03_CODICI_IVA");
System.out.println(pstmt.toString());
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {

            AC03_CODICI_IVA car = new AC03_CODICI_IVA();
            //per ogni riga nella tabella aggiungi
            //un elemento a una lista

          	car.setId_codice_iva(rs.getInt("id_codice_iva"));
			car.setcodice_iva(rs.getString("codice_iva"));
			car.setdescrizione(rs.getString("descrizione"));
			car.setaliquota(rs.getString("aliquota"));

			
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

    

}
