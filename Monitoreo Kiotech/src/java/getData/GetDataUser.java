/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getData;

import Model.ConnectionDB;
import Objects.Login;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jesús Mendoza
 */
public class GetDataUser {
    //Llamar a la base de datos para conectividad
    private  ConnectionDB dbSource = null;
    public GetDataUser(){
        this.dbSource = new ConnectionDB();
    }
    
    public Login obtenerUsuario(String user, String contraseña){
        //Variable Objeto tipo Login
        Login dataUser = new Login();
        //SQL que se ejecutará
        String sql ="Select nombre, correo, agencia from usuario where username like ? and contraseña like ? ";
        try (            Connection dbConnection = dbSource.conectar().getConnection();
                          //Tipo CallableStatement, otra variante tambien es usar PrepareStatement
                          CallableStatement consultUser = dbConnection.prepareCall(sql);                  ){
            
          //dbConnection.setAutoCommit(false);
          //Variables de Entrada (IN)
          System.out.println("Preparando llamada a PostgreSQL.");
          consultUser.setString(1, user );
          consultUser.setString(2, contraseña );
          consultUser.execute();
          
          System.out.println("Procesando resultados de Ejecucion de SELECT.");
          try(  ResultSet userRS =(ResultSet)consultUser.getResultSet(); ){
              while(userRS.next())
                {
                    dataUser.setNombre(userRS.getString(1));
                    dataUser.setCorreo(userRS.getString(2));
                    dataUser.setAgencia(userRS.getString(3));
                }
             System.out.println("Llamada a PostgreSQL finalizada.");
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
