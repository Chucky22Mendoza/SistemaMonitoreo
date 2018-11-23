/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.objects.controller.Archivo;
import com.objects.controller.ListaReproduccion;
import com.getdata.controller.GetFile;
import com.getdata.controller.GetKioscos;
import com.getdata.controller.GetPlayList;
import com.objects.controller.Agencia;
import com.objects.controller.Kiosco;
import com.objects.controller.Kiosco_Agencia;
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
            //Lista de id_kioscos a los que pertenece la agencia del usuario
            List<Integer> listKioscoAgencia = (List<Integer>) session.getAttribute("kioscos_usuario_agencia");
            List<Integer> listKioscoPermiso = (List<Integer>) session.getAttribute("kioscos_usuario_permiso");

            System.err.println(listKioscoAgencia);
            System.err.println(listKioscoPermiso);

            //OBTENEMOS LOS ARCHIVOS DE LA BASE DE DATOS Y LOS GUARDAMOS EN UN ARRAY TIPO ARCHIVO
            List<Kiosco_Agencia> kiosco = new ArrayList<>();
            List<Agencia> Ag = new ArrayList<>();

            //MÉTODO QUE RETORNA UNA LISTA TIPO ARCHIVO
            kiosco =new GetKioscos().obtenerKioscos();
            Ag = new GetKioscos().obtenerAgencias();
            //System.err.println(Agencia.get(0).getId_agencia());
            //NUEVA VISTA
            ModelAndView mav = new ModelAndView();

            //PASAMOS EL ARRAY A LA VISTA
            mav.addObject("kiosco", kiosco);
            mav.addObject("ag", Ag);

            //ACCEDEMOS A HOME
            mav.setViewName("home");

            return mav;

        }catch(Exception e){
            System.err.println("ERROR INTENTANDO INICIAR SESIÓN");
            return new ModelAndView("/");
        }

    }

    @RequestMapping("agencia.htm")
    public ModelAndView agencia(HttpServletRequest request, HttpServletResponse response) throws IOException{

            ModelAndView mav = new ModelAndView();
            //ACCEDEMOS A HOME
            mav.setViewName("home");

            return mav;

    }


    @RequestMapping("kiosko.htm")
    public ModelAndView kiosko(HttpServletRequest request, HttpServletResponse response) throws IOException{


        ModelAndView mav = new ModelAndView();
        mav.setViewName("home.htm");
        return mav;
    }

    
}
