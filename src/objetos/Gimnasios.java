
package objetos;

import java.util.ArrayList;

/**
 *
 * @author a16cristiancc
 */
public class Gimnasios {
    private String cif;
    private String nombre;
    private ArrayList<Actividades> actividades;
    private ArrayList<Clientes> clientes;

    public Gimnasios(String cif, String nombre) {
        this.cif = cif;
        this.nombre = nombre;
        this.actividades = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Actividades> getActividades() {
        return actividades;
    }

    public void setActividades(ArrayList<Actividades> actividades) {
        this.actividades = actividades;
    }

    public ArrayList<Clientes> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Clientes> clientes) {
        this.clientes = clientes;
    }
}
