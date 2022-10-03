
package biblioteca.modelo.entidades;

import biblioteca.modelo.administracion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;


public class TipoImpresora {
    int id_tipo_impresora;
    String etiqueta;
    String bandera;
    
    public TipoImpresora(){
    
    }

    public TipoImpresora(int id_tipo_impresora, String etiqueta, String bandera) {
        this.id_tipo_impresora = id_tipo_impresora;
        this.etiqueta = etiqueta;
        this.bandera = bandera;
    }

    public int getId_tipo_impresora() {
        return id_tipo_impresora;
    }

    public void setId_tipo_impresora(int id_tipo_impresora) {
        this.id_tipo_impresora = id_tipo_impresora;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getBandera() {
        return bandera;
    }

    public void setBandera(String bandera) {
        this.bandera = bandera;
    }
    
    public String toString(){
        return this.etiqueta;
    }
    
    public Vector<TipoImpresora>mostrarTipo() {
         PreparedStatement ps;
         Statement st = null;
        ResultSet rs;
        conexion con = new conexion();
        Connection acceso;
        
        Vector<TipoImpresora> datos= new Vector<TipoImpresora>(); 
        TipoImpresora dat=null;
        
        try {
            acceso = con.conectar();
            String sql = "SELECT * FROM c_tipo_impresora";
            st = acceso.createStatement();
            rs = st.executeQuery(sql);
            //ps = acceso.prepareStatement(sql);
            //ps.executeQuery();
            
            dat=new TipoImpresora();
            dat.setId_tipo_impresora(0);
            dat.setEtiqueta("Selecciona Marca");
            datos.add(dat);
            while (rs.next()) {
            dat=new TipoImpresora();
            dat.setId_tipo_impresora(rs.getInt("id_tipo_impresora"));
            dat.setEtiqueta(rs.getString("etiqueta")+" - "+rs.getString("bandera"));
            datos.add(dat);
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return datos;
    }
    
    
}
