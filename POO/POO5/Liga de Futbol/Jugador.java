
public class Jugador extends Persona {
    public int goles = 0;
    public Jugador(String nombre, Equipo equipo) {
      super(nombre,equipo);
    }
    public Jugador(String nombre) {
      this.nombre = nombre;
      this.equipo = null;  
      this.goles = 0;  
  }

    public String getNombre() {
       return nombre;
    }
    public void setNombre(String nombre) {
    this.nombre = nombre;
    }
      
    public Equipo getEquipo() {
       return equipo;
    }
    public void setEquipo(Equipo equipo) {
       this.equipo = equipo;
    }
    @Override
    public void gritarGol() {
        System.out.println(nombre + ":  Meti un gol!!!!!");}

    public static void mostrarJugador(String nombre, Equipo equipo) {
      System.out.println("Jugador: " + nombre + ", Equipo: " + (equipo != null ? equipo.getNombre() : "Sin equipo"));    }
}

// public class Jugador {
//    private String nombre;

    // Constructor
//    public Jugador(String nombre) {
//        this.nombre = nombre;
//    }

    // Getters y Setters
//    public String getNombre() {
//        return nombre;
//    }
//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }
// }