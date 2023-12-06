
package estancias.servicios;

import estancias.entidades.Clientes;
import estancias.persistencia.clientesDAO;


public class ClientesService {
    
    private clientesDAO dao;

    public ClientesService() {
        this.dao = new clientesDAO();
    }
    
    public Clientes buscarClienteporId(Integer id) throws Exception{
        try {
            if (id == null){
                throw new Exception ("Indique un ID cliente Correcto");
            }
            Clientes cliente = dao.buscarClientesporId(id);
            return cliente;
        } catch (Exception e) {
            throw e;
        }
    }
}
