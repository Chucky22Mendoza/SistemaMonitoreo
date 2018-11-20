/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Jesús Mendoza
 */
public class ConnectionDB {
    
            
     public Connection conectar(){
         
         Connection con = null;
         //String urlDatabase =  "jdbc:postgresql://localhost:5433/db_local";
         String urlDatabase =  "jdbc:postgresql://localhost:5432/db_local";
         //String urlDatabase =  "jdbc:postgresql://localhost:5432/db_local2";
         //String urlDatabase = "jdbc:postgresql://192.168.1.139:5433/db_local"; //Servidor Prueba
         //String urlDatabase =  "jdbc:postgresql://localhost:5432/Publicidad";
         String usuario = "postgres";
         //String pass = "1522";
         //String pass = "123";
         //String pass = "12345"; //Servidor Prueba
         String pass = "21octubre97";
         
         
         try {
                Class.forName("org.postgresql.Driver");
                con = DriverManager.getConnection(urlDatabase,  usuario, pass);
            } catch (Exception e) {
                System.out.println("Ocurrio un error : "+e.getMessage());
            }
         System.out.println("La conexión se realizo sin problemas! =) ");
         
         return con;
    }
}
