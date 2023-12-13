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
    
   public void PorDesdeyDias() throws Exception{
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

        System.out.println("Selecciona la cantidad de dias");
        int diasDisp = sc.nextInt();
           System.out.println(diasDisp);

               for (Casas casa : casas) {  
                   LocalDate fechaDesde = casa.getFecha_desde().toLocalDate();
                   System.out.println("Fecha desde casa: " + desde);
                   System.out.println("Cantidad de dias: " + diasDisp);
                    if ((desde.isEqual(fechaDesde)) && (diasDisp > casa.getTiempo_minimo()) && (diasDisp < casa.getTiempo_maximo())) {
                    System.out.println(casa);
                   }
                   
               }
           
       } catch (Exception e) {
           e.printStackTrace();
           throw e;
       }
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
       public void CasasActualizadas(){
           try {
               Collection <Casas> casas = dao.listarCasas();
               if(casas.isEmpty()){
                   throw new Exception ("Error al listar casas");
               }
               for (Casas x : casas) {
                   double cincoporciento = x.getPrecio_habitacion() * 0.05;
                   double nuevoprecio = x.getPrecio_habitacion() + cincoporciento;
                   System.out.println("El precio anterior es: " + x.getPrecio_habitacion());
                   dao.modificarCasaPrecio(x,nuevoprecio);
                   System.out.println("El precio con la actualizacion del 5% es: " + x.getPrecio_habitacion());
                   System.out.println("--------------------------------------------------------------");
                   
               }
           } catch (Exception e) {
           }
   }
        public Casas buscarCasaseporId(Integer id) throws Exception{
        try {
            if (id == null){
                throw new Exception ("Indique un ID casa Correcto");
            }
            Casas casa = dao.buscarCasasporId(id);
            return casa;
        } catch (Exception e) {
            throw e;
        }
    }
 
    
    }

