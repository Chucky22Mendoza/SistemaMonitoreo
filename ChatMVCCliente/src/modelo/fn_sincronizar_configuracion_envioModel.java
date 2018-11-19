/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package modelo;

/**
 *
 * @author Jesús Mendoza
 */
public class fn_sincronizar_configuracion_envioModel {
    private int id_configuracion_envio;
    private String servidor_smtp;
    private String seguridad;
    private String usuario;
    private String contrasena;
    private String puerto;
    private String puerto_tarjeta_sms;

    public fn_sincronizar_configuracion_envioModel() {
    }

    public fn_sincronizar_configuracion_envioModel(int id_configuracion_envio, String servidor_smtp, String seguridad, String usuario, String contrasena, String puerto, String puerto_tarjeta_sms) {
        this.id_configuracion_envio = id_configuracion_envio;
        this.servidor_smtp = servidor_smtp;
        this.seguridad = seguridad;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.puerto = puerto;
        this.puerto_tarjeta_sms = puerto_tarjeta_sms;
    }

    public int getId_configuracion_envio() {
        return id_configuracion_envio;
    }

    public void setId_configuracion_envio(int id_configuracion_envio) {
        this.id_configuracion_envio = id_configuracion_envio;
    }

    public String getServidor_smtp() {
        return servidor_smtp;
    }

    public void setServidor_smtp(String servidor_smtp) {
        this.servidor_smtp = servidor_smtp;
    }

    public String getSeguridad() {
        return seguridad;
    }

    public void setSeguridad(String seguridad) {
        this.seguridad = seguridad;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getPuerto_tarjeta_sms() {
        return puerto_tarjeta_sms;
    }

    public void setPuerto_tarjeta_sms(String puerto_tarjeta_sms) {
        this.puerto_tarjeta_sms = puerto_tarjeta_sms;
    }

    
}
