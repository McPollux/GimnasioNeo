package objetos;

public class Socios extends Clientes {
    private float cuota;


    public Socios(String dni, String nombre) {
        super(dni, nombre);
        this.cuota = 30;
    }

    public float getCuota() {
        return cuota;
    }

    public void setCuota(float cuota) {
        this.cuota = cuota;
    }

    @Override
    public float importeUso(Actividades actividad, long horaInicio, long horaFin) {
        int horas = (int)(horaFin - horaInicio)/1000*60*60;

        return actividad.getCuota()*horas*(1-actividad.getDescuento());
    }
}
