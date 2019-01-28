package gimnasioneo;

import objetos.*;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

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
            case 4:
                usuarios();
                break;
            case 5:
                gimnasioPopular();
                break;
            default:
                System.out.println("Opcion incorrecta!!");
                break;
        }
    }


    public static void gimnasioPopular() {
        ODB odb = ODBFactory.openClient("localhost", 1227, "gimnasio");

        Objects<Gimnasios> gimnasios = odb.getObjects(Gimnasios.class);

        Gimnasios maximus = gimnasios.next();

        while (gimnasios.hasNext()){
            Gimnasios gym = gimnasios.next();
            if (gym.getNumSocios()>maximus.getNumSocios()){
                maximus = gym;
            }
        }

        System.out.println("<-----------GIMNASIO---------->");
        System.out.println("CIF: "+maximus.getCif());
        System.out.println("Nombre: "+maximus.getNombre());
        System.out.println("Numero de actividades: "+maximus.getActividades().size());
        System.out.println("Numero de socios: "+maximus.getNumSocios());
        System.out.println("<---------------------------->\n");

        odb.close();
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
        odb.close();

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
        odb.close();
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
            System.out.println("Cuota mensual: "+so.getCuota());
            System.out.println("<-------------------------->");
        }
        odb.close();
        return socios.size()>0;
    }

    public static boolean usuarios() {
        ODB odb = ODBFactory.openClient("localhost", 1227, "gimnasio");

        Objects<Usuarios> usuarios = odb.getObjects(Socios.class);

        for (Usuarios us : usuarios){
            System.out.println("<-----------SOCIO---------->");
            System.out.println("DNI: "+us.getDni());
            System.out.println("Nombre: "+us.getNombre());
            System.out.println("Numero de usos: "+us.getUsos().size());
            System.out.println("<-------------------------->");
        }
        odb.close();
        return usuarios.size()>0;
    }
}
