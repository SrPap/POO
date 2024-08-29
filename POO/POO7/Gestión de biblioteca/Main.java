import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.agregarLibro(new Libro("El Hobbit", "J.R.R. Tolkien", 310));
        biblioteca.agregarLibro(new Libro("Cien Años de Soledad", "Gabriel García Márquez", 417));

        Persona persona1 = new Persona("Juan", "Pérez");
        biblioteca.registrarPersona(persona1);

        Persona persona2 = new Persona("Ana", "López");
        biblioteca.registrarPersona(persona2);

        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- MENÚ BIBLIOTECA ---");
            System.out.println("1. Mostrar catálogo de libros");
            System.out.println("2. Mostrar personas registradas");
            System.out.println("3. Prestar un libro");
            System.out.println("4. Devolver un libro");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1 -> biblioteca.mostrarCatalogo();
                case 2 -> biblioteca.mostrarPersonas();
                case 3 -> {
                    System.out.print("Ingrese el nombre de la persona: ");
                    String nombrePersona = scanner.nextLine();
                    System.out.print("Ingrese el título del libro a prestar: ");
                    String tituloLibroPrestar = scanner.nextLine();
                    Persona personaPrestamo = buscarPersona(biblioteca, nombrePersona);
                    if (personaPrestamo != null) {
                        biblioteca.prestarLibro(personaPrestamo, tituloLibroPrestar);
                    } else {
                        System.out.println("Persona no encontrada.");
                    }
                }
                case 4 -> {
                    System.out.print("Ingrese el nombre de la persona: ");
                    String nombrePersonaDevolver = scanner.nextLine();
                    System.out.print("Ingrese el título del libro a devolver: ");
                    String tituloLibroDevolver = scanner.nextLine();
                    Persona personaDevolucion = buscarPersona(biblioteca, nombrePersonaDevolver);
                    if (personaDevolucion != null) {
                        biblioteca.devolverLibro(personaDevolucion, tituloLibroDevolver);
                    } else {
                        System.out.println("Persona no encontrada.");
                    }
                }
                case 5 -> {
                    continuar = false;
                    System.out.println("Saliendo del sistema...");
                }
                default -> System.out.println("Opción inválida, intente nuevamente.");
            }
        }

        scanner.close();
    }

    private static Persona buscarPersona(Biblioteca biblioteca, String nombre) {
        for (Persona persona : biblioteca.getPersona()) {
            if (persona.getNombre().equalsIgnoreCase(nombre)) {
                return persona;
            }
        }
        return null;
    }

}
