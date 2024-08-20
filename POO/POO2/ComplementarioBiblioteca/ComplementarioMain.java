import java.util.Scanner;

public class ComplementarioMain {
    public static Libro[] libros = new Libro[100];
    private static int contadorLibros = 0;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            System.out.println("MENU");
            System.out.println("1. Agregar un libro.");
            System.out.println("2. Mostrar detalles de un libro.");
            System.out.println("3. Imprimir todos los títulos de los libros.");
            System.out.println("4. Salir.");
            System.out.println("");
            System.out.print("Elija una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1 -> agregarLibro();
                case 2 -> mostrarDetallesLibro();
                case 3 -> imprimirTitulosLibros();
                case 4 -> salir = true;
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    public static void agregarLibro() {
        if (contadorLibros < libros.length) {
            Libro libro = new Libro();

            System.out.print("Ingrese el título del libro: ");
            String titulo = sc.nextLine();
            libro.setTitulo(titulo);

            System.out.print("Ingrese el autor del libro: ");
            String autor = sc.nextLine();
            libro.setAutor(autor);

            System.out.print("Ingrese el número de páginas base (se multiplicará por 7): ");
            int paginasBase = sc.nextInt();
            libro.setPaginas(paginasBase);

            libros[contadorLibros] = libro;
            contadorLibros++;

            System.out.println("Libro agregado con éxito.");
        } else {
            System.out.println("No se pueden agregar más libros.");
        }
    }

    public static void mostrarDetallesLibro() {
        System.out.print("Seleccione el índice del libro (0 a " + (contadorLibros - 1) + "): ");
        int indice = sc.nextInt();
        sc.nextLine(); 

        if (indice >= 0 && indice < contadorLibros) {
            libros[indice].imprimirDetalles();
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public static void imprimirTitulosLibros() {
        System.out.println("Lista de títulos de los libros:");
        for (int i = 0; i < contadorLibros; i++) {
            System.out.println("- " + libros[i].getTitulo());
        }
    }
}
