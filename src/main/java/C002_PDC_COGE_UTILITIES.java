 
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class C002_PDC_COGE_UTILITIES{
	
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
public static List<C002_PDC_COGE> get_pdc_padre(){
	Connection conn = get_connection();
	
	List<C002_PDC_COGE> cars = new ArrayList<C002_PDC_COGE>();
try{
        PreparedStatement pstmt = conn.prepareStatement("select * from C002_PDC_COGE WHERE id_coge_padre =0");
System.out.println(pstmt.toString());
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {

            C002_PDC_COGE car = new C002_PDC_COGE();
            //per ogni riga nella tabella aggiungi
            //un elemento a una lista

			car.setcd_voce_coge(rs.getString("CD_VOCE_COGE"));
			car.setdenominazione(rs.getString("DENOMINAZIONE"));

			
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
public static List<C002_PDC_COGE> get_all(){
	Connection conn = get_connection();
	
	List<C002_PDC_COGE> cars = new ArrayList<C002_PDC_COGE>();
try{
        PreparedStatement pstmt = conn.prepareStatement("select * from C002_PDC_COGE");
System.out.println(pstmt.toString());
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {

            C002_PDC_COGE car = new C002_PDC_COGE();
            //per ogni riga nella tabella aggiungi
            //un elemento a una lista

			car.setcd_voce_coge(rs.getString("CD_VOCE_COGE"));
			car.setdenominazione(rs.getString("DENOMINAZIONE"));

			
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

    
public static List<C002_PDC_COGE> getvoci_per_livello(int livello){
	Connection conn = get_connection();
	
	List<C002_PDC_COGE> cars = new ArrayList<C002_PDC_COGE>();
try{
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM C002_PDC_COGE WHERE livello="+livello);
System.out.println(pstmt.toString());
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {

            C002_PDC_COGE car = new C002_PDC_COGE();
            //per ogni riga nella tabella aggiungi
            //un elemento a una lista

			car.setcd_voce_coge(rs.getString("CD_VOCE_COGE"));
			car.setdenominazione(rs.getString("DENOMINAZIONE"));

			
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
