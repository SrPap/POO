import java.util.Scanner;

public class Triangulo {
    private double lado1;
    private double lado2;
    private double lado3;
    private static int contadorTriangulos = 0;

    public Triangulo(double lado1, double lado2, double lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        contadorTriangulos++;
    }
    public Triangulo() {
    }

    public double area() {
        // Usamos la fórmula de Herón para calcular el área de un triángulo
        double s = (lado1 + lado2 + lado3) / 2;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }
    public double perimetro() {
        return lado1 + lado2 + lado3;
    }

    public void imprimirArea() {
        System.out.println("Área del triángulo: " + area());
    }
    public void imprimirPerimetro() {
        System.out.println("Perímetro del triángulo: " + perimetro());
    }
    public static int getTotalTriangulos() {
        return contadorTriangulos;
    }

    public double getLado1() {
        return lado1;
    }
    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public double getLado2() {
        return lado2;
    }
    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public double getLado3() {
        return lado3;
    }
    public void setLado3(double lado3) {
        this.lado3 = lado3;
    }

    public static Scanner sc = new Scanner(System.in);

    private static boolean esTrianguloValido(double lado1, double lado2, double lado3) {
        return (lado1 + lado2 > lado3) && (lado1 + lado3 > lado2) && (lado2 + lado3 > lado1);
    }

    public static void MenuTriangulo() {
        boolean salir = false;
        Triangulo triangulo = null;

        while (!salir) {
            System.out.println("MENU");
            System.out.println("1. Crear un triángulo");
            System.out.println("2. Calcular el área de un triángulo");
            System.out.println("3. Calcular el perímetro de un triángulo");
            System.out.println("4. Mostrar el número total de triángulos creados");
            System.out.println("5. Salir");
            System.out.println("");
            System.out.print("Elija una opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese el lado 1 del triángulo: ");
                    double lado1 = sc.nextDouble();
                    System.out.print("Ingrese el lado 2 del triángulo: ");
                    double lado2 = sc.nextDouble();
                    System.out.print("Ingrese el lado 3 del triángulo: ");
                    double lado3 = sc.nextDouble();

                    if (esTrianguloValido(lado1, lado2, lado3)) {
                        triangulo = new Triangulo(lado1, lado2, lado3);
                        System.out.println("Triángulo creado con éxito.");
                    } else {
                        System.out.println("Las longitudes no forman un triángulo válido.");
                    }
                }
                case 2 -> {
                    if (triangulo != null) {
                        triangulo.imprimirArea();
                    } else {
                        System.out.println("Primero debes crear un triángulo (opción 1).");
                    }
                }
                case 3 -> {
                    if (triangulo != null) {
                        triangulo.imprimirPerimetro();
                    } else {
                        System.out.println("Primero debes crear un triángulo (opción 1).");
                    }
                }
                case 4 -> System.out.println("Total de triángulos creados: " + Triangulo.getTotalTriangulos());
                case 5 -> salir = true;
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }


    public static void main(String[] args) {
        MenuTriangulo();
    }    
}