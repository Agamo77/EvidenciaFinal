import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        // Crear una instancia del sistema de gestión
        SistemaDeGestion sistema = new SistemaDeGestion();

        // Crear el escáner para recibir la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a Dr. Manager");

        boolean continuar = true;

        while (continuar) {
            //Creamos un menu para que el usuario interactue con el programa
            System.out.println("\nSelecciona una opcion:");
            System.out.println("1. Agregar nuevo doctor");
            System.out.println("2. Mostrar doctores registrados");
            System.out.println("3. Agregar nuevo paciente");
            System.out.println("4. Mostrar pacientes registrados");
            System.out.println("5. Salir");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    // Agregar un nuevo doctor
                    System.out.println("Por favor ingresa la información del doctor a agregar");

                    // Solicitar al usuario el nombre y especialidad del doctor
                    System.out.print("Nombre del doctor: ");
                    String nombreDoctor = scanner.nextLine();
                    System.out.print("Especialidad del doctor: ");
                    String especialidad = scanner.nextLine();

                    // Agregar el doctor al sistema
                    sistema.agregarDoctor(nombreDoctor, especialidad);
                    break;

                case "2":
                    // Mostrar los doctores registrados
                    System.out.println("\nDoctores registrados:");
                    sistema.mostrarDoctores();
                    break;

                case "3":
                    // Agregar un nuevo paciente
                    System.out.println("Por favor ingresa la información del paciente a agregar");

                    // Solicitar al usuario el nombre del paciente
                    System.out.print("Nombre del paciente: ");
                    String nombrePaciente = scanner.nextLine();

                    // Agregar el paciente al sistema
                    sistema.agregarPaciente(nombrePaciente);
                    break;

                case "4":
                    // Mostrar los pacientes registrados
                    System.out.println("\nPacientes registrados:");
                    sistema.mostrarPacientes();
                    break;

                case "5":
                    // Salir del programa
                    System.out.println("Gracias por usar Dr. Manager. Hasta la proxima!");
                    continuar = false;
                    break;

                default:
                    // Opción no válida
                    System.out.println("Opcion no válida. Intenta de nuevo");
            }
        }

        scanner.close();
    }
}
