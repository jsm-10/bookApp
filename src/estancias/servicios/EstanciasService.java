
package estancias.servicios;

import estancias.entidades.Estancias;
import estancias.persistencia.estanciasDAO;
import java.util.Collection;


public class EstanciasService {
    
    private estanciasDAO dao;

    public EstanciasService() {
        this.dao = new estanciasDAO();
    }
    
    public Collection <Estancias> listarEstanciasClientesyCasa () throws Exception{
        try {
            Collection<Estancias> estancias = dao.listarClientescEstancias();
            
            return estancias;
        } catch (Exception e) {
            throw e;
        }
    }
    
}
