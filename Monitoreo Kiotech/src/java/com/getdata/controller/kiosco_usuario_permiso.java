/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package com.getdata.controller;

import com.model.controller.ConnectionDB;
import com.objects.controller.PermisoAlertaKiosco;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesús Mendoza Verduzco
 */
public class kiosco_usuario_permiso {
    //Llamar a la base de datos para conectividad
    private ConnectionDB dbSource = null;
    public kiosco_usuario_permiso(){
        this.dbSource = new ConnectionDB();
    }
    
    public List<Integer> obtenerKioscoPermiso(int id_usuario){
        List<Integer> listKiosco = new ArrayList<>();
        String sql ="select id_kiosco from permiso_alerta_kiosco where id_usuario = ?";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement kiosco = dbConnection.prepareCall(sql);       )            {

          //Variables de Entrada (IN)
          //System.out.println("Preparando llamada a procedimiento almacenado.");
          kiosco.setInt(1, id_usuario);
          kiosco.execute();
          //System.out.println("Procesando resultados de llamada a procedimiento almacenado.");
          try(  ResultSet kioscoRS =(ResultSet)kiosco.getResultSet(); ){
              while(kioscoRS.next())
                {
                  
                    int kio = kioscoRS.getInt(1);
                    
                    listKiosco.add(kio);
                }
            // System.out.println("Llamada a procedimiento almacenado finalizada correctamente.");
          }
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            //ex.printStackTrace();
        }
        return listKiosco;
    }
    
    public List<Integer> obtenerKiosco(int id_usuario){
        List<Integer> listKiosco = new ArrayList<>();
        String sql ="select id_kiosco from permiso_alerta_kiosco where id_usuario = ?";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement kiosco = dbConnection.prepareCall(sql);       )            {

          //Variables de Entrada (IN)
          //System.out.println("Preparando llamada a procedimiento almacenado.");
          kiosco.setInt(1, id_usuario);
          kiosco.execute();
          //System.out.println("Procesando resultados de llamada a procedimiento almacenado.");
          try(  ResultSet kioscoRS =(ResultSet)kiosco.getResultSet(); ){
              while(kioscoRS.next())
                {
                    
                    int permiso = kioscoRS.getInt(1);
                    
                    listKiosco.add(permiso);
                }
            // System.out.println("Llamada a procedimiento almacenado finalizada correctamente.");
          }
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            //ex.printStackTrace();
        }
        return listKiosco;
    }
    
    public List<PermisoAlertaKiosco> obtenerPermisoKiosco(int id_usuario){
        List<PermisoAlertaKiosco> listKiosco = new ArrayList<>();
        String sql = "Select ki.id_kiosco,ki.nombre,aux.id_usuario from (Select us.id_usuario, ag.id_agencia from usuario as us inner join agencia as ag on ag.id_agencia = us.id_agencia) as aux inner join kiosco as ki on ki.id_agencia = aux.id_agencia where id_usuario = ? order by ki.id_kiosco";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement kiosco = dbConnection.prepareCall(sql);       )            {

          //Variables de Entrada (IN)
          //System.out.println("Preparando llamada a procedimiento almacenado.");
          kiosco.setInt(1, id_usuario);
          kiosco.execute();
          //System.out.println("Procesando resultados de llamada a procedimiento almacenado.");
          try(  ResultSet kioscoRS =(ResultSet)kiosco.getResultSet(); ){
              while(kioscoRS.next())
                {
                    PermisoAlertaKiosco permiso = new PermisoAlertaKiosco();                   
                    
                    permiso.setId_kiosco(kioscoRS.getInt(1));
                    permiso.setNombre(kioscoRS.getString(2));
                    permiso.setId_usuario(kioscoRS.getInt(3));
                    
                    listKiosco.add(permiso);
                }
            // System.out.println("Llamada a procedimiento almacenado finalizada correctamente.");
          }
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            //ex.printStackTrace();
        }
        return listKiosco;
    }
    
    public int eliminar_permiso(int id_usuario){
        
        String sql = "delete from permiso_alerta_kiosco where id_usuario = ?";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement kiosco = dbConnection.prepareCall(sql);       )            {

          //Variables de Entrada (IN)
          //System.out.println("Preparando llamada a procedimiento almacenado.");
          dbConnection.setAutoCommit(false);
          kiosco.setInt(1, id_usuario);
          int res = kiosco.executeUpdate();
          System.err.println("Proceso Eliminar---------- " + res);
          if(res>0){  
              dbConnection.commit();
              return 1;
          }else{
              dbConnection.rollback();
              return 0;
          }
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            return 0;
        }
    }
    
    public int registrar_permiso(int id_kiosco, int id_usuario){
        
        String sql = "insert into permiso_alerta_kiosco values(default,?,?)";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement kiosco = dbConnection.prepareCall(sql);       )            {

          //Variables de Entrada (IN)
          //System.out.println("Preparando llamada a procedimiento almacenado.");
          dbConnection.setAutoCommit(false);
          kiosco.setInt(1, id_kiosco);
          kiosco.setInt(2, id_usuario);
          int res = kiosco.executeUpdate();
            System.err.println("Proceso Registro---------- " + res);
          if(res > 0){
              dbConnection.commit();
              return 1;
          }else{
              dbConnection.rollback();
              return 0;
          }
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            return 0;
        }
    }
    
        public int eliminar_permiso_evento(int id_usuario){
        
        String sql = "delete from permiso_alerta_evento where id_usuario = ?";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement kiosco = dbConnection.prepareCall(sql);       )            {

          //Variables de Entrada (IN)
          //System.out.println("Preparando llamada a procedimiento almacenado.");
          dbConnection.setAutoCommit(false);
          kiosco.setInt(1, id_usuario);
          int res = kiosco.executeUpdate();
          System.err.println("Proceso Eliminar---------- " + res);
          if(res>0){  
              dbConnection.commit();
              return 1;
          }else{
              dbConnection.rollback();
              return 0;
          }
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            return 0;
        }
    }
    
    public int registrar_permiso_evento(boolean sms, boolean correo,int id_evento, int id_usuario){
        
        String sql = "insert into permiso_alerta_evento values(default,?,?,?,?)";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement kiosco = dbConnection.prepareCall(sql);       )            {

          //Variables de Entrada (IN)
          //System.out.println("Preparando llamada a procedimiento almacenado.");
          dbConnection.setAutoCommit(false);
          kiosco.setBoolean(1,sms);
          kiosco.setBoolean(2,correo);
          kiosco.setInt(3, id_evento);
          kiosco.setInt(4, id_usuario);
          
          int res = kiosco.executeUpdate();
            
          if(res > 0){
              dbConnection.commit();
              return 1;
          }else{
              dbConnection.rollback();
              return 0;
          }
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            return 0;
        }
    }
}
