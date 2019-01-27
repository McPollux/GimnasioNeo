package gimnasioneo;

import java.io.IOException;


public class Menu implements iFace {

    public static byte menu() throws IOException {
        System.out.println("\nMENU: "
                + "\n[1] Altas"
                + "\n[2] Modificar atributo interes en una cuenta plazo dando su número de cuenta"
                + "\n[3] Baja de una relación entre cliente y cuenta plazo"
                + "\n[4] Consultas"
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
        System.out.println("Elije una opción de consulta:\n"
                + "[1] Baja de un gimnasio\n"
                + "[2] Baja de una actividad\n"
                + "[3] Baja de un socio\n"
                + "[0] Salir");
        byte b = Byte.parseByte(lee.readLine());
        return b;
    }

    public static byte consultas() throws IOException {
        System.out.println("Elige una opción de consulta:\n"
                + "[1] Consultar de todos los autores italianos\n"
                + "[2] Consultar libros de un autor entre 2 fechas\n"
                + "[3] Consultar autores españoles menores de 60 años\n"
                + "[4] Visualizar por cada nación su numero de autores\n"
                + "[5] Consultar los libros de un autor\n"
                + "[6] Consultar autores\n"
                + "[7] Consultar libro con su autor\n"
                + "[8] Consultar libros\n"
                + "[0] Salir");
        byte b = Byte.parseByte(lee.readLine());
        return b;
    }
}

