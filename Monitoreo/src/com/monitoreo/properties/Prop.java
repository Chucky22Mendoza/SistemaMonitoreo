/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package com.monitoreo.properties;

import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Jesús Mendoza Verduzco
 */
public class Prop { 
    private int inizializate;
    private String password;
    private String port;
    private String user;
    private int id_kiosco;
    private String name;
    private String url;
    private String host;

    public Prop() {
    }

    public Prop(int inizializate, String password, String port, String user, int id_kiosco, String name, String url, String host) {
        this.inizializate = inizializate;
        this.password = password;
        this.port = port;
        this.user = user;
        this.id_kiosco = id_kiosco;
        this.name = name;
        this.url = url;
        this.host = host;
    }

    public int getInizializate() {
        return inizializate;
    }

    public void setInizializate(int inizializate) {
        this.inizializate = inizializate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getId_kiosco() {
        return id_kiosco;
    }

    public void setId_kiosco(int id_kiosco) {
        this.id_kiosco = id_kiosco;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
    
    
}
