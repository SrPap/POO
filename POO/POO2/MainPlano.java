
import java.util.Scanner;

public class MainPlano {
    public static Punto[] puntos = new Punto[100];
    private static int contadorPuntos = 0;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            System.out.println("MENU");
            System.out.println("1. Crear un punto.");
            System.out.println("2. Calcular la distancia desde el origen.");
            System.out.println("3. Calcular la distancia entre dos puntos.");
            System.out.println("4. Determinar si tres puntos están alineados.");
            System.out.println("5. Salir.");
            System.out.println("");
            System.out.print("Elija una opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> crearPunto();
                case 2 -> calcularDistanciaDesdeOrigen();
                case 3 -> calcularDistanciaEntrePuntos();
                case 4 -> determinarAlineacion();
                case 5 -> salir = true;
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    public static void crearPunto() {
        System.out.print("Ingrese la coordenada x del punto: ");
        double x = sc.nextDouble();
        System.out.print("Ingrese la coordenada y del punto: ");
        double y = sc.nextDouble();

        puntos[contadorPuntos] = new Punto(x, y);
        contadorPuntos++;
        System.out.println("Punto creado con éxito.");
    }

    public static void calcularDistanciaDesdeOrigen() {
        System.out.print("Seleccione el índice del punto (0 a " + (contadorPuntos - 1) + "): ");
        int indice = sc.nextInt();
        if (indice >= 0 && indice < contadorPuntos) {
            double distancia = puntos[indice].distanciaDesdeOrigen();
            System.out.println("La distancia desde el origen es: " + distancia);
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public static void calcularDistanciaEntrePuntos() {
        System.out.print("Seleccione el índice del primer punto (0 a " + (contadorPuntos - 1) + "): ");
        int indice1 = sc.nextInt();
        System.out.print("Seleccione el índice del segundo punto (0 a " + (contadorPuntos - 1) + "): ");
        int indice2 = sc.nextInt();

        if (indice1 >= 0 && indice1 < contadorPuntos && indice2 >= 0 && indice2 < contadorPuntos) {
            double distancia = Punto.calcularDistancia(puntos[indice1], puntos[indice2]);
            System.out.println("La distancia entre los puntos es: " + distancia);
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public static void determinarAlineacion() {
        System.out.print("Seleccione el índice del primer punto (0 a " + (contadorPuntos - 1) + "): ");
        int indice1 = sc.nextInt();
        System.out.print("Seleccione el índice del segundo punto (0 a " + (contadorPuntos - 1) + "): ");
        int indice2 = sc.nextInt();
        System.out.print("Seleccione el índice del tercer punto (0 a " + (contadorPuntos - 1) + "): ");
        int indice3 = sc.nextInt();

        if (indice1 >= 0 && indice1 < contadorPuntos && 
            indice2 >= 0 && indice2 < contadorPuntos && 
            indice3 >= 0 && indice3 < contadorPuntos) {
            boolean alineados = Punto.estanAlineados(puntos[indice1], puntos[indice2], puntos[indice3]);
            System.out.println("¿Están alineados? " + alineados);
        } else {
            System.out.println("Índice inválido.");
        }
    }
}