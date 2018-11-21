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
        List<PermisoAlertaKiosco> kiosco = new kiosco_usuario_permiso().obtenerKiosco(id_usuario);

        //NUEVA VISTA
        ModelAndView mav = new ModelAndView();

        //PASAMOS EL ARRAY A LA VISTA
        mav.addObject("kiosco", kiosco);

        //ACCEDEMOS A VISTA
        mav.setViewName("templates/tabla_kioscos_usuario");

        return mav;
    }
    //AGREGAR UN NUEVO ARCHIVO
    /*@RequestMapping("/Asig_Eventos.htm")


        //LLAMAMOS LAS VARIABLES MANDADAS POR EL AJAX
        //String nombre = request.getParameter("nombreList");
        //String descripcion = request.getParameter("descripcion");

        //OBJETOS NECESARIOS PARA REALIZAR EL ACCESO A LA DB
        //permisoAlertaUsuario permisoUsuario = new permisoAlertaUsuario();

        //UTILIZAMOS LA CLASE ARCHIVO PARA MANDAR LOS PARAMETROS
        //lista.setId(0);
        /*permisoUsuario.set
        permisoUsuario.setDescripcion(descripcion);

        //OBTENEMOS EL RESULTADO
        //int resultadoInsert = newList.nuevaLista(lista);
        System.err.println(resultadoInsert);
        if (resultadoInsert==1){
             //RECARGAMOS HOME
            return new ModelAndView("redirect:/home.htm");

        }else{
            return new ModelAndView("/");

        }*/

}
