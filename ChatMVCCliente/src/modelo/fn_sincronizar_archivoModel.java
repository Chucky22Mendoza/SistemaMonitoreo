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
public class fn_sincronizar_archivoModel {
    private int id_archivo;
    private String nombre;
    private int duracion;
    private String ubicacion;
    private int id_tipo_archivo;

    public fn_sincronizar_archivoModel() {
    }

    public fn_sincronizar_archivoModel(int id_archivo, String nombre, int duracion, String ubicacion, int id_tipo_archivo) {
        this.id_archivo = id_archivo;
        this.nombre = nombre;
        this.duracion = duracion;
        this.ubicacion = ubicacion;
        this.id_tipo_archivo = id_tipo_archivo;
    }

    public int getId_archivo() {
        return id_archivo;
    }

    public void setId_archivo(int id_archivo) {
        this.id_archivo = id_archivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getId_tipo_archivo() {
        return id_tipo_archivo;
    }

    public void setId_tipo_archivo(int id_tipo_archivo) {
        this.id_tipo_archivo = id_tipo_archivo;
    }

    
}
