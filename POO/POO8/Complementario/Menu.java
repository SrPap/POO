import java.util.Scanner;

public class Menu {
public static Scanner scanner = new Scanner(System.in);

    public static void mostrarMenu() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Mostrar estaciones y sus meses correspondientes");
            System.out.println("2. Ingresar un número de mes para obtener la estación del año");
            System.out.println("3. Salir (Ingrese el número 0 para salir)");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            System.out.println("");

            switch (opcion) {
                case 1 -> EstacionDelAño.imprimirEstaciones();
                case 2 -> {
                    System.out.print("Ingrese un número de mes (1-12): ");
                    int numeroMes = scanner.nextInt();
                    Mes mes = Mes.obtenerMesPorNumero(numeroMes);
                    if (mes != null) {
                        Estacion estacion = EstacionDelAño.obtenerEstacionPorMes(mes);
                        System.out.println("El mes " + mes.name() + " corresponde a la estación: " + estacion);
                    } else {
                        System.out.println("Número de mes inválido. Por favor, ingrese un número entre 1 y 12.");
                    }
                }
                case 0 -> {
                    continuar = false;
                    System.out.println("Saliendo del programa...");
                }
                default -> System.out.println("Opción inválida, por favor intente nuevamente.");
            }
        }

        scanner.close();
    }
}
