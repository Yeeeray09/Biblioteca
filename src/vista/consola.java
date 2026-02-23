package vista;

import modelo.*;
import java.util.List;
import java.util.Scanner;

public class consola {
    private Scanner sc;

    public consola() {
        this.sc = new Scanner(System.in);
    }

    public void mostrarMensaje(String msg) {
        System.out.println(">> " + msg);
    }

    public String leerTexto() {
        return sc.nextLine();
    }

    public int leerEntero() {
        int i = Integer.parseInt(sc.nextLine());
        return i;
    }

    public void mostrarCabecera() {
        System.out.println("BIBLIOTECA");

    }

    public void listarLibros(List<libro> libros) {
        System.out.println("LISTADO DE LIBROS");
        for (libro l : libros) {
            System.out.println("ISBN: " + l.getISBN() + " | " + l.getTitulo() + 
                               " Disponibles: " + l.getCopiasDisponibles());
        }
    }

    public void listarUsuarios(List<Usuario> usuarios) {
        System.out.println("LISTADO DE USUARIOS");
        for (Usuario u : usuarios) {
            System.out.println("ID: " + u.getIdUsuario() + " | Nombre: " + u.getNombreUsuario() + 
                               "Activos: " + u.getNumeroPrestamosActivos());
        }
    }
}