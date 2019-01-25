package objetos;

public class Socios extends Clientes{
    private float cuota;


    public Socios(String dni, String nombre) {
        super(dni, nombre);
        this.cuota = 30;
    }

    @Override
    public void importeUso() {

    }
}
