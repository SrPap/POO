import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Película extends ItemBiblioteca implements Catalogable {
    private String titulo;
    private String director;
    private String genero;
    private boolean prestada;
    private LocalDate fechaPrestamo;

    public Película(String titulo, String director, String genero) {
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.prestada = false;
        this.fechaPrestamo = null;
    }

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    @Override
    public void prestar() {
        if (!prestada) {
            prestada = true;
            fechaPrestamo = LocalDate.now();
            System.out.println("Película prestada el día " + fechaPrestamo);
        } else {
            System.out.println("La película ya está prestada.");
        }
    }

    @Override
    public void devolver() {
        if (prestada) {
            prestada = false;
            fechaPrestamo = null;
            System.out.println("Película devuelta.");
        } else {
            System.out.println("La película no está prestada.");
        }
    }

    @Override
    public double calcularMultas(int diasAtraso) {
        if (fechaPrestamo == null) {
            System.out.println("No se ha registrado un préstamo para esta película.");
            return 0;
        }

        LocalDate fechaDevolucion = LocalDate.now();
        long diasPrestamo = ChronoUnit.DAYS.between(fechaPrestamo, fechaDevolucion);

        double multaPorDia = 1.5;  // Multa fija por día de atraso para películas
        double multaTotal = (diasPrestamo - diasAtraso) * multaPorDia;

        return multaTotal > 0 ? multaTotal : 0;
    }

    @Override
    public void obtenerInformacion() {
        System.out.println("Título de la Película: " + titulo);
        System.out.println("Director: " + director);
        System.out.println("Género: " + genero);
        System.out.println("Fecha de Préstamo: " + (fechaPrestamo != null ? fechaPrestamo : "No prestada"));
    }
}
