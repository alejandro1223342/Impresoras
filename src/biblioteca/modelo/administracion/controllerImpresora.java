package biblioteca.modelo.administracion;

import biblioteca.modelo.entidades.Impresora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class controllerImpresora {

    PreparedStatement ps;
    Statement st = null;
    ResultSet rs;
    conexion con = new conexion();
    Connection acceso;

    public void insertar(Impresora imp) {

        try {
            String sql = "INSERT INTO t_impresora (numero_serie, id_marca_impresora, id_area, id_tipo_impresora, descripcion_imp) VALUES (?, ?, ?, ?, ?)";
            acceso = con.conectar();
            System.out.println("conexxion: " + acceso);
            ps = acceso.prepareStatement(sql);
            ps.setObject(1, imp.getNumero_serie());
            ps.setObject(2, imp.getId_marca_impresora());
            ps.setObject(3, imp.getId_area());
            ps.setObject(4, imp.getId_tipo_impresora());
            ps.setObject(5, imp.getDescripcion_imp());
            ps.executeUpdate();

        } catch (Exception e) {
        }

    }

    public ArrayList<Impresora> consulta() {

        ArrayList<Impresora> listaImpresora = new ArrayList<>();

        try {
/*
            String sql="SELECT *"
                    + " FROM t_impresora"
                    + " inner join c_marca_impresora on t_impresora.id_marca_impresora=c_marca_impresora.id_marca_impresora"
                    + " inner join c_area on t_impresora.id_area=c_area.id_area"
                    + " inner join c_tipo_impresora on t_impresora.id_tipo_impresora=c_tipo_impresora.id_tipo_impresora";
*/
            String sql = "SELECT"
                    + " t_imp.id_impresora,"
                    + " t_imp.numero_serie,"
                    + " marca.etiqueta,"
                    + " areatrabajo.etiqueta,"
                    + " tipoimp.etiqueta,"
                    + " tipoimp.bandera,"
                    + " t_imp.descripcion_imp"
                    + " FROM"
                    + " t_impresora AS t_imp"
                    + " INNER JOIN"
                    + " c_marca_impresora AS marca ON t_imp.id_marca_impresora=marca.id_marca_impresora"
                    + " INNER JOIN"
                    + " c_area AS areatrabajo ON t_imp.id_area=areatrabajo.id_area"
                    + " INNER JOIN"
                    + " c_tipo_impresora AS tipoimp ON t_imp.id_tipo_impresora=tipoimp.id_tipo_impresora";
            acceso = con.conectar();
            st = acceso.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("consulta");
            while (rs.next()) {
                System.out.println("fila: " + rs.getInt(1));
                Impresora imp = new Impresora();
                imp.setId_impresora(rs.getInt(1));
                imp.setNumero_serie(rs.getString(2));
                imp.setId_marca_impresora(rs.getString(3));
                imp.setId_area(rs.getString(4));
                imp.setId_tipo_impresora(rs.getString(5));
                imp.setBandera(rs.getString(6));
                imp.setDescripcion_imp(rs.getString(7));
                listaImpresora.add(imp);
            }

        } catch (Exception e) {
        }

        return listaImpresora;
    }

    public void actualizar(Impresora imp) {
        String sql = "UPDATE t_impresora SET id_impresora = ?, numero_serie = ?, id_marca_impresora = ?, id_area = ?, id_tipo_impresora = ?, descripcion_imp = ?  WHERE (id_impresora = ?)";
        try {
            acceso = con.conectar();
            ps = acceso.prepareStatement(sql);
            ps.setObject(1, imp.getId_impresora());
            ps.setObject(2, imp.getNumero_serie());
            ps.setObject(3, imp.getId_marca_impresora());
            ps.setObject(4, imp.getId_area());
            ps.setObject(5, imp.getId_tipo_impresora());
           // ps.setObject(6, imp.getBandera());
            ps.setObject(6, imp.getDescripcion_imp());
            ps.setObject(7, imp.getId_impresora());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM t_impresora WHERE (id_impresora = ?)";
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
