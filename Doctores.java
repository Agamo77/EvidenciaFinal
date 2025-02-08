public class Doctores {
    private String id;
    private String nombre;
    private String especialidad;

    public Doctores(String id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public String obtenerId() {
        return id;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public String obtenerEspecialidad() {
        return especialidad;
    }

    @Override
    public String toString() {
        return id + "," + nombre + "," + especialidad;
    }
}
