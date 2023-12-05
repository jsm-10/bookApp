
package estancias.persistencia;

import estancias.entidades.Clientes;
import java.util.ArrayList;
import java.util.Collection;


public final class clientesDAO extends DAO {
    
    public void guardarClientes (Clientes clientes) throws Exception{
        try {
            if(clientes == null){
                throw new Exception ("debe indicar un cliente valido");
            }
            String sql = "INSERT INTO clientes (id_cliente, nombre, calle, numero, codigo_postal, ciudad, pais, email) " + 
                    "VALUES ('" + clientes.getId_cliente() + "', '" + clientes.getNombre() + ", '" + clientes.getCalle() + "', '" + clientes.getNumero() + "', '"
                            + clientes.getCodigo_postal()+ "', '" + clientes.getCiudad() + "', '" + clientes.getPais() + "', '" + clientes.getEmail() + "');'";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    public Collection <Clientes> listarClientes() throws Exception{
        try {
            String sql = "SELECT * FROM clientes";
            consultarBase(sql);
            Clientes cliente = null;
            Collection <Clientes> clientes = new ArrayList();
            while (resultado.next()) {                
                cliente = new Clientes();
                cliente.setId_cliente(resultado.getInt(1));
                cliente.setCalle(resultado.getNString(2));
                cliente.setCalle(resultado.getNString(3));
                cliente.setNumero(resultado.getByte(4));
                cliente.setCodigo_postal(resultado.getNString(5));
                cliente.setCiudad(resultado.getNString(6));
                cliente.setPais(resultado.getNString(7));
                cliente.setEmail(resultado.getNString(8));
                clientes.add(cliente);
                
            }
            desconectarBase();
            return clientes;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception ("Error de sistema al listar los productos");
        }
    }
          
}
