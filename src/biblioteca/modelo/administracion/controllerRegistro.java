
package biblioteca.modelo.administracion;

import biblioteca.modelo.entidades.Area;
import biblioteca.modelo.entidades.Marca;
import biblioteca.modelo.entidades.TipoImpresora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class controllerRegistro {
     PreparedStatement ps;
    ResultSet rs;
    conexion con = new conexion();
    Connection acceso;
    
    public void insertar(Marca marca) {

        try {
            //String sql = "insert into libro(autor,titulo,cantidad,estado) values(?,?,?,?)";
            String sql = "INSERT INTO c_marca_impresora (etiqueta) VALUES (?)";
            acceso = con.conectar();
            System.out.println("conexxion: " + acceso);
            ps = acceso.prepareStatement(sql);
            ps.setObject(1, marca.getEtiqueta());
            ps.executeUpdate();

        } catch (Exception e) {
        }

    }
     public void insertarArea(Area area) {

        try {
            //String sql = "insert into libro(autor,titulo,cantidad,estado) values(?,?,?,?)";
            String sql = "INSERT INTO c_area (etiqueta) VALUES (?)";
            acceso = con.conectar();
            System.out.println("conexxion: " + acceso);
            ps = acceso.prepareStatement(sql);
            ps.setObject(1, area.getEtiqueta());
            ps.executeUpdate();

        } catch (Exception e) {
        }

    }
     
     public void insertarTipoimpresora(TipoImpresora tipoimpresora) {

        try {
            //String sql = "insert into libro(autor,titulo,cantidad,estado) values(?,?,?,?)";
            String sql = "INSERT INTO c_tipo_impresora (etiqueta,bandera) VALUES (?,?)";
            acceso = con.conectar();
            System.out.println("conexxion: " + acceso);
            ps = acceso.prepareStatement(sql);
            ps.setObject(1, tipoimpresora.getEtiqueta());
            ps.setObject(2, tipoimpresora.getBandera());
            ps.executeUpdate();

        } catch (Exception e) {
        }

    }
}
