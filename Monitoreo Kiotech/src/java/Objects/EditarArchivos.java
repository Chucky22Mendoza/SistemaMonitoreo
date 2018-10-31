/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author Jesús Mendoza
 */
public class EditarArchivos {
    private int idArchivo;
    private int orden;
    private String nombre;
    private String tipo;
    private int duracion;

    public EditarArchivos() {
    }

    public EditarArchivos(int idArchivo, int orden, String nombre, String tipo, int duracion) {
        this.idArchivo = idArchivo;
        this.orden = orden;
        this.nombre = nombre;
        this.tipo = tipo;
        this.duracion = duracion;
    }

    public int getIdArchivo() {
        return idArchivo;
    }

    public void setIdArchivo(int idArchivo) {
        this.idArchivo = idArchivo;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
}
