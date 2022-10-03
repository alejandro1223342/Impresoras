
package biblioteca.modelo.entidades;

import biblioteca.modelo.administracion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JComboBox;

public class Marca {
    int id_marca_impresora;
    String etiqueta;

    public Marca(){
    
    }
    public Marca(int id_marca_impresora, String etiqueta) {
        this.id_marca_impresora = id_marca_impresora;
        this.etiqueta = etiqueta;
    }

    public int getId_marca_impresora() {
        return id_marca_impresora;
    }

    public void setId_marca_impresora(int id_marca_impresora) {
        this.id_marca_impresora = id_marca_impresora;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }
    
    public String toString(){
        return this.etiqueta;
    }
    
    public Vector<Marca>mostrarMarca() {
         PreparedStatement ps;
         Statement st = null;
        ResultSet rs;
        conexion con = new conexion();
        Connection acceso;
        
        Vector<Marca> datos= new Vector<Marca>(); 
        Marca dat=null;
        
        try {
            acceso = con.conectar();
            String sql = "SELECT * FROM c_marca_impresora";
            st = acceso.createStatement();
            rs = st.executeQuery(sql);
            //ps = acceso.prepareStatement(sql);
            //ps.executeQuery();
            
            dat=new Marca();
            dat.setId_marca_impresora(0);
            dat.setEtiqueta("Selecciona Marca");
            datos.add(dat);
            while (rs.next()) {
            dat=new Marca();
            dat.setId_marca_impresora(rs.getInt("id_marca_impresora"));
            dat.setEtiqueta(rs.getString("etiqueta"));
            datos.add(dat);
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return datos;
    }
}
