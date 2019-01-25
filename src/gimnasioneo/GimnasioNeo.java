/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gimnasioneo;

import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ODBServer;

import java.io.IOException;

/**
 *
 * @author a16cristiancc
 */
public class GimnasioNeo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
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
                    //Modificaciones.interes();
                    break;
                case 3:
                    //Consultas.clientesNumerosRojos();
                    break;
                case 4:
                    //Modificaciones.interes();
                    break;
                case 5:
                    //Bajas.cuentaPlazo();
                    break;
                case 6:
                    op2 = 0; /// Menu.consultas();
                    switch (op2) {
                        case 0:
                            System.out.println("Saliendo...");
                            break;
                        case 1:
                            //Consultas.clientesPorC();
                            break;
                        case 2:
                            //Consultas.clientesRicos();
                            break;
                        case 3:
                            //Consultas.clientesNumerosRojos();
                            break;
                        case 4:
                            //Consultas.saldoMedio();
                            break;
                        case 5:
                            //Consultas.clientes();
                            break;
                        case 6:
                            //Consultas.cuentasCorrientes();
                            break;
                        case 7:
                            //Consultas.cuentasPlazo();
                            break;
                        default:
                            System.out.println("Opción incorrecta");
                            System.exit(0);
                    }
                default:
                    throw new AssertionError();
            }

        } while (op != 0);

        server.close();
    }
    
}
