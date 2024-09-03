import java.util.Scanner;

public class DivisionSegura {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            realizarDivision();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void realizarDivision() throws Exception {

        try {
            System.out.print("Ingrese el numerador (dividendo): ");
            int NumeroA = scanner.nextInt();
            
            int NumeroB = obtenerDenominador();

            int resultado = NumeroA / NumeroB;
            System.out.println("El resultado de la división es: " + resultado);

        } catch (ArithmeticException e) {
            System.out.println("No se puede dividir entre cero.");
        } finally {
            scanner.close();
            System.out.println("Scanner cerrado.");
        }
    }

    public static int obtenerDenominador() throws Exception {
        System.out.print("Ingrese el denominador (divisor): ");
        int denominador = scanner.nextInt();

        if (denominador == 0) {
            throw new Exception("El denominador no puede ser cero.");
        }
        if (denominador < 0) {
            throw new Exception("El denominador no puede ser menor que cero.");
        }


        return denominador;
    }
}


// Division Segura
// Escribe un programa que pida al usuario que ingrese dos números enteros
//  y realice la división del primer número entre el segundo número.

// Invocar un método llamado “obtenerNumerador()” que solicite el número por
//  el cual se desea dividir.

// Este método, "obtenerNumerador()", verificará que ingreses un número 
// distinto de 0. Si ingresas 0, el método lanzará una excepción que será
//  controlada por el método que lo invocó.