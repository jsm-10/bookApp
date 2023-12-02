
package estancias.persistencia;

import estancias.entidades.Familias;
import java.util.ArrayList;
import java.util.Collection;


public final class familiasDAO extends DAO {
    
    public Collection <Familias> listarFamilias() throws Exception{
        
        try {
            String sql = "SELECT * FROM familias";
            consultarBase(sql);
            Familias familia = null;
            Collection <Familias> familias = new ArrayList();
            while (resultado.next()) {                
                familia = new Familias();
                familia.setId_familia(resultado.getInt(1));
                familia.setNombre(resultado.getNString(2));
                familia.setEdad_minima(resultado.getInt(3));
                familia.setEdad_maxima(resultado.getInt(4));
                familia.setNum_hijos(resultado.getInt(5));
                familia.setEmail(resultado.getString(6));
                familia.setId_casa(resultado.getInt(7));
                familias.add(familia); 
            }
            desconectarBase();
            return familias;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception ("Error al listar las familias");
        }
        
    }
}
