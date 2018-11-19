/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objects.controller;

/**
 *
 * @author Jesús Mendoza
 */
public class Usuario {
    private int id;
    private String nombre;
    private String agencia;
    private String correo;
    private String celular;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String agencia, String correo, String celular) {
        this.id = id;
        this.nombre = nombre;
        this.agencia = agencia;
        this.correo = correo;
        this.celular = celular;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    
}
