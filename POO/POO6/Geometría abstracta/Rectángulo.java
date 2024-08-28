public class Rectángulo extends Figura implements Dibujable {
    private double ancho;
    private double alto;

    public Rectángulo() {
    }
    public Rectángulo(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    @Override
    public double calcularArea() {
        return ancho * alto;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (ancho + alto);
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando un rectángulo.");
    }
}
