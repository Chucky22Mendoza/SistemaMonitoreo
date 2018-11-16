
package Objects;

/**
 *
 * @author nipan
 */
public class Kiosco {
    public int id_kisoco;
    public String nombre;
    public boolean status;


    public Kiosco(int id_kisoco, String nombre, boolean status) {
        this.id_kisoco = id_kisoco;
        this.nombre = nombre;
        this.status = status;
    }

    public Kiosco() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_kisoco() {
        return id_kisoco;
    }

    public void setId_kisoco(int id_kisoco) {
        this.id_kisoco = id_kisoco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
