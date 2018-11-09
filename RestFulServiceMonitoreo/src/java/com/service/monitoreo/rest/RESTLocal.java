/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.monitoreo.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.service.monitoreo.models.fn_registrar_fondo_revolventeModel;
import com.service.monitoreo.models.return_messageModel;
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
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/POST_fn_registrar_fondo_revolvente/")
    public Response fn_registrar_fondo_revolvente(String inputParams){
        
        fn_registrar_fondo_revolventeModel InputModel;
        GsonBuilder builderSerialize = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss");
        Gson gsonSerialize = builderSerialize.create();
        InputModel = gsonSerialize.fromJson(inputParams, fn_registrar_fondo_revolventeModel.class);
        //DB interface
        return_messageModel dataReturn = new return_messageModel();
        dataReturn = FunctionsFromSource.fn_registrar_fondo_revolvente(InputModel);
        
        /* use lib gson
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String dataReturn = gson.toJson(dataResponse);*/
        
        return Response.ok(dataReturn,MediaType.APPLICATION_JSON).build();
        
    }
}
