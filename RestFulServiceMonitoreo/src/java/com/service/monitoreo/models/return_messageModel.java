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
public class return_messageModel {
    private boolean exito;
    private String mensaje;
    private String excepcion;
    private int codigo;

    public return_messageModel() {
    }

    public return_messageModel(boolean exito, String mensaje, String excepcion, int codigo) {
        this.exito = exito;
        this.mensaje = mensaje;
        this.excepcion = excepcion;
        this.codigo = codigo;
    }

    public boolean isExito() {
        return exito;
    }

    public void setExito(boolean exito) {
        this.exito = exito;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getExcepcion() {
        return excepcion;
    }

    public void setExcepcion(String excepcion) {
        this.excepcion = excepcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
}
