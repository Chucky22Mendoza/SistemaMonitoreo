/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package com.getdata.controller;

import com.model.controller.ConnectionDB;
import com.objects.controller.Horario_Corte;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Jesús Mendoza Verduzco
 */
public class New_Horario_Corte {
    private ConnectionDB dbSource = null;
    public New_Horario_Corte(){
        this.dbSource = new ConnectionDB();
    }
    
    public int registrarCorte(Horario_Corte inputParams){
        String sql ="insert into horario_corte values (default,?::time without time zone,?::time without time zone,?,?,?,?,?,?,?,?)";
        
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement horario = dbConnection.prepareCall(sql);       )            {
          //Variables de Entrada (IN)
            //System.err.println(inputParams.getHora_fin());
          horario.setString(1, inputParams.getHora_inicio());
          horario.setString(2, inputParams.getHora_fin());
          horario.setBoolean(3, inputParams.isDomingo());
          horario.setBoolean(4, inputParams.isLunes());
          horario.setBoolean(5, inputParams.isMartes());
          horario.setBoolean(6, inputParams.isMiercoles());
          horario.setBoolean(7, inputParams.isJueves());
          horario.setBoolean(8, inputParams.isViernes());
          horario.setBoolean(9, inputParams.isSabado());
          horario.setInt(10, inputParams.getId_kiosco());
          int res = horario.executeUpdate();
            //System.err.println(res);
          if(res >= 1){
              return 1;
          }else{
              return 0;
          }
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            return 0;
        }        
    }
}
