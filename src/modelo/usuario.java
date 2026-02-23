package modelo;
import java.util.ArrayList;

public class Usuario{
    
    private int idUsuario;
    private String nombreUsuario;

//Lista de prestamos actuales
    private ArrayList<prestamo>prestamosActuales;

//lista para el historial de los prestanmos 
    private ArrayList<prestamo>historialPrestamos;

//Constructor
public Usuario(int idUsuario, String nombreUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.prestamosActuales = new ArrayList<>();
        this.historialPrestamos = new ArrayList<>();
    }
//Devuelve el numero de prestamos activos
public int getNumeroPrestamosActivos(){
        return prestamosActuales.size();
    }

//Comprobamos que tenga no tenga mas de 3 libros
public boolean puedePedirLibro(){
        return prestamosActuales.size()< 3;
    }

//para añadir un prestamo a la lista de activos
public void agregarPrestamo(prestamo prestamo){
    prestamosActuales.add(prestamo);
    }

//Devuelve un prestamos lo quita de activos y lo pasa al historial
public void devolverPrestamo(prestamo prestamo){
    prestamosActuales.remove(prestamo);
    historialPrestamos.add(prestamo);
    }

//Getters basicos
public int getIdUsuario(){
     return idUsuario;
    }

public String getNombreUsuario(){
    return nombreUsuario;
    }

public ArrayList<prestamo> getPrestamosActuales(){
    return prestamosActuales;
    }

public ArrayList<prestamo> getHistorialPrestamos(){
    return historialPrestamos;
    }
}
