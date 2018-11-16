/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package com.service.monitoreo.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.service.monitoreo.models.fn_actualizar_impresoraModel;
import com.service.monitoreo.models.fn_registrar_fondo_revolventeModel;
import com.service.monitoreo.models.infoServicio;
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
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import com.service.monitoreo.services.Interface_FunctionsFromDB;
import com.service.monitoreo.utils.StringEncrypt;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;

/**
 *
 * @author Jesús Mendoza
 */
@Path("LocalService")
@ApplicationScoped
public class RESTLocal {
    
    @Context
    private UriInfo context;
    
    @Inject
    private Interface_FunctionsFromDB FunctionsFromSource;
    
     //VARIABLE PARA ACTIVAR O DESACTIVAR EL CIFRADO 
    StringEncrypt cifrado;
    public RESTLocal() {
        // Activar o desactivar cifrado.
         cifrado = new StringEncrypt(false);
    }
 
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/GET_infoServicio/") // Ruta de consumo : /javarfs/services/CentralService/GET_infoServicio/
    public Response infoServicio() {
        infoServicio dataResponse = new infoServicio();
        dataResponse.setNombre("REST Service - Procedimientos centralizado");
        dataResponse.setVersion("1.0.0");
        dataResponse.setLenguajeCodificacion("JAVA - Restfull service");
        dataResponse.setPlataforma("WEB - Multiplataforma");
        
        if (cifrado.cipherActive){
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            String DataReturn = gson.toJson(dataResponse); 
            String DataReturnCipher = "";
            try{
                DataReturnCipher = cifrado.encrypt(cifrado.key, cifrado.InitVector, DataReturn);
            }catch(Exception error){
                DataReturnCipher = "No es posible realizar el cifrado; causa: " + error.getMessage();
            }
            return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
        }
        else
            return Response.ok(dataResponse,MediaType.APPLICATION_JSON).build();
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/GET_Decrypt/{texto}") // 
    public Response DecryptGet(@PathParam("texto") String texto) {
        
        String dataResponse = texto;
        
        if (cifrado.cipherActive){
            String DataReturnCipher = "";
            try{
                DataReturnCipher = cifrado.decrypt(cifrado.key, cifrado.InitVector, dataResponse);
            }catch(Exception error){
                DataReturnCipher = "No es posible realizar el cifrado; causa: " + error.getMessage();
            }
            return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
        }
        else
            return Response.ok(dataResponse,MediaType.APPLICATION_JSON).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/POST_Decrypt/{texto}") // 
    public Response DecryptPost(@PathParam("texto") String texto) {
        
        String dataResponse = texto;
        
        if (cifrado.cipherActive){
            String DataReturnCipher = "";
            try{
                DataReturnCipher = cifrado.decrypt(cifrado.key, cifrado.InitVector, dataResponse);
            }catch(Exception error){
                DataReturnCipher = "No es posible realizar el cifrado; causa: " + error.getMessage();
            }
            return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
        }
        else
            return Response.ok(dataResponse,MediaType.APPLICATION_JSON).build();
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/GET_encryption/{texto}") // 
    public Response encryptionGet(@PathParam("texto") String texto) {
        String dataResponse = texto;
        
        if (cifrado.cipherActive){
            String DataReturnCipher = "";
            try{
                DataReturnCipher = cifrado.encrypt(cifrado.key, cifrado.InitVector, dataResponse);
            }catch(Exception error){
                DataReturnCipher = "No es posible realizar el cifrado; causa: " + error.getMessage();
            }
            return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
        }
        else
            return Response.ok(dataResponse,MediaType.APPLICATION_JSON).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/POST_encryption/{texto}") 
    public Response encryptionPost(@PathParam("texto") String texto) {
        String dataResponse = texto;
        
        if (cifrado.cipherActive){
            String DataReturnCipher = "";
            try{
                DataReturnCipher = cifrado.encrypt(cifrado.key, cifrado.InitVector, dataResponse);
            }catch(Exception error){
                DataReturnCipher = "No es posible realizar el cifrado; causa: " + error.getMessage();
            }
            return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
        }
        else
            return Response.ok(dataResponse,MediaType.APPLICATION_JSON).build();
    }
    
    //Registrar fondo revolvente es una función de la bd local
    //Esta función recibe como parametros id_kiosco, id_fondo_revolvente, fecha_hora, denominaciones en forma de vector de entero, en este mismo orden
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/POST_fn_registrar_fondo_revolvente/")
    public Response fn_registrar_fondo_revolvente(String inputParams){
        
        fn_registrar_fondo_revolventeModel InputModel;
        GsonBuilder builderSerialize = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss");
        Gson gsonSerialize = builderSerialize.create();
        
         if (cifrado.cipherActive){
            try{  
             
             String jsonInString = cifrado.decrypt(cifrado.key, cifrado.InitVector, inputParams);
             InputModel = gsonSerialize.fromJson(jsonInString, fn_registrar_fondo_revolventeModel.class);
            }catch(Exception error)
            {
             String DataReturnCipher = "";
             DataReturnCipher = "No es posible procesar el cifrado; causa: " + error.getMessage();
             return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
            }
       }
       else
       {
            InputModel = gsonSerialize.fromJson(inputParams, fn_registrar_fondo_revolventeModel.class);
       }
         
        //InputModel = gsonSerialize.fromJson(inputParams, fn_registrar_fondo_revolventeModel.class);
        //DB interface
        return_messageModel dataReturn = new return_messageModel();
        dataReturn = FunctionsFromSource.fn_registrar_fondo_revolvente(InputModel);
        
        if (cifrado.cipherActive){
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            String DataReturn = gson.toJson(dataReturn); 
            String DataReturnCipher = "";
            try{
                DataReturnCipher = cifrado.encrypt(cifrado.key, cifrado.InitVector, DataReturn);
            }catch(Exception error){
                DataReturnCipher = "No es posible realizar el cifrado; causa: " + error.getMessage();
            }
            return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
        }
        else{
            return Response.ok(dataReturn,MediaType.APPLICATION_JSON).build();
        }
        
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/POST_fn_registrar_alerta/")
    public Response fn_registrar_alerta(String inputParams){
        
        fn_registrar_alertaModel InputModel;
        GsonBuilder builderSerialize = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss");
        Gson gsonSerialize = builderSerialize.create();
        
         if (cifrado.cipherActive){
            try{  
             
             String jsonInString = cifrado.decrypt(cifrado.key, cifrado.InitVector, inputParams);
             InputModel = gsonSerialize.fromJson(jsonInString, fn_registrar_alertaModel.class);
            }catch(Exception error)
            {
             String DataReturnCipher = "";
             DataReturnCipher = "No es posible procesar el cifrado; causa: " + error.getMessage();
             return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
            }
       }
       else
       {
            InputModel = gsonSerialize.fromJson(inputParams, fn_registrar_alertaModel.class);
       }
         
        //InputModel = gsonSerialize.fromJson(inputParams, fn_registrar_fondo_revolventeModel.class);
        //DB interface
        return_messageModel dataReturn = new return_messageModel();
        dataReturn = FunctionsFromSource.fn_registrar_alerta(InputModel);
        
        if (cifrado.cipherActive){
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            String DataReturn = gson.toJson(dataReturn); 
            String DataReturnCipher = "";
            try{
                DataReturnCipher = cifrado.encrypt(cifrado.key, cifrado.InitVector, DataReturn);
            }catch(Exception error){
                DataReturnCipher = "No es posible realizar el cifrado; causa: " + error.getMessage();
            }
            return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
        }
        else{
            return Response.ok(dataReturn,MediaType.APPLICATION_JSON).build();
        }
        
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/POST_fn_registrar_alerta_enviada/")
    public Response fn_registrar_alerta_enviada(String inputParams){
        
        fn_registrar_alerta_enviadaModel InputModel;
        GsonBuilder builderSerialize = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss");
        Gson gsonSerialize = builderSerialize.create();
        
         if (cifrado.cipherActive){
            try{  
             
             String jsonInString = cifrado.decrypt(cifrado.key, cifrado.InitVector, inputParams);
             InputModel = gsonSerialize.fromJson(jsonInString, fn_registrar_alerta_enviadaModel.class);
            }catch(Exception error)
            {
             String DataReturnCipher = "";
             DataReturnCipher = "No es posible procesar el cifrado; causa: " + error.getMessage();
             return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
            }
       }
       else
       {
            InputModel = gsonSerialize.fromJson(inputParams, fn_registrar_alerta_enviadaModel.class);
       }
         
        //InputModel = gsonSerialize.fromJson(inputParams, fn_registrar_fondo_revolventeModel.class);
        //DB interface
        return_messageModel dataReturn = new return_messageModel();
        dataReturn = FunctionsFromSource.fn_registrar_alerta_enviada(InputModel);
        
        if (cifrado.cipherActive){
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            String DataReturn = gson.toJson(dataReturn); 
            String DataReturnCipher = "";
            try{
                DataReturnCipher = cifrado.encrypt(cifrado.key, cifrado.InitVector, DataReturn);
            }catch(Exception error){
                DataReturnCipher = "No es posible realizar el cifrado; causa: " + error.getMessage();
            }
            return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
        }
        else{
            return Response.ok(dataReturn,MediaType.APPLICATION_JSON).build();
        }
        
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/POST_fn_registrar_corte_caja/")
    public Response fn_registrar_corte_caja(String inputParams){
        
        fn_registrar_corte_cajaModel InputModel;
        GsonBuilder builderSerialize = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss");
        Gson gsonSerialize = builderSerialize.create();
        
         if (cifrado.cipherActive){
            try{  
             
             String jsonInString = cifrado.decrypt(cifrado.key, cifrado.InitVector, inputParams);
             InputModel = gsonSerialize.fromJson(jsonInString, fn_registrar_corte_cajaModel.class);
            }catch(Exception error)
            {
             String DataReturnCipher = "";
             DataReturnCipher = "No es posible procesar el cifrado; causa: " + error.getMessage();
             return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
            }
       }
       else
       {
            InputModel = gsonSerialize.fromJson(inputParams, fn_registrar_corte_cajaModel.class);
       }
         
        //InputModel = gsonSerialize.fromJson(inputParams, fn_registrar_fondo_revolventeModel.class);
        //DB interface
        return_messageModel dataReturn = new return_messageModel();
        dataReturn = FunctionsFromSource.fn_registrar_corte_caja(InputModel);
        
        if (cifrado.cipherActive){
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            String DataReturn = gson.toJson(dataReturn); 
            String DataReturnCipher = "";
            try{
                DataReturnCipher = cifrado.encrypt(cifrado.key, cifrado.InitVector, DataReturn);
            }catch(Exception error){
                DataReturnCipher = "No es posible realizar el cifrado; causa: " + error.getMessage();
            }
            return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
        }
        else{
            return Response.ok(dataReturn,MediaType.APPLICATION_JSON).build();
        }
        
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/POST_fn_registrar_denominacion_transaccion/")
    public Response fn_registrar_denominacion_transaccion(String inputParams){
        
        fn_registrar_denominacion_transaccionModel InputModel;
        GsonBuilder builderSerialize = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss");
        Gson gsonSerialize = builderSerialize.create();
        
         if (cifrado.cipherActive){
            try{  
             
             String jsonInString = cifrado.decrypt(cifrado.key, cifrado.InitVector, inputParams);
             InputModel = gsonSerialize.fromJson(jsonInString, fn_registrar_denominacion_transaccionModel.class);
            }catch(Exception error)
            {
             String DataReturnCipher = "";
             DataReturnCipher = "No es posible procesar el cifrado; causa: " + error.getMessage();
             return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
            }
       }
       else
       {
            InputModel = gsonSerialize.fromJson(inputParams, fn_registrar_denominacion_transaccionModel.class);
       }
         
        //InputModel = gsonSerialize.fromJson(inputParams, fn_registrar_fondo_revolventeModel.class);
        //DB interface
        return_messageModel dataReturn = new return_messageModel();
        dataReturn = FunctionsFromSource.fn_registrar_denominacion_transaccion(InputModel);
        
        if (cifrado.cipherActive){
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            String DataReturn = gson.toJson(dataReturn); 
            String DataReturnCipher = "";
            try{
                DataReturnCipher = cifrado.encrypt(cifrado.key, cifrado.InitVector, DataReturn);
            }catch(Exception error){
                DataReturnCipher = "No es posible realizar el cifrado; causa: " + error.getMessage();
            }
            return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
        }
        else{
            return Response.ok(dataReturn,MediaType.APPLICATION_JSON).build();
        }
        
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/POST_fn_actualizar_impresora/")
    public Response fn_actualizar_impresora(String inputParams){
        
        fn_actualizar_impresoraModel InputModel;
        GsonBuilder builderSerialize = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss");
        Gson gsonSerialize = builderSerialize.create();
        
         if (cifrado.cipherActive){
            try{  
             
             String jsonInString = cifrado.decrypt(cifrado.key, cifrado.InitVector, inputParams);
             InputModel = gsonSerialize.fromJson(jsonInString, fn_actualizar_impresoraModel.class);
            }catch(Exception error)
            {
             String DataReturnCipher = "";
             DataReturnCipher = "No es posible procesar el cifrado; causa: " + error.getMessage();
             return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
            }
       }
       else
       {
            InputModel = gsonSerialize.fromJson(inputParams, fn_actualizar_impresoraModel.class);
       }
         
        //InputModel = gsonSerialize.fromJson(inputParams, fn_registrar_fondo_revolventeModel.class);
        //DB interface
        return_messageModel dataReturn = new return_messageModel();
        dataReturn = FunctionsFromSource.fn_actualizar_impresora(InputModel);
        
        if (cifrado.cipherActive){
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            String DataReturn = gson.toJson(dataReturn); 
            String DataReturnCipher = "";
            try{
                DataReturnCipher = cifrado.encrypt(cifrado.key, cifrado.InitVector, DataReturn);
            }catch(Exception error){
                DataReturnCipher = "No es posible realizar el cifrado; causa: " + error.getMessage();
            }
            return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
        }
        else{
            return Response.ok(dataReturn,MediaType.APPLICATION_JSON).build();
        }
        
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/POST_fn_sincronizar_impresora/")
    public Response fn_sincronizar_impresora(String inputParams){
        
        fn_sincronizar_impresoraModel InputModel;
        GsonBuilder builderSerialize = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss");
        Gson gsonSerialize = builderSerialize.create();
        
         if (cifrado.cipherActive){
            try{  
             
             String jsonInString = cifrado.decrypt(cifrado.key, cifrado.InitVector, inputParams);
             InputModel = gsonSerialize.fromJson(jsonInString, fn_sincronizar_impresoraModel.class);
            }catch(Exception error)
            {
             String DataReturnCipher = "";
             DataReturnCipher = "No es posible procesar el cifrado; causa: " + error.getMessage();
             return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
            }
       }
       else
       {
            InputModel = gsonSerialize.fromJson(inputParams, fn_sincronizar_impresoraModel.class);
       }
         
        //InputModel = gsonSerialize.fromJson(inputParams, fn_registrar_fondo_revolventeModel.class);
        //DB interface
        return_messageModel dataReturn = new return_messageModel();
        dataReturn = FunctionsFromSource.fn_sincronizar_impresora(InputModel);
        
        if (cifrado.cipherActive){
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            String DataReturn = gson.toJson(dataReturn); 
            String DataReturnCipher = "";
            try{
                DataReturnCipher = cifrado.encrypt(cifrado.key, cifrado.InitVector, DataReturn);
            }catch(Exception error){
                DataReturnCipher = "No es posible realizar el cifrado; causa: " + error.getMessage();
            }
            return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
        }
        else{
            return Response.ok(dataReturn,MediaType.APPLICATION_JSON).build();
        }
        
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/POST_fn_sincronizar_agencia/")
    public Response fn_sincronizar_agencia(String inputParams){
        
        fn_sincronizar_agenciaModel InputModel;
        GsonBuilder builderSerialize = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss");
        Gson gsonSerialize = builderSerialize.create();
        
         if (cifrado.cipherActive){
            try{  
             
             String jsonInString = cifrado.decrypt(cifrado.key, cifrado.InitVector, inputParams);
             InputModel = gsonSerialize.fromJson(jsonInString, fn_sincronizar_agenciaModel.class);
            }catch(Exception error)
            {
             String DataReturnCipher = "";
             DataReturnCipher = "No es posible procesar el cifrado; causa: " + error.getMessage();
             return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
            }
       }
       else
       {
            InputModel = gsonSerialize.fromJson(inputParams, fn_sincronizar_agenciaModel.class);
       }
         
        //InputModel = gsonSerialize.fromJson(inputParams, fn_registrar_fondo_revolventeModel.class);
        //DB interface
        return_messageModel dataReturn = new return_messageModel();
        dataReturn = FunctionsFromSource.fn_sincronizar_agencia(InputModel);
        
        if (cifrado.cipherActive){
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            String DataReturn = gson.toJson(dataReturn); 
            String DataReturnCipher = "";
            try{
                DataReturnCipher = cifrado.encrypt(cifrado.key, cifrado.InitVector, DataReturn);
            }catch(Exception error){
                DataReturnCipher = "No es posible realizar el cifrado; causa: " + error.getMessage();
            }
            return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
        }
        else{
            return Response.ok(dataReturn,MediaType.APPLICATION_JSON).build();
        }
        
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/POST_fn_sincronizar_archivo/")
    public Response fn_sincronizar_archivo(String inputParams){
        
        fn_sincronizar_archivoModel InputModel;
        GsonBuilder builderSerialize = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss");
        Gson gsonSerialize = builderSerialize.create();
        
         if (cifrado.cipherActive){
            try{  
             
             String jsonInString = cifrado.decrypt(cifrado.key, cifrado.InitVector, inputParams);
             InputModel = gsonSerialize.fromJson(jsonInString, fn_sincronizar_archivoModel.class);
            }catch(Exception error)
            {
             String DataReturnCipher = "";
             DataReturnCipher = "No es posible procesar el cifrado; causa: " + error.getMessage();
             return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
            }
       }
       else
       {
            InputModel = gsonSerialize.fromJson(inputParams, fn_sincronizar_archivoModel.class);
       }

        //DB interface
        return_messageModel dataReturn = new return_messageModel();
        dataReturn = FunctionsFromSource.fn_sincronizar_archivo(InputModel);
        
        if (cifrado.cipherActive){
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            String DataReturn = gson.toJson(dataReturn); 
            String DataReturnCipher = "";
            try{
                DataReturnCipher = cifrado.encrypt(cifrado.key, cifrado.InitVector, DataReturn);
            }catch(Exception error){
                DataReturnCipher = "No es posible realizar el cifrado; causa: " + error.getMessage();
            }
            return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
        }
        else{
            return Response.ok(dataReturn,MediaType.APPLICATION_JSON).build();
        }
        
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/POST_fn_sincronizar_configuracion_envio/")
    public Response fn_sincronizar_configuracion_envio(String inputParams){
        
        fn_sincronizar_configuracion_envioModel InputModel;
        GsonBuilder builderSerialize = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss");
        Gson gsonSerialize = builderSerialize.create();
        
         if (cifrado.cipherActive){
            try{  
             
             String jsonInString = cifrado.decrypt(cifrado.key, cifrado.InitVector, inputParams);
             InputModel = gsonSerialize.fromJson(jsonInString, fn_sincronizar_configuracion_envioModel.class);
            }catch(Exception error)
            {
             String DataReturnCipher = "";
             DataReturnCipher = "No es posible procesar el cifrado; causa: " + error.getMessage();
             return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
            }
       }
       else
       {
            InputModel = gsonSerialize.fromJson(inputParams, fn_sincronizar_configuracion_envioModel.class);
       }

        //DB interface
        return_messageModel dataReturn = new return_messageModel();
        dataReturn = FunctionsFromSource.fn_sincronizar_configuracion_envio(InputModel);
        
        if (cifrado.cipherActive){
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            String DataReturn = gson.toJson(dataReturn); 
            String DataReturnCipher = "";
            try{
                DataReturnCipher = cifrado.encrypt(cifrado.key, cifrado.InitVector, DataReturn);
            }catch(Exception error){
                DataReturnCipher = "No es posible realizar el cifrado; causa: " + error.getMessage();
            }
            return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
        }
        else{
            return Response.ok(dataReturn,MediaType.APPLICATION_JSON).build();
        }
        
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/POST_fn_sincronizar_det_lista_archivo/")
    public Response fn_sincronizar_det_lista_archivo(String inputParams){
        
        fn_sincronizar_det_lista_archivoModel InputModel;
        GsonBuilder builderSerialize = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss");
        Gson gsonSerialize = builderSerialize.create();
        
         if (cifrado.cipherActive){
            try{  
             
             String jsonInString = cifrado.decrypt(cifrado.key, cifrado.InitVector, inputParams);
             InputModel = gsonSerialize.fromJson(jsonInString, fn_sincronizar_det_lista_archivoModel.class);
            }catch(Exception error)
            {
             String DataReturnCipher = "";
             DataReturnCipher = "No es posible procesar el cifrado; causa: " + error.getMessage();
             return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
            }
       }
       else
       {
            InputModel = gsonSerialize.fromJson(inputParams, fn_sincronizar_det_lista_archivoModel.class);
       }

        //DB interface
        return_messageModel dataReturn = new return_messageModel();
        dataReturn = FunctionsFromSource.fn_sincronizar_det_lista_archivo(InputModel);
        
        if (cifrado.cipherActive){
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            String DataReturn = gson.toJson(dataReturn); 
            String DataReturnCipher = "";
            try{
                DataReturnCipher = cifrado.encrypt(cifrado.key, cifrado.InitVector, DataReturn);
            }catch(Exception error){
                DataReturnCipher = "No es posible realizar el cifrado; causa: " + error.getMessage();
            }
            return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
        }
        else{
            return Response.ok(dataReturn,MediaType.APPLICATION_JSON).build();
        }
        
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/POST_fn_sincronizar_dispositivo_vending/")
    public Response fn_sincronizar_dispositivo_vending(String inputParams){
        
        fn_sincronizar_dispositivo_vendingModel InputModel;
        GsonBuilder builderSerialize = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss");
        Gson gsonSerialize = builderSerialize.create();
        
         if (cifrado.cipherActive){
            try{  
             
             String jsonInString = cifrado.decrypt(cifrado.key, cifrado.InitVector, inputParams);
             InputModel = gsonSerialize.fromJson(jsonInString, fn_sincronizar_dispositivo_vendingModel.class);
            }catch(Exception error)
            {
             String DataReturnCipher = "";
             DataReturnCipher = "No es posible procesar el cifrado; causa: " + error.getMessage();
             return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
            }
       }
       else
       {
            InputModel = gsonSerialize.fromJson(inputParams, fn_sincronizar_dispositivo_vendingModel.class);
       }

        //DB interface
        return_messageModel dataReturn = new return_messageModel();
        dataReturn = FunctionsFromSource.fn_sincronizar_dispositivo_vending(InputModel);
        
        if (cifrado.cipherActive){
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            String DataReturn = gson.toJson(dataReturn); 
            String DataReturnCipher = "";
            try{
                DataReturnCipher = cifrado.encrypt(cifrado.key, cifrado.InitVector, DataReturn);
            }catch(Exception error){
                DataReturnCipher = "No es posible realizar el cifrado; causa: " + error.getMessage();
            }
            return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
        }
        else{
            return Response.ok(dataReturn,MediaType.APPLICATION_JSON).build();
        }
        
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/POST_fn_sincronizar_dispositivo_vending_kiosco/")
    public Response fn_sincronizar_dispositivo_vending_kiosco(String inputParams){
        
        fn_sincronizar_dispositivo_vending_kioscoModel InputModel;
        GsonBuilder builderSerialize = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss");
        Gson gsonSerialize = builderSerialize.create();
        
         if (cifrado.cipherActive){
            try{  
             
             String jsonInString = cifrado.decrypt(cifrado.key, cifrado.InitVector, inputParams);
             InputModel = gsonSerialize.fromJson(jsonInString, fn_sincronizar_dispositivo_vending_kioscoModel.class);
            }catch(Exception error)
            {
             String DataReturnCipher = "";
             DataReturnCipher = "No es posible procesar el cifrado; causa: " + error.getMessage();
             return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
            }
       }
       else
       {
            InputModel = gsonSerialize.fromJson(inputParams, fn_sincronizar_dispositivo_vending_kioscoModel.class);
       }

        //DB interface
        return_messageModel dataReturn = new return_messageModel();
        dataReturn = FunctionsFromSource.fn_sincronizar_dispositivo_vending_kiosco(InputModel);
        
        if (cifrado.cipherActive){
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            String DataReturn = gson.toJson(dataReturn); 
            String DataReturnCipher = "";
            try{
                DataReturnCipher = cifrado.encrypt(cifrado.key, cifrado.InitVector, DataReturn);
            }catch(Exception error){
                DataReturnCipher = "No es posible realizar el cifrado; causa: " + error.getMessage();
            }
            return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
        }
        else{
            return Response.ok(dataReturn,MediaType.APPLICATION_JSON).build();
        }
        
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/POST_fn_sincronizar_kiosco/")
    public Response fn_sincronizar_kiosco(String inputParams){
        
        fn_sincronizar_kioscoModel InputModel;
        GsonBuilder builderSerialize = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss");
        Gson gsonSerialize = builderSerialize.create();
        
         if (cifrado.cipherActive){
            try{  
             
             String jsonInString = cifrado.decrypt(cifrado.key, cifrado.InitVector, inputParams);
             InputModel = gsonSerialize.fromJson(jsonInString, fn_sincronizar_kioscoModel.class);
            }catch(Exception error)
            {
             String DataReturnCipher = "";
             DataReturnCipher = "No es posible procesar el cifrado; causa: " + error.getMessage();
             return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
            }
       }
       else
       {
            InputModel = gsonSerialize.fromJson(inputParams, fn_sincronizar_kioscoModel.class);
       }

        //DB interface
        return_messageModel dataReturn = new return_messageModel();
        dataReturn = FunctionsFromSource.fn_sincronizar_kiosco(InputModel);
        
        if (cifrado.cipherActive){
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            String DataReturn = gson.toJson(dataReturn); 
            String DataReturnCipher = "";
            try{
                DataReturnCipher = cifrado.encrypt(cifrado.key, cifrado.InitVector, DataReturn);
            }catch(Exception error){
                DataReturnCipher = "No es posible realizar el cifrado; causa: " + error.getMessage();
            }
            return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
        }
        else{
            return Response.ok(dataReturn,MediaType.APPLICATION_JSON).build();
        }
        
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/POST_fn_sincronizar_lista_programada/")
    public Response fn_sincronizar_lista_programada(String inputParams){
        
        fn_sincronizar_lista_programadaModel InputModel;
        GsonBuilder builderSerialize = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss");
        Gson gsonSerialize = builderSerialize.create();
        
         if (cifrado.cipherActive){
            try{  
             
             String jsonInString = cifrado.decrypt(cifrado.key, cifrado.InitVector, inputParams);
             InputModel = gsonSerialize.fromJson(jsonInString, fn_sincronizar_lista_programadaModel.class);
            }catch(Exception error)
            {
             String DataReturnCipher = "";
             DataReturnCipher = "No es posible procesar el cifrado; causa: " + error.getMessage();
             return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
            }
       }
       else
       {
            InputModel = gsonSerialize.fromJson(inputParams, fn_sincronizar_lista_programadaModel.class);
       }

        //DB interface
        return_messageModel dataReturn = new return_messageModel();
        dataReturn = FunctionsFromSource.fn_sincronizar_lista_programada(InputModel);
        
        if (cifrado.cipherActive){
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            String DataReturn = gson.toJson(dataReturn); 
            String DataReturnCipher = "";
            try{
                DataReturnCipher = cifrado.encrypt(cifrado.key, cifrado.InitVector, DataReturn);
            }catch(Exception error){
                DataReturnCipher = "No es posible realizar el cifrado; causa: " + error.getMessage();
            }
            return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
        }
        else{
            return Response.ok(dataReturn,MediaType.APPLICATION_JSON).build();
        }
        
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/POST_fn_sincronizar_lista_reproduccion/")
    public Response fn_sincronizar_lista_reproduccion(String inputParams){
        
        fn_sincronizar_lista_reproduccionModel InputModel;
        GsonBuilder builderSerialize = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss");
        Gson gsonSerialize = builderSerialize.create();
        
         if (cifrado.cipherActive){
            try{  
             
             String jsonInString = cifrado.decrypt(cifrado.key, cifrado.InitVector, inputParams);
             InputModel = gsonSerialize.fromJson(jsonInString, fn_sincronizar_lista_reproduccionModel.class);
            }catch(Exception error)
            {
             String DataReturnCipher = "";
             DataReturnCipher = "No es posible procesar el cifrado; causa: " + error.getMessage();
             return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
            }
       }
       else
       {
            InputModel = gsonSerialize.fromJson(inputParams, fn_sincronizar_lista_reproduccionModel.class);
       }

        //DB interface
        return_messageModel dataReturn = new return_messageModel();
        dataReturn = FunctionsFromSource.fn_sincronizar_lista_reproduccion(InputModel);
        
        if (cifrado.cipherActive){
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            String DataReturn = gson.toJson(dataReturn); 
            String DataReturnCipher = "";
            try{
                DataReturnCipher = cifrado.encrypt(cifrado.key, cifrado.InitVector, DataReturn);
            }catch(Exception error){
                DataReturnCipher = "No es posible realizar el cifrado; causa: " + error.getMessage();
            }
            return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
        }
        else{
            return Response.ok(dataReturn,MediaType.APPLICATION_JSON).build();
        }
        
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/POST_fn_sincronizar_permiso_alerta_kiosco/")
    public Response fn_sincronizar_permiso_alerta_kiosco(String inputParams){
        
        fn_sincronizar_permiso_alerta_kioscoModel InputModel;
        GsonBuilder builderSerialize = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss");
        Gson gsonSerialize = builderSerialize.create();
        
         if (cifrado.cipherActive){
            try{  
             
             String jsonInString = cifrado.decrypt(cifrado.key, cifrado.InitVector, inputParams);
             InputModel = gsonSerialize.fromJson(jsonInString, fn_sincronizar_permiso_alerta_kioscoModel.class);
            }catch(Exception error)
            {
             String DataReturnCipher = "";
             DataReturnCipher = "No es posible procesar el cifrado; causa: " + error.getMessage();
             return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
            }
       }
       else
       {
            InputModel = gsonSerialize.fromJson(inputParams, fn_sincronizar_permiso_alerta_kioscoModel.class);
       }

        //DB interface
        return_messageModel dataReturn = new return_messageModel();
        dataReturn = FunctionsFromSource.fn_sincronizar_permiso_alerta_kiosco(InputModel);
        
        if (cifrado.cipherActive){
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            String DataReturn = gson.toJson(dataReturn); 
            String DataReturnCipher = "";
            try{
                DataReturnCipher = cifrado.encrypt(cifrado.key, cifrado.InitVector, DataReturn);
            }catch(Exception error){
                DataReturnCipher = "No es posible realizar el cifrado; causa: " + error.getMessage();
            }
            return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
        }
        else{
            return Response.ok(dataReturn,MediaType.APPLICATION_JSON).build();
        }
        
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/POST_fn_sincronizar_rol/")
    public Response fn_sincronizar_rol(String inputParams){
        
        fn_sincronizar_rolModel InputModel;
        GsonBuilder builderSerialize = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss");
        Gson gsonSerialize = builderSerialize.create();
        
         if (cifrado.cipherActive){
            try{  
             
             String jsonInString = cifrado.decrypt(cifrado.key, cifrado.InitVector, inputParams);
             InputModel = gsonSerialize.fromJson(jsonInString, fn_sincronizar_rolModel.class);
            }catch(Exception error)
            {
             String DataReturnCipher = "";
             DataReturnCipher = "No es posible procesar el cifrado; causa: " + error.getMessage();
             return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
            }
       }
       else
       {
            InputModel = gsonSerialize.fromJson(inputParams, fn_sincronizar_rolModel.class);
       }

        //DB interface
        return_messageModel dataReturn = new return_messageModel();
        dataReturn = FunctionsFromSource.fn_sincronizar_rol(InputModel);
        
        if (cifrado.cipherActive){
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            String DataReturn = gson.toJson(dataReturn); 
            String DataReturnCipher = "";
            try{
                DataReturnCipher = cifrado.encrypt(cifrado.key, cifrado.InitVector, DataReturn);
            }catch(Exception error){
                DataReturnCipher = "No es posible realizar el cifrado; causa: " + error.getMessage();
            }
            return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
        }
        else{
            return Response.ok(dataReturn,MediaType.APPLICATION_JSON).build();
        }
        
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/POST_fn_sincronizar_status/")
    public Response fn_sincronizar_status(String inputParams){
        
        fn_sincronizar_statusModel InputModel;
        GsonBuilder builderSerialize = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss");
        Gson gsonSerialize = builderSerialize.create();
        
         if (cifrado.cipherActive){
            try{  
             
             String jsonInString = cifrado.decrypt(cifrado.key, cifrado.InitVector, inputParams);
             InputModel = gsonSerialize.fromJson(jsonInString, fn_sincronizar_statusModel.class);
            }catch(Exception error)
            {
             String DataReturnCipher = "";
             DataReturnCipher = "No es posible procesar el cifrado; causa: " + error.getMessage();
             return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
            }
       }
       else
       {
            InputModel = gsonSerialize.fromJson(inputParams, fn_sincronizar_statusModel.class);
       }

        //DB interface
        return_messageModel dataReturn = new return_messageModel();
        dataReturn = FunctionsFromSource.fn_sincronizar_status(InputModel);
        
        if (cifrado.cipherActive){
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            String DataReturn = gson.toJson(dataReturn); 
            String DataReturnCipher = "";
            try{
                DataReturnCipher = cifrado.encrypt(cifrado.key, cifrado.InitVector, DataReturn);
            }catch(Exception error){
                DataReturnCipher = "No es posible realizar el cifrado; causa: " + error.getMessage();
            }
            return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
        }
        else{
            return Response.ok(dataReturn,MediaType.APPLICATION_JSON).build();
        }
        
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/POST_fn_sincronizar_tipo_archivo/")
    public Response fn_sincronizar_tipo_archivo(String inputParams){
        
        fn_sincronizar_tipo_archivoModel InputModel;
        GsonBuilder builderSerialize = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss");
        Gson gsonSerialize = builderSerialize.create();
        
         if (cifrado.cipherActive){
            try{  
             
             String jsonInString = cifrado.decrypt(cifrado.key, cifrado.InitVector, inputParams);
             InputModel = gsonSerialize.fromJson(jsonInString, fn_sincronizar_tipo_archivoModel.class);
            }catch(Exception error)
            {
             String DataReturnCipher = "";
             DataReturnCipher = "No es posible procesar el cifrado; causa: " + error.getMessage();
             return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
            }
       }
       else
       {
            InputModel = gsonSerialize.fromJson(inputParams, fn_sincronizar_tipo_archivoModel.class);
       }

        //DB interface
        return_messageModel dataReturn = new return_messageModel();
        dataReturn = FunctionsFromSource.fn_sincronizar_tipo_archivo(InputModel);
        
        if (cifrado.cipherActive){
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            String DataReturn = gson.toJson(dataReturn); 
            String DataReturnCipher = "";
            try{
                DataReturnCipher = cifrado.encrypt(cifrado.key, cifrado.InitVector, DataReturn);
            }catch(Exception error){
                DataReturnCipher = "No es posible realizar el cifrado; causa: " + error.getMessage();
            }
            return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
        }
        else{
            return Response.ok(dataReturn,MediaType.APPLICATION_JSON).build();
        }
        
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/POST_fn_sincronizar_usuario/")
    public Response fn_sincronizar_usuario(String inputParams){
        
        fn_sincronizar_usuarioModel InputModel;
        GsonBuilder builderSerialize = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss");
        Gson gsonSerialize = builderSerialize.create();
        
         if (cifrado.cipherActive){
            try{  
             
             String jsonInString = cifrado.decrypt(cifrado.key, cifrado.InitVector, inputParams);
             InputModel = gsonSerialize.fromJson(jsonInString, fn_sincronizar_usuarioModel.class);
            }catch(Exception error)
            {
             String DataReturnCipher = "";
             DataReturnCipher = "No es posible procesar el cifrado; causa: " + error.getMessage();
             return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
            }
       }
       else
       {
            InputModel = gsonSerialize.fromJson(inputParams, fn_sincronizar_usuarioModel.class);
       }

        //DB interface
        return_messageModel dataReturn = new return_messageModel();
        dataReturn = FunctionsFromSource.fn_sincronizar_usuario(InputModel);
        
        if (cifrado.cipherActive){
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            String DataReturn = gson.toJson(dataReturn); 
            String DataReturnCipher = "";
            try{
                DataReturnCipher = cifrado.encrypt(cifrado.key, cifrado.InitVector, DataReturn);
            }catch(Exception error){
                DataReturnCipher = "No es posible realizar el cifrado; causa: " + error.getMessage();
            }
            return Response.ok(DataReturnCipher,MediaType.APPLICATION_JSON).build();
        }
        else{
            return Response.ok(dataReturn,MediaType.APPLICATION_JSON).build();
        }
        
    }
}
