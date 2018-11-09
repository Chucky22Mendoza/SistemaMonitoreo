/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.monitoreo.models;

/**
 *
 * @author Jesús Mendoza
 */
public class sincronizar_usuarioModel {
    private int id_usuario;
    private boolean status;
    private String nombre;
    private String username;
    private String contrasena;
    private String correo;
    private String telefono;
    private int id_agencia;
    private int id_rol;
    private int id_kiosco;

    public sincronizar_usuarioModel() {
    }

    public sincronizar_usuarioModel(int id_usuario, boolean status, String nombre, String username, String contrasena, String correo, String telefono, int id_agencia, int id_rol, int id_kiosco) {
        this.id_usuario = id_usuario;
        this.status = status;
        this.nombre = nombre;
        this.username = username;
        this.contrasena = contrasena;
        this.correo = correo;
        this.telefono = telefono;
        this.id_agencia = id_agencia;
        this.id_rol = id_rol;
        this.id_kiosco = id_kiosco;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId_agencia() {
        return id_agencia;
    }

    public void setId_agencia(int id_agencia) {
        this.id_agencia = id_agencia;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public int getId_kiosco() {
        return id_kiosco;
    }

    public void setId_kiosco(int id_kiosco) {
        this.id_kiosco = id_kiosco;
    }
    
    
}
