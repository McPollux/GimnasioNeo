package gimnasioneo;

import objetos.*;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ODBRuntimeException;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.NeoDatisError;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Altas implements iFace {

    public static void main() throws IOException, ParseException {

        byte op;

        op = Menu.altas();

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
                actividadGimnasio();
            case 4:
                cliente();
                break;
            case 5:
                uso();
                break;
            default:
                System.out.println("Opcion incorrecta!!");
                break;
        }
    }

    public static void gimnasio() throws IOException {
        ODB odb = ODBFactory.openClient("localhost", 1227, "gimnasio");

        System.out.println("Introduce el CIF del gimnasio:");
        String CIF = lee.readLine();

        System.out.println("Introduce el nombre del gimnasio:");
        String nombre = lee.readLine();

        Gimnasios gym = new Gimnasios(CIF, nombre);

        odb.store(gym);
        odb.commit();
        odb.close();
    }

    public static void actividad() throws IOException {
        ODB odb = ODBFactory.openClient("localhost", 1227, "gimnasio");

        System.out.println("Introduce el nombre de la actividad:");
        String nombre = lee.readLine();

        System.out.println("Introduce el tipo de actividad:");
        String tipo = lee.readLine();

        System.out.println("Introduce la cuota de la actividad:");
        float cuota = Float.parseFloat(lee.readLine());

        System.out.println("Introduce el descuento de la actividad para socios:");
        float descuento = Float.parseFloat(lee.readLine());

        Actividades actividad = new Actividades(nombre, tipo, cuota, descuento);

        odb.store(actividad);
        odb.commit();
        odb.close();
    }

    public static void actividadGimnasio() throws IOException {
        ODB odb = ODBFactory.openClient("localhost", 1227, "gimnasio");
        Actividades actividad = null;
        Gimnasios gym = null;
        //Consultar.actividades();

        do {
            System.out.println("Introduce el nombre de la actividad:");
            String nombre = lee.readLine();

            try {
                actividad = (Actividades) odb.getObjects(new CriteriaQuery(Actividades.class, Where.iequal("nombre", nombre))).getFirst();
            } catch (ODBRuntimeException e) {
                System.out.println("Actividad no encontrada en la base de datos, vuelve a intentarlo");
            }
        } while (actividad == null);

        //Consultar.gimnasios();

        do {
            System.out.println("Introduce el CIF del gimnasio:");
            String cif = lee.readLine();

            try {
                gym = (Gimnasios) odb.getObjects(new CriteriaQuery(Gimnasios.class, Where.iequal("cif", cif))).getFirst();
            } catch (ODBRuntimeException e) {
                System.out.println("Gimmasnio no encontrado en la base de datos, vuelve a intentarlo");
            }
        } while (gym  == null);

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
                gym.getActividades().add(actividad);
                odb.store(gym);
                odb.commit();
                break;
            default:
                System.out.println("Operacion cancelada!");
                break;
        }
        odb.close();
    }

    public static void cliente() throws IOException {
        ODB odb = ODBFactory.openClient("localhost", 1227, "gimnasio");
        Gimnasios gym = null;
        Clientes cliente;

        //Consultas.gimnasios();
        do {
            System.out.println("Introduce el CIF del gimnasio:");
            String cif = lee.readLine();

            try {
                gym = (Gimnasios) odb.getObjects(new CriteriaQuery(Gimnasios.class, Where.iequal("cif", cif))).getFirst();
            } catch (ODBRuntimeException e) {
                System.out.println("Gimmasnio no encontrado en la base de datos, vuelve a intentarlo");
            }

        } while (gym  == null);

        System.out.println("Introduce el dni del cliente:");
        String dni = lee.readLine();

        System.out.println("Introduce el nombre del cliente:");
        String nombre = lee.readLine();

        System.out.println("¿Este cliente es un socio o un usuario? [S|U]");
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
                cliente = new Socios(dni, nombre);
                gym.getClientes().add(cliente);
                odb.store(gym);
                odb.commit();
                break;
            case '6':
            case '7':
            case '8':
            case 'y':
            case 'u':
            case 'i':
            case 'h':
            case 'j':
            case 'k':
                cliente = new Usuarios(dni, nombre);
                gym.getClientes().add(cliente);
                odb.store(gym);
                odb.commit();
                break;
            default:
                System.out.println("Operacion cancelada!");
                break;
        }
        odb.close();
    }

    public static void uso() throws IOException, ParseException {
        ODB odb = ODBFactory.openClient("localhost", 1227, "gimnasio");
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Gimnasios gym = null;
        Socios socio;
        Usuarios usuario;
        Actividades actividad;

        //Consultas.gimnasios();
        do {
            System.out.println("Introduce el CIF del gimnasio:");
            String cif = lee.readLine();

            try {
                gym = (Gimnasios) odb.getObjects(new CriteriaQuery(Gimnasios.class, Where.iequal("cif", cif))).getFirst();
            } catch (ODBRuntimeException e) {
                System.out.println("Gimmasnio no encontrado en la base de datos, vuelve a intentarlo");
            }

        } while (gym  == null);

        for (Actividades ac : gym.getActividades()){
            System.out.println("<--------------------------->");
            System.out.println("Nombre: "+ac.getNombre()+
                               "Tipo: "+ac.getTipo()+
                               "Cuota: "+ac.getCuota());
            System.out.println("<--------------------------->");
        }

        if (gym.getActividades().size()==0){
            System.out.println("Este gimnasio no tiene actividades dadas de alta!");
        } else {
            do {
                System.out.println("Introduce el nombre de la actividad:");
                String nombre = lee.readLine();
                actividad = obtenerActividad(gym.getActividades(), nombre);
            }while(actividad==null);

            System.out.println("<---------------------->");
            System.out.println("Numero de socios: " +gym.getNumSocios());
            System.out.println("Numero de usuarios: "+gym.getNumUsuarios());
            System.out.println("¿El cliente es un socio o un usuario? [S|U]");
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
                    if (gym.getNumSocios()==0){
                        System.out.println("Este gimnasio no tiene socios dados de alta");
                    } else {
                        gym.printSocios();

                        do {
                            System.out.println("Introduce el DNI del socio:");
                            String dni = lee.readLine();

                            socio = obtenerSocio(gym.getClientes(), dni);
                        } while (socio == null);

                        System.out.println("Introduce la hora de salida: [HH:mm]");
                        Time fin = new Time(sdf.parse(lee.readLine()).getTime());

                        System.out.println("¿Estas seguro? [S|N]");
                        char respuesta2 = lee.readLine().toLowerCase().charAt(0);

                        switch (respuesta2) {
                            case 'q':
                            case 'w':
                            case 'e':
                            case 'a':
                            case 's':
                            case 'd':
                            case 'z':
                            case 'x':
                            case 'c':
                                Usos uso = new Usos(new Date(), fin, actividad);
                                socio.getUsos().add(uso);
                                odb.store(socio);
                                odb.commit();
                                break;
                            default:
                                System.out.println("Operacion cancelada!");
                                break;
                        }
                    }
                    break;
                case '6':
                case '7':
                case '8':
                case 'y':
                case 'u':
                case 'i':
                case 'h':
                case 'j':
                case 'k':
                    if (gym.getNumUsuarios()==0){
                        System.out.println("Este gimnasio no tiene usuarios dados de alta");
                    } else {
                        gym.printUsuarios();

                        do {
                            System.out.println("Introduce el DNI del usuario:");
                            String dni = lee.readLine();

                            usuario = obtenerUsuario(gym.getClientes(), dni);
                        } while (usuario == null);

                        System.out.println("Introduce la hora de salida: [HH:mm]");
                        Time fin = new Time(sdf.parse(lee.readLine()).getTime());

                        System.out.println("¿Estas seguro? [S|N]");
                        char respuesta2 = lee.readLine().toLowerCase().charAt(0);

                        switch (respuesta2) {
                            case 'q':
                            case 'w':
                            case 'e':
                            case 'a':
                            case 's':
                            case 'd':
                            case 'z':
                            case 'x':
                            case 'c':
                                Usos uso = new Usos(new Date(), fin, actividad);
                                usuario.getUsos().add(uso);
                                odb.store(usuario);
                                odb.commit();
                                break;
                            default:
                                System.out.println("Operacion cancelada!");
                                return;
                        }
                    }
                default:
                    System.out.println("Operacion cancelada!");
                    break;
            }
        }
        odb.close();
    }

    public static Actividades obtenerActividad(ArrayList<Actividades> actividades, String nombre) {
        for (Actividades ac : actividades){
            if (ac.getNombre().equalsIgnoreCase(nombre)){
                return ac;
            }
        }
        System.out.println("Nombre de la actividad mal intrducido!!");
        return null;
    }

    public static Socios obtenerSocio(ArrayList<Clientes> clientes, String dni) {
        for (Clientes cli : clientes){
            if (cli instanceof Socios && cli.getDni().equalsIgnoreCase(dni)){
                return (Socios)cli;
            }
        }
        System.out.println("DNI del socio mal introducido!!");
        return null;
    }

    public static Usuarios obtenerUsuario(ArrayList<Clientes> clientes, String dni) {
        for (Clientes cli : clientes){
            if (cli instanceof Usuarios && cli.getDni().equalsIgnoreCase(dni)){
                return (Usuarios)cli;
            }
        }
        System.out.println("DNI del socio mal introducido!!");
        return null;
    }
}
