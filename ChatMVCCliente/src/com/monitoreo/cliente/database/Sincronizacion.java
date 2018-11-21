/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package com.monitoreo.cliente.database;

import com.monitoreo.cliente.model.objects.fn_registrar_alertaModel;
import com.monitoreo.cliente.model.objects.fn_registrar_alerta_enviadaModel;
import com.monitoreo.cliente.model.objects.fn_registrar_corte_cajaModel;
import com.monitoreo.cliente.model.objects.fn_sincronizar_configuracion_envioModel;
import com.monitoreo.cliente.model.objects.fn_sincronizar_dispositivo_vendingModel;
import com.monitoreo.cliente.model.objects.fn_sincronizar_dispositivo_vending_kioscoModel;
import com.monitoreo.cliente.model.objects.fn_sincronizar_impresoraModel;
import com.monitoreo.cliente.model.objects.fn_sincronizar_kioscoModel;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesús Mendoza Verduzco
 */
public class Sincronizacion {
    ConnectionDB connDB;
    
    public Sincronizacion() throws IOException{
        connDB = new ConnectionDB();
    }

    public List<fn_registrar_alertaModel> get_alertas(){
        List<fn_registrar_alertaModel> lista = new ArrayList<>();
        try{
            CallableStatement proc = connDB.connection.prepareCall("select * from historial_alerta");
            ResultSet rs = proc.executeQuery();
            while (rs.next()){
                fn_registrar_alertaModel obj= new fn_registrar_alertaModel();
                obj.setId_historial_alerta(rs.getInt(1));
                obj.setMensaje(rs.getString(2));
                obj.setFecha_hora(rs.getTimestamp(3));
                obj.setStatus(rs.getBoolean(4));
                obj.setId_evento(rs.getInt(5));
                obj.setId_kiosco(rs.getInt(6));

                lista.add(obj);
            }
        }catch(SQLException exp){
            System.out.println("Proceso fallido! Verifica la salida de consola: " + exp.getErrorCode());
        }
        return lista;
    }
    
    public List<fn_registrar_alerta_enviadaModel> get_alerta_enviada(){
        List<fn_registrar_alerta_enviadaModel> lista = new ArrayList<>();
        try{
            CallableStatement proc = connDB.connection.prepareCall("select * from alerta_enviada");
            ResultSet rs = proc.executeQuery();
            while (rs.next()){
                fn_registrar_alerta_enviadaModel obj= new fn_registrar_alerta_enviadaModel();
                obj.setId_alerta_enviada(rs.getInt(1));
                obj.setFecha_hora(rs.getTimestamp(2));
                obj.setEmisor(rs.getString(3));
                obj.setCorreo_enviado(rs.getBoolean(4));
                obj.setSms_enviado(rs.getBoolean(5));
                obj.setId_usuario(rs.getInt(6));
                obj.setId_historial_alerta(rs.getInt(7));
                obj.setId_kiosco(rs.getInt(8));
                
                lista.add(obj);
            }
        }catch(SQLException exp){
            System.out.println("Proceso fallido! Verifica la salida de consola: " + exp.getErrorCode());
        }
        return lista;
    }
    
    public List<fn_registrar_corte_cajaModel> get_corte_caja(){
        List<fn_registrar_corte_cajaModel> lista = new ArrayList<>();
        try{
            CallableStatement proc = connDB.connection.prepareCall("select * from corte_caja");
            ResultSet rs = proc.executeQuery();
            while (rs.next()){
                fn_registrar_corte_cajaModel obj= new fn_registrar_corte_cajaModel();
                obj.setId_corte_caja(rs.getInt(1));
                obj.setFecha_hora(rs.getTimestamp(2));
                obj.setId_kiosco(rs.getInt(3));
                
                lista.add(obj);
            }
        }catch(SQLException exp){
            System.out.println("Proceso fallido! Verifica la salida de consola: " + exp.getErrorCode());
        }
        return lista;
    }
    
