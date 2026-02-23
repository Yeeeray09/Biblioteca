package controlador;

import modelo.Usuario;
import modelo.libro;
import modelo.prestamo;
import vista.consola;
import java.util.ArrayList;

public class GestorBiblioteca {
    private ArrayList<libro> inventario;
    private ArrayList<Usuario> usuarios;
    private ArrayList<prestamo> registroGlobalPrestamos;
    private consola vista;

    //Constructor del Controlador 
    
    public GestorBiblioteca(consola vista) {
        // Inicializamos las listas del Modelo
        this.inventario = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.registroGlobalPrestamos = new ArrayList<>();
        
        // Inyectamos la vista
        this.vista = vista;
        
        this.vista.mostrarMensaje("Sistema iniciado: Gestión de Libros, Usuarios e Historiales lista.");
    }

    // Método para añadir un usuario 
    public void registrarUsuario(int id, String nombre) {
        Usuario nuevo = new Usuario(id, nombre);
        this.usuarios.add(nuevo);
        this.vista.mostrarMensaje("Usuario '" + nombre + "' registrado con ID: " + id);
    }
}