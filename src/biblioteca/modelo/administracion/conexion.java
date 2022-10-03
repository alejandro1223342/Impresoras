package biblioteca.modelo.administracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class conexion {

    Connection con;
    String url = "jdbc:mysql://localhost:3306/mydb";
    String user = "root";
    String password = "root";

    public Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("llego conexion?");
        } catch (SQLException e) {
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
}
