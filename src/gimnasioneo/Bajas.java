package gimnasioneo;

import objetos.*;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import java.io.IOException;
import java.text.ParseException;

public class Bajas implements iFace {


    public static void main() throws IOException, ParseException {

        byte op;

        op = Menu.bajas();

        switch (op) {
            case 0:
                break;
            case 1:
                gimnasio();
                break;
            case 2:
                actividad();
                break;
            case 3:
                socio();
                break;
            default:
                System.out.println("Opcion incorrecta!!");
                break;
        }
    }

    public static void gimnasio() throws IOException {
        ODB odb = ODBFactory.openClient("localhost", 1227, "gimnasio");

        if (Consultas.gimnasios()) {

            System.out.println("Introduce el CIF del gimnasio a eliminar:");
            String cif = lee.readLine();

            Objects<Gimnasios> objGym = odb.getObjects(new CriteriaQuery(Gimnasios.class, Where.ilike("cif", cif)));

            if (objGym.isEmpty()) {
                System.out.println("CIF del gimnasio mal introducido!");
            } else {
                System.out.println("¿Estas seguro? [S|N]");
                char respuesta = lee.readLine().toLowerCase().charAt(0);

                switch (respuesta) {
                    case 'q':
                    case 'w':
                    case 'e':
                    case 'a':
                    case 's':
                    case 'd':
                    case 'z':
                    case 'x':
                    case 'c':
                        odb.delete(objGym.getFirst());
                        odb.commit();
                        break;
                    default:
                        System.out.println("Operacion cancelada!");
                        break;
                }
            }
        } else {
            System.out.println("No hay gimasios disponibles en la base de datos!");
        }
        odb.close();
    }

    public static void actividad() throws IOException {
        ODB odb = ODBFactory.openClient("localhost", 1227, "gimnasio");

        if (Consultas.actividades()) {

            System.out.println("Introduce el nombre de la actividad a eliminar:");
            String nombre = lee.readLine();

            Objects<Actividades> objActividad = odb.getObjects(new CriteriaQuery(Actividades.class, Where.ilike("nombre", nombre)));

            if (objActividad.isEmpty()) {
                System.out.println("Nombre de la actividad mal introducido!");
            } else {
                System.out.println("¿Estas seguro? [S|N]");
                char respuesta = lee.readLine().toLowerCase().charAt(0);

                switch (respuesta) {
                    case 'q':
                    case 'w':
                    case 'e':
                    case 'a':
                    case 's':
                    case 'd':
                    case 'z':
                    case 'x':
                    case 'c':
                        odb.delete(objActividad.getFirst());
                        odb.commit();
                        break;
                    default:
                        System.out.println("Operacion cancelada!");
                        break;
                }
            }
        } else {
            System.out.println("No hay actividades disponibles en la base de datos!");
        }
        odb.close();
    }

    public static void socio() throws IOException {
        ODB odb = ODBFactory.openClient("localhost", 1227, "gimnasio");

        if (Consultas.socios()) {

            System.out.println("Introduce el dni del socio a eliminar:");
            String dni = lee.readLine();

            Objects<Socios> objSocios = odb.getObjects(new CriteriaQuery(Socios.class, Where.ilike("dni", dni)));

            if (objSocios.isEmpty()) {
                System.out.println("Nombre de la actividad mal introducido!");
            } else {
                System.out.println("¿Estas seguro? [S|N]");
                char respuesta = lee.readLine().toLowerCase().charAt(0);

                switch (respuesta) {
                    case 'q':
                    case 'w':
                    case 'e':
                    case 'a':
                    case 's':
                    case 'd':
                    case 'z':
                    case 'x':
                    case 'c':
                        odb.delete(objSocios.getFirst());
                        odb.commit();
                        break;
                    default:
                        System.out.println("Operacion cancelada!");
                        break;
                }
            }
        } else {
            System.out.println("No hay socios disponibles en la base de datos!");
        }
        odb.close();
    }
}
