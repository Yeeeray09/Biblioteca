package vista;

import java.util.Scanner;

public class consola {
    private Scanner sc;

    public consola() {
        this.sc = new Scanner(System.in);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(">> " + mensaje);
    }

    public String leerTexto(String etiqueta) {
        System.out.print(etiqueta + ": ");
        return sc.nextLine();
    }

    public int leerEntero(String etiqueta) {
        System.out.print(etiqueta + ": ");
        while (!sc.hasNextInt()) {
            System.out.println("Error: Introduce un número válido.");
            sc.next();
        }
        int numero = sc.nextInt();
        sc.nextLine(); 
        return numero;
    }
}