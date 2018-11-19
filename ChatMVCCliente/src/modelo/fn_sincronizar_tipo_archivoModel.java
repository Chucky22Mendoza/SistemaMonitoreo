/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package modelo;

/**
 *
 * @author Jesús Mendoza
 */
public class fn_sincronizar_tipo_archivoModel {
    private int id_tipo_archivo;
    private String nombre;
    private String descripcion;

    public fn_sincronizar_tipo_archivoModel() {
    }

    public fn_sincronizar_tipo_archivoModel(int id_tipo_archivo, String nombre, String descripcion) {
        this.id_tipo_archivo = id_tipo_archivo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId_tipo_archivo() {
        return id_tipo_archivo;
    }

    public void setId_tipo_archivo(int id_tipo_archivo) {
        this.id_tipo_archivo = id_tipo_archivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
