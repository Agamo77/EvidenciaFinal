import java.util.Scanner;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        
        SistemaDeGestion sistema = new SistemaDeGestion();

        // Crear el escáner para recibir la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Inicio del programa
        System.out.println("Bienvenido a Dr. Manager");

        boolean continuar = true;

        while (continuar) {
            //Creamos un menu para que el usuario interactue con el programa
            System.out.println("\nSelecciona una opcion:");
            System.out.println("1. Agregar Doctor");
            System.out.println("2. Agregar Paciente");
            System.out.println("3. Agregar Cita");
            System.out.println("4. Mostrar Doctores");
            System.out.println("5. Mostrar Pacientes");
            System.out.println("6. Mostrar Citas");
            System.out.println("7. Salir");

            
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    // Agregar doctor
                    System.out.print("Nombre del doctor: ");
                    String nombreDoctor = scanner.nextLine();
                    System.out.print("Especialidad del doctor: ");
                    String especialidadDoctor = scanner.nextLine();
                    sistema.agregarDoctor(nombreDoctor, especialidadDoctor);
                    break;
                case 2:
                    // Agregar paciente
                    System.out.print("Nombre del paciente: ");
                    String nombrePaciente = scanner.nextLine();
                    sistema.agregarPaciente(nombrePaciente);
                    break;
                case 3:
                    // Agregar cita
                    System.out.print("Fecha y hora de la cita (YYYY-MM-DDTHH:MM): ");
                    String fechaHoraString = scanner.nextLine();
                    LocalDateTime fechaHora = LocalDateTime.parse(fechaHoraString);
                    System.out.print("Motivo de la cita: ");
                    String motivoCita = scanner.nextLine();
                    System.out.print("Nombre del doctor: ");
                    String doctor = scanner.nextLine();
                    System.out.print("Nombre del paciente: ");
                    String paciente = scanner.nextLine();
                    sistema.agregarCita(fechaHora, motivoCita, doctor, paciente);
                    break;
                case 4:
                    sistema.mostrarDoctores();
                    break;
                case 5:
                    sistema.mostrarPacientes();
                    break;
                case 6:
                    sistema.mostrarCitas();
                    break;
                case 7:
                    continuar = false;
                    break;
                default:
                    System.out.println("Esa opcion es invalida.");
            }
        }

        scanner.close();
    }
}
