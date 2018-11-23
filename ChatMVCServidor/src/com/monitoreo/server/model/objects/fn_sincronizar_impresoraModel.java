/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package com.monitoreo.server.model.objects;

import java.sql.Timestamp;

/**
 *
 * @author Jesús Mendoza
 */
public class fn_sincronizar_impresoraModel {
    private int id_impresora;
    private String nombre;
    private int id_kiosco;
    private Timestamp fecha_actualizacion;

    public fn_sincronizar_impresoraModel() {
    }

    public fn_sincronizar_impresoraModel(int id_impresora, String nombre, int id_kiosco, Timestamp fecha_actualizacion) {
        this.id_impresora = id_impresora;
        this.nombre = nombre;
        this.id_kiosco = id_kiosco;
        this.fecha_actualizacion = fecha_actualizacion;
    }

    public int getId_impresora() {
        return id_impresora;
    }

    public void setId_impresora(int id_impresora) {
        this.id_impresora = id_impresora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_kiosco() {
        return id_kiosco;
    }

    public void setId_kiosco(int id_kiosco) {
        this.id_kiosco = id_kiosco;
    }

    public Timestamp getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(Timestamp fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }

    
}
