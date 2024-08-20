import java.util.Scanner;

public class Rectangulo {
    private double ancho;
    private double alto;
    private static int contadorRectangulos = 0;

    public Rectangulo(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
        contadorRectangulos++;
    }
    public Rectangulo() {
    }

    public double area() {
        return ancho * alto;
    }
    public double perimetro() {
        return 2 * (ancho + alto);
    }
    public void imprimirArea() {
        System.out.println("Área del rectángulo: " + area());
    }
    public void imprimirPerimetro() {
        System.out.println("Perímetro del rectángulo: " + perimetro());
    }

    public static int getTotalRectangulos() {
        return contadorRectangulos;
    }

    public double getAncho() {
        return ancho;
    }
    public void setAncho(double ancho) {
        this.ancho = ancho;
    }
    public double getAlto() {
        return alto;
    }
    public void setAlto(double alto) {
        this.alto = alto;
    }

    public static Scanner sc = new Scanner(System.in);

    public static void MenuRectangulo() {
        boolean salir = false;
        Rectangulo rectangulo = null;

        while (!salir) {
            System.out.println("MENU");
            System.out.println("1. Crear un rectángulo");
            System.out.println("2. Calcular el área de un rectángulo");
            System.out.println("3. Calcular el perímetro de un rectángulo");
            System.out.println("4. Mostrar el número total de rectángulos creados");
            System.out.println("5. Salir");
            System.out.println("");
            System.out.print("Elija una opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese el ancho del rectángulo: ");
                    double ancho = sc.nextDouble();
                    System.out.print("Ingrese el alto del rectángulo: ");
                    double alto = sc.nextDouble();
                    if (ancho > 0 && alto > 0) {
                        rectangulo = new Rectangulo(ancho, alto);
                        System.out.println("Rectángulo creado con éxito.");
                    } else {
                        System.out.println("Las dimensiones deben ser positivas.");
                    }
                }
                case 2 -> {
                    if (rectangulo != null) {
                        rectangulo.imprimirArea();
                    } else {
                        System.out.println("Primero debes crear un rectángulo (opción 1).");
                    }
                }
                case 3 -> {
                    if (rectangulo != null) {
                        rectangulo.imprimirPerimetro();
                    } else {
                        System.out.println("Primero debes crear un rectángulo (opción 1).");
                    }
                }
                case 4 -> System.out.println("Total de rectángulos creados: " + Rectangulo.getTotalRectangulos());
                case 5 -> salir = true;
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }
 
    public static void main(String[] args) {
        MenuRectangulo();
    }
}