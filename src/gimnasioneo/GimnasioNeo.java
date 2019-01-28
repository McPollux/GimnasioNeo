/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gimnasioneo;

import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ODBServer;

import java.io.IOException;
import java.text.ParseException;

/**
 *
 * @author a16cristiancc
 */
public class GimnasioNeo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ParseException {
        ODBServer server = ODBFactory.openServer(1227);
        byte op, op2;
        try {
            server.addBase("gimnasio", "gimnasio.db");
            server.startServer(true);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        do {
            op = Menu.menu();
            switch (op) {
                case 0:
                    System.out.println("Saliendo...");
                    break;
                case 1:
                    Altas.main();
                    break;
                case 2:
                    Bajas.main();
                    break;
                case 3:
                    Consultas.main();
                    break;
                default:
                    throw new AssertionError();
            }

        } while (op != 0);

        server.close();
    }
    
}
