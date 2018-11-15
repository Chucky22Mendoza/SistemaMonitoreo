/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package com.service.monitoreo.database;

import com.service.monitoreo.models.fn_actualizar_impresoraModel;
import com.service.monitoreo.models.fn_registrar_fondo_revolventeModel;
import com.service.monitoreo.models.return_messageModel;
import com.service.monitoreo.models.fn_registrar_alertaModel;
import com.service.monitoreo.models.fn_registrar_alerta_enviadaModel;
import com.service.monitoreo.models.fn_registrar_corte_cajaModel;
import com.service.monitoreo.models.fn_registrar_denominacion_transaccionModel;
import com.service.monitoreo.models.fn_sincronizar_agenciaModel;
import com.service.monitoreo.models.fn_sincronizar_archivoModel;
import com.service.monitoreo.models.fn_sincronizar_configuracion_envioModel;
import com.service.monitoreo.models.fn_sincronizar_det_lista_archivoModel;
import com.service.monitoreo.models.fn_sincronizar_dispositivo_vendingModel;
import com.service.monitoreo.models.fn_sincronizar_dispositivo_vending_kioscoModel;
import com.service.monitoreo.models.fn_sincronizar_impresoraModel;
import com.service.monitoreo.models.fn_sincronizar_kioscoModel;
import com.service.monitoreo.models.fn_sincronizar_lista_programadaModel;
import com.service.monitoreo.models.fn_sincronizar_lista_reproduccionModel;
import com.service.monitoreo.models.fn_sincronizar_permiso_alerta_kioscoModel;
import com.service.monitoreo.models.fn_sincronizar_rolModel;
import com.service.monitoreo.models.fn_sincronizar_statusModel;
import com.service.monitoreo.models.fn_sincronizar_tipo_archivoModel;
import com.service.monitoreo.models.fn_sincronizar_usuarioModel;
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
    
  
    // fn_registrar_fondo_revolvente
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
     
      // fn_registrar_alerta
     public return_messageModel fn_registrar_alerta(fn_registrar_alertaModel inputParams){
        return_messageModel modelo = new return_messageModel();
        
        try{
            CallableStatement proc = connDB.connection.prepareCall("{call fn_registrar_alerta(?,?,?::timestamp without time zone,?,?,?) }");
            proc.setInt(1,inputParams.getId_historial_alerta());
            proc.setString(2,inputParams.getMensaje());
            proc.setTimestamp(3,inputParams.getFecha_hora());
            proc.setBoolean(4,inputParams.isStatus());
            proc.setInt(5,inputParams.getId_evento());
            proc.setInt(6,inputParams.getId_kiosco());
            
        
        
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
     
     // fn_registrar_alerta_enviada
     public return_messageModel fn_registrar_alerta_enviada(fn_registrar_alerta_enviadaModel inputParams){
        return_messageModel modelo = new return_messageModel();
        
        try{
            CallableStatement proc = connDB.connection.prepareCall("{call fn_registrar_alerta_enviada(?,?::timestamp without time zone,?,?,?,?,?,?) }");
            proc.setInt(1,inputParams.getId_alerta_enviada());
            proc.setTimestamp(2,inputParams.getFecha_hora());
            proc.setString(3,inputParams.getEmisor());
            proc.setBoolean(4,inputParams.isCorreo_enviado());
            proc.setBoolean(5,inputParams.isSms_enviado());
            proc.setInt(6,inputParams.getId_usuario());
            proc.setInt(7,inputParams.getId_historial_alerta());
            proc.setInt(8,inputParams.getId_kiosco());
            
        
        
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
     
     // fn_registrar_corte_caja
     public return_messageModel fn_registrar_corte_caja(fn_registrar_corte_cajaModel inputParams){
        return_messageModel modelo = new return_messageModel();
        
        try{
            CallableStatement proc = connDB.connection.prepareCall("{call fn_registrar_corte_caja(?,?::timestamp without time zone,?) }");
            proc.setInt(1,inputParams.getId_corte_caja());
            proc.setTimestamp(2,inputParams.getFecha_hora());
            proc.setInt(3,inputParams.getId_kiosco());
        
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
     
     // fn_registrar_denominacion_transaccion
     public return_messageModel fn_registrar_denominacion_transaccion(fn_registrar_denominacion_transaccionModel inputParams){
        return_messageModel modelo = new return_messageModel();
        
        try{
            CallableStatement proc = connDB.connection.prepareCall("{call fn_registrar_denominacion_transaccion(?,?::timestamp without time zone,?::integer[][],?,?::integer[][]) }");
            proc.setInt(1,inputParams.getId_transaccion());
            proc.setTimestamp(2,inputParams.getFecha_hora());
            proc.setArray(3,connDB.connection.createArrayOf("integer", inputParams.getDenominaciones_recibidas()));
            proc.setInt(4,inputParams.getId_kiosco());
            proc.setArray(5,connDB.connection.createArrayOf("integer", inputParams.getDenominaciones_dispensadas()));
        
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
     
     // fn_actualizar_impresora
     public return_messageModel fn_actualizar_impresora(fn_actualizar_impresoraModel inputParams){
        return_messageModel modelo = new return_messageModel();
        
        try{
            CallableStatement proc = connDB.connection.prepareCall("{call fn_actualizar_impresora(?,?,?,?,?) }");
            proc.setInt(1,inputParams.getId_impresora());
            proc.setInt(2,inputParams.getFolio_inicial());
            proc.setInt(3,inputParams.getFolio_final());
            proc.setInt(4,inputParams.getTotal_folios());
            proc.setInt(5,inputParams.getId_kiosco());
            
        
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
     
       // fn_sincronizar_impresora
     public return_messageModel fn_sincronizar_impresora(fn_sincronizar_impresoraModel inputParams){
        return_messageModel modelo = new return_messageModel();
        
        try{
            CallableStatement proc = connDB.connection.prepareCall("{call fn_sincronizar_impresora(?,?,?,?::timestamp without time zone) }");
            proc.setInt(1,inputParams.getId_impresora());
            proc.setString(2,inputParams.getNombre());
            proc.setInt(3,inputParams.getId_kiosco());
            proc.setTimestamp(4,inputParams.getFecha_actualizacion());
            
        
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
     
     // fn_sincronizar_agencia
     public return_messageModel fn_sincronizar_agencia(fn_sincronizar_agenciaModel inputParams){
        return_messageModel modelo = new return_messageModel();
        
        try{
            CallableStatement proc = connDB.connection.prepareCall("{call fn_sincronizar_agencia(?,?,?) }");
            proc.setInt(1,inputParams.getId_agencia());
            proc.setString(2,inputParams.getNombre());
            proc.setString(3,inputParams.getUbicacion());
            
        
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
     
     // fn_sincronizar_archivo
     public return_messageModel fn_sincronizar_archivo(fn_sincronizar_archivoModel inputParams){
        return_messageModel modelo = new return_messageModel();
        
        try{
            CallableStatement proc = connDB.connection.prepareCall("{call fn_sincronizar_archivo(?,?,?,?,?) }");
            proc.setInt(1,inputParams.getId_archivo());
            proc.setString(2,inputParams.getNombre());
            proc.setInt(3,inputParams.getDuracion());
            proc.setString(4,inputParams.getUbicacion());
            proc.setInt(5,inputParams.getId_tipo_archivo());
        
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
     
      // fn_sincronizar_configuracion_envio
     public return_messageModel fn_sincronizar_configuracion_envio(fn_sincronizar_configuracion_envioModel inputParams){
        return_messageModel modelo = new return_messageModel();
        
        try{
            CallableStatement proc = connDB.connection.prepareCall("{call fn_sincronizar_configuracion_envio(?,?,?,?,?,?,?) }");
            proc.setInt(1,inputParams.getId_configuracion_envio());
            proc.setString(2,inputParams.getServidor_smtp());
            proc.setString(3,inputParams.getSeguridad());
            proc.setString(4,inputParams.getUsuario());
            proc.setString(5,inputParams.getContrasena());
            proc.setString(6,inputParams.getPuerto());
            proc.setString(7,inputParams.getPuerto_tarjeta_sms());
        
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
     
     // fn_sincronizar_det_lista_archivo
     public return_messageModel fn_sincronizar_det_lista_archivo(fn_sincronizar_det_lista_archivoModel inputParams){
        return_messageModel modelo = new return_messageModel();
        
        try{
            CallableStatement proc = connDB.connection.prepareCall("{call fn_sincronizar_det_lista_archivo(?,?,?,?) }");
            proc.setInt(1,inputParams.getId_lista_reproduccion_archivo());
            proc.setInt(2,inputParams.getOrden());
            proc.setInt(3,inputParams.getId_lista());
            proc.setInt(4,inputParams.getId_archivo());
        
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
     
     // fn_sincronizar_dispositivo_vending
     public return_messageModel fn_sincronizar_dispositivo_vending(fn_sincronizar_dispositivo_vendingModel inputParams){
        return_messageModel modelo = new return_messageModel();
        
        try{
            CallableStatement proc = connDB.connection.prepareCall("{call fn_sincronizar_dispositivo_vending(?,?) }");
            proc.setInt(1,inputParams.getId_dispositivo_vending());
            proc.setString(2,inputParams.getNombre());
        
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
     
      // fn_sincronizar_dispositivo_vending_kiosco
     public return_messageModel fn_sincronizar_dispositivo_vending_kiosco(fn_sincronizar_dispositivo_vending_kioscoModel inputParams){
        return_messageModel modelo = new return_messageModel();
        
        try{
            CallableStatement proc = connDB.connection.prepareCall("{call fn_sincronizar_dispositivo_vending_kiosco(?,?,?,?) }");
            proc.setInt(1,inputParams.getId_dispositivo_vending_kiosco());
            proc.setBoolean(2, inputParams.isStatus());
            proc.setInt(3,inputParams.getId_kiosco());
            proc.setInt(4,inputParams.getId_dispositivo_vending());
        
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
     
      // fn_sincronizar_kiosco
     public return_messageModel fn_sincronizar_kiosco(fn_sincronizar_kioscoModel inputParams){
        return_messageModel modelo = new return_messageModel();
        
        try{
            CallableStatement proc = connDB.connection.prepareCall("{call fn_sincronizar_kiosco(?,?,?,?,?,?,?) }");
            proc.setInt(1,inputParams.getId_kiosco());
            proc.setString(2, inputParams.getNombre());
            proc.setBoolean(3,inputParams.isStatus_mantenimiento());
            proc.setString(4,inputParams.getIp());
            proc.setInt(5,inputParams.getId_status());
            proc.setInt(6,inputParams.getId_agencia());
            proc.setInt(7,inputParams.getId_configuracion_envio());
        
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
     
     // fn_sincronizar_lista_programada
     public return_messageModel fn_sincronizar_lista_programada(fn_sincronizar_lista_programadaModel inputParams){
        return_messageModel modelo = new return_messageModel();
        
        try{
            CallableStatement proc = connDB.connection.prepareCall("{call fn_sincronizar_lista_programada(?,?::time without time zone,?,?,?,?,?,?,?,?,?) }");
            proc.setInt(1,inputParams.getId_lista_programada());
            proc.setTimestamp(2, inputParams.getHora_inicio());
            proc.setBoolean(3,inputParams.isDomingo());
            proc.setBoolean(4,inputParams.isLunes());
            proc.setBoolean(5,inputParams.isMartes());
            proc.setBoolean(6,inputParams.isMiercoles());
            proc.setBoolean(7,inputParams.isJueves());
            proc.setBoolean(8,inputParams.isViernes());
            proc.setBoolean(9,inputParams.isSabado());
            proc.setInt(10,inputParams.getId_kiosco());
            proc.setInt(11,inputParams.getId_lista());
        
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
     
     // fn_sincronizar_lista_reproduccion
     public return_messageModel fn_sincronizar_lista_reproduccion(fn_sincronizar_lista_reproduccionModel inputParams){
        return_messageModel modelo = new return_messageModel();
        
        try{
            CallableStatement proc = connDB.connection.prepareCall("{call fn_sincronizar_lista_reproduccion(?,?,?) }");
            proc.setInt(1,inputParams.getId_lista_reproduccion());
            proc.setString(2, inputParams.getNombre());
            proc.setString(3,inputParams.getDescripcion());
            
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
     
     // fn_sincronizar_permiso_alerta_kiosco
     public return_messageModel fn_sincronizar_permiso_alerta_kiosco(fn_sincronizar_permiso_alerta_kioscoModel inputParams){
        return_messageModel modelo = new return_messageModel();
        
        try{
            CallableStatement proc = connDB.connection.prepareCall("{call fn_sincronizar_permiso_alerta_kiosco(?,?,?) }");
            proc.setInt(1,inputParams.getId_permiso_alerta_kiosco());
            proc.setInt(2, inputParams.getId_kiosco());
            proc.setInt(3,inputParams.getId_usuario());
            
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
     
     // fn_sincronizar_rol
     public return_messageModel fn_sincronizar_rol(fn_sincronizar_rolModel inputParams){
        return_messageModel modelo = new return_messageModel();
        
        try{
            CallableStatement proc = connDB.connection.prepareCall("{call fn_sincronizar_rol(?,?,?) }");
            proc.setInt(1,inputParams.getId_rol());
            proc.setString(2, inputParams.getNombre());
            proc.setString(3,inputParams.getDescripcion());
            
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
     
     // fn_sincronizar_status
     public return_messageModel fn_sincronizar_status(fn_sincronizar_statusModel inputParams){
        return_messageModel modelo = new return_messageModel();
        
        try{
            CallableStatement proc = connDB.connection.prepareCall("{call fn_sincronizar_status(?,?,?) }");
            proc.setInt(1,inputParams.getId_status());
            proc.setString(2, inputParams.getNombre());
            proc.setString(3,inputParams.getDescripcion());
            
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
     
     // fn_sincronizar_tipo_archivo
     public return_messageModel fn_sincronizar_tipo_archivo(fn_sincronizar_tipo_archivoModel inputParams){
        return_messageModel modelo = new return_messageModel();
        
        try{
            CallableStatement proc = connDB.connection.prepareCall("{call fn_sincronizar_tipo_archivo(?,?,?) }");
            proc.setInt(1,inputParams.getId_tipo_archivo());
            proc.setString(2, inputParams.getNombre());
            proc.setString(3,inputParams.getDescripcion());
            
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
     
     // fn_sincronizar_usuario
     public return_messageModel fn_sincronizar_usuario(fn_sincronizar_usuarioModel inputParams){
        return_messageModel modelo = new return_messageModel();
        
        try{
            CallableStatement proc = connDB.connection.prepareCall("{call fn_sincronizar_usuario(?,?,?,?,?,?,?,?,?) }");
            proc.setInt(1,inputParams.getId_usuario());
            proc.setBoolean(2,inputParams.isStatus());
            proc.setString(3, inputParams.getNombre());
            proc.setString(4, inputParams.getUsuario());
            proc.setString(5, inputParams.getContrasena());
            proc.setString(6,inputParams.getCorreo());
            proc.setString(7, inputParams.getTelefono());
            proc.setInt(8, inputParams.getId_agencia());
            proc.setInt(9, inputParams.getId_rol());
            
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
