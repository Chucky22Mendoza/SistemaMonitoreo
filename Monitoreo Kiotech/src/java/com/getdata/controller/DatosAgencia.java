/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package com.getdata.controller;

import com.model.controller.ConnectionDB;
import com.objects.controller.Alertas_Agencia_Mes;
import com.objects.controller.Kiosco_Gen;
import java.sql.Array;
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
public class DatosAgencia {
    private ConnectionDB dbSource = null;
    public DatosAgencia(){
        this.dbSource = new ConnectionDB();
    }
    private String agencia;
    public String obtenerAgencia(int id_agencia){
        
        String sql ="select nombe from agencia where id_agencia = ?";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement CStmt = dbConnection.prepareCall(sql);       )            {
            
          CStmt.setInt(1, id_agencia);
          //Variables de Entrada (IN)
          CStmt.execute();
          
          try(  ResultSet rs =(ResultSet)CStmt.getResultSet(); ){
              while(rs.next())
                {
                    agencia = rs.getString(1);
                }
             //System.out.println("Llamada a procedimiento almacenado finalizada correctamente.");
          }
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            //ex.printStackTrace();
        }
        return agencia;
    }
    
    private int total;
    public int obtenerNumAlertas(int id_agencia){
        List<Integer> lista = new ArrayList<>();
        String sql ="select * from vw_contar_dist_alertas where id_agencia = ?";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement CStmt = dbConnection.prepareCall(sql);       )            {
            
          CStmt.setInt(1, id_agencia);
          //Variables de Entrada (IN)
          CStmt.execute();
          
          try(  ResultSet rs =(ResultSet)CStmt.getResultSet(); ){
              while(rs.next())
                {
                  
                    total = rs.getInt(1);
                    if( !(total > 0)){
                        total = 0;
                    }
                }
             //System.out.println("Llamada a procedimiento almacenado finalizada correctamente.");
          }
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            return 0;
        }
        return total;
    }
    
    private int status1;
    public int obtenerNumeroKioscoStatus1(int id_agencia){
        
        String sql ="select * from vw_cont_status where id_status = 1 and id_agencia = ?";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement CStmt = dbConnection.prepareCall(sql);       )            {
            
          CStmt.setInt(1, id_agencia);
          //Variables de Entrada (IN)
          CStmt.execute();
          
          try(  ResultSet rs =(ResultSet)CStmt.getResultSet(); ){
              while(rs.next())
                {
                  
                    status1 = rs.getInt(3);
                    if( !(status1 > 0)){
                        status1 = 0;
                    }
                    
                }
             //System.out.println("Llamada a procedimiento almacenado finalizada correctamente.");
          }
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            return 0;
        }
        return status1;
    }
    
    private int status2;
    public int obtenerNumeroKioscoStatus2(int id_agencia){
        
        String sql ="select * from vw_cont_status where id_status = 2 and id_agencia = ?";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement CStmt = dbConnection.prepareCall(sql);       )            {
            
          CStmt.setInt(1, id_agencia);
          //Variables de Entrada (IN)
          CStmt.execute();
          
          try(  ResultSet rs =(ResultSet)CStmt.getResultSet(); ){
              while(rs.next())
                {
                  
                    status2 = rs.getInt(3);
                    if( !(status2 > 0)){
                        status2 = 0;
                    }
                    
                }
             //System.out.println("Llamada a procedimiento almacenado finalizada correctamente.");
          }
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            return 0;
        }
        return status2;
    }
    
    private int status3;
    public int obtenerNumeroKioscoStatus3(int id_agencia){
        
        String sql ="select * from vw_cont_status where id_status = 3 and id_agencia = ?";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement CStmt = dbConnection.prepareCall(sql);       )            {
            
          CStmt.setInt(1, id_agencia);
          //Variables de Entrada (IN)
          CStmt.execute();
          
          try(  ResultSet rs =(ResultSet)CStmt.getResultSet(); ){
              while(rs.next())
                {
                  
                    status3 = rs.getInt(3);
                    if( !(status3 > 0)){
                        status3 = 0;
                    }
                    
                }
             //System.out.println("Llamada a procedimiento almacenado finalizada correctamente.");
          }
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            return 0;
        }
        return status3;
    }
    
    public List<Alertas_Agencia_Mes> obtenerNumAlertasKiosco(int id_agencia){
        List<Alertas_Agencia_Mes> lista = new ArrayList<Alertas_Agencia_Mes>();
        String sql ="select * from vw_alertas_x_mes where id_agencia = ? and mes = date_part('Month',now()) and agno = date_part('Year',now()) ";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement CStmt = dbConnection.prepareCall(sql);       )            {
            
          CStmt.setInt(1, id_agencia);
          //Variables de Entrada (IN)
          CStmt.execute();
          
          try(  ResultSet rs =(ResultSet)CStmt.getResultSet(); ){
              while(rs.next())
                {
                  Alertas_Agencia_Mes obj = new Alertas_Agencia_Mes();
                    
                  obj.setNombre(rs.getString(2));
                  obj.setStatus(rs.getBoolean(4));
                  obj.setTotal(rs.getInt(5));
                  lista.add(obj);
                }
             //System.out.println("Llamada a procedimiento almacenado finalizada correctamente.");
          }
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            
        }
        return lista;
    }
    
    
}
