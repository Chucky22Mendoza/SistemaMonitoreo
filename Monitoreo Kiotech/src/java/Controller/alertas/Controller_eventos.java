/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.alertas;

import com.getdata.controller.Denominaciones;
import com.objects.controller.Evento;
import com.getdata.controller.GetEvents;
import com.model.controller.denominacion;
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
public class Controller_eventos {
    @RequestMapping("eventos.htm")
    public ModelAndView eventos(HttpServletRequest request, HttpServletResponse response) throws IOException{
         
            //VALIDAR EL ACCESO CON VARIABLES DE SESIÓN
            HttpSession session = request.getSession();
            String id = session.getAttribute("id_usuario").toString();
            String user = session.getAttribute("usuario").toString();
            String correo = session.getAttribute("correo").toString();
            String agencia = session.getAttribute("agencia").toString();            
            //System.err.println("USUARIO " + user + " CORREO " + correo + " AGENCIA " + agencia);
            //OBTENEMOS LOS ARCHIVOS DE LA BASE DE DATOS Y LOS GUARDAMOS EN UN ARRAY TIPO ARCHIVO
            
            List<Evento> evento = new ArrayList<>();
            
            //Lista de id_kioscos a los que pertenece la agencia del usuario
            List<Integer> listKioscoAgencia = (List<Integer>) session.getAttribute("kioscos_usuario_agencia");
            List<Integer> listKioscoPermiso = (List<Integer>) session.getAttribute("kioscos_usuario_permiso");
            int id_kiosco = listKioscoAgencia.get(0);
            //MÉTODO QUE RETORNA UNA LISTA TIPO ARCHIVO
            evento =new GetEvents().obtenerEventos();
            int folio = new Denominaciones().obtMinFolios(id_kiosco);
            List<denominacion> denom = new Denominaciones().denominaciones();
            //System.err.println(historial.get(0));
            //NUEVA VISTA
            ModelAndView mav = new ModelAndView();

            //PASAMOS EL ARRAY A LA VISTA
            mav.addObject("evento", evento);
            mav.addObject("denom", denom);
            
            if(folio > 0){
                mav.addObject("minFolio", folio);
            }else{
                
            }
            
            //ACCEDEMOS A HOME
            mav.setViewName("alertas/configuracion_eventos");
            
            return mav;
    }
    
    @RequestMapping("min_folios.htm")
    public ModelAndView min_folios(HttpServletRequest request, HttpServletResponse response) throws IOException{
         
            String minF = request.getParameter("minFolios");
            int min_folios = Integer.parseInt(minF);
            //System.err.println(min_folios);
            //MÉTODO QUE RETORNA UNA LISTA TIPO ARCHIVO
            HttpSession session = request.getSession();
            //Lista de id_kioscos a los que pertenece la agencia del usuario
            List<Integer> listKioscoAgencia = (List<Integer>) session.getAttribute("kioscos_usuario_agencia");
            List<Integer> listKioscoPermiso = (List<Integer>) session.getAttribute("kioscos_usuario_permiso");
            
            
            for(int i=0;i< listKioscoAgencia.size();i++){
                new Denominaciones().minFolios(min_folios, listKioscoAgencia.get(i));
            }
            //int result =new Denominaciones().minFolios(min_folios);
            
            //System.err.println(result);
            
        //if(result == 1){
            ModelAndView mav = new ModelAndView();
        
            mav.addObject("exTitle", 1);
            mav.setViewName("templates/noresultado");
            
            return mav;
        /*}else{
            ModelAndView mav = new ModelAndView();
        
            mav.addObject("exTitle", 0);
            mav.setViewName("templates/noresultado");
            
            return mav;
        }*/
            
    }
    
    @RequestMapping("ver_denominaciones.htm")
    public ModelAndView ver_denominaciones(HttpServletRequest request, HttpServletResponse response) throws IOException{
            
         List<denominacion> denom = new Denominaciones().denominaciones();
         
         ModelAndView mav = new ModelAndView();
        
         mav.addObject("exTitle", 1);
         mav.setViewName("templates/noresultado");
            
         return mav;

    }
}
