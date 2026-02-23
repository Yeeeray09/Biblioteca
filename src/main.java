import controlador.GestorBiblioteca;
import vista.consola;

public class main {
    public static void Main(String[] args) {
        consola vista = new consola();
        GestorBiblioteca gestor = new GestorBiblioteca(vista);

        // Ejemplo de flujo para registrar un usuario cumpliendo los requisitos
        vista.mostrarMensaje("REGISTRO DE NUEVO USUARIO");
        int id = vista.leerEntero("Ingrese ID único del usuario");
        String nombre = vista.leerTexto("Ingrese nombre completo");

        // El controlador usa su constructor y sus listas para guardarlo
        gestor.registrarUsuario(id, nombre);
    }
}