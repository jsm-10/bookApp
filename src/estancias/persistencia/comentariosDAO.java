
package estancias.persistencia;

import estancias.entidades.Casas;
import estancias.entidades.Comentarios;
import estancias.servicios.CasasService;
import java.util.ArrayList;
import java.util.Collection;


public final class comentariosDAO extends DAO {
    
    private final CasasService casasservice;
    casasDAO casasdao;

    public comentariosDAO() {
        this.casasservice = new CasasService();
        this.casasdao = new casasDAO();
    }
    
    
    
    public void guardarComentario (Comentarios comentarios) throws Exception{
        try {
            if (comentarios == null){
                throw new Exception ("indique un comentario valido");
                
            }
            String sql = "INSERT INTO comentarios (id_comentario, id_casa, comentario)" + "VALUES ('" + comentarios.getId_comentario() + "', '" + comentarios.getId_casa() +"', '" + comentarios.getComentario() + "');";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    public Collection<Comentarios> listarComentarios() throws Exception{
        try {
            String sql = "SELECT * FROM comentarios";
            consultarBase(sql);
            Comentarios comentario = null;
            Collection <Comentarios> comentarios = new ArrayList();
            while (resultado.next()) {                
                comentario = new Comentarios();
                comentario.setId_comentario(resultado.getInt(1));
                Integer idCasa = resultado.getInt(2);
                comentario.setId_casa(resultado.getInt(2));
                Casas casa = casasdao.buscarCasasporId(idCasa);
                comentario.setCasas(casa);
                comentario.setComentario(resultado.getString(3));
                comentarios.add(comentario);
               
            }
            desconectarBase();
            return comentarios;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
}
