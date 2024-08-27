public class Polideportivo extends Edificio {
    protected String nombre;
    protected String tipoInstalacion; 

    public Polideportivo(double ancho, double alto, double largo, String nombre, String tipoInstalacion) {
        super(ancho, alto, largo);
        this.nombre = nombre;
        this.tipoInstalacion = tipoInstalacion;
    }

    @Override
    public double calcularSuperficie() {
        return ancho * largo;
    }
    @Override
    public double calcularVolumen() {
        return ancho * largo * alto;
    }



    public String getTipoInstalacion() {
        return tipoInstalacion;
    }
    public String getNombre() {
        return nombre;
    }
}