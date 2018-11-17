/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package getData;

import Model.ConnectionDB;
import Objects.Historial;
import Objects.Servidor_smtp;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesús Mendoza Verduzco
 */
public class NewConfig {
    //Llamar a la base de datos para conectividad
    private ConnectionDB dbSource = null;
    public NewConfig(){
        this.dbSource = new ConnectionDB();
    }
    
    public int nuevaConfiguracion(Servidor_smtp config){
    
    String sql ="INSERT INTO configuracion_envio(id_configuracion_envio,servidor_smtp,seguridad,usuario,contrasena,puerto)  VALUES(default,?,?,?,?,?);";

    try (
           Connection dbConnection = dbSource.conectar().getConnection();
            //Tipo CallableStatement, otra variante tambien es usar PrepareStatement
            CallableStatement nuevaConf= dbConnection.prepareCall(sql);
           )            
        {
        
        dbConnection.setAutoCommit(false);
            System.err.println(config.getServer() + config.getSeguridad() + config.getUsuario() + config.getContrasena() + config.getPuerto());
        //Variables de Entrada (IN) 
        nuevaConf.setString(1, config.getServer());
        nuevaConf.setString(2, config.getSeguridad());
        nuevaConf.setString(3, config.getUsuario());
        nuevaConf.setString(4, config.getContrasena());
        nuevaConf.setInt(5, config.getPuerto());

        int res = nuevaConf.executeUpdate();

        System.err.println("<------------------------------------------------ !!!!  " + res);

        if(res==1){
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

    
    public Servidor_smtp obtenerConfiguracion(int id){
    Servidor_smtp servidor = new Servidor_smtp();
    
    String sql ="select * from vw_configuracion_usuario where id_usuario = ?;";

    try (
           Connection dbConnection = dbSource.conectar().getConnection();
            //Tipo CallableStatement, otra variante tambien es usar PrepareStatement
            CallableStatement obtConf= dbConnection.prepareCall(sql);
           )            
        {
        
        dbConnection.setAutoCommit(false);
            
        //Variables de Entrada (IN) 
        obtConf.setInt(1, id);

        obtConf.execute();

        try(  ResultSet serverRS =(ResultSet)obtConf.getResultSet(); ){
              while(serverRS.next())
                { 
                    
                    servidor.setServer(serverRS.getString(2));
                    servidor.setSeguridad(serverRS.getString(3));
                    servidor.setUsuario(serverRS.getString(4));
                    servidor.setContrasena(serverRS.getString(5));
                    servidor.setPuerto(serverRS.getInt(6));
                    
                }
            // System.out.println("Llamada a procedimiento almacenado finalizada correctamente.");
          }
        
            //System.err.println(servidor.getServer());

      }
      catch(Exception ex){
          System.err.println("Excepcion2: "+ ex.getMessage());
          //ex.printStackTrace();
          
      }
    return servidor;
    
    }
}
