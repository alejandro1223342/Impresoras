
package biblioteca.modelo.entidades;

import biblioteca.modelo.administracion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Area {
    int id_area;
    String etiqueta;
    
    public Area(){
        
    }

    public Area(int id_area, String etiqueta) {
        this.id_area = id_area;
        this.etiqueta = etiqueta;
    }
    

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
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
    
    public Vector<Area>mostrarArea() {
         PreparedStatement ps;
         Statement st = null;
        ResultSet rs;
        conexion con = new conexion();
        Connection acceso;
        
        Vector<Area> datos= new Vector<Area>(); 
        Area dat=null;
        
        try {
            acceso = con.conectar();
            String sql = "SELECT * FROM c_area;";
            st = acceso.createStatement();
            rs = st.executeQuery(sql);
            //ps = acceso.prepareStatement(sql);
            //ps.executeQuery();
            
            dat=new Area();
            dat.setId_area(0);
            dat.setEtiqueta("Selecciona Marca");
            datos.add(dat);
            while (rs.next()) {
            dat=new Area();
            dat.setId_area(rs.getInt("id_area"));
            dat.setEtiqueta(rs.getString("etiqueta"));
            datos.add(dat);
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return datos;
    }
    
    
}
