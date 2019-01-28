package objetos;

public class Usuarios extends Clientes {

    public Usuarios(String dni, String nombre) {
        super(dni, nombre);
    }

    @Override
    public float importeUso(Actividades actividad, long horaInicio, long horaFin) {

        int horas = (int)(horaFin - horaInicio)/(1000*60*60);

        return horas * actividad.getCuota();
    }
}
