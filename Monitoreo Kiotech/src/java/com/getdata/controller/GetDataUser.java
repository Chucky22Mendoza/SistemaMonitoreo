/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.getdata.controller;

import com.model.controller.ConnectionDB;
import com.objects.controller.Login;
import com.objects.controller.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
    public Login obtenerUsuario(String user, String contraseña){
        //Variable Objeto tipo Login
        Login dataUser = new Login();
        //SQL que se ejecutará
        String sql ="Select id_usuario,nombre,correo,telefono,agencia,rol,status from vw_usuarios where username like ? and contrasena like ? ";
        try (            Connection dbConnection = dbSource.conectar().getConnection();
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
                    dataUser.setId_usuario(userRS.getInt(1));
                    dataUser.setNombre(userRS.getString(2));
                    dataUser.setCorreo(userRS.getString(3));
                    dataUser.setTelefono(userRS.getString(4));
                    dataUser.setAgencia(userRS.getString(5));
                    dataUser.setRol(userRS.getString(6));
                    dataUser.setStatus(userRS.getBoolean(7));
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
    
    public List<Usuario> obtenerUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        String sql ="select id_usuario,nombre,agencia,correo,telefono from vw_usuarios order by id_usuario";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement obtenerUsuarios = dbConnection.prepareCall(sql);       )            {

          //Variables de Entrada (IN)
          //System.out.println("Preparando llamada a procedimiento almacenado.");
          obtenerUsuarios.execute();
          //System.out.println("Procesando resultados de llamada a procedimiento almacenado.");
          try(  ResultSet usuariosRS =(ResultSet)obtenerUsuarios.getResultSet(); ){
              while(usuariosRS.next())
              {                  
                    Usuario usuario= new Usuario();
                    usuario.setId(usuariosRS.getInt(1));
                    usuario.setNombre(usuariosRS.getString(2));
                    usuario.setAgencia(usuariosRS.getString(3));
                    usuario.setCorreo(usuariosRS.getString(4));
                    usuario.setCelular(usuariosRS.getString(5));
                    
                    usuarios.add(usuario);
                }
             //System.out.println("Llamada a procedimiento almacenado finalizada correctamente.");
          }
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            //ex.printStackTrace();
        }
        return usuarios;
    }
}
