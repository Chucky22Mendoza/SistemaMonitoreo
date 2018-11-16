/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package com.service.monitoreo.models;

/**
 *
 * @author Jesús Mendoza
 */
public class fn_sincronizar_lista_reproduccionModel {
    private int id_lista_reproduccion;
    private String nombre;
    private String descripcion;

    public fn_sincronizar_lista_reproduccionModel() {
    }

    public fn_sincronizar_lista_reproduccionModel(int id_lista_reproduccion, String nombre, String descripcion) {
        this.id_lista_reproduccion = id_lista_reproduccion;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId_lista_reproduccion() {
        return id_lista_reproduccion;
    }

    public void setId_lista_reproduccion(int id_lista_reproduccion) {
        this.id_lista_reproduccion = id_lista_reproduccion;
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
