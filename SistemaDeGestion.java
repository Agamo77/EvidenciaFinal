import java.util.ArrayList;
import java.util.List;

public class SistemaDeGestion {
    private List<Doctores> doctores;

    public SistemaDeGestion() {
        this.doctores = new ArrayList<>();
    }

    //Creamos un metodo para agregar doctores a la lista
    public void agregarDoctor(Doctores nuevoDoctor) {
        doctores.add(nuevoDoctor);
        System.out.println("Nuevo Doctor: " + nuevoDoctor.obtenerNombre());
    }

    //Ahora un metodo para listar a todos los doctores
    public void mostrarDoctores() {
        if (doctores.isEmpty()) {
            System.out.println("No se encontraron doctores en base de datos.");
        } else {
            System.out.println("Doctores actualmente en base de datos:");
            for (Doctores doctores : doctores) {
                System.out.println(doctores.obtenerNombre() + ": " + doctores.obtenerEspecialidad());
            }
        }
    }
}
