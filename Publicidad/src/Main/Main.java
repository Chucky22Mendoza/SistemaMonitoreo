/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Views.Login;
import Views.PantallaExclusiva;
import Views.PantallaServicios;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Jesús Mendoza
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Properties p = new Properties();
        //Forma de buscar la ruta dentro del proyecto
        InputStream propertiesStream = ClassLoader.getSystemResourceAsStream("properties/configuracion.properties");
        p.load(propertiesStream);
        //getProperty devuelve un String
        String tipo = p.getProperty("tipo.configuracion");
        int con = Integer.parseInt(tipo);
        //System.out.println(pant_posicion);
        //Todos los valores
        /*Enumeration<Object> keys = p.keys();

        while (keys.hasMoreElements()){
           Object key = keys.nextElement();
           System.out.println(key + " = "+ p.get(key));
        }*/
        //Forma de mandar valor a una propiedad
        //p.setProperty("cuatro", "4");
        //Forma de guardar properties
        //p.store(new FileWriter("out.properties"),"un comentario");
        propertiesStream.close();
        //Configuracion ind=new Configuracion();
        //ind.setVisible(true);
        
        if(con == 0){
            Login log = new Login();
            log.setVisible(true);
        }else if(con == 1){
            PantallaExclusiva ex = new PantallaExclusiva();
            ex.setVisible(true);
        }else if(con == 2) {
            PantallaServicios ser = new PantallaServicios();
            ser.setVisible(true);
        }else{
            System.err.println("No se encontró una configuración, favor de revisar los archivos de propiedades");
        }
    }
    
}
