/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GetData;

import Objects.Kiosco;
import modelo.ConnectionDB;
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
    

    public Session GetVerificarKiosco(String usuario, String contraseña) {
        
         dbSource = new ConnectionDB();
         Session s=new Session();
              String sql ="Select status,id_usuario from Usuario where username=? and password=? ";
        try (Connection dbConnection = dbSource.conectar();CallableStatement consultUser = dbConnection.prepareCall(sql);)
        {
              consultUser.setString(1, usuario);
              consultUser.setString(2, contraseña);
              consultUser.execute();
          
      
          try(  ResultSet userRS =(ResultSet)consultUser.getResultSet(); ){
              while(userRS.next())
                {
                    System.out.println(userRS.getInt(2));
                    System.out.println(userRS.getBoolean(1));
                    
                   s.setId(userRS.getInt(2));
                   s.setStatus(userRS.getBoolean(1));
                   }
          }catch(SQLException ex){
                  dbConnection.rollback();
                  System.out.println("Excepcion: "+ ex.getMessage());
                  }
        }
        catch(Exception ex){
            System.out.println("Excepcion: "+ ex.getMessage());
         
        }
        
         return s; 
    }
    
    public Kiosco ConsultarStatusKiosco(int idUsuario){
        dbSource = new ConnectionDB();
        Kiosco k=new Kiosco();
        
        String sql ="select ki.id_kiosco,ki.nombre,ki.status_mantenimiento from permiso_alerta_kiosco as pak inner"
                + " join kiosco as ki on ki.id_kiosco = pak.id_kiosco where pak.id_usuario = ?";

        try (Connection dbConnection = dbSource.conectar();CallableStatement consultUser = dbConnection.prepareCall(sql);)
        {
              consultUser.setInt(1, idUsuario);
              consultUser.execute();
          
      
          try(  ResultSet userRS =(ResultSet)consultUser.getResultSet(); ){
              while(userRS.next())
                {
                   k.setId_kisoco(userRS.getInt(1));
                   k.setNombre(userRS.getString(2));
                   k.setStatus(userRS.getBoolean(3));
                   
                   }
          }catch(SQLException ex){
                  dbConnection.rollback();
                  System.out.println("Excepcion: "+ ex.getMessage());
                  }
        }
        catch(Exception ex){
            System.out.println("Excepcion: "+ ex.getMessage());
         
        }
        return k;
    
    }
    
    
    
}
