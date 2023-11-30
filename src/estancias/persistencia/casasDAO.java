
package estancias.persistencia;

import estancias.entidades.Casas;
import java.time.LocalDate;



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
    public void modificarCasa (Casas casas, LocalDate fechaDesde, LocalDate fechaHasta, int tiempoMinimo, int tiempoMaximo,  Double precioHabitacion) throws Exception{
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
}
