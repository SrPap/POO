import java.util.Objects;

public class Perro extends Animal {
    protected String raza;

    public Perro() {
    }
    public Perro(String nombre, int edad) {
        super(nombre, edad);    
    }
    public Perro(String nombre, int edad, String raza) {
        super(nombre, edad);
        this.raza = raza;
    }

    public void ladrar() {
        System.out.println("Woof");
        }




        @Override
    public void comer() {
        System.out.println("El perro " + nombre + " está comiendo croquetas.");
        }
    @Override
    public void dormir() {
        System.out.println("El perro " + nombre + " está durmiendo en su cama.");
        }
    


 @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Perro perro = (Perro) o;
        return edad == perro.edad &&
                Objects.equals(nombre, perro.nombre) &&
                Objects.equals(raza, perro.raza);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad, raza);
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

// Sobrescribe el método "equals()" y "hashCode()" únicamente en la clase "Perro". La clase "Gato" 
// no requerirá esta sobrescritura.
