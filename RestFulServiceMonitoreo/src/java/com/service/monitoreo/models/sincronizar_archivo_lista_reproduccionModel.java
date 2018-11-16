/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package com.service.monitoreo.models;

import java.sql.Time;

/**
 *
 * @author Jesús Mendoza
 */
public class sincronizar_archivo_lista_reproduccionModel {
    //lista programada
    private Time hora_inicio;
    private boolean domingo;
    private boolean lunes;
    private boolean martes;
    private boolean miercoles;
    private boolean jueves;
    private boolean viernes;
    private boolean sabado;
    private int id_kiosco;
    //lista de reproduccion
    private int id_lista_reproduccion;
    private String nombre_lista_reproduccion;
    
    //archivo y su tipo, al igual que orden
    private int id_archivo;
    private String nombre_archivo;
    private int duracion;
    private String ubicacion;
    private int id_tipo_archivo;
    private String nombre_tipo;
    private int orden;

    public sincronizar_archivo_lista_reproduccionModel() {
    }

    public sincronizar_archivo_lista_reproduccionModel(Time hora_inicio, boolean domingo, boolean lunes, boolean martes, boolean miercoles, boolean jueves, boolean viernes, boolean sabado, int id_kiosco, int id_lista_reproduccion, String nombre_lista_reproduccion, int id_archivo, String nombre_archivo, int duracion, String ubicacion, int id_tipo_archivo, String nombre_tipo, int orden) {
        this.hora_inicio = hora_inicio;
        this.domingo = domingo;
        this.lunes = lunes;
        this.martes = martes;
        this.miercoles = miercoles;
        this.jueves = jueves;
        this.viernes = viernes;
        this.sabado = sabado;
        this.id_kiosco = id_kiosco;
        this.id_lista_reproduccion = id_lista_reproduccion;
        this.nombre_lista_reproduccion = nombre_lista_reproduccion;
        this.id_archivo = id_archivo;
        this.nombre_archivo = nombre_archivo;
        this.duracion = duracion;
        this.ubicacion = ubicacion;
        this.id_tipo_archivo = id_tipo_archivo;
        this.nombre_tipo = nombre_tipo;
        this.orden = orden;
    }

    public Time getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Time hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public boolean isDomingo() {
        return domingo;
    }

    public void setDomingo(boolean domingo) {
        this.domingo = domingo;
    }

    public boolean isLunes() {
        return lunes;
    }

    public void setLunes(boolean lunes) {
        this.lunes = lunes;
    }

    public boolean isMartes() {
        return martes;
    }

    public void setMartes(boolean martes) {
        this.martes = martes;
    }

    public boolean isMiercoles() {
        return miercoles;
    }

    public void setMiercoles(boolean miercoles) {
        this.miercoles = miercoles;
    }

    public boolean isJueves() {
        return jueves;
    }

    public void setJueves(boolean jueves) {
        this.jueves = jueves;
    }

    public boolean isViernes() {
        return viernes;
    }

    public void setViernes(boolean viernes) {
        this.viernes = viernes;
    }

    public boolean isSabado() {
        return sabado;
    }

    public void setSabado(boolean sabado) {
        this.sabado = sabado;
    }

    public int getId_kiosco() {
        return id_kiosco;
    }

    public void setId_kiosco(int id_kiosco) {
        this.id_kiosco = id_kiosco;
    }

    public int getId_lista_reproduccion() {
        return id_lista_reproduccion;
    }

    public void setId_lista_reproduccion(int id_lista_reproduccion) {
        this.id_lista_reproduccion = id_lista_reproduccion;
    }

    public String getNombre_lista_reproduccion() {
        return nombre_lista_reproduccion;
    }

    public void setNombre_lista_reproduccion(String nombre_lista_reproduccion) {
        this.nombre_lista_reproduccion = nombre_lista_reproduccion;
    }

    public int getId_archivo() {
        return id_archivo;
    }

    public void setId_archivo(int id_archivo) {
        this.id_archivo = id_archivo;
    }

    public String getNombre_archivo() {
        return nombre_archivo;
    }

    public void setNombre_archivo(String nombre_archivo) {
        this.nombre_archivo = nombre_archivo;
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

    public String getNombre_tipo() {
        return nombre_tipo;
    }

    public void setNombre_tipo(String nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    
}
