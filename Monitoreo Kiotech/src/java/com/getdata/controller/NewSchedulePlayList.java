/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.getdata.controller;

import com.model.controller.ConnectionDB;
import com.objects.controller.ListaProgramada;
import java.sql.CallableStatement;
import java.sql.Connection;

/**
 *
 * @author Jesús Mendoza
 */
public class NewSchedulePlayList {
    //Llamar a la base de datos para conectividad
    private ConnectionDB dbSource = null;
    public NewSchedulePlayList(){
        this.dbSource = new ConnectionDB();
    }
    
    public int nuevoArchivo(ListaProgramada obj){
    
    String sql ="{call fn_insert_lista_programada(?,?,?,?,?,?,?,?,?,?)}";
    

    try (
           Connection dbConnection = dbSource.conectar().getConnection();
            //Tipo CallableStatement, otra variante tambien es usar PrepareStatement
            CallableStatement nuevoObj= dbConnection.prepareCall(sql);
           )            
        {
        //fechaestreno,duracion,fecha_registro,fecha_actualizacion
        dbConnection.setAutoCommit(false);
        //Variables de Entrada (IN)
        //System.err.println("Preparando llamada a PostgreSQL. ---> ");
            //System.err.println("fn_insert_archivos('"+obj.getNombre()+"'," + obj.getDuracion()+",'"+obj.getUbicacion()+"','"+obj.getTipo()+"')");
            
        nuevoObj.setString(1, obj.getHoraInicio());
        nuevoObj.setBoolean(2, obj.getDomingo());
        nuevoObj.setBoolean(3, obj.getLunes());
        nuevoObj.setBoolean(4, obj.getMartes());
        nuevoObj.setBoolean(5, obj.getMiercoles());
        nuevoObj.setBoolean(6, obj.getJueves());
        nuevoObj.setBoolean(7, obj.getViernes());
        nuevoObj.setBoolean(8, obj.getSabado());
        nuevoObj.setInt(9, obj.getIdKiosco());
        nuevoObj.setInt(10, obj.getIdLista());

        boolean res = nuevoObj.execute();

        //System.err.println("<------------------------------------------------ !!!!  " + res);

        if(res){
            //Finalizamos la transaccion
            dbConnection.commit();
            //System.err.println("Llamada a PostgreSQL finalizada.");
            return 1;
        }else{
            //Si hubo un error, cancelamos la transaccion.
            dbConnection.rollback();
            return 0;
        }

      }
      catch(Exception ex){
          System.err.println("Excepcion2: "+ ex.getMessage());
          //ex.printStackTrace();
          return 0;
      }
    
    }
    
    public int uptHoraInicio(String obj, int lista, int kiosco){
    
    String sql ="{call fn_update_hrinicio_lista_programada(?,?,?)}";

    try (
           Connection dbConnection = dbSource.conectar().getConnection();
            //Tipo CallableStatement, otra variante tambien es usar PrepareStatement
            CallableStatement nuevoObj= dbConnection.prepareCall(sql);
           )            
        {
        
        dbConnection.setAutoCommit(false);
        //Variables de Entrada (IN)
        //System.err.println("Preparando llamada a PostgreSQL. ---> ");
            //System.err.println("fn_insert_archivos('"+obj.getNombre()+"'," + obj.getDuracion()+",'"+obj.getUbicacion()+"','"+obj.getTipo()+"')");
            
        nuevoObj.setString(1, obj);
        nuevoObj.setInt(2, kiosco);
        nuevoObj.setInt(3, lista);

        boolean res = nuevoObj.execute();

        //System.err.println("<------------------------------------------------ !!!!  " + res);

        if(res){
            //Finalizamos la transaccion
            dbConnection.commit();
            //System.err.println("Llamada a PostgreSQL finalizada.");
            return 1;
        }else{
            //Si hubo un error, cancelamos la transaccion.
            dbConnection.rollback();
            return 0;
        }

      }
      catch(Exception ex){
          System.err.println("Excepcion2: "+ ex.getMessage());
          //ex.printStackTrace();
          return 0;
      }
    
    }
    
