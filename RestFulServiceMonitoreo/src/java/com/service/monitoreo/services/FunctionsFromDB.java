/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.monitoreo.services;

import com.service.monitoreo.database.ResultFunctionsFromDB;
import com.service.monitoreo.models.fn_registrar_fondo_revolventeModel;
import com.service.monitoreo.models.return_messageModel;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Jesús Mendoza
 */
@ApplicationScoped
public class FunctionsFromDB implements Interface_FunctionsFromDB{
    private ResultFunctionsFromDB resultFunc = new ResultFunctionsFromDB();
    
    @Override
    public return_messageModel fn_registrar_fondo_revolvente(fn_registrar_fondo_revolventeModel inputParams){
        return resultFunc.fn_registrar_fondo_revolvente(inputParams);
    }
}
