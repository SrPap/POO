public class Círculo extends Figura implements Dibujable {
    private double radio;

    public Círculo() {
    }
    public Círculo(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando un círculo.");
    }
}
