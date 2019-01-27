package objetos;

import java.util.ArrayList;

public abstract class Clientes {
    private String dni;
    private String nombre;
    private ArrayList<Usos> usos;

    public Clientes(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
        this.usos = new ArrayList();
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Usos> getUsos() {
        return usos;
    }

    public void setUsos(ArrayList<Usos> usos) {
        this.usos = usos;
    }

    public abstract float importeUso(Actividades actividad, long horaInicio, long horaFin);
}
