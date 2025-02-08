import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

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

    // Agregar un nuevo doctor
    public void agregarDoctor(String nombre, String especialidad) {
        String id = generarIdUnicoDoctores();
        Doctores nuevoDoctor = new Doctores(id, nombre, especialidad);
        doctores.add(nuevoDoctor);
        guardarDoctores(nuevoDoctor);
    }

    // Generar un ID único para doctores
    private String generarIdUnicoDoctores() {
        return String.format("%04d", doctores.size() + 1);
    }

    // Guardar doctor en archivo CSV
    private void guardarDoctores(Doctores doctor) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoDoctores, true))) {
            writer.write(doctor.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Ocurrió un error al guardar el doctor: " + e.getMessage());
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
                if (datos.length == 5) {
                    Citas cita = new Citas(datos[0], LocalDateTime.parse(datos[1]), datos[2], datos[3], datos[4]);
                    citas.add(cita);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar citas: " + e.getMessage());
        }
    }

    // Mostrar citas registradas
    public void mostrarCitas() {
        if (citas.isEmpty()) {
            System.out.println("No hay citas registradas.");
        } else {
            System.out.println("Citas registradas:");
            for (Citas cita : citas) {
                System.out.println("Cita ID: " + cita.obtenerId() + ", Fecha: " + cita.obtenerFecha() +
                        ", Motivo: " + cita.obtenerMotivoConsulta() + ", Doctor: " + cita.obtenerNombreDoctor() +
                        ", Paciente: " + cita.obtenerNombrePaciente());
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
