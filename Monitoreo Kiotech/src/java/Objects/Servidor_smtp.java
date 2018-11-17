/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package Objects;

/**
 *
 * @author Jesús Mendoza Verduzco
 */
public class Servidor_smtp {
    private String server;
    private String usuario;
    private String contrasena;
    private int puerto;
    private String seguridad;

    public Servidor_smtp() {
    }

    public Servidor_smtp(String server, String usuario, String contrasena, int puerto, String seguridad) {
        this.server = server;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.puerto = puerto;
        this.seguridad = seguridad;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
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

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public String getSeguridad() {
        return seguridad;
    }

    public void setSeguridad(String seguridad) {
        this.seguridad = seguridad;
    }
    
    
}
