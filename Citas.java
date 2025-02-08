import java.time.LocalDateTime;


public class Citas {
    private String id;
    private LocalDateTime fecha;
    private String motivoConsulta;
    private String nombreDoctor;
    private String nombrePaciente;

    public Citas(String id, LocalDateTime fecha, String motivoConsulta, String nombreDoctor, String nombrePaciente) {
        this.id = id;
        this.fecha = fecha;
        this.motivoConsulta = motivoConsulta;
        this.nombreDoctor = nombreDoctor;
        this.nombrePaciente = nombrePaciente;
    }

    public String obtenerId() {
        return id;
    }

    public LocalDateTime obtenerFecha() {
        return fecha;
    }

    public String obtenerMotivoConsulta() {
        return motivoConsulta;
    }

    public String obtenerNombreDoctor() {
        return nombreDoctor;
    }

    public String obtenerNombrePaciente() {
        return nombrePaciente;
    }

    @Override
    public String toString() {
        return id + "," + fecha + "," + motivoConsulta + "," + nombreDoctor + "," + nombrePaciente;
    }

}
