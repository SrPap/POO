public class Main {
    public static void main(String[] args) {
        Revista revista1 = new Revista(101, 5, "Revista de Ciencia", null);
        Revista revista2 = new Revista(202, 0, "Revista de Tecnología", null);
        Revista revista3 = new Revista(303, 2, "Revista de Historia", null);
        Revista[] revistas = {revista1, revista2, revista3};


        Película pelicula1 = new Película("Inception", "Christopher Nolan", "Ciencia Ficción");
        Película pelicula2 = new Película("The Godfather", "Francis Ford Coppola", "Drama");
        Película pelicula3 = new Película("The Matrix", "Wachowski Sisters", "Acción");
        Película[] peliculas = {pelicula1, pelicula2, pelicula3};

        // Probar métodos de Revista
        revista1.obtenerInformacion();
        double multaRevista = revista1.calcularMultas(5);
        System.out.println("Multa por atraso en la revista: $" + multaRevista);
        System.out.println("-----------------------------------------------------");

        // Probar métodos de Pelicula
        pelicula1.prestar();
        pelicula1.devolver();
        double multaPelicula = pelicula1.calcularMultas(3);
        System.out.println("Multa por atraso en la película: $" + multaPelicula);
        pelicula1.obtenerInformacion();
        System.out.println("-----------------------------------------------------");

        // Probar métodos de Revista con Array
        for (Revista revista : revistas) {
            System.out.println("Información de la Revista:");
            revista.obtenerInformacion();
            System.out.println();

            revista.prestar();
            System.out.println();

            revista.devolver();
            System.out.println();

            int diasAtraso = 3;

            double multa = revista.calcularMultas(diasAtraso);
            System.out.println("Multa por " + diasAtraso + " días de atraso: $" + multa);
            System.out.println("-----------------------------------------------------");
        }


        // Probar métodos de Pelicula con Array
        for (Película pelicula : peliculas) {
            System.out.println("Información de la Película:");
            pelicula.obtenerInformacion();
            System.out.println();

            pelicula.prestar();
            System.out.println();

            pelicula.devolver();
            System.out.println();

            int diasAtraso = 3;

            double multa = pelicula.calcularMultas(diasAtraso);
            System.out.println("Multa por " + diasAtraso + " días de atraso: $" + multa);
            System.out.println("-----------------------------------------------------");
        }
    }
}
