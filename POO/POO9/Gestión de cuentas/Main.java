import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        CuentaBancaria cuenta = new CuentaBancaria(500.00);

        try {
            System.out.println("Saldo actual: $" + cuenta.getSaldoInicial());

            System.out.print("Ingrese la cantidad que desea retirar: $");
            double cantidad = scanner.nextDouble();

            cuenta.retirar(cantidad);
            System.out.println("Retiro exitoso. Saldo restante: $" + cuenta.getSaldoInicial());

        } catch (SaldoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Operación finalizada.");
        }
    }
}
