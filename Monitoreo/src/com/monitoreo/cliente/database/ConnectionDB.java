/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package com.monitoreo.cliente.database;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Jesús Mendoza
 */
public class ConnectionDB {
    public Connection connection = null;
    public String message = "";
    public String StackError = "";
    /*Ingresar datos del properties*/
    public ConnectionDB() throws IOException{
        Properties p = new Properties();
        InputStream propertiesStream = ClassLoader.getSystemResourceAsStream("com/monitoreo/properties/configuracion.properties");
        p.load(propertiesStream);
        
        //getProperty devuelve un String
        String host = p.getProperty("database.host");
        String port = p.getProperty("database.port");
        String db = p.getProperty("database.db");
        String user = p.getProperty("database.user");
        String pass = p.getProperty("database.password");
        
        System.out.println("--- PostgreSQL JDBC Connection ---");
        if  (connection == null){
            // Registrar driver de base de datos
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                
                /*** LOG DE ARCHIVO ***/
                StringWriter errors = new StringWriter();
                e.printStackTrace(new PrintWriter(errors));
                //LogExcepciones.log(e.getMessage(), errors.toString());
                /*********************/
                message = e.getMessage();
                StackError = errors.toString();
                
                System.err.println("En donde esta tu Driver PostgreSQL JDBC ?" + e.getMessage());
                e.printStackTrace();
                connection = null;
                return;
            }
            System.out.println("PostgreSQL JDBC Driver registrado OK!");
            
            // Realizar conexi'on con servidor
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+db, user,pass);
                //connection = DriverManager.getConnection("jdbc:postgresql://192.168.1.139:5433/db_local", "postgres","12345");
            } catch (SQLException e) {
                
                /*** LOG DE ARCHIVO ***/
                StringWriter errors = new StringWriter();
                e.printStackTrace(new PrintWriter(errors));
                //LogExcepciones.log(e.getMessage(), errors.toString());
                /*********************/
                message = e.getMessage();
                StackError = errors.toString();
                
                System.err.println("Conexion fallida! Verifica la salida de consola");
                e.printStackTrace();
                connection = null;
                return;
            }
            
            // Verificar la conexion OK.
            if (connection != null) {
                    System.out.println("Conexion realizada!");
            } else {
                    System.out.println("Fallo al realizar la conexion!");
            }
        }
    }

    //M'etodo generico para consulta de entidades
    public ResultSet execQuery(String query){
        ResultSet rs = null;
        try{
            PreparedStatement prst = connection.prepareStatement(query);
            rs = prst.executeQuery();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rs;  
    }
}