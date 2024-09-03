import java.util.Scanner;

public class SaludoUsuario {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        saludarUsuario();
    }

    public static void saludarUsuario() {

        try {
            System.out.print("Por favor, ingrese su nombre: ");
            String nombre = scanner.nextLine();

            if (nombre.length() < 2) {
                throw new IllegalArgumentException("El nombre debe tener al menos 2 caracteres.");
            }

            System.out.println("¡Hola, " + nombre + "! Bienvenido/a.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
                scanner.close();
                System.out.println("Scanner cerrado.");
        }
    }
}


// Actividad: Saludo al usuario
// Para completar esta actividad, debes desarrollar un programa que salude 
// a las personas por consola. Sigue estos pasos:

// Crea una clase con un método main que llame a otro método encargado de 
// solicitar al usuario su nombre y luego imprima un saludo en pantalla.

// Este método deberá lanzar una excepción si el nombre ingresado por el 
// usuario tiene menos de 2 caracteres.

// Utiliza el bloque "finally" para asegurarte de cerrar el Scanner después de usarlo.