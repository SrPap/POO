public class Animal {
    protected String nombre;
    protected int edad;

    public Animal() {
    }
    public Animal(String nombre, int edad) {
    this.nombre = nombre;
    this.edad = edad;
    }

    public void comer() {
        System.out.println("*Come*");
        }
    public void dormir() {
        System.out.println("*Duerme*");
        }
    
        public String getNombre() {
            return nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        public int getEdad() {
            return edad;
        }
        public void setEdad(int edad) {
            this.edad = edad;
        }
}

// En esta actividad, se te solicita crear una clase llamada "Animal". Esta 
// clase debe incluir los atributos "nombre" y "edad", así como los métodos "comer()" 
// y "dormir()". En este contexto, la clase "Animal" actúa como la superclase o clase 
// padre.
