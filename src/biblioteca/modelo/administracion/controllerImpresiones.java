
package biblioteca.modelo.administracion;

import biblioteca.modelo.entidades.Impresiones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class controllerImpresiones {
    
    PreparedStatement ps;
    Statement st = null;
    ResultSet rs;
    conexion con = new conexion();
    Connection acceso;
    
    public void insertar(Impresiones imp) {

        try {
            String sql = "INSERT INTO t_registro (cedula, apellidos, nombres, id_impresora, id_tipoImp, numero_hojas, timestamp, descripcion) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            acceso = con.conectar();
            System.out.println("conexxion: " + acceso);
            ps = acceso.prepareStatement(sql);
            ps.setObject(1, imp.getCedula());
            ps.setObject(2, imp.getApellidos());
            ps.setObject(3, imp.getNombres());
            ps.setObject(4, imp.getId_impresora());
            ps.setObject(5, imp.getId_tipoImp());
            ps.setObject(6, imp.getNumero_hojas());
            ps.setObject(7, imp.getTimestamp());
            ps.setObject(8, imp.getDescripcion());
            ps.executeUpdate();

        } catch (Exception e) {
        }

    }
    
       public ArrayList<Impresiones> consulta() {

        ArrayList<Impresiones> listaImpresiones = new ArrayList<>();

        try {
/*
            String sql="SELECT *"
                    + " FROM t_impresora"
                    + " inner join c_marca_impresora on t_impresora.id_marca_impresora=c_marca_impresora.id_marca_impresora"
                    + " inner join c_area on t_impresora.id_area=c_area.id_area"
                    + " inner join c_tipo_impresora on t_impresora.id_tipo_impresora=c_tipo_impresora.id_tipo_impresora";
*/
            String sql = "SELECT"
                    + " t_registro.id_registro,"
                    + " t_registro.cedula,"
                    + " t_registro.apellidos,"
                    + " t_registro.nombres,"
                    + " t_registro.id_impresora,"
                    + " c_tipo_impresion.etiqueta,"
                    + " t_registro.numero_hojas,"
                    + " t_registro.timestamp,"
                    + " t_registro.descripcion"
                    + " from"
                    + " t_registro"
                    + " inner join"
                    + " c_tipo_impresion on t_registro.id_tipoImp=c_tipo_impresion.id_tipoImp"
                    + " inner join"
                    + " t_impresora on t_registro.id_impresora = t_impresora.id_impresora";
                   
            acceso = con.conectar();
            st = acceso.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("consulta");
            while (rs.next()) {
                System.out.println("fila: " + rs.getInt(1));
                Impresiones imp = new Impresiones();
                imp.setId_registro(rs.getInt(1));
                imp.setCedula(rs.getString(2));
                imp.setApellidos(rs.getString(3));
                imp.setNombres(rs.getString(4));
                imp.setId_impresora(rs.getString(5));
                imp.setId_tipoImp(rs.getString(6));
                imp.setNumero_hojas(rs.getString(7));
                imp.setTimestamp(rs.getString(8));
                imp.setDescripcion(rs.getString(9));
                listaImpresiones.add(imp);
            }

        } catch (Exception e) {
        }

        return listaImpresiones;
    }
       
       public void actualizar(Impresiones imp) {
           
           try{
           String sql = "UPDATE t_registro SET id_registro = ?, cedula = ?, apellidos = ?, nombres = ? , id_impresora = ?, id_tipoImp = ?, numero_hojas = ?, timestamp = ?, descripcion = ? WHERE (id_registro = ?);";

           acceso = con.conectar();
            ps = acceso.prepareStatement(sql);
            ps.setObject(1, imp.getId_registro());
            ps.setObject(2, imp.getCedula());
            ps.setObject(3, imp.getApellidos());
            ps.setObject(4, imp.getNombres());
            ps.setObject(5, imp.getId_impresora());
            ps.setObject(6, imp.getId_tipoImp());
            ps.setObject(7, imp.getNumero_hojas());
            ps.setObject(8, imp.getTimestamp());
            ps.setObject(9, imp.getDescripcion());
            ps.setObject(10, imp.getId_registro());
            
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
       
           public void eliminar(int id) {
        String sql = "DELETE FROM t_registro WHERE (id_registro = ?)";
        try {
            acceso = con.conectar();
            System.out.println("id="+id);
            ps = acceso.prepareStatement(sql);
            ps.setObject(1, id);
            ps.executeUpdate();
            System.out.println("eliminacion");
        } catch (Exception e) {
        }
    }

}

