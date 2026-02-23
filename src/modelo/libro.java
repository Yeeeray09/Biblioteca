//@Autor Yeray Musila
package modelo;

/**
 * Clase que representa un libro dentro del sistema de biblioteca.
 * 
 * Gestiona su informacion basica y controla internamente
 * el numero de copias prestadas para mantener coherencia.
 */
public class libro {
 
    private String ISBN ;
    private String titulo;
    private String autor;
    private int añoPublicacion;
    private String editorial;
    private Genero genero;
    private int totalCopias;
    private int copiasPrestadas;

// constructor principal
public libro(String ISBN, String titulo, String autor,
    int anioPublicacion, String editorial,Genero genero, int totalCopias){

//cada libro tiene que tener un ISBN obligatoriamente y aqui nos aseguramos de que no este vacio
if(ISBN==null || ISBN.isEmpty()){
    throw new IllegalArgumentException("El ISBN no puede estar vacio o nulo");
}

//si no hay copias no hay libro
if(totalCopias<=0){
    throw new IllegalArgumentException("Debe existir una copia al menos");
}
    this.ISBN = ISBN;
    this.titulo = titulo;
    this.autor = autor;
    this.añoPublicacion = anioPublicacion;
    this.editorial = editorial;
    this.genero = genero;
    this.totalCopias = totalCopias;
    this.copiasPrestadas = 0;
}

//Gstionamos las copias disponibles
public int getCopiasDisponibles(){
    return totalCopias- copiasPrestadas;
}

public boolean hayCopiasDisponibles(){
    return copiasPrestadas<totalCopias;
}

//Presta una copia del libro si esta disponible
//Cancelamos el prestamo si no hay copias disponibles 
public boolean prestarCopia(){
    if(!hayCopiasDisponibles()){
        return false;
    }
   copiasPrestadas --;
   return true;
}

//para cuando se devuelven copias
//comprobamos que hay copias prestadas
public boolean devolverCopia(){
    if(copiasPrestadas<=0){
        return false;
    }
    copiasPrestadas++;
    return true;
}

//getters
 public String getISBN() {
        return ISBN;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public int getañoPublicacion() {
        return añoPublicacion;
}
    public String getEditorial() {
        return editorial;
    }
    public Genero getGenero() {
        return genero;
    }
    public int getTotalCopias() {
        return totalCopias;
    }
    public int getCopiasPrestadas() {
        return copiasPrestadas;
    }
}