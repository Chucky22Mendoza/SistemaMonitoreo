/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Views.Configuracion.txtHeader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesús Mendoza
 */
public class ConnectionDB {
    
            
     public Connection conectar() throws IOException{
        String host = "";
        String user = "";
        String port = "";
        String pass = "";
        Connection conn = null;
        Properties p = new Properties();
        InputStream propertiesStream = ClassLoader.getSystemResourceAsStream("Properties/configuracion.properties");
        p.load(propertiesStream);
        String tipo = p.getProperty("tipo.configuracion");
        propertiesStream.close();
        int con = Integer.parseInt(tipo);
        if(con == 1){
            
            try {
                    Properties prop = new Properties();
                    InputStream propertiesStream2 = ClassLoader.getSystemResourceAsStream("Properties/exclusiva.config.properties");
                    prop.load(propertiesStream2);
                    host = prop.getProperty("conexiones.Host");
                    user = prop.getProperty("conexiones.usuario");
                    port = prop.getProperty("conexiones.Puerto");
                    pass = prop.getProperty("conexiones.contraseña");

                    propertiesStream2.close();
                        
                } catch(IOException e) {
	System.err.println(e);
                }
        }else{
             try {
                 
                  Properties prop = new Properties();
                  InputStream propertiesStream2 = ClassLoader.getSystemResourceAsStream("Properties/compartida.config.properties");
                    prop.load(propertiesStream2);
                    host = prop.getProperty("conexiones.Host");
                    user = prop.getProperty("conexiones.usuario");
                    port = prop.getProperty("conexiones.Puerto");
                    pass = prop.getProperty("conexiones.contraseña");
                  
                    propertiesStream2.close();
                } catch(IOException e) {
	  System.err.println(e);
                }
        }
         String urlDatabase = "jdbc:postgresql://"+ host;
         //String urlDatabase =  "jdbc:postgresql://localhost:5433/db_local";
         //String urlDatabase =  "jdbc:postgresql://localhost:5432/db_local";
         //String urlDatabase =  "jdbc:postgresql://localhost:5432/db_local2";
         //String urlDatabase = "jdbc:postgresql://192.168.1.139:5433/db_local"; //Servidor Prueba
         //String urlDatabase =  "jdbc:postgresql://localhost:5432/Publicidad";
         //String usuario = "postgres";
         //String pass = "1522";
         //String pass = "123";
         //String pass = "12345"; //Servidor Prueba
         
         //String pass = "21octubre97";
         
         
         try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(urlDatabase,  user, pass);
            } catch (Exception e) {
                System.out.println("Ocurrio un error : "+e.getMessage());
            }
         System.out.println("La conexión se realizo sin problemas! =) ");
         
         return conn;
    }
}
