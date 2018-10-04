/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Jesús Mendoza
 */

public class Conectar {
    public DriverManagerDataSource conectar(){
        DriverManagerDataSource DS=new DriverManagerDataSource();
        DS.setDriverClassName("org.postgresql.Driver");
        DS.setUrl("jdbc:postgresql://localhost:5432/Publicidad");
        DS.setUsername("postgres");
        DS.setPassword("1522");
        return DS;

    }
}
