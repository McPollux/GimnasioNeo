package gimnasioneo;

import objetos.*;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

import java.io.IOException;
import java.text.ParseException;

public class Consultas {

    public static void main() throws IOException, ParseException {

        byte op;

        op = Menu.consultas();

        switch (op) {
            case 0:
                break;
            case 1:
                gimnasios();
                break;
            case 2:
                actividades();
                break;
            case 3:
                socios();
                break;
            default:
                System.out.println("Opcion incorrecta!!");
                break;
        }
    }


    public static boolean gimnasios() {
        ODB odb = ODBFactory.openClient("localhost", 1227, "gimnasio");

        Objects<Gimnasios> gimnasios = odb.getObjects(Gimnasios.class);

        for (Gimnasios gym : gimnasios){
            System.out.println("<-----------GIMNASIO---------->");
            System.out.println("CIF: "+gym.getCif());
            System.out.println("Nombre: "+gym.getNombre());
            System.out.println("Numero de actividades: "+gym.getActividades().size());
            System.out.println("Numero de clientes: "+gym.getClientes().size());
            System.out.println("<---------------------------->\n");
        }

        return gimnasios.size()>0;
    }

    public static boolean actividades() {
        ODB odb = ODBFactory.openClient("localhost", 1227, "gimnasio");

        Objects<Actividades> actividades = odb.getObjects(Actividades.class);

        for (Actividades ac : actividades){
            System.out.println("<----------ACTIVIDAD---------->");
            System.out.println("Tipo de actividad: "+ac.getTipo());
            System.out.println("Nombre: "+ac.getNombre());
            System.out.println("Cuota/hora: "+ac.getCuota());
            System.out.println("<----------------------------->\n");
        }
        return actividades.size()>0;
    }

    public static boolean socios() {
        ODB odb = ODBFactory.openClient("localhost", 1227, "gimnasio");

        Objects<Socios> socios = odb.getObjects(Socios.class);

        for (Socios so : socios){
            System.out.println("<-----------SOCIO---------->");
            System.out.println("DNI: "+so.getDni());
            System.out.println("Nombre: "+so.getNombre());
            System.out.println("Numero de usos: "+so.getUsos().size());
            System.out.println("Cuota mensual: "+((Socios)so).getCuota());
            System.out.println("<-------------------------->");
        }
        return socios.size()>0;
    }
}