    public int uptDomingo(Boolean obj,int lista, int kiosco){
    
    String sql ="update lista_programada set domingo = ? where id_lista_reproduccion = ? and id_kiosco = ?";

    try (
           Connection dbConnection = dbSource.conectar().getConnection();
            //Tipo CallableStatement, otra variante tambien es usar PrepareStatement
            CallableStatement nuevoObj= dbConnection.prepareCall(sql);
           )            
        {
        //fechaestreno,duracion,fecha_registro,fecha_actualizacion
        dbConnection.setAutoCommit(false);
        //Variables de Entrada (IN)
        //System.err.println("Preparando llamada a PostgreSQL. ---> ");
            //System.err.println("fn_insert_archivos('"+obj.getNombre()+"'," + obj.getDuracion()+",'"+obj.getUbicacion()+"','"+obj.getTipo()+"')");
            
        nuevoObj.setBoolean(1, obj);
        nuevoObj.setInt(2, lista);
        nuevoObj.setInt(3, kiosco);

        int res = nuevoObj.executeUpdate();

        //System.err.println("<------------------------------------------------ !!!!  " + res);

        if(res == 1){
            //Finalizamos la transaccion
            dbConnection.commit();
            //System.err.println("Llamada a PostgreSQL finalizada.");
            return 1;
        }else{
            //Si hubo un error, cancelamos la transaccion.
            dbConnection.rollback();
            return 0;
        }

      }
      catch(Exception ex){
          System.err.println("Excepcion2: "+ ex.getMessage());
          //ex.printStackTrace();
          return 0;
      }
    
    }
    
    
    public int uptLunes(Boolean obj, int lista, int kiosco){
    
    String sql ="update lista_programada set lunes = ? where id_lista_reproduccion = ? and id_kiosco = ?";

    try (
           Connection dbConnection = dbSource.conectar().getConnection();
            //Tipo CallableStatement, otra variante tambien es usar PrepareStatement
            CallableStatement nuevoObj= dbConnection.prepareCall(sql);
           )            
        {
        //fechaestreno,duracion,fecha_registro,fecha_actualizacion
        dbConnection.setAutoCommit(false);
        //Variables de Entrada (IN)
        //System.err.println("Preparando llamada a PostgreSQL. ---> ");
            //System.err.println("fn_insert_archivos('"+obj.getNombre()+"'," + obj.getDuracion()+",'"+obj.getUbicacion()+"','"+obj.getTipo()+"')");
            
        nuevoObj.setBoolean(1, obj);
        nuevoObj.setInt(2, lista);
        nuevoObj.setInt(3, kiosco);

        int res = nuevoObj.executeUpdate();

        //System.err.println("<------------------------------------------------ !!!!  " + res);

        if(res == 1){
            //Finalizamos la transaccion
            dbConnection.commit();
            //System.err.println("Llamada a PostgreSQL finalizada.");
            return 1;
        }else{
            //Si hubo un error, cancelamos la transaccion.
            dbConnection.rollback();
            return 0;
        }

      }
      catch(Exception ex){
          System.err.println("Excepcion2: "+ ex.getMessage());
          //ex.printStackTrace();
          return 0;
      }
    
    }
    
    public int uptMartes(Boolean obj, int lista, int kiosco){
    
    String sql ="update lista_programada set martes = ? where id_lista_reproduccion = ? and id_kiosco = ?";

    try (
           Connection dbConnection = dbSource.conectar().getConnection();
            //Tipo CallableStatement, otra variante tambien es usar PrepareStatement
            CallableStatement nuevoObj= dbConnection.prepareCall(sql);
           )            
        {
        //fechaestreno,duracion,fecha_registro,fecha_actualizacion
        dbConnection.setAutoCommit(false);
        //Variables de Entrada (IN)
        //System.err.println("Preparando llamada a PostgreSQL. ---> ");
            //System.err.println("fn_insert_archivos('"+obj.getNombre()+"'," + obj.getDuracion()+",'"+obj.getUbicacion()+"','"+obj.getTipo()+"')");
            
        nuevoObj.setBoolean(1, obj);
        nuevoObj.setInt(2, lista);
        nuevoObj.setInt(3, kiosco);

        int res = nuevoObj.executeUpdate();

        //System.err.println("<------------------------------------------------ !!!!  " + res);

        if(res == 1){
            //Finalizamos la transaccion
            dbConnection.commit();
            //System.err.println("Llamada a PostgreSQL finalizada.");
            return 1;
        }else{
            //Si hubo un error, cancelamos la transaccion.
            dbConnection.rollback();
            return 0;
        }

      }
      catch(Exception ex){
          System.err.println("Excepcion2: "+ ex.getMessage());
          //ex.printStackTrace();
          return 0;
      }
    
    }
    
    public int uptMiercoles(Boolean obj, int lista, int kiosco){
    
    String sql ="update lista_programada set miercoles = ? where id_lista_reproduccion = ? and id_kiosco = ?";

    try (
           Connection dbConnection = dbSource.conectar().getConnection();
            //Tipo CallableStatement, otra variante tambien es usar PrepareStatement
            CallableStatement nuevoObj= dbConnection.prepareCall(sql);
           )            
        {
        //fechaestreno,duracion,fecha_registro,fecha_actualizacion
        dbConnection.setAutoCommit(false);
        //Variables de Entrada (IN)
        //System.err.println("Preparando llamada a PostgreSQL. ---> ");
            //System.err.println("fn_insert_archivos('"+obj.getNombre()+"'," + obj.getDuracion()+",'"+obj.getUbicacion()+"','"+obj.getTipo()+"')");
            
        nuevoObj.setBoolean(1, obj);
        nuevoObj.setInt(2, lista);
        nuevoObj.setInt(3, kiosco);

        int res = nuevoObj.executeUpdate();

        //System.err.println("<------------------------------------------------ !!!!  " + res);

        if(res == 1){
            //Finalizamos la transaccion
            dbConnection.commit();
            //System.err.println("Llamada a PostgreSQL finalizada.");
            return 1;
        }else{
            //Si hubo un error, cancelamos la transaccion.
            dbConnection.rollback();
            return 0;
        }

      }
      catch(Exception ex){
          System.err.println("Excepcion2: "+ ex.getMessage());
          //ex.printStackTrace();
          return 0;
      }
    
    }
    
