package objetos;

import java.sql.Time;
import java.util.Date;

public class Usos {
    private Date fecha;
    private Time horaFin;
    private Actividades actividad;
    private float importeUso;

    public Usos(Date fecha, Time horaFin, Actividades actividad) {
        this.fecha = fecha;
        this.horaFin = horaFin;
        this.actividad = actividad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public Actividades getActividad() {
        return actividad;
    }

    public void setActividad(Actividades actividad) {
        this.actividad = actividad;
    }

    public float getImporteUso() {
        return importeUso;
    }

    public void setImporteUso(float importeUso) {
        this.importeUso = importeUso;
    }
}
