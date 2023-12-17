
package estancias.servicios;

import estancias.entidades.Comentarios;
import estancias.persistencia.comentariosDAO;
import java.util.Collection;


public class ComentariosService {
    
    private comentariosDAO dao;

    public ComentariosService() {
        this.dao = new comentariosDAO();
    }
    
    public void listarComentariosxCasa() throws Exception{
        try {
            Collection <Comentarios> comentarios = dao.listarComentarios();
            if(comentarios.isEmpty()){
                throw new Exception ("Error al traer la lista de comentarios");
            }
            for (Comentarios x : comentarios) {
                if (x.getCasas().getPais().contains("Reino") && (x.getComentario().contains("limpia"))) {
                    System.out.println(x.getCasas().getCalle() + " " + x.getCasas().getNumero() + " " + x.getCasas().getPais());
                    System.out.println("Comentario: " + x.getComentario());
                }
                
            }
            
        } catch (Exception e) {
            throw e;
        }
    }

    
}
