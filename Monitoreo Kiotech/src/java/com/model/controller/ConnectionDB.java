/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.controller;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Jesús Mendoza
 */

public class ConnectionDB {
    public DriverManagerDataSource conectar(){
        DriverManagerDataSource DS=new DriverManagerDataSource();
        DS.setDriverClassName("org.postgresql.Driver");
        DS.setUrl("jdbc:postgresql://localhost:5433/db_local");
        //DS.setUrl("jdbc:postgresql://192.168.1.139:5433/db_local"); //Servidor Prueba
        //DS.setUrl("jdbc:postgresql://localhost:5432/db_local");
        //DS.setUrl("jdbc:postgresql://localhost:5432/db_local2");
        
        DS.setUsername("postgres");
        DS.setPassword("1522");
        //DS.setPassword("12345"); //Servidor Prueba
        //DS.setPassword("123");
        //DS.setPassword("21octubre97");
        return DS;
    }
}
