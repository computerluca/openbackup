package computerlucaworld.createfepa.ac.business;
 
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
 
        String USERNAME = System.getEnv("OPENSHIFT_MYSQL_DB_USERNAME");
String PASSWORD = System.getEnv("OPENSHIFT_MYSQL_DB_PASSWORD");
String DB_NAME = System.getEnv("OPENSHIFT_APP_NAME");
String FORNAME_URL = "com.mysql.jdbc.Driver";
String URL = "jdbc:"+System.getEnv("OPENSHIFT_MYSQL_DB_URL")+ DB_NAME;
Connection m_connection = DriverManager.getConnection(URL , USERNAME , PASSWORD);
    
}  
public static List select_all_ac01_anagrafiche(){
	Connection conn = get_connection();
	
	List<AC01_ANAGRAFICHE> cars = new ArrayList<AC01_ANAGRAFICHE>();

        PreparedStatement pstmt = conn

                .prepareStatement("select partita_iva,codice_fiscale,denominazione from ac01_anagrafiche");

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

        conn.close();

        return cars;

    

}
	  
}

