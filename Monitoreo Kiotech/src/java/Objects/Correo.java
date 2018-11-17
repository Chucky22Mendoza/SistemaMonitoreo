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
public class Correo {
    private String correo;
    private String msg;

    public Correo() {
    }

    public Correo(String correo, String msg) {
        this.correo = correo;
        this.msg = msg;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    
}
