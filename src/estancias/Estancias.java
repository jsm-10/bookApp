
package estancias;

import estancias.servicios.CasasService;
import estancias.servicios.ComentariosService;
import estancias.servicios.EstanciasService;
import estancias.servicios.FamiliasService;


public class Estancias {

    public static void main(String[] args) throws Exception {
        CasasService casasservice = new CasasService();
        FamiliasService fs = new FamiliasService();
        EstanciasService es = new EstanciasService();
        ComentariosService cs = new ComentariosService();
        
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
//          try {
//            fs.FamiliasEmail();
//        } catch (Exception e) {
//            throw new Exception ("Error al intentar clasificar las familias por el email");
//        }*
//          try {
//            casasservice.PorDesdeyDias();
//            
//        } catch (Exception e) {
//            throw new Exception ("Error al clasificar en fecha y dias de disponibilidad");
//        }
//          try {
//              System.out.println(es.listarEstanciasClientesyCasa());
//        } catch (Exception e) {
//            throw new Exception ("Error al mostrar las estancias, personas y casas");
//        }
//          try {
//              casasservice.CasasActualizadas();
//        } catch (Exception e) {
//            throw new Exception ("La actualizacion no funciona");
//        }
//          try {
//            casasservice.separarCasasxPais();
//        } catch (Exception e) {
//            throw new Exception ("La clasificacion no funciono");
//        }
          try {
            cs.listarComentariosxCasa();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception ("Error al clasificar los comentarios");
        }
    }
    
}
