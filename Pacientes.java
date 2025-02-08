public class Pacientes {
    private String id;
    private String nombre;

    //Creamos un constructor para pacientes
    public Pacientes(String id, String nombre) {
        this.id  = id;
        this.nombre = nombre;
    }

    public String obtenerId() {
        return id;
    }

    public String obtenerNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return id + "," + nombre;
    }

}
