public class Main {
    public static void main(String[] args) {
        Círculo circulo = new Círculo(5);
        Rectángulo rectangulo = new Rectángulo(4, 7);
        Triángulo triangulo = new Triángulo(3, 4, 3, 4, 5);

        System.out.println("Círculo - Área: " + circulo.calcularArea() + ", Perímetro: " + circulo.calcularPerimetro());
        System.out.println("Rectángulo - Área: " + rectangulo.calcularArea() + ", Perímetro: " + rectangulo.calcularPerimetro());
        System.out.println("Triángulo - Área: " + triangulo.calcularArea() + ", Perímetro: " + triangulo.calcularPerimetro());

        circulo.dibujar();
        rectangulo.dibujar();
        triangulo.dibujar();
    }
}
