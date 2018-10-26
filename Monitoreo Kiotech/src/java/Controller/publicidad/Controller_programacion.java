/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.publicidad;

import Objects.Archivo;
import Objects.Kiosco;
import Objects.Programadas;
import getData.GetFile;
import getData.GetKioscos;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jesús Mendoza
 */
@Controller
public class Controller_programacion {
    @RequestMapping("programacion.htm")
    public ModelAndView programacion(HttpServletRequest request, HttpServletResponse response) throws IOException{
         try{
            //VALIDAR EL ACCESO CON VARIABLES DE SESIÓN
            HttpSession session = request.getSession();
            String user = session.getAttribute("usuario").toString();
            String correo = session.getAttribute("correo").toString();
            String agencia = session.getAttribute("agencia").toString();  
            int id = 1;
            //System.err.println("USUARIO " + user + " CORREO " + correo + " AGENCIA " + agencia);
            
            //OBTENEMOS LOS ARCHIVOS DE LA BASE DE DATOS Y LOS GUARDAMOS EN UN ARRAY TIPO ARCHIVO
            List<Kiosco> kiosco = new ArrayList<>();
            List<Programadas> pro = new ArrayList<>();
            
            //MÉTODO QUE RETORNA UNA LISTA TIPO ARCHIVO
            kiosco =new GetKioscos().obtenerKioscos();
            //pro =new GetKioscos().obtenerProgramadas(id);
            
            //NUEVA VISTA
            ModelAndView mav = new ModelAndView();
            
            //PASAMOS EL ARRAY A LA VISTA
            mav.addObject("kiosco", kiosco);
            //mav.addObject("programadas", pro);
            
            //ACCEDEMOS A HOME
            mav.setViewName("publicidad/programacion_listas");
            
            return mav;
            
        }catch(Exception e){
            System.err.println("ERROR INTENTANDO INICIAR SESIÓN");
            return new ModelAndView("error");
        }
        
    }
    
    @RequestMapping("ver_listas.htm") //1  
    public ModelAndView ver_listas(HttpServletRequest request/*2*/, Model model){
        
        String idKiosco = request.getParameter("id");
        int id = Integer.parseInt(idKiosco);
        
         //OBTENEMOS LOS ARCHIVOS DE LA BASE DE DATOS Y LOS GUARDAMOS EN UN ARRAY TIPO ARCHIVO
         List<Programadas> pro = new ArrayList<>();    
            
         //MÉTODO QUE RETORNA UNA LISTA TIPO ARCHIVO
         pro =new GetKioscos().obtenerProgramadas(id);
         
         //NUEVA VISTA
         ModelAndView mav = new ModelAndView();
            
         //PASAMOS EL ARRAY A LA VISTA
         mav.addObject("programadas", pro);
         
         mav.setViewName("templates/tablasprogramadas");
         return mav;
    } 
}
