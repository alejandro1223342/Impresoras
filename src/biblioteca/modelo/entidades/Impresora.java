
package biblioteca.modelo.entidades;


public class Impresora {
    int id_impresora;
    String numero_serie;
    String id_marca_impresora;
    String id_area;
    String id_tipo_impresora;
    String descripcion_imp;
    String bandera;

  
    
    public Impresora(){
        
    }

    public Impresora(int id_impresora, String numero_serie, String id_marca_impresora, String id_area, String id_tipo_impresora, String descripcion_imp, String bandera) {
        this.id_impresora = id_impresora;
        this.numero_serie = numero_serie;
        this.id_marca_impresora = id_marca_impresora;
        this.id_area = id_area;
        this.id_tipo_impresora = id_tipo_impresora;
        this.descripcion_imp = descripcion_imp;
        this.bandera=bandera;
    }

    public int getId_impresora() {
        return id_impresora;
    }

    public void setId_impresora(int id_impresora) {
        this.id_impresora = id_impresora;
    }

    public String getNumero_serie() {
        return numero_serie;
    }

    public void setNumero_serie(String numero_serie) {
        this.numero_serie = numero_serie;
    }

    public String getId_marca_impresora() {
        return id_marca_impresora;
    }

    public void setId_marca_impresora(String id_marca_impresora) {
        this.id_marca_impresora = id_marca_impresora;
    }

    public String getId_area() {
        return id_area;
    }

    public void setId_area(String id_area) {
        this.id_area = id_area;
    }

    public String getId_tipo_impresora() {
        return id_tipo_impresora;
    }

    public void setId_tipo_impresora(String id_tipo_impresora) {
        this.id_tipo_impresora = id_tipo_impresora;
    }

    public String getDescripcion_imp() {
        return descripcion_imp;
    }

    public void setDescripcion_imp(String descripcion_imp) {
        this.descripcion_imp = descripcion_imp;
    }

   
    public String getBandera() {
        return bandera;
    }

    public void setBandera(String bandera) {
        this.bandera = bandera;
    }
    
}
