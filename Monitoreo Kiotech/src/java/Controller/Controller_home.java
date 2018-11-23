/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.getdata.controller.DatosAgencia;
import com.getdata.controller.DatosKiosco;
import com.objects.controller.Archivo;
import com.objects.controller.ListaReproduccion;
import com.getdata.controller.GetFile;
import com.getdata.controller.GetKioscos;
import com.getdata.controller.GetPlayList;
import com.objects.controller.Agencia;
import com.objects.controller.Alertas_Agencia_Mes;
import com.objects.controller.Contenedor_Actual;
import com.objects.controller.Denom_Dispensada;
import com.objects.controller.Disp_Vending;
import com.objects.controller.Impresora;
import com.objects.controller.Kiosco;
import com.objects.controller.Kiosco_Agencia;
import com.objects.controller.Kiosco_Gen;
import com.objects.controller.Total_X_Denomimacion_Recibida;
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
        String id = request.getParameter("id_agencia");
        int id_agencia = Integer.parseInt(id);
        
        String agencia = new DatosAgencia().obtenerAgencia(id_agencia);
        int num_alertas = new DatosAgencia().obtenerNumAlertas(id_agencia);
        int status1 = new DatosAgencia().obtenerNumeroKioscoStatus1(id_agencia);
        int status2 = new DatosAgencia().obtenerNumeroKioscoStatus2(id_agencia);
        int status3 = new DatosAgencia().obtenerNumeroKioscoStatus3(id_agencia);
        List<Alertas_Agencia_Mes> alertas_mes = new DatosAgencia().obtenerNumAlertasKiosco(id_agencia);
        
        ModelAndView mav = new ModelAndView();
        //ACCEDEMOS A HOME
        mav.addObject("agencia",agencia);
        mav.addObject("num_alertas",num_alertas);
        mav.addObject("status1",status1);
        mav.addObject("status2",status2);
        mav.addObject("status3",status3);
        mav.addObject("alertas_mes",alertas_mes);
        
        
        mav.setViewName("templates/Informacion_Agencia");
        
        return mav;

    }


    @RequestMapping("kiosco.htm")
    public ModelAndView kiosco(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String id = request.getParameter("id_kiosco");
        int id_kiosco = Integer.parseInt(id);
        
        List<Kiosco_Gen> kiosco_gen = new DatosKiosco().obtenerKiosco(id_kiosco);
        int numAlertas = new DatosKiosco().numAlertas(id_kiosco);
        List<Disp_Vending> dv = new DatosKiosco().obtenerDV(id_kiosco);
        List<Impresora> impresora = new DatosKiosco().obtenerImpresora(id_kiosco);
        String corte = new DatosKiosco().obtenerCorteCaja(id_kiosco);
        String total_recibido = new DatosKiosco().totalRecibido(id_kiosco);
        List<Total_X_Denomimacion_Recibida> total_x_den = new DatosKiosco().denomRecibidas(id_kiosco);
        List<Contenedor_Actual> contenedor = new DatosKiosco().contenedorActual(id_kiosco);
        String total_disp = new DatosKiosco().efectivoDisponible(id_kiosco);
        List<Denom_Dispensada> disp_x_den = new DatosKiosco().denominacionDispensada(id_kiosco);
        
        String[] cort = corte.split(" ");
        String hora = cort[1];
        String[] fecha = cort[0].split("-");
        String year = fecha[0];
        String mes = fecha[1];
        String dia = fecha[2];
        int Nmes = Integer.parseInt(mes);
        switch(Nmes){
            case 1:
                mes ="enero";
            case 2:
                mes = "febrero";
            case 3:
                mes = "marzo";
            case 4:
                mes = "abril";
            case 5:
                mes = "mayo";
            case 6:
                mes = "junio";
            case 7:
                mes = "julio";
            case 8:
                mes = "agosto";
            case 9:
                mes = "septiembre";
            case 10:
                mes = "octubre";
            case 11:
                mes = "noviembre";
            case 12:
                mes = "diciembre";                
        }
        
        corte = "Fecha de último corte: " + dia + " de " + mes + " de " + year + " a las " + hora + " hrs.";
                
        ModelAndView mav = new ModelAndView();
        mav.addObject("kiosco_gen",kiosco_gen);
        mav.addObject("numAlertas",numAlertas);
        mav.addObject("dv",dv);
        mav.addObject("impresora",impresora);
        mav.addObject("corte",corte);
        mav.addObject("total_recibido",total_recibido);
        mav.addObject("total_x_den",total_x_den);
        mav.addObject("contenedor",contenedor);
        mav.addObject("total_disp",total_disp);
        mav.addObject("disp_x_den",disp_x_den);
        
        mav.setViewName("templates/Informacion_Kiosco");
        return mav;
    }

    @RequestMapping("mantenimiento.htm")
    public ModelAndView mantenimiento(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String id = request.getParameter("id_kiosco");
        int id_kiosco = Integer.parseInt(id);
        
        int res = new DatosKiosco().mantenimiento(id_kiosco);
        
        if(res == 1){
            ModelAndView mav = new ModelAndView();
            mav.addObject("exTitle",1);
            mav.setViewName("templates/noresultado");
            return mav;
        }else{
            ModelAndView mav = new ModelAndView();
            mav.addObject("exTitle",0);
            mav.setViewName("templates/noresultado");
            return mav;
        }
    }
    
    @RequestMapping("apagado.htm")
    public ModelAndView apagado(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String id = request.getParameter("id_kiosco");
        int id_kiosco = Integer.parseInt(id);
        
        int res = new DatosKiosco().apagado(id_kiosco);
        
        if(res == 1){
            ModelAndView mav = new ModelAndView();
            mav.addObject("exTitle",1);
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
