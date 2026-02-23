package modelo;

import java.time.LocalDate;

/**
 * Clase que representa el préstamo de un libro a un usuario.
 * 
 * Guarda el libro, el usuario y las fechas del préstamo.
 * El vencimiento es a 30 días desde la fecha de inicio.
 */
public class prestamo {

    private libro libro;
    private Usuario usuario;

    private LocalDate fechaPrestamo;
    private LocalDate fechaVencimiento;

    // Constructor
    public prestamo(libro libro, Usuario usuario) {
        this.libro = libro;
        this.usuario = usuario;

        this.fechaPrestamo = LocalDate.now();
        this.fechaVencimiento = fechaPrestamo.plusDays(30);
    }

    // Comprueba si el préstamo está vencido
    public boolean estaVencido() {
        return LocalDate.now().isAfter(fechaVencimiento);
    }

    // Getters
    public libro getlibro() {
        return libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }
}