
public class Jugador {
    private String nombre;
    private Equipo equipo;
    public Jugador(String nombre, Equipo equipo) {
      this.nombre = nombre;
      this.equipo = equipo;
    }
    public Jugador(String nombre) {
      this.nombre = nombre;
      this.equipo = null;  
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

    public static void mostrarJugador(String nombre, Equipo equipo) {
      System.out.println("Jugador: " + nombre + ", Equipo: " + (equipo != null ? equipo.getNombre() : "Sin equipo"));    }
}