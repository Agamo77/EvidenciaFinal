import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        Doctores doctor = new Doctores("0001", "Emilio Guerra", "Medicina Interna");

        Pacientes paciente = new Pacientes("0001", "Daniel Garza");

        Citas cita = new Citas("0001", LocalDateTime.of(2025,2,10,11,0), "Dolor abdominal", doctor, paciente);

        System.out.println("Cita Creada!");
        System.out.println(cita);
}
}    
