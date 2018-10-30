/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GetData;

import Model.ConnectionDB;
import Objects.Session;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jesús Mendoza
 * 
 * OBTENER SI UN USUARIO ES VÁLIDO EN LA BASE DE DATOS Y ENVIARLO AL CONTROLADOR
 */
public class GetDataUser {
    //Llamar a la base de datos para conectividad
    private  ConnectionDB dbSource = null;
    public GetDataUser(){
        this.dbSource = new ConnectionDB();
    }
    
    public Session obtenerUsuario(String user, String contraseña){
        //Variable Objeto tipo Session
        Session dataUser = new Session();
        //SQL que se ejecutará
        String sql ="Select nombre,correo,telefono,agencia,rol,status from vw_usuarios where username like ? and contrasena like ? ";
        try (            Connection dbConnection = dbSource.conectar();
                          //Tipo CallableStatement, otra variante tambien es usar PrepareStatement
                          CallableStatement consultUser = dbConnection.prepareCall(sql);                  ){
            
          //dbConnection.setAutoCommit(false);
          //Variables de Entrada (IN)
          //System.out.println("Preparando llamada a PostgreSQL.");
          consultUser.setString(1, user );
          consultUser.setString(2, contraseña );
          consultUser.execute();
          
          //System.out.println("Procesando resultados de Ejecucion de SELECT.");
          try(  ResultSet userRS =(ResultSet)consultUser.getResultSet(); ){
              while(userRS.next())
                {
                    dataUser.setNombre(userRS.getString(1));
                    dataUser.setCorreo(userRS.getString(2));
                    dataUser.setTelefono(userRS.getString(3));
                    dataUser.setAgencia(userRS.getString(4));
                    dataUser.setRol(userRS.getString(5));
                    dataUser.setStatus(userRS.getBoolean(6));
                }
             //System.out.println("Llamada a PostgreSQL finalizada.");
          }
          catch(SQLException ex){
                  //Cancelar la transaccion
                  dbConnection.rollback();
                  System.out.println("Excepcion: "+ ex.getMessage());
                  }
        }
        catch(Exception ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            //ex.printStackTrace();
        }
        return dataUser;
    }
}
