package controlador;

import modelo.*;
import java.util.ArrayList;
import java.util.List;

public class GestorBiblioteca {
    private List<libro> libros;
    private List<Usuario> usuarios;
    private List<prestamo> prestamosActivos;

    public GestorBiblioteca() {
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.prestamosActivos = new ArrayList<>();
    }

    public void registrarLibro(libro libro) {
        libros.add(libro);
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void realizarPrestamo(String isbn, int idUsuario) throws Exception {
        libro libroEncontrado = buscarLibroPorIsbn(isbn);
        Usuario usuarioEncontrado = buscarUsuarioPorId(idUsuario);

        if (libroEncontrado == null) throw new Exception("Libro no encontrado.");
        if (usuarioEncontrado == null) throw new Exception("Usuario no encontrado.");
        
        // Usando tu método 'hayCopiasDisponibles' de la captura
        if (!libroEncontrado.hayCopiasDisponibles()) {
            throw new Exception("No hay copias disponibles.");
        }

        // Usando tu método 'puedePedirLibro' (valida el máximo de 3)
        if (!usuarioEncontrado.puedePedirLibro()) {
            throw new Exception("El usuario ha excedido el límite de 3 libros.");
        }

        // Crear el prestamo y actualizar usando tus métodos
        prestamo nuevoPrestamo = new prestamo(libroEncontrado, usuarioEncontrado);
        libroEncontrado.prestarCopia(); // Resta una copia
        usuarioEncontrado.agregarPrestamo(nuevoPrestamo);
        prestamosActivos.add(nuevoPrestamo);
    }

    public void devolverLibro(String isbn, int idUsuario) throws Exception {
        prestamo pEncontrado = null;
        for (prestamo p : prestamosActivos) {
            if (p.getlibro().getISBN().equals(isbn) && p.getUsuario().getIdUsuario() == idUsuario) {
                pEncontrado = p;
                break;
            }
        }

        if (pEncontrado == null) throw new Exception("No se encontró el préstamo activo.");

        pEncontrado.getlibro().devolverCopia(); // Suma una copia
        pEncontrado.getUsuario().devolverPrestamo(pEncontrado); // Pasa a historial
        prestamosActivos.remove(pEncontrado);
    }

    public libro buscarLibroPorIsbn(String isbn) {
        for (libro l : libros) {
            if (l.getISBN().equals(isbn)) return l;
        }
        return null;
    }

    public Usuario buscarUsuarioPorId(int id) {
        for (Usuario u : usuarios) {
            if (u.getIdUsuario() == id) return u;
        }
        return null;
    }

    public List<libro> getLibros() { return libros; }
    public List<Usuario> getUsuarios() { return usuarios; }
}