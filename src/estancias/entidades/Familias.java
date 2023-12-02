
package estancias.entidades;


public class Familias {
   int id_familia;
   String nombre;
   int edad_minima;
   int edad_maxima;
   int num_hijos;
   String email;
   int id_casa;

    public Familias(int id_familia, String nombre, int edad_minima, int edad_maxima, int num_hijos, String email, int id_casa) {
        this.id_familia = id_familia;
        this.nombre = nombre;
        this.edad_minima = edad_minima;
        this.edad_maxima = edad_maxima;
        this.num_hijos = num_hijos;
        this.email = email;
        this.id_casa = id_casa;
        
    }

    public Familias() {
    }
    

    public int getId_familia() {
        return id_familia;
    }

    public int getId_casa() {
        return id_casa;
    }

    public void setId_casa(int id_casa) {
        this.id_casa = id_casa;
    }

    public void setId_familia(int id_familia) {
        this.id_familia = id_familia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad_minima() {
        return edad_minima;
    }

    public void setEdad_minima(int edad_minima) {
        this.edad_minima = edad_minima;
    }

    public int getEdad_maxima() {
        return edad_maxima;
    }

    public void setEdad_maxima(int edad_maxima) {
        this.edad_maxima = edad_maxima;
    }

    public int getNum_hijos() {
        return num_hijos;
    }

    public void setNum_hijos(int num_hijos) {
        this.num_hijos = num_hijos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Familias{" + "id_familia=" + id_familia + ", nombre=" + nombre + ", edad_minima=" + edad_minima + ", edad_maxima=" + edad_maxima + ", num_hijos=" + num_hijos + ", email=" + email + '}';
    }
   
   
}
