
package estancias.entidades;


import java.sql.Date;


public class Estancias {
    int id_estancia;
    int id_cliente;
    int id_casa;
    String nombre_huesped;
    Date fecha_desde;
    Date fecha_hasta;
    Clientes cliente;
    Casas casas;

    public Estancias(int id_estancia, int id_cliente, int id_casa, String nombre_huesped, Date fecha_desde, Date fecha_hasta, Clientes cliente, Casas casas) {
        this.id_estancia = id_estancia;
        this.id_cliente = id_cliente;
        this.id_casa = id_casa;
        this.nombre_huesped = nombre_huesped;
        this.fecha_desde = fecha_desde;
        this.fecha_hasta = fecha_hasta;
        this.cliente = new Clientes();
        this.casas = new Casas();
    }

    public Estancias() {
    }

    public int getId_estancia() {
        return id_estancia;
    }

    public Casas getCasas() {
        return casas;
    }

    public void setCasas(Casas casas) {
        this.casas = casas;
    }

    public void setId_estancia(int id_estancia) {
        this.id_estancia = id_estancia;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_casa() {
        return id_casa;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public void setId_casa(int id_casa) {
        this.id_casa = id_casa;
    }

    public String getNombre_huesped() {
        return nombre_huesped;
    }

    public void setNombre_huesped(String nombre_huesped) {
        this.nombre_huesped = nombre_huesped;
    }

    public Date getFecha_desde() {
        return fecha_desde;
    }

    public void setFecha_desde(Date fecha_desde) {
        this.fecha_desde = fecha_desde;
    }

    public Date getFecha_hasta() {
        return fecha_hasta;
    }

    public void setFecha_hasta(Date fecha_hasta) {
        this.fecha_hasta = fecha_hasta;
    }

    @Override
    public String toString() {
        return "Estancias{" + "id_estancia=" + id_estancia + ", id_cliente=" + id_cliente + ", id_casa=" + id_casa + ", nombre_huesped=" + nombre_huesped + ", fecha_desde=" + fecha_desde + ", fecha_hasta=" + fecha_hasta + ", cliente=" + cliente + ", casas=" + casas + '}';
    }

    
    
    
}
