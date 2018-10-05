/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Conectar;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jesús Mendoza
 */
@Controller
public class Controller_login extends HttpServlet {
    
    private JdbcTemplate jdbc;
    public Controller_login() {
        Conectar con = new Conectar();
        this.jdbc = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("login.htm")
    public ModelAndView login(HttpServletRequest request/*2*/ ){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }
 
    @RequestMapping("sesion.htm") //1  
    protected ModelAndView sesion(HttpServletRequest request/*2*/ ) throws ServletException, IOException{
        //HttpServletRequest used to take data to the controller
        String user = request.getParameter("user");
        String contraseña = request.getParameter("pass");
     
        //System.out.println("DATOS CONSULTA  "+user);
     
        String sql = "Select nombre, correo, agencia from usuario where username like '"+user+"' and contraseña like '"+contraseña+"'";

        //Procesa la consulta para almacenar los resultados en una lista, con el fin de pasar los valores mediante Mav a la vista.
        try{
            List datos = this.jdbc.queryForList(sql);
            ArrayList<String> data = new ArrayList<String>();
            data.add(datos.get(0).toString());

            String str = data.get(0);

            //Convertir usuario a String
             String[] parts = str.split(",");
             String str1 = parts[0];
             str1 = str1.trim();
             String[] strP1 = str1.split("=");
             str1 = strP1[1];

             //Convertir correo a String
             String str2 = parts[1];
             str2 = str2.trim();
             String[] strP2 = str2.split("=");
             str2 = strP2[1];

             //Convertir agencia a String
             String str3 = parts[2];
             str3 = str3.trim();
             String[] strP3 = str3.split("=");
             str3 = strP3[1];
             str3 = str3.replace("}", "");

             System.err.println("USUARIO = "+str1);
             System.err.println("CORREO = "+str2);
             System.err.println("AGENCIA = "+str3);
             
             HttpSession sesion= request.getSession(true);
            
             //Here you set your values to the session
             sesion.setAttribute("usuario", str1);
             sesion.setAttribute("correo", str2);
             sesion.setAttribute("agencia", str3);
        
            return new ModelAndView("redirect:/home.htm");  
        }catch(Exception e){
            return new ModelAndView("redirect:/error.htm");    
        }
        
        
    } 
}
