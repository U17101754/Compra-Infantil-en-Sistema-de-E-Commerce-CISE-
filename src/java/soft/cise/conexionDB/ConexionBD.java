package soft.cise.conexionDB;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author SISTEMA
 */
public class ConexionBD {

    public static ConexionBD instancia = null;
    public static final String url = "jdbc:sqlserver://localhost:1834;databaseName=VentaOnline;";
    public static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static final String usu = "sa";
    public static final String pass = "sa";

    private static Connection con;

    private ConexionBD() {
        try {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url, usu, pass);
            System.out.println("Conexion exitosa");
        } catch (Exception e) {
            System.out.println("Error al conectar" + e.getMessage());
            
        }

    }
    
    public synchronized static ConexionBD conectar(){
        if(instancia == null){
            instancia = new ConexionBD();
        }
        return instancia;
    }
    
    public Connection getCon(){
        return con;
    }
    
    public void cerrarConexion(){
        instancia = null;
    }
    



}
