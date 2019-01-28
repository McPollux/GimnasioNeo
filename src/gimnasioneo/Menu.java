package gimnasioneo;

import java.io.IOException;


public class Menu implements iFace {

    public static byte menu() throws IOException {
        System.out.println("\nMENU: "
                + "\n[1] Altas"
                + "\n[2] Bajas"
                + "\n[3] Consultas"
                + "\n[0] Salir");
        byte b = Byte.parseByte(lee.readLine());

        return b;
    }

    public static byte altas() throws IOException {

        System.out.println("\nMENU: "
                + "\n[1] Alta de gimnasio"
                + "\n[2] Alta de actividad"
                + "\n[3] Asociar actividad a un gimnasio"
                + "\n[4] Alta de un cliente"
                + "\n[5] Alta de un uso en un cliente especifico"
                + "\n[0] Salir");
        byte b = Byte.parseByte(lee.readLine());

        return b;
    }

    public static byte bajas() throws IOException {
        System.out.println("Elije una opción de baja:\n"
                + "[1] Baja de un gimnasio\n"
                + "[2] Baja de una actividad\n"
                + "[3] Baja de un socio\n"
                + "[0] Salir");
        byte b = Byte.parseByte(lee.readLine());
        return b;
    }

    public static byte consultas() throws IOException {
        System.out.println("Elige una opción de consulta:\n"
                + "[1] Consultar de todos los gimnasios\n"
                + "[2] Consultar de todos los actividades\n"
                + "[3] Consultar de todos los socios\n"
                + "[4] Consultar de todos los usuarios\n"
                + "[5] Consultar información del gimnasio con mas socios\n"
                + "[0] Salir");
        byte b = Byte.parseByte(lee.readLine());
        return b;
    }
}

