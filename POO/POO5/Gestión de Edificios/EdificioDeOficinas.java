public class EdificioDeOficinas extends Edificio {
    protected int numeroOficinas;
    protected int personasPorOficina;
    protected int numeroPisos;

    public EdificioDeOficinas(double ancho, double alto, double largo, int numeroOficinas, int personasPorOficina, int numeroPisos) {
        super(ancho, alto, largo);
        this.numeroOficinas = numeroOficinas;
        this.personasPorOficina = personasPorOficina;
        this.numeroPisos = numeroPisos;
    }


    
    @Override
    public double calcularSuperficie() {
        return ancho * largo * numeroPisos;
    }
    @Override
    public double calcularVolumen() {
        return ancho * largo * alto;
    }



    public int cantPersonas() {
        return numeroOficinas * personasPorOficina * numeroPisos;
    }
    public int getNumeroOficinas() {
        return numeroOficinas;
    }
    public int getPersonasPorOficina() {
        return personasPorOficina;
    }
    public int getNumeroPisos() {
        return numeroPisos;
    }
}