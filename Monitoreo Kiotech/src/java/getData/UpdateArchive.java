/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getData;

import Model.ConnectionDB;
import Objects.Archivo;
import java.io.StringWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;

/**
 *
 * @author Jesús Mendoza
 */
public class UpdateArchive {
    
    private ConnectionDB dbSource = null;
    public UpdateArchive(){
        this.dbSource = new ConnectionDB();
    }
    
    public int actualizarArchivo(Archivo archEdit){

    String sql ="Update archivo set nombre=?, tipo=?, duracion=? where idarchivo=?;";

    try (
           Connection dbConnection = dbSource.conectar().getConnection();
            //Tipo CallableStatement, otra variante tambien es usar PrepareStatement
            CallableStatement actualizarArchivo= dbConnection.prepareCall(sql);
           )            
        {
      //fechaestreno,duracion,fecha_registro,fecha_actualizacion
      dbConnection.setAutoCommit(false);
      //Variables de Entrada (IN)
      System.err.println("Preparando llamada a PostgreSQL. ---> ");
      actualizarArchivo.setString(1, archEdit.getNombre());
      actualizarArchivo.setString(2, archEdit.getTipo());
      actualizarArchivo.setInt(3, archEdit.getDuracion());
      actualizarArchivo.setInt(4, archEdit.getId());
      int res = actualizarArchivo.executeUpdate();
        
      System.err.println("<------------------------------------------------ !!!!  " + res);
      
      if(res == 1){
          //Finalizamos la transaccion
          dbConnection.commit();
          System.err.println("lllllllllllllllllllllLlamada a PostgreSQL finalizada.");
          return res;
      }else{
          //Si hubo un error, cancelamos la transaccion.
          dbConnection.rollback();
          return res;
      }

    }
    catch(Exception ex){
        System.err.println("Excepcion2: "+ ex.getMessage());
        //ex.printStackTrace();
        return 0;
    }
    
}
}
