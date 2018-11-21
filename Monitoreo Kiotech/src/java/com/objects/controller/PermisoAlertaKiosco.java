package com.objects.controller;

/**
 *
 * @author mario
 */
public class PermisoAlertaKiosco {
    private int permisoAlerta, id_kiosco, id_usuario;
    private String nombre;
    private boolean recibir_alerta;

    public PermisoAlertaKiosco() {
    }

    public PermisoAlertaKiosco(int permisoAlerta, int id_kiosco, int id_usuario, String nombre, boolean recibir_alerta) {
        this.permisoAlerta = permisoAlerta;
        this.id_kiosco = id_kiosco;
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.recibir_alerta = recibir_alerta;
    }

    public int getPermisoAlerta() {
        return permisoAlerta;
    }

    public void setPermisoAlerta(int permisoAlerta) {
        this.permisoAlerta = permisoAlerta;
    }

    public int getId_kiosco() {
        return id_kiosco;
    }

    public void setId_kiosco(int id_kiosco) {
        this.id_kiosco = id_kiosco;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isRecibir_alerta() {
        return recibir_alerta;
    }

    public void setRecibir_alerta(boolean recibir_alerta) {
        this.recibir_alerta = recibir_alerta;
    }
}
