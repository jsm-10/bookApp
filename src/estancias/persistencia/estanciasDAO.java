
package estancias.persistencia;


import estancias.entidades.Casas;
import estancias.entidades.Clientes;
import estancias.entidades.Estancias;
import estancias.servicios.CasasService;
import estancias.servicios.ClientesService;
import java.util.ArrayList;
import java.util.Collection;


public final class estanciasDAO extends DAO {
    
    private final ClientesService clientesservice;
    private final CasasService casasservice;

    public estanciasDAO() {
        this.clientesservice = new ClientesService();
        this.casasservice = new CasasService();
    }
    
    
    
    public Collection<Estancias> listarClientescEstancias () throws Exception{
        try {
            String sql = "SELECT * FROM estancias";
            consultarBase(sql);
            Estancias estancia = null;
            Collection <Estancias> estancias = new ArrayList();
            while(resultado.next()){
                estancia = new Estancias();
                Integer idCliente = resultado.getInt(2);
                Clientes cliente = clientesservice.buscarClienteporId(idCliente);
                estancia.setCliente(cliente);
                Integer idCasa = resultado.getInt(3);
                Casas casa = casasservice.buscarCasaseporId(idCasa);
                estancia.setCasas(casa);
                estancias.add(estancia);
            }
            desconectarBase();
            return estancias;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
    
}
