/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.alertas;

import com.getdata.controller.Denominaciones;
import com.objects.controller.Evento;
import com.getdata.controller.GetEvents;
import com.getdata.controller.GetKioscos;
import com.getdata.controller.New_Horario_Corte;
import com.model.controller.denominacion;
import com.objects.controller.Contenedor;
import com.objects.controller.Horario_Corte;
import com.objects.controller.Kiosco;
import com.objects.controller.ListaReproduccion;
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
            int id_usuario = Integer.parseInt(id);
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
            List<Contenedor> contenedor = new Denominaciones().obtenerContenedor();
            
            List<Kiosco> kiosco = new ArrayList<>();
            //MÉTODO QUE RETORNA UNA LISTA TIPO ARCHIVO
            kiosco =new GetKioscos().obtenerKioscos(id_usuario);
            //NUEVA VISTA
            ModelAndView mav = new ModelAndView();

            //PASAMOS EL ARRAY A LA VISTA
            mav.addObject("evento", evento);
            mav.addObject("denom", denom);
            mav.addObject("contenedor", contenedor);
            mav.addObject("kiosco", kiosco);
            
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
    
    @RequestMapping("denom_cant_min.htm")
    public ModelAndView ver_denominaciones(HttpServletRequest request, HttpServletResponse response) throws IOException{
            
         String idSTR = request.getParameter("id_denominacion");
         String cant_min = request.getParameter("cantidad_min");
         int id = Integer.parseInt(idSTR);
         int cantidad_min = Integer.parseInt(cant_min);
         
         int res = new Denominaciones().updtCantMin(id, cantidad_min);
         //System.err.println(res);
         if(res == 1){
             ModelAndView mav = new ModelAndView();
        
             mav.addObject("exTitle", 1);
             mav.setViewName("templates/noresultado");
            
            return mav;
         }else{
             ModelAndView mav = new ModelAndView();
        
             mav.addObject("exTitle",0);
             mav.setViewName("templates/noresultado");
            
            return mav;
         }
         

    }
    
    @RequestMapping("contenedores.htm")
    public ModelAndView contenedores(HttpServletRequest request, HttpServletResponse response) throws IOException{
            
         String idSTR = request.getParameter("id_contenedor");
         String cant_max = request.getParameter("cantidad_max");
         int id = Integer.parseInt(idSTR);
         int cantidad_max = Integer.parseInt(cant_max);
         
         int res = new Denominaciones().updtContenedores(id, cantidad_max);
         //System.err.println(res);
         if(res == 1){
             ModelAndView mav = new ModelAndView();
        
             mav.addObject("exTitle", 1);
             mav.setViewName("templates/noresultado");
            
            return mav;
         }else{
             ModelAndView mav = new ModelAndView();
        
             mav.addObject("exTitle",0);
             mav.setViewName("templates/noresultado");
            
            return mav;
         }
         

    }
    
    @RequestMapping("horario_corte.htm")
    public ModelAndView horario_corte(HttpServletRequest request, HttpServletResponse response) throws IOException{
            
         String hr_ini = request.getParameter("hora_inicio");
         String hr_fin = request.getParameter("hora_final");
         String D = request.getParameter("domingo");
         String L = request.getParameter("lunes");
         String Ma = request.getParameter("martes");
         String Mi = request.getParameter("miercoles");
         String J = request.getParameter("jueves");
         String V = request.getParameter("viernes");
         String S = request.getParameter("sabado");
         String idKio = request.getParameter("id_kiosco");
         
         boolean dom = Boolean.parseBoolean(D);
         boolean lun = Boolean.parseBoolean(L);
         boolean mar = Boolean.parseBoolean(Ma);
         boolean mie = Boolean.parseBoolean(Mi);
         boolean jue = Boolean.parseBoolean(J);
         boolean vie = Boolean.parseBoolean(V);
         boolean sab = Boolean.parseBoolean(S);         
         int id_kiosco = Integer.parseInt(idKio);
         //System.err.println(lun);
         Horario_Corte hc = new Horario_Corte();
         hc.setHora_inicio(hr_ini);
         hc.setHora_fin(hr_fin);
         hc.setDomingo(dom);
         hc.setLunes(lun);
         hc.setMartes(mar);
         hc.setMiercoles(mie);
         hc.setJueves(jue);
         hc.setViernes(vie);
         hc.setSabado(sab);
         hc.setId_kiosco(id_kiosco);
         
         int res = new New_Horario_Corte().registrarCorte(hc);
         //System.err.println(res);
         if(res == 1){
             ModelAndView mav = new ModelAndView();
        
             mav.addObject("exTitle", 1);
             mav.setViewName("templates/noresultado");
            
            return mav;
         }else{
             ModelAndView mav = new ModelAndView();
        
             mav.addObject("exTitle",0);
             mav.setViewName("templates/noresultado");
            
            return mav;
         }
         

    }
}
