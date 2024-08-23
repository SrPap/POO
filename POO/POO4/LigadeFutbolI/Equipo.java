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

