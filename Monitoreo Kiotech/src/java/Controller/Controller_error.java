/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jesús Mendoza
 */
@Controller
public class Controller_error {
    
    @RequestMapping("error.htm")
    public ModelAndView error(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("error");
        return mav;
    }
}
