public class Main {
    public static void main(String[] args) {
        // Animal animal = new Animal("Tortuga", 70);
        // Perro perro = new Perro("Firulais", 6, "");
        // Gato gato = new Gato("Michi", 2, "Gris");

        // perro.ladrar();
        // gato.maullar();
        // System.out.println();

        // System.out.println(perro.nombre);
        // System.out.println(gato.edad);
        // System.out.println(animal.nombre);

        // animal.comer();
        // animal.dormir();

        Perro perro1 = new Perro("Firulais", 5, "Labrador");
        Perro perro2 = new Perro("Max", 3, "Bulldog");
        Gato gato1 = new Gato("Mimi", 2, "Blanco");
        Perro perro3 = new Perro("Max", 3, "Bulldog");

        perro1.comer();
        perro1.dormir();
        perro1.ladrar();

        gato1.comer();
        gato1.dormir();
        gato1.maullar();

        // equals y hashCode
        System.out.println("¿Son iguales perro1 y perro2? " + perro1.equals(perro2));
        System.out.println("¿Son iguales perro3 y perro2? " + perro3.equals(perro2));

        System.out.println("HashCode de perro1: " + perro1.hashCode());
        System.out.println("HashCode de perro2: " + perro2.hashCode());

        Object[] objects = { perro1, perro2, gato1, perro3, new Animal(), new Gato(), new Animal(), new Animal(), new Gato(), new Gato()};


        for (Object obj : objects) {
            if (obj instanceof Perro) {
                System.out.println("Es un perro");
            } else if (obj instanceof Gato) {
                System.out.println("Es un gato");
            } else if (obj instanceof Animal) {
                System.out.println("Es un animal");
            } else {System.out.println("Tipo desconocido");}

        }
}
}


// En esta actividad, crearás una lista de objetos de tipo "Animal" y agregarás varios objetos de las 
// clases "Perro" y "Gato". La lista debe contener al menos diez objetos. Luego, deberás:

// Recorrer la lista de objetos utilizando el operador Instanceof para identificar si cada objeto 
// corresponde a una clase "Perro" o "Gato", e imprimir los resultados.

// Una vez identificada la instancia del objeto, el programa debe ejecutar los métodos propios y comunes del objeto.