    public int uptJueves(Boolean obj, int lista, int kiosco){
    
    String sql ="update lista_programada set jueves = ? where id_lista_reproduccion = ? and id_kiosco = ?";

    try (
           Connection dbConnection = dbSource.conectar().getConnection();
            //Tipo CallableStatement, otra variante tambien es usar PrepareStatement
            CallableStatement nuevoObj= dbConnection.prepareCall(sql);
           )            
        {
        //fechaestreno,duracion,fecha_registro,fecha_actualizacion
        dbConnection.setAutoCommit(false);
        //Variables de Entrada (IN)
        //System.err.println("Preparando llamada a PostgreSQL. ---> ");
            //System.err.println("fn_insert_archivos('"+obj.getNombre()+"'," + obj.getDuracion()+",'"+obj.getUbicacion()+"','"+obj.getTipo()+"')");
            
        nuevoObj.setBoolean(1, obj);
        nuevoObj.setInt(2, lista);
        nuevoObj.setInt(3, kiosco);

        int res = nuevoObj.executeUpdate();

        //System.err.println("<------------------------------------------------ !!!!  " + res);

        if(res == 1){
            //Finalizamos la transaccion
            dbConnection.commit();
            //System.err.println("Llamada a PostgreSQL finalizada.");
            return 1;
        }else{
            //Si hubo un error, cancelamos la transaccion.
            dbConnection.rollback();
            return 0;
        }

      }
      catch(Exception ex){
          System.err.println("Excepcion2: "+ ex.getMessage());
          //ex.printStackTrace();
          return 0;
      }
    
    }
    
    public int uptViernes(Boolean obj,int lista, int kiosco){
    
    String sql ="update lista_programada set viernes = ? where id_lista_reproduccion = ? and id_kiosco = ?";

    try (
           Connection dbConnection = dbSource.conectar().getConnection();
            //Tipo CallableStatement, otra variante tambien es usar PrepareStatement
            CallableStatement nuevoObj= dbConnection.prepareCall(sql);
           )            
        {
        //fechaestreno,duracion,fecha_registro,fecha_actualizacion
        dbConnection.setAutoCommit(false);
        //Variables de Entrada (IN)
        //System.err.println("Preparando llamada a PostgreSQL. ---> ");
            //System.err.println("fn_insert_archivos('"+obj.getNombre()+"'," + obj.getDuracion()+",'"+obj.getUbicacion()+"','"+obj.getTipo()+"')");
            
        nuevoObj.setBoolean(1, obj);
        nuevoObj.setInt(2, lista);
        nuevoObj.setInt(3, kiosco);

        int res = nuevoObj.executeUpdate();

        //System.err.println("<------------------------------------------------ !!!!  " + res);

        if(res == 1){
            //Finalizamos la transaccion
            dbConnection.commit();
            //System.err.println("Llamada a PostgreSQL finalizada.");
            return 1;
        }else{
            //Si hubo un error, cancelamos la transaccion.
            dbConnection.rollback();
            return 0;
        }

      }
      catch(Exception ex){
          System.err.println("Excepcion2: "+ ex.getMessage());
          //ex.printStackTrace();
          return 0;
      }
    
    }
    
    public int uptSabado(Boolean obj,int lista, int kiosco){
    
    String sql ="update lista_programada set sabado = ? where id_lista_reproduccion = ? and id_kiosco = ?";

    try (
           Connection dbConnection = dbSource.conectar().getConnection();
            //Tipo CallableStatement, otra variante tambien es usar PrepareStatement
            CallableStatement nuevoObj= dbConnection.prepareCall(sql);
           )            
        {
        //fechaestreno,duracion,fecha_registro,fecha_actualizacion
        dbConnection.setAutoCommit(false);
        //Variables de Entrada (IN)
        //System.err.println("Preparando llamada a PostgreSQL. ---> ");
            //System.err.println("fn_insert_archivos('"+obj.getNombre()+"'," + obj.getDuracion()+",'"+obj.getUbicacion()+"','"+obj.getTipo()+"')");
            
        nuevoObj.setBoolean(1, obj);
        nuevoObj.setInt(2, lista);
        nuevoObj.setInt(3, kiosco);

       int res = nuevoObj.executeUpdate();

        //System.err.println("<------------------------------------------------ !!!!  " + res);

        if(res == 1){
            //Finalizamos la transaccion
            dbConnection.commit();
            //System.err.println("Llamada a PostgreSQL finalizada.");
            return 1;
        }else{
            //Si hubo un error, cancelamos la transaccion.
            dbConnection.rollback();
            return 0;
        }

      }
      catch(Exception ex){
          System.err.println("Excepcion2: "+ ex.getMessage());
          //ex.printStackTrace();
          return 0;
      }
    
    }
}
