/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package com.service.monitoreo.models;

/**
 *
 * @author mss
 */
public class infoServicio {
    private String nombre;
    private String version;
    private String lenguajeCodificacion;
    private String versionLenguaje;
    private String plataforma;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLenguajeCodificacion() {
        return lenguajeCodificacion;
    }

    public void setLenguajeCodificacion(String lenguajeCodificacion) {
        this.lenguajeCodificacion = lenguajeCodificacion;
    }

    public String getVersionLenguaje() {
        return versionLenguaje;
    }

    public void setVersionLenguaje(String versionLenguaje) {
        this.versionLenguaje = versionLenguaje;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
    
    
    
}
