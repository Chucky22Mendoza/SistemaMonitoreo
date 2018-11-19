/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.publicidad;

import com.objects.controller.Archivo;
import com.objects.controller.Kiosco;
import com.objects.controller.ListaProgramada;
import com.objects.controller.ListaReproduccion;
import com.objects.controller.Programadas;
import com.getdata.controller.GetFile;
import com.getdata.controller.GetKioscos;
import com.getdata.controller.GetPlayList;
import com.getdata.controller.NewSchedulePlayList;
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
            String id = session.getAttribute("id_usuario").toString();
            String user = session.getAttribute("usuario").toString();
            String correo = session.getAttribute("correo").toString();
            String agencia = session.getAttribute("agencia").toString(); 
            int id_usuario = Integer.parseInt(id);
            //int id = 1;
            //System.err.println("USUARIO " + user + " CORREO " + correo + " AGENCIA " + agencia);
            
            //OBTENEMOS LOS ARCHIVOS DE LA BASE DE DATOS Y LOS GUARDAMOS EN UN ARRAY TIPO ARCHIVO
            List<Kiosco> kiosco = new ArrayList<>();
            //List<Programadas> pro = new ArrayList<>();
            List<ListaReproduccion> lista = new ArrayList<>();
            
            //MÉTODO QUE RETORNA UNA LISTA TIPO ARCHIVO
            kiosco =new GetKioscos().obtenerKioscos(id_usuario);
            lista = new GetPlayList().obtenerPlayLists();
            //pro =new GetKioscos().obtenerProgramadas(id);
            
            //NUEVA VISTA
            ModelAndView mav = new ModelAndView();
            
            //PASAMOS EL ARRAY A LA VISTA
            mav.addObject("kiosco", kiosco);
            mav.addObject("lista", lista);
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
    
    @RequestMapping("programar_lista.htm") //1  
    public ModelAndView programar_lista(HttpServletRequest request/*2*/, Model model){
        
        String horaInicial = request.getParameter("horaInicial");
        String domingo = request.getParameter("domingo");
        String lunes = request.getParameter("lunes");
        String martes = request.getParameter("martes");
        String miercoles = request.getParameter("miercoles");
        String jueves = request.getParameter("jueves");
        String viernes = request.getParameter("viernes");
        String sabado = request.getParameter("sabado");
        String idKiosco = request.getParameter("idKiosco");
        String idLista = request.getParameter("idLista");
        
        boolean dom = Boolean.parseBoolean(domingo);
        boolean lun = Boolean.parseBoolean(lunes);
        boolean mar = Boolean.parseBoolean(martes);
        boolean mie = Boolean.parseBoolean(miercoles);
        boolean jue = Boolean.parseBoolean(jueves);
        boolean vie = Boolean.parseBoolean(viernes);
        boolean sab = Boolean.parseBoolean(sabado);
        int id_kiosco = Integer.parseInt(idKiosco);
        int id_lista = Integer.parseInt(idLista);
        
         //OBTENEMOS LOS ARCHIVOS DE LA BASE DE DATOS Y LOS GUARDAMOS EN UN ARRAY TIPO ARCHIVO
         ListaProgramada lista = new ListaProgramada();    
         
         lista.setHoraInicio(horaInicial);
         lista.setDomingo(dom);
         lista.setLunes(lun);
         lista.setMartes(mar);
         lista.setMiercoles(mie);
         lista.setJueves(jue);
         lista.setViernes(vie);
         lista.setSabado(sab);
         lista.setIdKiosco(id_kiosco);
         lista.setIdLista(id_lista);
         
         //MÉTODO QUE RETORNA UNA LISTA TIPO ARCHIVO
         int res =new NewSchedulePlayList().nuevoArchivo(lista);
         
         if(res == 1){
             //NUEVA VISTA
             ModelAndView mav = new ModelAndView();
             mav.setViewName("publicidad/programacion_listas");
             return mav;
         }else{
             //NUEVA VISTA
             ModelAndView mav = new ModelAndView();
             mav.addObject("exTitle", 1);
             mav.setViewName("templates/noresultado");
             return mav;
         }
         
    } 
    
    @RequestMapping("actualizar_programar_lista.htm") //1  
    public ModelAndView actualizar_programar_lista(HttpServletRequest request/*2*/, Model model){
        
        String horaInicial = request.getParameter("horaInicial");
        String domingo = request.getParameter("domingo");
        String lunes = request.getParameter("lunes");
        String martes = request.getParameter("martes");
        String miercoles = request.getParameter("miercoles");
        String jueves = request.getParameter("jueves");
        String viernes = request.getParameter("viernes");
        String sabado = request.getParameter("sabado");
        String idKiosco = request.getParameter("idKiosco");
        String idLista = request.getParameter("idLista");
        
        boolean dom = Boolean.parseBoolean(domingo);
        boolean lun = Boolean.parseBoolean(lunes);
        boolean mar = Boolean.parseBoolean(martes);
        boolean mie = Boolean.parseBoolean(miercoles);
        boolean jue = Boolean.parseBoolean(jueves);
        boolean vie = Boolean.parseBoolean(viernes);
        boolean sab = Boolean.parseBoolean(sabado);
        int id_kiosco = Integer.parseInt(idKiosco);
        int id_lista = Integer.parseInt(idLista);
         //System.err.println("-------------"+dom + lun + mar + mie + jue + vie + sab);
         //System.err.println("-------------"+id_kiosco + id_lista);
         int hrInicio = new NewSchedulePlayList().uptHoraInicio(horaInicial,id_lista,id_kiosco);
         int d = new NewSchedulePlayList().uptDomingo(dom,id_lista,id_kiosco);
         int l = new NewSchedulePlayList().uptLunes(lun,id_lista,id_kiosco);
         int ma = new NewSchedulePlayList().uptMartes(mar,id_lista,id_kiosco);
         int mi = new NewSchedulePlayList().uptMiercoles(mie,id_lista,id_kiosco);
         int j = new NewSchedulePlayList().uptJueves(jue,id_lista,id_kiosco);
         int v = new NewSchedulePlayList().uptViernes(vie,id_lista,id_kiosco);
         int s = new NewSchedulePlayList().uptSabado(sab,id_lista,id_kiosco);
         //int kio = new NewSchedulePlayList().uptIdKiosco(id_kiosco);
         //int list = new NewSchedulePlayList().uptIdLista(id_lista);
         //System.err.println(hrInicio + "-"+ d+l+ma+mi+j+v+s);
         if(hrInicio == 1 && d == 1 && l == 1 && ma==1 && mi == 1 && j == 1 && v == 1 && s == 1){
             //NUEVA VISTA
             ModelAndView mav = new ModelAndView();
             mav.setViewName("publicidad/programacion_listas");
             return mav;
         }else{
             //NUEVA VISTA
             ModelAndView mav = new ModelAndView();
             mav.addObject("exTitle", 1);
             mav.setViewName("templates/noresultado");
             return mav;
         }
         
    } 
}
