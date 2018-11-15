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
public class fn_sincronizar_agenciaModel {
    private int id_agencia;
    private String nombre;
    private String ubicacion;

    public fn_sincronizar_agenciaModel() {
    }

    public fn_sincronizar_agenciaModel(int id_agencia, String nombre, String ubicacion) {
        this.id_agencia = id_agencia;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public int getId_agencia() {
        return id_agencia;
    }

    public void setId_agencia(int id_agencia) {
        this.id_agencia = id_agencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    
}
