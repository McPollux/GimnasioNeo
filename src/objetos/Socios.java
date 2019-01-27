package objetos;

public class Socios extends Clientes{
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
    public void importeUso() {


    }
}
