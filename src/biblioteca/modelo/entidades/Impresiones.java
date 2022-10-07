
package biblioteca.modelo.entidades;


public class Impresiones {
    int id_registro;
    String cedula;
    String apellidos;
    String nombres;
    String id_impresora;
    String id_tipoImp;
    String numero_hojas;
    String timestamp;
    String descripcion;

    public Impresiones(int id_registro, String cedula, String apellidos, String nombres, String id_impresora, String id_tipoImp, String numero_hojas, String timestamp, String descripcion) {
        this.id_registro = id_registro;
        this.cedula = cedula;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.id_impresora = id_impresora;
        this.id_tipoImp = id_tipoImp;
        this.numero_hojas = numero_hojas;
        this.timestamp = timestamp;
        this.descripcion = descripcion;
    }
    
    public Impresiones(){
    
    
    }

    public int getId_registro() {
        return id_registro;
    }

    public void setId_registro(int id_registro) {
        this.id_registro = id_registro;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getId_impresora() {
        return id_impresora;
    }

    public void setId_impresora(String id_impresora) {
        this.id_impresora = id_impresora;
    }

    public String getId_tipoImp() {
        return id_tipoImp;
    }

    public void setId_tipoImp(String id_tipoImp) {
        this.id_tipoImp = id_tipoImp;
    }

    public String getNumero_hojas() {
        return numero_hojas;
    }

    public void setNumero_hojas(String numero_hojas) {
        this.numero_hojas = numero_hojas;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
