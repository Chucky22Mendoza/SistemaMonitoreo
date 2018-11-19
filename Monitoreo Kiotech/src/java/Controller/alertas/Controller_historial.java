/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.alertas;

import com.objects.controller.Historial;
import com.getdata.controller.GetAlerts;
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
public class Controller_historial {
    @RequestMapping("historial.htm")
    public ModelAndView historial(HttpServletRequest request, HttpServletResponse response) throws IOException{

            //VALIDAR EL ACCESO CON VARIABLES DE SESIÓN
            HttpSession session = request.getSession();
            String id = session.getAttribute("id_usuario").toString();
            String user = session.getAttribute("usuario").toString();
            String correo = session.getAttribute("correo").toString();
            String agencia = session.getAttribute("agencia").toString();
            int id_usuario = Integer.parseInt(id);
            //OBTENEMOS LOS ARCHIVOS DE LA BASE DE DATOS Y LOS GUARDAMOS EN UN ARRAY TIPO ARCHIVO
            List<Historial> historial = new ArrayList<>();

            //MÉTODO QUE RETORNA UNA LISTA TIPO ARCHIVO
            //historial =new GetAlerts().obtenerAlertas();
            historial = new GetAlerts().obtenerAlertas(id_usuario);
            //System.err.println(historial.get(0).getStatus());
            //System.err.println(historial.get(0));
            //NUEVA VISTA
            ModelAndView mav = new ModelAndView();

            //PASAMOS EL ARRAY A LA VISTA
            mav.addObject("historial", historial);

            //ACCEDEMOS A HOME
            mav.setViewName("alertas/historial_alertas");

            return mav;
    }
    
    @RequestMapping("cambiar_status.htm")
    public ModelAndView cambiar_status(HttpServletRequest request, HttpServletResponse response) throws IOException{
            String status = request.getParameter("status");
            String id = request.getParameter("id_historial_alerta");
            
            int id_historial = Integer.parseInt(id);
            boolean stts = Boolean.parseBoolean(status);
            
            int res = new GetAlerts().uptdateStatus(stts,id_historial);
            
            if(res == 1){
                List<Historial> historial = new ArrayList<>();

                //MÉTODO QUE RETORNA UNA LISTA TIPO ARCHIVO
                historial =new GetAlerts().obtenerAlertas();
                
                //NUEVA VISTA
                ModelAndView mav = new ModelAndView();

                //PASAMOS EL ARRAY A LA VISTA
                mav.addObject("historial", historial);

                //ACCEDEMOS A HOME
                mav.setViewName("templates/tablaHistorialAlerta");

                return mav;
            }else{
                 ModelAndView mav = new ModelAndView();
                 mav.addObject("exTitle", 0);
                 mav.setViewName("templates/noresultado");
                 return mav;
            }
            
    }
}
