package com.objects.controller;

public class permisoAlertaUsuario {
    int id_permiso_alerta_evento, id_evento, id_usuario;
    boolean activo_sms, activo_correo;
    
    public permisoAlertaUsuario(){
        
    }

    public permisoAlertaUsuario(int id_permiso_alerta_evento, int id_evento, int id_usuario, boolean activo_sms, boolean activo_correo) {
        this.id_permiso_alerta_evento = id_permiso_alerta_evento;
        this.id_evento = id_evento;
        this.id_usuario = id_usuario;
        this.activo_sms = activo_sms;
        this.activo_correo = activo_correo;
    }
    
    public int getId_permiso_alerta_evento() {
        return id_permiso_alerta_evento;
    }

    public void setId_permiso_alerta_evento(int id_permiso_alerta_evento) {
        this.id_permiso_alerta_evento = id_permiso_alerta_evento;
    }

    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public boolean isActivo_sms() {
        return activo_sms;
    }

    public void setActivo_sms(boolean activo_sms) {
        this.activo_sms = activo_sms;
    }

    public boolean isActivo_correo() {
        return activo_correo;
    }

    public void setActivo_correo(boolean activo_correo) {
        this.activo_correo = activo_correo;
    }
}
