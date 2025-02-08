import java.time.LocalDateTime;


public class Citas {
    private String id;
    private LocalDateTime fecha;
    private String motivoConsulta;
    private Doctores doctor;
    private Pacientes paciente;

    public Citas(string id, LocalDateTime fecha, String motivoConsulta, Doctores doctor, Pacientes paciente) {
        this.id = id;
        this.fecha = fecha;
        this.motivoConsulta = motivoConsulta;
        this.doctor = doctor;
        this.paciente = paciente;
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

    public Doctores obtenerDoctor() {
        return doctor
    }

    public Pacientes obtenerPaciente() {
        return paciente;
    }

    @Override
    public String toString() {
        return id + "," + fecha + "," + motivoConsulta + "," + doctor.obtenerId() + "," + paciente.obtenerId();
    }

}
