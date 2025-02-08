import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        SistemaDeGestion SistemaDeGestion = new SistemaDeGestion();

        
        Scanner scanner = new Scanner(System.in);

      
        System.out.println("Bienvenido a Dr. Manager");

        
        System.out.println("¿Deseas agregar un nuevo doctor? (Ingresa 's' para SI y 'n' para NO)");
        String respuesta = scanner.nextLine();

        while (respuesta.equalsIgnoreCase("s")) {
            System.out.println("Por favor ingrese la informacion del doctor a agregar");

            // Solicitar al usuario el ID, nombre y especialidad
            System.out.print("ID del doctor: ");
            String id = scanner.nextLine();
            System.out.print("Nombre del doctor: ");
            String nombre = scanner.nextLine();
            System.out.print("Especialidad del doctor: ");
            String especialidad = scanner.nextLine();

          
            Doctores doctor = new Doctores(id, nombre, especialidad);
            SistemaDeGestion.agregarDoctor(doctor);

           
            System.out.println("¿Quieres agregar otro doctor a la base de datos?");
            respuesta = scanner.nextLine();
        }

        // Mostrar los doctores registrados
        SistemaDeGestion.mostrarDoctores();

        scanner.close();
    }
}
