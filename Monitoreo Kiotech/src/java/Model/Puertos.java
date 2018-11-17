/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package Model;

import gnu.io.CommPortIdentifier;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 *
 * @author Jesús Mendoza Verduzco
 */
public class Puertos {
    
    public List<String> puertos(){
        List<String> puertos = new ArrayList<String>();
        CommPortIdentifier port;
        Enumeration<?> puerto=CommPortIdentifier.getPortIdentifiers();
        while(puerto.hasMoreElements()){
            port=(CommPortIdentifier) puerto.nextElement();
            
            //System.out.println("Puerto: " + port.getName());
            puertos.add(port.getName());
        }
        
        return puertos;
    }
    
            
}
