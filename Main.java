import java.util.Scanner;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        
        SistemaDeGestion sistema = new SistemaDeGestion();

        
        Scanner scanner = new Scanner(System.in);

        // Bienvenida
        System.out.println("Bienvenido a Dr. Manager");

        // Preguntar al usuario si desea agregar un nuevo doctor
        System.out.println("¿Deseas agregar un nuevo doctor? (Ingresa 's' para SI y 'n' para NO)");
        String respuesta = scanner.nextLine();

        // Bucle para agregar doctores si la respuesta es 's'
        while (respuesta.equalsIgnoreCase("s")) {
            System.out.println("Por favor ingresa la información del doctor a agregar");

            // Solicitar al usuario el nombre y especialidad del doctor
            System.out.print("Nombre del doctor: ");
            String nombre = scanner.nextLine();
            System.out.print("Especialidad del doctor: ");
            String especialidad = scanner.nextLine();

            // Agregar el doctor al sistema
            sistema.agregarDoctor(nombre, especialidad);

            // Preguntar si desea agregar otro doctor
            System.out.println("¿Quieres agregar otro doctor a la base de datos? (Ingresa 's' para SI y 'n' para NO)");
            respuesta = scanner.nextLine();
        }

        // Mostrar los doctores registrados
        System.out.println("\nDoctores registrados:");
        sistema.mostrarDoctores();

        scanner.close();
    }
}
