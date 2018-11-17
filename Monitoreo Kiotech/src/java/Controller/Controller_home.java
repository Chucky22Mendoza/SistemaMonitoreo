/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Objects.Archivo;
import Objects.ListaReproduccion;
import getData.GetFile;
import getData.GetPlayList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jesús Mendoza
 */
@Controller
public class Controller_home {
    
    //PÁGINA PRINCIPAL
    @RequestMapping("home.htm")
    public ModelAndView home(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try{
            //VALIDAR EL ACCESO CON VARIABLES DE SESIÓN
            HttpSession session = request.getSession();
            String id = session.getAttribute("id_usuario").toString();
            String user = session.getAttribute("usuario").toString();
            String correo = session.getAttribute("correo").toString();
            String agencia = session.getAttribute("agencia").toString();            
            System.err.println("ID "+id +" USUARIO " + user + " CORREO " + correo + " AGENCIA " + agencia);
            
            //OBTENEMOS LOS ARCHIVOS DE LA BASE DE DATOS Y LOS GUARDAMOS EN UN ARRAY TIPO ARCHIVO
            List<Archivo> archivo = new ArrayList<>();
            List<ListaReproduccion> lista = new ArrayList<>();
            
            //MÉTODO QUE RETORNA UNA LISTA TIPO ARCHIVO
            archivo =new GetFile().obtenerArchivo();
            lista = new GetPlayList().obtenerPlayLists();
            //NUEVA VISTA
            ModelAndView mav = new ModelAndView();
            
            //PASAMOS EL ARRAY A LA VISTA
            mav.addObject("File", archivo);
            mav.addObject("List", lista);
            
            //ACCEDEMOS A HOME
            mav.setViewName("home");
            
            return mav;
            
        }catch(Exception e){
            System.err.println("ERROR INTENTANDO INICIAR SESIÓN");
            return new ModelAndView("/");
        }
        
    }        
}




