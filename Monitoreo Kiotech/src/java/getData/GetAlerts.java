/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getData;

import Model.ConnectionDB;
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
                  //System.out.println("--> "+alertasRS.getInt(1));
                  //System.out.println("--> "+alertasRS.getString(2));
                  
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
}
