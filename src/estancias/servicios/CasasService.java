/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estancias.servicios;

import estancias.entidades.Casas;
import estancias.persistencia.casasDAO;
import java.util.Collection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author juans
 */
public class CasasService {
    
    private casasDAO dao;

    public CasasService() {
        this.dao = new casasDAO();
    }
    
   public void PorPeriodo() throws Exception{
       try {
           Collection <Casas> casas = dao.listarCasas();
           Scanner sc = new Scanner(System.in);
           System.out.println("Seleccionar fecha desde y hasta:");

        
           if(casas.isEmpty()){
               throw new Exception ("Error al listar casas");
  
           }
        System.out.println("Seleccionar fecha desde (YYYY-MM-DD): ");
        String desdeStr = sc.next();
        LocalDate desde = LocalDate.parse(desdeStr);
           System.out.println(desde);

        System.out.println("Seleccionar fecha hasta (YYYY-MM-DD): ");
        String hastaStr = sc.next();
        LocalDate hasta = LocalDate.parse(hastaStr);
           System.out.println(hasta);

               for (Casas casa : casas) {  
                   LocalDate fechaMinima = casa.getFecha_desde().toLocalDate();
                   LocalDate fechaMaxima = casa.getFecha_hasta().toLocalDate();
                   System.out.println("Fecha desde casa: " + fechaMinima);
                   System.out.println("Fecha hasta casa: " + fechaMaxima);
                    if ((desde.isEqual(fechaMinima)) && (hasta.isEqual(fechaMaxima))) {
                    System.out.println(casa);
                   }
                   
               }
           
       } catch (Exception e) {
           e.printStackTrace();
           throw e;
       }
   }
 
        
    }
