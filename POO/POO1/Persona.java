
public class Persona {
       String nombre;
       Integer edad;

    // constructor por defecto
        public Persona() {
        this("Desconocido", 0);
        }
        
    // constructor con parámetros
        public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public void imprimirDatos() {
        System.out.println("Nombre : " + nombre + "    Edad: " + edad);
     }
    }

// Actividad: Creando un objeto “Persona”
// Crea una clase llamada Persona.

// Define 2 atributos para la clase: nombre y edad.

// Crea una método llamado imprimirDatos para imprimir la presentación de una persona en consola mostrando sus 
// atributos.

// Asegúrate de incluir dentro de tu proyecto una clase que contenga un método main, el cual será el punto para 
// ejecutar tu proyecto.En ella, crea un objeto a partir de una instancia de la clase “Persona”.

// Ejecuta el método que imprime la presentación de dicha persona en consola.

// Crea un nuevo objeto del tipo Persona.

// Imprime por consola, invocando al método correspondiente, los datos de dicho objeto. 

