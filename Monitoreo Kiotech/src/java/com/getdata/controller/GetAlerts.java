/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.getdata.controller;

import com.model.controller.ConnectionDB;
import com.objects.controller.Historial;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesús Mendoza
 */
public class GetAlerts {
    //Llamar a la base de datos para conectividad
    private ConnectionDB dbSource = null;
    public GetAlerts(){
        this.dbSource = new ConnectionDB();
    }
    
    public List<Historial> obtenerAlertas(){
        List<Historial> historial = new ArrayList<>();
        String sql ="select * from vw_historial_alerta order by id_historial_alerta";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement obtenerAlertas = dbConnection.prepareCall(sql);       )            {

          //Variables de Entrada (IN)
          //System.out.println("Preparando llamada a procedimiento almacenado.");
          obtenerAlertas.execute();
          //System.out.println("Procesando resultados de llamada a procedimiento almacenado.");
          try(  ResultSet alertasRS =(ResultSet)obtenerAlertas.getResultSet(); ){
              while(alertasRS.next())
                {
                  //System.out.println("--> "+statusRS.getInt(1));
                  //System.out.println("--> "+statusRS.getString(2));
                  
                    Historial his= new Historial();
                    his.setId(alertasRS.getInt(1));
                    his.setFechaHora(alertasRS.getString(2));
                    his.setTipoAlerta(alertasRS.getString(3));
                    his.setMensaje(alertasRS.getString(4));
                    his.setKiosco(alertasRS.getString(5));
                    his.setStatus(alertasRS.getBoolean(6));
                    
                    historial.add(his);
                }
            // System.out.println("Llamada a procedimiento almacenado finalizada correctamente.");
          }
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            //ex.printStackTrace();
        }
        return historial;
    }
    
    public List<Historial> obtenerAlertas(int id){
        List<Historial> historial = new ArrayList<>();
        String sql ="select * from vw_historial_alerta_usuario where id_usuario = ?";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement obtenerAlertas = dbConnection.prepareCall(sql);       )            {

          //Variables de Entrada (IN)
          //System.out.println("Preparando llamada a procedimiento almacenado.");
          obtenerAlertas.setInt(1,id);
          obtenerAlertas.execute();
          //System.out.println("Procesando resultados de llamada a procedimiento almacenado.");
          try(  ResultSet alertasRS =(ResultSet)obtenerAlertas.getResultSet(); ){
              while(alertasRS.next())
                {
                  //System.out.println("--> "+statusRS.getInt(1));
                  //System.out.println("--> "+statusRS.getString(2));
                  
                    Historial his= new Historial();
                    his.setId(alertasRS.getInt(1));
                    his.setFechaHora(alertasRS.getString(2));
                    his.setTipoAlerta(alertasRS.getString(3));
                    his.setMensaje(alertasRS.getString(4));
                    his.setKiosco(alertasRS.getString(5));
                    his.setStatus(alertasRS.getBoolean(6));

                    historial.add(his);
                }
            // System.out.println("Llamada a procedimiento almacenado finalizada correctamente.");
          }
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            //ex.printStackTrace();
        }
        return historial;
    }
    
    public int uptdateStatus(boolean status,int id){
        
        String sql ="update historial_alerta set status = ? where id_historial_alerta = ?";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement cambiarStatus = dbConnection.prepareCall(sql);       )            {
          
          dbConnection.setAutoCommit(false);
          
          cambiarStatus.setBoolean(1, status);
          cambiarStatus.setInt(2, id);
          int res =  cambiarStatus.executeUpdate();
          
          if(res == 1){
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
