
package biblioteca.modelo.entidades;

import biblioteca.modelo.administracion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;


public class TipoImpresiones {
    int id_tipoImp;
    String etiqueta;
    
    public TipoImpresiones(){
    
    }

    public int getId_tipoImp() {
        return id_tipoImp;
    }

    public void setId_tipoImp(int id_tipoImp) {
        this.id_tipoImp = id_tipoImp;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public TipoImpresiones(int id_tipoImp, String etiqueta) {
        this.id_tipoImp = id_tipoImp;
        this.etiqueta = etiqueta;
    }
    
      public String toString(){
        return this.etiqueta;
    }
    
      public Vector<TipoImpresiones>mostrarImpresiones() {
         PreparedStatement ps;
         Statement st = null;
        ResultSet rs;
        conexion con = new conexion();
        Connection acceso;
        
        Vector<TipoImpresiones> datos= new Vector<TipoImpresiones>(); 
        TipoImpresiones dat=null;
        
        try {
            acceso = con.conectar();
            String sql = "SELECT * FROM c_tipo_impresion;";
            st = acceso.createStatement();
            rs = st.executeQuery(sql);
            //ps = acceso.prepareStatement(sql);
            //ps.executeQuery();
            
            dat=new TipoImpresiones();
            dat.setId_tipoImp(0);
            dat.setEtiqueta("Selecciona Tipo");
            datos.add(dat);
            while (rs.next()) {
            dat=new TipoImpresiones();
            dat.setId_tipoImp(rs.getInt("id_tipoImp"));
            dat.setEtiqueta(rs.getString("etiqueta"));
            datos.add(dat);
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return datos;
    }
}
