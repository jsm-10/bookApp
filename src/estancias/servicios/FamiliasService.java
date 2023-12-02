
package estancias.servicios;

import estancias.entidades.Familias;
import estancias.persistencia.familiasDAO;
import java.util.Collection;
import java.util.Scanner;


public class FamiliasService {
    
    private familiasDAO dao;
    Scanner sc = new Scanner (System.in);

    public FamiliasService() {
        this.dao = new familiasDAO();
    }
public void FamiliasCaract() throws Exception{
    try {
        Collection <Familias> familias = dao.listarFamilias();
        if(familias.isEmpty()){
            throw new Exception ("Error al traer la lista de familias");
        }
        System.out.println("Selecciona la cantidad de hijos");
        int hijos = sc.nextInt();
        System.out.println("Selecciona la edad maxima que quiere clasificar");
        int edadMax = sc.nextInt();
        
        for (Familias x : familias) {
            if(x.getNum_hijos() == hijos && x.getEdad_maxima() <= edadMax){
                System.out.println(x);
            }
            
        }
    } catch (Exception e) {
        throw e;
    }
}    
public void FamiliasEmail() throws Exception{
    try {
        Collection <Familias> familias = dao.listarFamilias();
        if(familias.isEmpty()){
            throw new Exception ("Error al traer la lista de familias");
        }
        for (Familias x : familias) {
            if(x.getEmail().contains("hotmail")){
                System.out.println(x);
            }
            
        }
    } catch (Exception e) {
        throw e;
    }
}        
}
