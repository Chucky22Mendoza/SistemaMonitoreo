/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getData;

import Model.ConnectionDB;
import Objects.Evento;
import Objects.Historial;
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
public class GetEvents {
    //Llamar a la base de datos para conectividad
    private ConnectionDB dbSource = null;
    public GetEvents(){
        this.dbSource = new ConnectionDB();
    }
    
    public List<Evento> obtenerEventos(){
        List<Evento> evento = new ArrayList<>();
        String sql ="select * from cat_evento order by id_evento";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement obtenerEventos = dbConnection.prepareCall(sql);       )            {

          //Variables de Entrada (IN)
          //System.out.println("Preparando llamada a procedimiento almacenado.");
          obtenerEventos.execute();
          //System.out.println("Procesando resultados de llamada a procedimiento almacenado.");
          try(  ResultSet eventosRS =(ResultSet)obtenerEventos.getResultSet(); ){
              while(eventosRS.next())
                {
                  //System.out.println("--> "+eventosRS.getInt(1));
                  //System.out.println("--> "+eventosRS.getString(2));
                  
                    Evento event= new Evento();
                    event.setId(eventosRS.getInt(1));
                    event.setNombre(eventosRS.getString(2));
                    event.setMensaje(eventosRS.getString(3));
                    event.setActivo(true);
                    
                    evento.add(event);
                }
             //System.out.println("Llamada a procedimiento almacenado finalizada correctamente.");
          }
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            //ex.printStackTrace();
        }
        return evento;
    }
}
