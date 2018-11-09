/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.monitoreo.database;

import com.service.monitoreo.models.fn_registrar_fondo_revolventeModel;
import com.service.monitoreo.models.return_messageModel;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jesús Mendoza
 */
public class ResultFunctionsFromDB {
    ConnectionDB connDB;
    
    public ResultFunctionsFromDB(){
        connDB = new ConnectionDB();
    }
    
  
    // sp_registrar_fondo_revolvente
     public return_messageModel fn_registrar_fondo_revolvente(fn_registrar_fondo_revolventeModel inputParams){
        return_messageModel modelo = new return_messageModel();
        
        try{
        CallableStatement proc = connDB.connection.prepareCall("{ call fn_registrar_fondo_revolvente(?,?,?::timestamp without time zone,?::integer[][]) }");
        proc.setInt(1,inputParams.getId_kiosco());
        proc.setInt(2,inputParams.getId_fondo_revolvente());
        proc.setTimestamp(3,inputParams.getFecha_hora());
        proc.setArray(4,connDB.connection.createArrayOf("integer", inputParams.getDenominaciones()));
        
        
        ResultSet results = proc.executeQuery();
        while (results.next()){
            int code = results.getInt(1);
            String message = results.getString(2);
            
            modelo.setCodigo(code);
            modelo.setMensaje(message);
        }
        results.close();
        proc.close();
        modelo.setExito(true);
        }catch(SQLException exp)
        {
            /*** LOG DE ARCHIVO ***/
            StringWriter errors = new StringWriter();
            exp.printStackTrace(new PrintWriter(errors));
            //LogExcepciones.log(exp.getMessage(), errors.toString());
            /*********************/
            
            System.out.println("Proceso fallido! Verifica la salida de consola");
            exp.printStackTrace();
            modelo.setExito(false);
            modelo.setExcepcion(exp.getMessage());
        }
        return modelo;
    }
}
