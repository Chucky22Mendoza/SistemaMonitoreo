/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.alertas;

import com.objects.controller.Archivo;
import com.objects.controller.Usuario;
import com.getdata.controller.GetDataUser;
import com.getdata.controller.GetEvents;
import com.getdata.controller.GetFile;
import com.getdata.controller.kiosco_usuario_permiso;
import com.objects.controller.Evento;
import com.objects.controller.Kiosco;
import com.objects.controller.PermisoAlertaKiosco;
import com.objects.controller.permisoAlertaUsuario;
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
public class Controller_asignar_usuario {

    @RequestMapping("asignar_usuario.htm")
    public ModelAndView asig_usuario(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //VALIDAR EL ACCESO CON VARIABLES DE SESIÓN
        HttpSession session = request.getSession();
        String id = session.getAttribute("id_usuario").toString();
        String user = session.getAttribute("usuario").toString();
        String correo = session.getAttribute("correo").toString();
        String agencia = session.getAttribute("agencia").toString();
        //System.err.println("USUARIO " + user + " CORREO " + correo + " AGENCIA " + agencia);

        List<Usuario> usuarios = new ArrayList<>();
        List<Evento> eventos = new ArrayList<>();

        //MÉTODO QUE RETORNA UNA LISTA TIPO ARCHIVO
        usuarios = new GetDataUser().obtenerUsuarios();
        eventos = new GetEvents().obtenerEventos();

        //NUEVA VISTA
        ModelAndView mav = new ModelAndView();

        //PASAMOS EL ARRAY A LA VISTA
        mav.addObject("usuarios", usuarios);
        mav.addObject("evento", eventos);

        //ACCEDEMOS A VISTA
        mav.setViewName("alertas/asig_usuario");

        return mav;
    }

    @RequestMapping("usuario_kioscos.htm")
    public ModelAndView usuario_kioscos(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id = request.getParameter("id_usuario");
        int id_usuario = Integer.parseInt(id);

        //MÉTODO QUE RETORNA UNA LISTA TIPO ARCHIVO
        List<Integer> permiso = new kiosco_usuario_permiso().obtenerKiosco(id_usuario);
        List<PermisoAlertaKiosco> kiosco = new kiosco_usuario_permiso().obtenerPermisoKiosco(id_usuario);

        //NUEVA VISTA
        ModelAndView mav = new ModelAndView();

        //PASAMOS EL ARRAY A LA VISTA
        mav.addObject("permiso", permiso);
        mav.addObject("kiosco", kiosco);

        //ACCEDEMOS A VISTA
        mav.setViewName("templates/tabla_kioscos_usuario");

        return mav;
    }
    
    @RequestMapping("ingresar_kioscos.htm")
    public ModelAndView ingresar_kioscos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        String id = request.getParameter("id_kiosco");      
        String id2 = request.getParameter("id_usuario");
        int id_kiosco = Integer.parseInt(id);
        int id_usuario = Integer.parseInt(id2);
        
        int res = new kiosco_usuario_permiso().registrar_permiso(id_kiosco,id_usuario);
        
        if(res == 1){
            System.err.println("Insercción correcta ID KIOSCO: "+ id);
        }else{
            System.err.println("Error al registrar permisos ID KIOSCO: " + id);
        }
        
        ModelAndView mav = new ModelAndView();
        mav.addObject("exTitle",1);
        mav.setViewName("templates/noresultado");
        return mav;
    }
    
    @RequestMapping("borrar_asignados.htm")
    public ModelAndView borrar_asignados(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        String id = request.getParameter("id_usuario");      
        int id_usuario = Integer.parseInt(id);
        
        //NUEVA VISTA
        
        
        int res = new kiosco_usuario_permiso().eliminar_permiso(id_usuario);
        
        if(res == 1){
            System.err.println("Borrado correcto");
        }else{
            System.err.println("Error al borrar permisos");
        }
        //ACCEDEMOS A VISTA
        ModelAndView mav = new ModelAndView();
        mav.addObject("exTitle",1);
        mav.setViewName("templates/noresultado");
        return mav;
    }
    //AGREGAR UN NUEVO ARCHIVO
    @RequestMapping("/asig_eventos.htm")
    public ModelAndView asig_eventos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        String id = request.getParameter("id_usuario");      
        int id_usuario = Integer.parseInt(id);
        List<Evento> eventos = new ArrayList<>();
        List<Integer> evento_usuario = new ArrayList<>();
        
        //MÉTODO QUE RETORNA UNA LISTA TIPO ARCHIVO
        eventos = new GetEvents().obtenerEventos();
        evento_usuario = new GetEvents().obtenerEventos_Usuario(id_usuario);

        //NUEVA VISTA
        ModelAndView mav = new ModelAndView();

        //PASAMOS EL ARRAY A LA VISTA
        mav.addObject("evento", eventos);
        mav.addObject("evento_usuario", evento_usuario);
        
        mav.setViewName("templates/tabla_usuario_evento");
        return mav;
    }   
    
    @RequestMapping("/borrar_eventos.htm")
    public ModelAndView borrar_eventos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        String id = request.getParameter("id_usuario");      
        int id_usuario = Integer.parseInt(id);
        
        int res = new kiosco_usuario_permiso().eliminar_permiso_evento(id_usuario);
        if(res ==1){
            System.err.println("Eliminado correcto");
        }else{
            System.err.println("Error al eliminar, probabilidad de no haber cambios");
        }
        //NUEVA VISTA
        
        ModelAndView mav = new ModelAndView();
        mav.addObject("exTitle",1);
        mav.setViewName("templates/noresultado");
        return mav;
    }   
    
    @RequestMapping("ingresar_eventos.htm")
    public ModelAndView ingresar_eventos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        String Bsms = request.getParameter("sms");
        String Bcorreo = request.getParameter("correo");
        String id = request.getParameter("id_evento");      
        String id2 = request.getParameter("id_usuario");
        int id_evento = Integer.parseInt(id);
        int id_usuario = Integer.parseInt(id2);
        boolean sms = Boolean.parseBoolean(Bsms);
        boolean correo = Boolean.parseBoolean(Bcorreo);
        
        int res = new kiosco_usuario_permiso().registrar_permiso_evento(sms,correo,id_evento,id_usuario);
        
        if(res == 1){
            System.err.println("Insercción correcta ID KIOSCO: "+ id);
        }else{
            System.err.println("Error al registrar permisos ID KIOSCO: " + id);
        }
        
        ModelAndView mav = new ModelAndView();
        mav.addObject("exTitle",1);
        mav.setViewName("templates/noresultado");
        return mav;
    }
}
