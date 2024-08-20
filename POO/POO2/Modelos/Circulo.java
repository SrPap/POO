import java.util.Scanner;

public class Circulo {
    private double radio;
    private static int contadorCirculos = 0;

    public Circulo(double radio) {
        this.radio = radio;
        contadorCirculos++;
    }

    public Circulo() {
    }

    public double area() {
        return Math.PI * Math.pow(radio, 2);
    }

    public double circunferencia() {
        return 2 * Math.PI * radio;
    }

    public void imprimirArea() {
        System.out.println("Área del círculo: " + area());
    }

    public void imprimirCircunferencia() {
        System.out.println("Circunferencia del círculo: " + circunferencia());
    }

    public static int getTotalCirculos() {
        return contadorCirculos;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public static Scanner sc = new Scanner(System.in);

    public static void MenuCirculo() {
        boolean salir = false;
        Circulo circulo = null;

        while (!salir) {
            System.out.println("MENU");
            System.out.println("1. Crear un círculo");
            System.out.println("2. Calcular el área de un círculo");
            System.out.println("3. Calcular la circunferencia de un círculo");
            System.out.println("4. Mostrar el número total de círculos creados");
            System.out.println("5. Salir");
            System.out.println("");
            System.out.print("Elija una opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese el radio del círculo: ");
                    double radio = sc.nextDouble();

                    if (radio > 0) {
                        circulo = new Circulo(radio);
                        System.out.println("Círculo creado con éxito.");
                    } else {
                        System.out.println("El radio debe ser un valor positivo.");
                    }
                }
                case 2 -> {
                    if (circulo != null) {
                        circulo.imprimirArea();
                    } else {
                        System.out.println("Primero debes crear un círculo (opción 1).");
                    }
                }
                case 3 -> {
                    if (circulo != null) {
                        circulo.imprimirCircunferencia();
                    } else {
                        System.out.println("Primero debes crear un círculo (opción 1).");
                    }
                }
                case 4 -> System.out.println("Total de círculos creados: " + Circulo.getTotalCirculos());
                case 5 -> salir = true;
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    public static void main(String[] args) {
        MenuCirculo();
    }
}