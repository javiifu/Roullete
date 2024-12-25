package Ruleta;
import java.util.Scanner;

public class Seguirjugando {
    Scanner sc = new Scanner(System.in);

    // Método para preguntar si el usuario quiere seguir jugando
    public String Seguirjugando() {
        String respuesta;
        do {
            System.out.println("¿Quiere seguir jugando? (Si/No)");
            respuesta = sc.nextLine().trim(); // Eliminar espacios adicionales
            if (respuesta.equalsIgnoreCase("Si") || respuesta.equalsIgnoreCase("No")) {
                return respuesta;
            }
            System.out.println("Lo siento, no te he entendido. Por favor, responde con 'Si' o 'No'.");
        } while (true);
    }
}
