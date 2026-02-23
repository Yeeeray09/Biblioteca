import controlador.GestorBiblioteca;
import vista.consola;
import modelo.*;

public class main {
    public static void main(String[] args) {
        GestorBiblioteca gestor = new GestorBiblioteca();
        consola consola = new consola();

        // 1. Registro de libros
        gestor.registrarLibro(new libro("001", "El Hobbit", "Tolkien", 1937, "Minotauro", Genero.FANTASIA, 3));
        gestor.registrarLibro(new libro("002", "1984", "George Orwell", 1949, "Debolsillo", Genero.CIENCIA_FICCION, 2));
        gestor.registrarLibro(new libro("003", "El Corredor del Laberinto", "James Dashner", 2009, "Nocturna", Genero.CIENCIA_FICCION, 5));
        
        // 2. Registro de usuarios solicitados
        gestor.registrarUsuario(new Usuario(101, "Yeray"));
        gestor.registrarUsuario(new Usuario(102, "Gabriel"));

        boolean salir = false;
        while (!salir) {
            consola.mostrarCabecera();
            System.out.println("1. Listar Libros (Estado)");
            System.out.println("2. Resumen de Usuarios");
            System.out.println("3. Realizar Préstamo");
            System.out.println("4. Devolver Libro");
            System.out.println("5. Salir");
            
            String op = consola.leerTexto();

            try {
                switch (op) {
                    case "1":
                        consola.listarLibros(gestor.getLibros());
                        break;
                    
                    case "2":
                        System.out.println("ESTADÍSTICAS DE USUARIOS");
                        for (Usuario u : gestor.getUsuarios()) {
                            int prestados = u.getPrestamosActuales().size();
                            int devueltos = u.getHistorialPrestamos().size();
                            
                            System.out.println("Usuario: " + u.getNombreUsuario());
                            System.out.println("  > Libros en posesión: " + prestados);
                            System.out.println("  > Libros devueltos:   " + devueltos);
                        }
                        break;
                    
                    case "3":
                        consola.mostrarMensaje("Ingrese ISBN del libro:");
                        String isbnP = consola.leerTexto();
                        consola.mostrarMensaje("Ingrese ID del usuario (101 o 102):");
                        int idUP = consola.leerEntero();
                        gestor.realizarPrestamo(isbnP, idUP);
                        consola.mostrarMensaje("¡Préstamo registrado con éxito!");
                        break;
                    
                    case "4":
                        consola.mostrarMensaje("Ingrese ISBN a devolver:");
                        String isbnD = consola.leerTexto();
                        consola.mostrarMensaje("Ingrese ID del usuario:");
                        int idUD = consola.leerEntero();
                        gestor.devolverLibro(isbnD, idUD);
                        consola.mostrarMensaje("Libro devuelto al sistema.");
                        break;
                    
                    case "5":
                        salir = true;
                        consola.mostrarMensaje("Saliendo de la Biblioteca");
                        break;
                        
                    default:
                        consola.mostrarMensaje("Opción no válida.");
                }
            } catch (Exception e) {
                consola.mostrarMensaje("ERROR: " + e.getMessage());
            }
        }
    }
}