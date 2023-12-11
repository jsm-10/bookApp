
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
    casasDAO casasdao;

    public estanciasDAO() {
        this.clientesservice = new ClientesService();
        this.casasservice = new CasasService();
        this.casasdao = new casasDAO();
    }
    
    
    
    public Collection<Estancias> listarClientescEstancias () throws Exception{
        try {
            String sql = "SELECT * FROM estancias";
            consultarBase(sql);
            Estancias estancia = null;
            Collection <Estancias> estancias = new ArrayList();
            while(resultado.next()){
                estancia = new Estancias();
                estancia.setId_estancia(resultado.getInt(1));
                estancia.setId_cliente(resultado.getInt(2));
                Integer idCliente = resultado.getInt(2);
                System.out.println(resultado.getInt(2));
                Clientes cliente = clientesservice.buscarClienteporId(idCliente);
                estancia.setCliente(cliente);
                Integer idCasa = resultado.getInt(3);
                estancia.setId_casa(resultado.getInt(3));
                Casas casa = casasdao.buscarCasasporId(idCasa);
                estancia.setCasas(casa);
                estancia.setNombre_huesped(resultado.getNString(4));
                estancia.setFecha_desde(resultado.getDate(5));
                estancia.setFecha_hasta(resultado.getDate(6));
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
