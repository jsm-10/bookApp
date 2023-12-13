
package estancias.persistencia;

import estancias.entidades.Casas;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;



public final class casasDAO extends DAO {
    
    
    
    
    public void guardarCasa (Casas casas) throws Exception{
        try {
            if (casas == null){
                throw new Exception ("Debe indicar una casa valida");
            }
            String sql = "INSERT INTO casas (calle, numero, codigo_postal, ciudad, pais, fecha_desde, fecha_hasta, tiempo_minimo, tiempo_maximo, precio_habitacion, tipo_vivienda)" +
                    "VALUES ('" + casas.getCalle() + "', '" + casas.getNumero() + "', '" + casas.getCodigo_postal() + "', '" + casas.getCiudad() + "', '" + casas.getPais() + "', '" +
                    casas.getFecha_desde() + "', '" + casas.getFecha_hasta() + "', '" + casas.getTiempo_minimo() + "', '" + casas.getTiempo_maximo() + "', '" + casas.getPrecio_habitacion() + "', '"+
                    casas.getTipo_vivienda()+"');";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    public void modificarCasa (Casas casas, Date fechaDesde, Date fechaHasta, int tiempoMinimo, int tiempoMaximo,  Double precioHabitacion) throws Exception{
        try {
            if(casas == null){
                throw new Exception ("Indicar una casa valida");
            }
            if (precioHabitacion != null){
                casas.setPrecio_habitacion(precioHabitacion);
            }
            if (fechaDesde != null){
                casas.setFecha_desde(fechaHasta);
            }
            if (fechaHasta != null){
                casas.setFecha_hasta(fechaDesde);
            }
            if (tiempoMinimo != Integer.MIN_VALUE){
                casas.setTiempo_minimo(tiempoMinimo);
            }
             if (tiempoMaximo != Integer.MIN_VALUE){
                casas.setTiempo_maximo(tiempoMaximo);
            }
            String sql = "UPDATE casas SET";
             if (precioHabitacion != null){
                sql += " habitacion_precio = " + precioHabitacion + ", ";
            }
            if (fechaDesde != null){
                sql += " fecha_desde = " + fechaDesde + ", ";
            }
            if (fechaHasta != null){
                sql += " fecha_hasta = " + fechaHasta + ", ";
            }
            if (tiempoMinimo != Integer.MIN_VALUE){
                sql += " tiempo_minimo = " + tiempoMinimo + ", ";
            }
             if (tiempoMaximo != Integer.MIN_VALUE){
                sql += " tiempo_maximo = " + tiempoMaximo + ", ";
            }
             
        sql = sql.substring(0, sql.length() - 1) + " WHERE id_casa = '" + casas.getId_casa() + "'";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    public void eliminarCasa (String calle, int numero) throws Exception{
        try {
            String sql = "DELETE FROM casas WHERE calle = '" + calle + "' AND numero ='" + numero + "'";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
   public Casas buscarCasa(String calle)throws Exception{
       try {
           String sql = "SELECT * FROM casas WHERE calle= '" + calle + "'";
           consultarBase(sql);
           Casas casas = null;
           while (resultado.next()){
               casas = new Casas();
               casas.setId_casa(resultado.getByte(1));
               casas.setCalle(resultado.getNString(2));
               casas.setNumero(resultado.getByte(3));
               casas.setCodigo_postal(resultado.getNString(4));
               casas.setCiudad(resultado.getNString(5));
               casas.setPais(resultado.getNString(6));
               casas.setFecha_desde(resultado.getDate(7));
               casas.setFecha_hasta(resultado.getDate(8));
               casas.setTiempo_minimo(resultado.getInt(9));
               casas.setTiempo_maximo(resultado.getInt(10));
               casas.setPrecio_habitacion(resultado.getDouble(11));
               casas.setTipo_vivienda(resultado.getString(12));
               }
           desconectarBase();
           return casas;
           }
       catch (Exception e) {
           e.printStackTrace();
           desconectarBase();
           throw new Exception ("Error al buscar casas");
       }
    
   } 
   public Collection <Casas> listarCasas() throws Exception{
        try {
           String sql = "SELECT * FROM casas";
            consultarBase(sql);
            Casas casas = null;
            Collection <Casas> casass = new ArrayList();
            while (resultado.next()) {
             casas = new Casas();
             casas.setCalle(resultado.getNString(2));
             casas.setNumero(resultado.getInt(3));
             casas.setCodigo_postal(resultado.getNString(4));
             casas.setCiudad(resultado.getNString(5));
             casas.setPais(resultado.getNString(6));
             casas.setFecha_desde(resultado.getDate(7));
             casas.setFecha_hasta(resultado.getDate(8));
             casas.setTiempo_minimo(resultado.getInt(9));
             casas.setTiempo_maximo(resultado.getInt(10));
             casas.setPrecio_habitacion(resultado.getDouble(11));
             casas.setTipo_vivienda(resultado.getString(12));
             casass.add(casas);
            }
            desconectarBase();
            return casass;
       } catch (Exception e) {
           e.printStackTrace();
           desconectarBase();
           throw new Exception("Error de sistema");
       }
    }
   public Casas buscarCasasporId (Integer id) throws Exception{
       try {
           String sql = "SELECT * FROM casas WHERE id_casa = " + id + "";
           consultarBase(sql);
           Casas casa = null;
           while (resultado.next()) {               
               casa = new Casas();
               casa.setId_casa(resultado.getByte(1));
               casa.setCalle(resultado.getNString(2));
               casa.setNumero(resultado.getByte(3));
               casa.setCodigo_postal(resultado.getNString(4));
               casa.setCiudad(resultado.getNString(5));
               casa.setPais(resultado.getNString(6));
               casa.setPrecio_habitacion(resultado.getDouble(11));
           }
           desconectarBase();
           return casa;
       } catch (Exception e) {
           desconectarBase();
           throw e;
           
       }
      
           
       }
    public void modificarCasaPrecio (Casas casa, double nuevoPrecio) throws Exception{
        try {
            if(casa == null){
                throw new Exception ("La casa no se encuentra");
            }
            casa.setPrecio_habitacion(nuevoPrecio);
            String sql = "UPDATE casas SET precio_habitacion = '" + casa.getPrecio_habitacion() + "' WHERE id_casa = '" + casa.getId_casa() + "'";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
   }
    
}
