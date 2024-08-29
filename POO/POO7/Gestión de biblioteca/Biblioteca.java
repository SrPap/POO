import java.util.ArrayList;

public class Biblioteca {
    private final ArrayList<Libro> catalogo;
    private final ArrayList<Persona> personas;

    public Biblioteca() {
        this.catalogo = new ArrayList<>();
        this.personas = new ArrayList<>();
    }

    public ArrayList<Persona> getPersona() {
        return personas;
    }

    public void agregarLibro(Libro libro) {
        catalogo.add(libro);
        System.out.println("Libro '" + libro.getTitulo() + "' fue agregado al catálogo.");
        System.out.println();
    }

    public void registrarPersona(Persona persona) {
        personas.add(persona);
        System.out.println("Persona '" + persona.getNombre() + " " + persona.getApellido() + "' registrada.");
    }

    public void prestarLibro(Persona persona, String tituloLibro) {
        for (Libro libro : catalogo) {
            if (libro.getTitulo().equalsIgnoreCase(tituloLibro)) {
                if (!libro.isPrestado()) {
                    libro.prestar();
                    persona.prestarLibro(libro);
                    System.out.println("El libro '" + tituloLibro + "' ha sido prestado a " + persona.getNombre() + ".");
                    return;
                } else {
                    System.out.println("El libro '" + tituloLibro + "' ya está prestado.");
                    return;
                }
            }
        }
        System.out.println("El libro '" + tituloLibro + "' no se encuentra en el catálogo.");
    }

    public void devolverLibro(Persona persona, String tituloLibro) {
        for (Libro libro : persona.getLibrosPrestados()) {
            if (libro.getTitulo().equalsIgnoreCase(tituloLibro)) {
                libro.devolver();
                persona.devolverLibro(libro);
                System.out.println("El libro '" + tituloLibro + "' ha sido devuelto por " + persona.getNombre() + ".");
                return;
            }
        }
        System.out.println("El libro '" + tituloLibro + "' no está prestado por " + persona.getNombre() + ".");
    }

    public void mostrarCatalogo() {
        if (catalogo.isEmpty()) {
            System.out.println("El catálogo está vacío.");
            System.out.println();

        } else {
            System.out.println("Catálogo de la Biblioteca:");
            for (Libro libro : catalogo) {
                System.out.println();
                libro.obtenerInformacion();
                System.out.println("-------------------------------------------");
            }
        }
    }

    public void mostrarPersonas() {
        if (personas.isEmpty()) {
            System.out.println("No hay personas registradas.");
        } else {
            System.out.println("Personas registradas en la Biblioteca:");
            System.out.println();
            for (Persona persona : personas) {
                System.out.println(persona.getNombre() + " " + persona.getApellido());
            }
            System.out.println();

        }
    }
}
