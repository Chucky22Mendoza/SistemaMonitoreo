/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package com.monitoreo.cliente.model.objects;

/**
 *
 * @author Jesús Mendoza
 */
public class fn_sincronizar_statusModel {
    private int id_status;
    private String nombre;
    private String descripcion;

    public fn_sincronizar_statusModel() {
    }

    public fn_sincronizar_statusModel(int id_status, String nombre, String descripcion) {
        this.id_status = id_status;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId_status() {
        return id_status;
    }

    public void setId_status(int id_status) {
        this.id_status = id_status;
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
