/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package com.getdata.controller;

import com.model.controller.ConnectionDB;

/**
 *
 * @author Jesús Mendoza Verduzco
 */
public class DatosAgencia {
    private ConnectionDB dbSource = null;
    public DatosAgencia(){
        this.dbSource = new ConnectionDB();
    }
}
