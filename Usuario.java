public class Usuario {
    private String nombreUsuario;
    private String contrasena;

public Usuario(String nombreUsuario, String contrasena) {
    this.nombreUsuario = nombreUsuario;
    this.contrasena = contrasena;
    }

public String obtenerNombreUsuario() {
    return nombreUsuario;
    }

public String obtenerContrasena() {
    return contrasena;
    }
}
