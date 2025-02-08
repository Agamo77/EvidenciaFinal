import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class SistemaDeGestion {
    private List<Doctores> doctores;
    private List<Pacientes> pacientes;
    private List<Citas> citas;
    private final String archivoDoctores = "doctores.csv";
    private final String archivoPacientes = "pacientes.csv";
    private final String archivoCitas = "citas.csv";

    public SistemaDeGestion() {
        this.doctores = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        this.citas = new ArrayList<>();
        cargarDoctores();
        cargarPacientes();
        cargarCitas();
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

    // Cargar doctores desde archivo CSV
    private void cargarDoctores() {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoDoctores))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 3) {
                    Doctores doctor = new Doctores(datos[0], datos[1], datos[2]);
                    doctores.add(doctor);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar doctores: " + e.getMessage());
        }
    }

    // Agregar un nuevo paciente
    public void agregarPaciente(String nombre) {
        String id = generarIdUnicoPacientes();
        Pacientes nuevoPaciente = new Pacientes(id, nombre);
        pacientes.add(nuevoPaciente);
        guardarPacientes(nuevoPaciente);
    }

    // Generar un ID único para pacientes
    private String generarIdUnicoPacientes() {
        return String.format("%04d", pacientes.size() + 1);
    }

    // Guardar paciente en archivo CSV
    private void guardarPacientes(Pacientes paciente) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoPacientes, true))) {
            writer.write(paciente.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Ocurrió un error al guardar el paciente: " + e.getMessage());
        }
    }

    // Cargar pacientes desde archivo CSV
    private void cargarPacientes() {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoPacientes))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 2) {
                    Pacientes paciente = new Pacientes(datos[0], datos[1]);
                    pacientes.add(paciente);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar pacientes: " + e.getMessage());
        }
    }

    // Agregar una nueva cita
    public void agregarCita(LocalDateTime fechaHora, String motivo, String nombreDoctor, String nombrePaciente) {
        // Buscar el doctor y paciente por nombre
        String idDoctor = buscarIdPorNombreDoctor(nombreDoctor);
        String idPaciente = buscarIdPorNombrePaciente(nombrePaciente);

        if (idDoctor != null && idPaciente != null) {
            String id = generarIdUnicoCitas();
            Citas nuevaCita = new Citas(id, fechaHora, motivo, nombreDoctor, nombrePaciente);
            citas.add(nuevaCita);
            guardarCitas(nuevaCita);
        } else {
            if (idDoctor == null) {
                System.out.println("Error: El doctor con nombre " + nombreDoctor + " no existe.");
            }
            if (idPaciente == null) {
                System.out.println("Error: El paciente con nombre " + nombrePaciente + " no existe.");
            }
        }
    }

    // Buscar ID de doctor por nombre
    private String buscarIdPorNombreDoctor(String nombreDoctor) {
        for (Doctores doctor : doctores) {
            if (doctor.obtenerNombre().equalsIgnoreCase(nombreDoctor)) {
                return doctor.obtenerId();
            }
        }
        return null;
    }

    // Buscar ID de paciente por nombre
    private String buscarIdPorNombrePaciente(String nombrePaciente) {
        for (Pacientes paciente : pacientes) {
            if (paciente.obtenerNombre().equalsIgnoreCase(nombrePaciente)) {
                return paciente.obtenerId();
            }
        }
        return null;
    }

    // Generar un ID único para citas
    private String generarIdUnicoCitas() {
        return String.format("%04d", citas.size() + 1);
    }

    // Guardar cita en archivo CSV
    private void guardarCitas(Citas cita) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoCitas, true))) {
            writer.write(cita.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Ocurrió un error al guardar la cita: " + e.getMessage());
        }
    }

    // Cargar citas desde archivo CSV
    private void cargarCitas() {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoCitas))) {
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

    // Mostrar doctores registrados
    public void mostrarDoctores() {
        if (doctores.isEmpty()) {
            System.out.println("No hay doctores registrados.");
        } else {
            System.out.println("Doctores registrados:");
            for (Doctores doctor : doctores) {
                System.out.println("Doctor ID: " + doctor.obtenerId() + ", Nombre: " + doctor.obtenerNombre() +
                        ", Especialidad: " + doctor.obtenerEspecialidad());
            }
        }
    }

    // Mostrar pacientes registrados
    public void mostrarPacientes() {
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
        } else {
            System.out.println("Pacientes registrados:");
            for (Pacientes paciente : pacientes) {
                System.out.println("Paciente ID: " + paciente.obtenerId() + ", Nombre: " + paciente.obtenerNombre());
            }
        }
    }
}
