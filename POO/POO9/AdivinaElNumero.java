import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
  // Complementario 1
  
public class AdivinaElNumero {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Random random = new Random();
        int numeroAdivinar = random.nextInt(50) + 1;

        int intentos = 0;
        boolean adivinado = false;

        System.out.println("¡Bienvenido al juego de adivinar el número!");
        System.out.println("Estoy pensando en un número entre 1 y 50. ¡Intenta adivinarlo!");

        while (!adivinado) {
            System.out.print("Ingresa un número: ");

            try {
                intentos++;
                int numeroUsuario = scanner.nextInt();

                if (numeroUsuario < numeroAdivinar) {
                    System.out.println("El número es mayor.");
                } else if (numeroUsuario > numeroAdivinar) {
                    System.out.println("El número es menor.");
                } else {
                    System.out.println("¡Felicidades! Adivinaste el número en " + intentos + " intentos.");
                    adivinado = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número válido.");
                intentos++;  
                scanner.next(); 
            }
        }

        scanner.close();
    }
}
