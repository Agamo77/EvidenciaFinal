import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SistemaDeGestion {
    // Lista creada para almacenar los doctores
    private List<Doctores> doctores;
    // Asignamos un archivo CSV para guardar la lista de doctores
    private final String archivoDoctores = "doctores.csv";

    public SistemaDeGestion() {
        this.doctores = new ArrayList<>();
        cargarDoctores();
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
}