    public List<fn_sincronizar_configuracion_envioModel> get_configuracion_envio(){
        List<fn_sincronizar_configuracion_envioModel> lista = new ArrayList<>();
        try{
            CallableStatement proc = connDB.connection.prepareCall("select * from configuracion_envio");
            ResultSet rs = proc.executeQuery();
            while (rs.next()){
                fn_sincronizar_configuracion_envioModel obj= new fn_sincronizar_configuracion_envioModel();
                obj.setId_configuracion_envio(rs.getInt(1));
                obj.setServidor_smtp(rs.getString(2));
                obj.setSeguridad(rs.getString(3));
                obj.setUsuario(rs.getString(3));
                obj.setContrasena(rs.getString(3));
                obj.setPuerto(rs.getString(3));
                obj.setPuerto_tarjeta_sms(rs.getString(3));
                
                lista.add(obj);
            }
        }catch(SQLException exp){
            System.out.println("Proceso fallido! Verifica la salida de consola: " + exp.getErrorCode());
        }
        return lista;
    }
    
    public List<fn_sincronizar_dispositivo_vendingModel> get_dispositivo_vending(){
        List<fn_sincronizar_dispositivo_vendingModel> lista = new ArrayList<>();
        try{
            CallableStatement proc = connDB.connection.prepareCall("select * from dispositivo_vending");
            ResultSet rs = proc.executeQuery();
            while (rs.next()){
                fn_sincronizar_dispositivo_vendingModel obj= new fn_sincronizar_dispositivo_vendingModel();
                obj.setId_dispositivo_vending(rs.getInt(1));
                obj.setNombre(rs.getString(2));
                
                lista.add(obj);
            }
        }catch(SQLException exp){
            System.out.println("Proceso fallido! Verifica la salida de consola: " + exp.getErrorCode());
        }
        return lista;
    }
    
    public List<fn_sincronizar_dispositivo_vending_kioscoModel> get_dispositivo_vending_kiosco(){
        List<fn_sincronizar_dispositivo_vending_kioscoModel> lista = new ArrayList<>();
        try{
            CallableStatement proc = connDB.connection.prepareCall("select * from det_dispositivo_vending_kiosco");
            ResultSet rs = proc.executeQuery();
            while (rs.next()){
                fn_sincronizar_dispositivo_vending_kioscoModel obj= new fn_sincronizar_dispositivo_vending_kioscoModel();
                obj.setId_dispositivo_vending_kiosco(rs.getInt(1));
                obj.setStatus(rs.getBoolean(2));
                obj.setId_kiosco(rs.getInt(3));
                obj.setId_dispositivo_vending(rs.getInt(4));
                
                lista.add(obj);
            }
        }catch(SQLException exp){
            System.out.println("Proceso fallido! Verifica la salida de consola: " + exp.getErrorCode());
        }
        return lista;
    }
    
    public List<fn_sincronizar_kioscoModel> get_kiosco(){
        List<fn_sincronizar_kioscoModel> lista = new ArrayList<>();
        try{
            CallableStatement proc = connDB.connection.prepareCall("select * from kiosco");
            ResultSet rs = proc.executeQuery();
            while (rs.next()){
                fn_sincronizar_kioscoModel obj= new fn_sincronizar_kioscoModel();
                obj.setId_kiosco(rs.getInt(1));
                obj.setNombre(rs.getString(2));
                obj.setStatus_mantenimiento(rs.getBoolean(3));
                obj.setIp(rs.getString(4));
                obj.setId_status(rs.getInt(5));
                obj.setId_agencia(rs.getInt(6));
                obj.setId_configuracion_envio(rs.getInt(7));
                
                lista.add(obj);
            }
        }catch(SQLException exp){
            System.out.println("Proceso fallido! Verifica la salida de consola: " + exp.getErrorCode());
        }
        return lista;
    }
    
    public List<fn_sincronizar_impresoraModel> get_impresora(){
        List<fn_sincronizar_impresoraModel> lista = new ArrayList<>();
        try{
            CallableStatement proc = connDB.connection.prepareCall("select * from impresora");
            ResultSet rs = proc.executeQuery();
            while (rs.next()){
                fn_sincronizar_impresoraModel obj= new fn_sincronizar_impresoraModel();
                
                obj.setId_impresora(rs.getInt(1));
                obj.setNombre(rs.getString(2));
                obj.setId_kiosco(rs.getInt(7));
                obj.setFecha_actualizacion(rs.getTimestamp(8));
                
                lista.add(obj);
            }
        }catch(SQLException exp){
            System.out.println("Proceso fallido! Verifica la salida de consola: " + exp.getErrorCode());
        }
        return lista;
    }
    
}
