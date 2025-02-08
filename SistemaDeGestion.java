import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class SistemaDeGestion {
    // Lista creada para almacenar los doctores
    private List<Doctores> doctores;
    // Asignamos un archivo CSV para guardar la lista de doctores
    private final String archivoDoctores = "doctores.csv";

    public SistemaDeGestion() {
        this.doctores = new ArrayList<>();
        cargarDoctores();
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
}
