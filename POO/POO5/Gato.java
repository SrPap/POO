public class Gato extends Animal {
    protected String color;

    public Gato() {
    }
    public Gato(String nombre, int edad) {
        super(nombre, edad);  
    }
    public Gato(String nombre, int edad, String color) {
        super(nombre, edad);
        this.color = color;
    }

    public void maullar() {
        System.out.println("Miau");
        }

        @Override
    public void comer() {
                System.out.println("El gato " + nombre + " está comiendo pescado.");
        }
            @Override
    public void dormir() {
                System.out.println("El gato " + nombre + " está durmiendo encima del sofá.");
        }
        

}


// Luego, deberás crear dos clases que hereden de la clase "Animal": La clase 
// "Perro" y la clase "Gato". Cada una de estas subclases debe poseer sus propios 
// atributos y métodos únicos. Por ejemplo, la clase "Perro" podría incluir el 
// atributo "raza" y el método "ladrar()".


// Sobrescribe los métodos "comer()" y "dormir()" en las subclases "Perro" y "Gato" para que 
// muestren comportamientos específicos de cada animal. Por ejemplo, cuando un perro coma, podría 
// imprimir "El perro está comiendo croquetas" y cuando un gato duerma, podría imprimir "El gato 
// está durmiendo encima del sofá".