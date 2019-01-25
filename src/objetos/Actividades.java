package objetos;

public class Actividades {
    private String nombre;
    private String tipo;
    private float cuota;
    private float descuento;

    public Actividades(String nombre, String tipo, float cuota, float descuento) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.cuota = cuota;
        this.descuento = descuento;
    }

    public Actividades() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCuota() {
        return cuota;
    }

    public void setCuota(float cuota) {
        this.cuota = cuota;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
