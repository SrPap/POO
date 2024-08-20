
public class Punto {
    private double x;
    private double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return x;
    }
    public void setx(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void sety(double x) {
        this.y = x;
    }
    public double distanciaDesdeOrigen() {
        return Math.sqrt(x * x + y * y);
    }

    public static double calcularDistancia(Punto p1, Punto p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }

    public static boolean estanAlineados(Punto p1, Punto p2, Punto p3) {
        double area = p1.getX() * (p2.getY() - p3.getY()) +
                      p2.getX() * (p3.getY() - p1.getY()) +
                      p3.getX() * (p1.getY() - p2.getY());
        return area == 0;
    }
    

}
