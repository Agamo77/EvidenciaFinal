import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SistemaDeGestion {
    // Listas creadas para almacenar los doctores y pacientes
    private List<Doctores> doctores;
    private List<Pacientes> pacientes;
    // Asignamos un archivo CSV para guardar la lista de doctores
    private final String archivoDoctores = "doctores.csv";
    private final String archivoPacientes = "pacientes.csv";

    public SistemaDeGestion() {
        this.doctores = new ArrayList<>();
        this.pacientes  = new ArrayList<>();
        cargarDoctores();
        cargarPacientes();
    }

    // Creamos un método para agregar doctores a la lista
    public void agregarDoctor(String nombre, String especialidad) {
        // Generar un ID único para el doctor
        String id = generarIdUnico();
        Doctores nuevoDoctor = new Doctores(id, nombre, especialidad);

        doctores.add(nuevoDoctor);
        guardarDoctores(nuevoDoctor);
        System.out.println("Nuevo Doctor: " + nuevoDoctor.obtenerNombre());
    }

    //Este metodo genera un ID para el doctor que se vaya a agregar
    private String generarIdUnico() {
        // Lógica para generar un ID único
        return String.format("%04d", doctores.size() + 1);  // Ejemplo: "0001", "0002", ...
    }

    // Este metodo agrega la informacion del doctor al CSV
    private void guardarDoctores(Doctores doctor) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoDoctores, true))) {
            writer.write(doctor.obtenerId() + "," + doctor.obtenerNombre() + "," + doctor.obtenerEspecialidad());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en base de datos: " + e.getMessage());
        }
    }

    //Este metodo agrega pacientes a la lista
    public void agregarPaciente(String nombre) {
        String id = generarIdUnicoPacientes();
        Pacientes nuevoPaciente = new Pacientes(id, nombre);
        pacientes.add(nuevoPaciente);
        guardarPacientes(nuevoPaciente);
        System.out.println("Nuevo Paciente: " + nuevoPaciente.obtenerNombre());
    }

    //Este metodo genera un ID para el paciente agregado
    private String generarIdUnicoPacientes() {
        return String.format("%04d", pacientes.size() + 1);
    }

    //Este metodo guarda los pacientes en el CSV
    private void guardarPacientes(Pacientes paciente) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoPacientes, true))) {
            writer.write(paciente.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar el paciente nuevo: " + e.getMessage());
        }
    }

    //Con este metodo cargamos los pacientes desde el CSV
    private void cargarPacientes() {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoPacientes))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 2) {
                    String id = datos[0];
                    String nombre = datos[1];
                    Pacientes paciente = new Pacientes(id, nombre);
                    pacientes.add(paciente);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar pacientes: " + e.getMessage());
        }
    }

    // Este metodo carga la informacion de los doctores desde el CSV
    private void cargarDoctores() {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoDoctores))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 3) {  
                    String id = datos[0];  
                    String nombre = datos[1];
                    String especialidad = datos[2];

                    // Crear un nuevo doctor y agregarlo a la lista
                    Doctores doctor = new Doctores(id, nombre, especialidad);
                    doctores.add(doctor);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar doctores desde el archivo: " + e.getMessage());
        }
    }

    // Metodo para mostrar todos los doctores
    public void mostrarDoctores() {
        if (doctores.isEmpty()) {
            System.out.println("No se encontraron doctores en base de datos.");
        } else {
            System.out.println("Doctores actualmente en base de datos:");
            for (Doctores doctor : doctores) {
                System.out.println(doctor.obtenerNombre() + ": " + doctor.obtenerEspecialidad());
            }
        }
    }
    //Metodo para mostrar todos los pacientes
    public void mostrarPacientes() {
        if (pacientes.isEmpty()) {
            System.out.println("No se encontraron pacientes.");
        } else {
            System.out.println("Pacientes en la base de datos:");
            for (Pacientes paciente : pacientes) {
                System.out.println(paciente.obtenerNombre());
            }
        }
    }
}
