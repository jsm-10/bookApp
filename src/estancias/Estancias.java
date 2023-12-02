
package estancias;

import estancias.servicios.CasasService;


public class Estancias {

    public static void main(String[] args) throws Exception {
        CasasService casasservice = new CasasService();
        
        try {
            casasservice.PorPeriodo();
        } catch (Exception e) {
            throw new Exception ("error al intentar clasificar en periodos");
        }
    }
    
}
