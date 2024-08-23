import java.util.ArrayList;

public class Equipo {
    private String nombre;
    private ArrayList<Jugador> jugadores;

    public Equipo(String nombre) {
      this.nombre = nombre;
      this.jugadores = new ArrayList<>();
  }
  public Equipo() {
  }
    
   public String getNombre() {
       return nombre;
    }
    public void setNombre(String nombre) {
       this.nombre = nombre;
    }

  public ArrayList<Jugador> getJugadores() {
      return jugadores;
  }

 

  public void agregarJugador(Jugador jugador) {
      jugadores.add(jugador);
      jugador.setEquipo(this);
  }
}

// public class Equipo {
//     private String nombre;
//     private ArrayList<Jugador> jugadores;

     // Constructor
//     public Equipo(String nombre) {
//         this.nombre = nombre;
//         this.jugadores = new ArrayList<>();
//     }

     // Método para crear un jugador y agregarlo al equipo (Composición)
//     public void agregarJugador(String nombreJugador) {
//         Jugador nuevoJugador = new Jugador(nombreJugador);
//         jugadores.add(nuevoJugador);
//     }

     // Método para eliminar un jugador del equipo
//     public void eliminarJugador(String nombreJugador) {
//         jugadores.removeIf(jugador -> jugador.getNombre().equalsIgnoreCase(nombreJugador));
//     }

     // Getters y Setters
//     public String getNombre() {
//         return nombre;
//     }
//     public void setNombre(String nombre) {
//         this.nombre = nombre;
//     }
//     public ArrayList<Jugador> getJugadores() {
//         return jugadores;
//     }

// }