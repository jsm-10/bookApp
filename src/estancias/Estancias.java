
package estancias;

import estancias.servicios.CasasService;
import estancias.servicios.FamiliasService;


public class Estancias {

    public static void main(String[] args) throws Exception {
        CasasService casasservice = new CasasService();
        FamiliasService fs = new FamiliasService();
        
//        try {
//            casasservice.PorPeriodo();
//        } catch (Exception e) {
//            throw new Exception ("error al intentar clasificar en periodos");
//        }
//        try {
//            fs.FamiliasCaract();
//        } catch (Exception e) {
//            throw new Exception ("Error al intentar clasificar las familias en hijos y edad maxima");
//        }
          try {
            fs.FamiliasEmail();
        } catch (Exception e) {
            throw new Exception ("Error al intentar clasificar las familias por el email");
        }

    }
    
}
