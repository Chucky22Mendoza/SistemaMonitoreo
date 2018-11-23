/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package com.getdata.controller;

import com.model.controller.ConnectionDB;
import com.objects.controller.Contenedor_Actual;
import com.objects.controller.Denom_Dispensada;
import com.objects.controller.Disp_Vending;
import com.objects.controller.Impresora;
import com.objects.controller.Kiosco_Gen;
import com.objects.controller.Total_X_Denomimacion_Recibida;
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
public class DatosKiosco {
    private ConnectionDB dbSource = null;
    public DatosKiosco(){
        this.dbSource = new ConnectionDB();
    }
    
    public List<Kiosco_Gen> obtenerKiosco(int id_kiosco){
        List<Kiosco_Gen> lista = new ArrayList<>();
        String sql ="select ki.id_kiosco,ki.nombre,ag.nombre as agencia,ag.ubicacion,ki.ip,ki.id_status from kiosco ki inner join agencia ag on ki.id_agencia = ag.id_agencia where id_kiosco = ?";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement CStmt = dbConnection.prepareCall(sql);       )            {
            
          CStmt.setInt(1, id_kiosco);
          //Variables de Entrada (IN)
          CStmt.execute();
          
          try(  ResultSet rs =(ResultSet)CStmt.getResultSet(); ){
              while(rs.next())
                {
                  
                    Kiosco_Gen obj= new Kiosco_Gen();
                    obj.setId_kiosco(rs.getInt(1));
                    obj.setNombre(rs.getString(2));
                    obj.setAgencia(rs.getString(3));
                    obj.setUbicacion(rs.getString(4));
                    obj.setIp(rs.getString(5));
                    obj.setId_status(rs.getInt(6));
                    
                    lista.add(obj);
                }
             //System.out.println("Llamada a procedimiento almacenado finalizada correctamente.");
          }
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            //ex.printStackTrace();
        }
        return lista;
    }
    private int resAlertas;
    public int numAlertas(int id_kiosco){
        
        String sql ="select count(id_kiosco) from historial_alerta where status = false and id_kiosco = ?";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement CStmt = dbConnection.prepareCall(sql);       )            {
            
          CStmt.setInt(1, id_kiosco);
          //Variables de Entrada (IN)
          CStmt.execute();
          
          try(  ResultSet rs =(ResultSet)CStmt.getResultSet(); ){
              while(rs.next())
                {                    
                    resAlertas = rs.getInt(1);
                }
          }
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            return -1;
        }
        return resAlertas;
    }
    
    public List<Disp_Vending> obtenerDV(int id_kiosco){
        List<Disp_Vending> lista = new ArrayList<>();
        String sql ="select dv.id_dispositivo_vending, dv.nombre, det.status from det_dispositivo_vending_kiosco as det inner join dispositivo_vending as dv on dv.id_dispositivo_vending = det.id_dispositivo_vending where det.id_kiosco = ?";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement CStmt = dbConnection.prepareCall(sql);       )            {
            
          CStmt.setInt(1, id_kiosco);
          //Variables de Entrada (IN)
          CStmt.execute();
          
          try(  ResultSet rs =(ResultSet)CStmt.getResultSet(); ){
              while(rs.next())
                {
                  
                    Disp_Vending obj= new Disp_Vending();
                    obj.setId_disp_vend(rs.getInt(1));
                    obj.setNombre(rs.getString(2));
                    obj.setStatus(rs.getBoolean(3));
                    
                    lista.add(obj);
                }
             //System.out.println("Llamada a procedimiento almacenado finalizada correctamente.");
          }
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            //ex.printStackTrace();
        }
        return lista;
    }
    
    public List<Impresora> obtenerImpresora(int id_kiosco){
        List<Impresora> lista = new ArrayList<>();
        String sql ="select nombre,folio_inicial,folio_final,total_folios from impresora where id_kiosco = ?";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement CStmt = dbConnection.prepareCall(sql);       )            {
            
          CStmt.setInt(1, id_kiosco);
          //Variables de Entrada (IN)
          CStmt.execute();
          
          try(  ResultSet rs =(ResultSet)CStmt.getResultSet(); ){
              while(rs.next())
                {
                  
                    Impresora obj= new Impresora();
                    obj.setNombre(rs.getString(1));
                    obj.setFolio_inicial(rs.getInt(2));
                    obj.setFolio_final(rs.getInt(3));
                    obj.setTotal(rs.getInt(4));
                    
                    lista.add(obj);
                }
             //System.out.println("Llamada a procedimiento almacenado finalizada correctamente.");
          }
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            //ex.printStackTrace();
        }
        return lista;
    }
    
   private String resCorteCaja;
   public String obtenerCorteCaja(int id_kiosco){
        
        String sql ="select max(fecha_hora) from corte_caja where id_kiosco = ?";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement CStmt = dbConnection.prepareCall(sql);       )            {
            
          CStmt.setInt(1, id_kiosco);
          //Variables de Entrada (IN)
          CStmt.execute();
          
          try(  ResultSet rs =(ResultSet)CStmt.getResultSet(); ){
              while(rs.next())
                {
                    resCorteCaja = rs.getString(1);
                }
             //System.out.println("Llamada a procedimiento almacenado finalizada correctamente.");
          }
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            //ex.printStackTrace();
            resCorteCaja = "No existe corte de caja aún";
        }
        return resCorteCaja;
    }
    
    private String totalRec;
    public String totalRecibido(int id_kiosco){
        
        String sql ="select total_recibido from vw_total_recibido where id_kiosco = ?";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement CStmt = dbConnection.prepareCall(sql);       )            {
            
          CStmt.setInt(1, id_kiosco);
          //Variables de Entrada (IN)
          CStmt.execute();
          
          try(  ResultSet rs =(ResultSet)CStmt.getResultSet(); ){
              while(rs.next())
                {
                    totalRec = rs.getString(1);
                }
          }
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            totalRec = "Es posible que aún no exista alguna transacción";
        }
        return totalRec;
    }
    
    public List<Total_X_Denomimacion_Recibida> denomRecibidas(int id_kiosco){
        List<Total_X_Denomimacion_Recibida> lista = new ArrayList<>();
        String sql ="select * from vw_total_x_denom_recibida where id_kiosco = ?";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement CStmt = dbConnection.prepareCall(sql);       )            {
            
          CStmt.setInt(1, id_kiosco);
          //Variables de Entrada (IN)
          CStmt.execute();
          
          try(  ResultSet rs =(ResultSet)CStmt.getResultSet(); ){
              while(rs.next())
                {
                  
                    Total_X_Denomimacion_Recibida obj= new Total_X_Denomimacion_Recibida();
                    obj.setNombre(rs.getString(2));
                    obj.setTotal(rs.getInt(3));
                    
                    lista.add(obj);
                }
             //System.out.println("Llamada a procedimiento almacenado finalizada correctamente.");
          }
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            //ex.printStackTrace();
        }
        return lista;
    }
    
    public List<Contenedor_Actual> contenedorActual(int id_kiosco){
        List<Contenedor_Actual> lista = new ArrayList<>();
        String sql ="select * from vw_contenedor_actual where id_kiosco = ?";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement CStmt = dbConnection.prepareCall(sql);       )            {
            
          CStmt.setInt(1, id_kiosco);
          //Variables de Entrada (IN)
          CStmt.execute();
          
          try(  ResultSet rs =(ResultSet)CStmt.getResultSet(); ){
              while(rs.next())
                {
                    Contenedor_Actual obj = new Contenedor_Actual();
                    
                    obj.setNombre(rs.getString(2));
                    obj.setCantidad_actual(rs.getInt(3));
                    obj.setCantidad_total(rs.getInt(4));
                    lista.add(obj);
                }
          }
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            //ex.printStackTrace();
        }
        return lista;
    }
    
    private String efec_disponible;
    public String efectivoDisponible(int id_kiosco){
        String sql ="select * from vw_total_dispensado where id_kiosco = ?";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement CStmt = dbConnection.prepareCall(sql);       )            {
            
          CStmt.setInt(1, id_kiosco);
          //Variables de Entrada (IN)
          CStmt.execute();
          
          try(  ResultSet rs =(ResultSet)CStmt.getResultSet(); ){
              while(rs.next())
                {
                    efec_disponible = rs.getString(2);
                }
          }
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            return "Es posible que aún no exista alguna transacción";
            //ex.printStackTrace();
        }
        return efec_disponible;
    }
    
    public List<Denom_Dispensada> denominacionDispensada(int id_kiosco){
        List<Denom_Dispensada> lista = new ArrayList<>();
        String sql ="select * from vw_total_x_denom_dispensada where id_kiosco = ?";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement CStmt = dbConnection.prepareCall(sql);       )            {
            
          CStmt.setInt(1, id_kiosco);
          //Variables de Entrada (IN)
          CStmt.execute();
          
          try(  ResultSet rs =(ResultSet)CStmt.getResultSet(); ){
              while(rs.next())
                {
                    Denom_Dispensada obj = new Denom_Dispensada();
                    
                    obj.setCantidad_total(rs.getInt(2));
                    obj.setNombre(rs.getString(3));
                    obj.setCantidad_minima(rs.getInt(4));
                    
                    lista.add(obj);
                }
          }
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            //ex.printStackTrace();
        }
        return lista;
    }
    
     public int mantenimiento(int id_kiosco){
        
        String sql ="update kiosco set status_mantenimiento=true where id_kiosco = ?";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement CStmt = dbConnection.prepareCall(sql);       )            {
            
          dbConnection.setAutoCommit(false);
          CStmt.setInt(1, id_kiosco);
          //Variables de Entrada (IN)
          int res = CStmt.executeUpdate();
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
     
     public int apagado(int id_kiosco){
        
        String sql ="update kiosco set id_status=3 where id_kiosco = ?";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement CStmt = dbConnection.prepareCall(sql);       )            {
            
          dbConnection.setAutoCommit(false);
          CStmt.setInt(1, id_kiosco);
          //Variables de Entrada (IN)
          int res = CStmt.executeUpdate();
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
