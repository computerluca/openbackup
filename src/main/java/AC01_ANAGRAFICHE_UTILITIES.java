 
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AC01_ANAGRAFICHE_UTILITIES{
	/* Classe con metodi riutilizzabili nei managed beans */
	public static Connection get_connection (){
 
        String USERNAME = "adminT2hJwLi";
String PASSWORD = "CcNHwzdNVza9";
String DB_NAME = "computerlucaworld";
String FORNAME_URL = "com.mysql.jdbc.Driver";
String URL = "jdbc:"+"mysql://127.13.47.2:3306/"+ DB_NAME;
Connection m_connection = null;
try{
m_connection = DriverManager.getConnection(URL , USERNAME , PASSWORD); 

}
catch(SQLException e){
	System.out.println(e);
}   

return m_connection;

}  
public static List select_all_ac01_anagrafiche(){
	Connection conn = get_connection();
	
	List<AC01_ANAGRAFICHE> cars = new ArrayList<AC01_ANAGRAFICHE>();
try{
        PreparedStatement pstmt = conn.prepareStatement("select partita_iva,codice_fiscale,denominazione from ac01_anagrafiche");

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {

            AC01_ANAGRAFICHE car = new AC01_ANAGRAFICHE();
            //per ogni riga nella tabella aggiungi
            //un elemento a una lista

           /*  car.setCid(rs.getInt("car_id"));

            car.setCname(rs.getString("cname"));

            car.setColor(rs.getString("color"));

            car.setSpeed(rs.getInt("speed"));

            car.setMfdctry(rs.getString("Manufactured_Country"));

            cars.add(car);*/
			car.setCodice_fiscale(rs.getString("codice_fiscale"));
			car.setPartita_iva(rs.getString("partita_iva"));
			car.setDenominazione(rs.getString("denominazione"));
        }

        rs.close();

        pstmt.close();

        conn.close();}
catch(SQLException e){
	
}
        return cars;

    

}
	  
}



