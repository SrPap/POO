import java.util.Scanner;

public class Menu {
    public static Scanner sc = new Scanner(System.in);

    public static void Menú() {
        boolean salir = false;

        while (!salir) {
            System.out.println("MENU");
            System.out.println("1. Crear un rectángulo.");
            System.out.println("2. Crear un triángulo.");
            System.out.println("3. Crear un círculo.");
            System.out.println("4. Salir.");
            System.out.println("");
            System.out.print("Elija una opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> Rectangulo.MenuRectangulo();
                case 2 -> Triangulo.MenuTriangulo();
                case 3 -> Circulo.MenuCirculo();
                case 4 -> salir = true;
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    public static void main(String[] args) {
        Menú();
    }
}