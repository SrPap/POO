import java.util.ArrayList;
import java.util.Scanner;
package LigadeFutbolI;

public class LigadeFutbol {
    public static ArrayList<Jugador> jugadores = new ArrayList<>();
    public static ArrayList<Equipo> equipos = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            System.out.println("\nMENU");
            System.out.println("1. Crear jugador.");
            System.out.println("2. Crear equipo.");
            System.out.println("3. Asignar jugador a equipo.");
            System.out.println("4. Mostrar lista de jugadores.");
            System.out.println("5. Mostrar lista de equipos.");
            System.out.println("6. Salir.");
            System.out.println("");
            System.out.print("Elija una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();
            
            switch (opcion) {
                case 1 -> crearJugador();
                case 2 -> crearEquipo();
                case 3 -> asignarJugadorAEquipo();
                case 4 -> mostrarListaJugadores();
                case 5 -> mostrarListaEquipos();
                case 6 -> salir = true;
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    private static void crearJugador() {
        System.out.print("Ingrese el nombre del jugador: ");
        String nombreJugador = sc.nextLine();
        if (equipos.isEmpty()) {
            jugadores.add(new Jugador(nombreJugador));
            System.out.println("Jugador creado sin equipo (no hay equipos disponibles).");
        } else {
            mostrarListaEquipos();
            System.out.print("Seleccione el número de equipo para asignar al jugador, o 0 para no asignar: ");
            int opcionEquipo = sc.nextInt();
            sc.nextLine();
            Jugador nuevoJugador = new Jugador(nombreJugador);
            jugadores.add(nuevoJugador);

            if (opcionEquipo > 0 && opcionEquipo <= equipos.size()) {
                Equipo equipoSeleccionado = equipos.get(opcionEquipo - 1);
                equipoSeleccionado.agregarJugador(nuevoJugador);
                System.out.println("Jugador creado y asignado al equipo " + equipoSeleccionado.getNombre() + ".");
            } else {
                System.out.println("Jugador creado sin equipo.");
            }
        }
    }

    private static void crearEquipo() {
        System.out.print("Ingrese el nombre del equipo: ");
        String nombreEquipo = sc.nextLine();
        equipos.add(new Equipo(nombreEquipo));
        System.out.println("Equipo creado exitosamente.");
    }

    private static void asignarJugadorAEquipo() {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores creados.");
            return;
        }
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos creados.");
            return;
        }

        mostrarListaJugadores();
        System.out.print("Seleccione el número del jugador que desea asignar: ");
        int opcionJugador = sc.nextInt();
        sc.nextLine();
        if (opcionJugador > 0 && opcionJugador <= jugadores.size()) {
            Jugador jugadorSeleccionado = jugadores.get(opcionJugador - 1);

            mostrarListaEquipos();
            System.out.print("Seleccione el número del equipo al que desea asignar el jugador: ");
            int opcionEquipo = sc.nextInt();
            sc.nextLine(); 
            if (opcionEquipo > 0 && opcionEquipo <= equipos.size()) {
                Equipo equipoSeleccionado = equipos.get(opcionEquipo - 1);
                equipoSeleccionado.agregarJugador(jugadorSeleccionado);
                System.out.println("Jugador " + jugadorSeleccionado.getNombre() + " asignado al equipo " + equipoSeleccionado.getNombre() + ".");
            } else {
                System.out.println("Opción de equipo no válida.");
            }
        } else {
            System.out.println("Opción de jugador no válida.");
        }
    }

    private static void mostrarListaJugadores() {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores creados.");
        } else {
            System.out.println("\nLista de jugadores:");
            for (int i = 0; i < jugadores.size(); i++) {
                System.out.println((i + 1) + ". " + jugadores.get(i));
            }
        }
    }

    private static void mostrarListaEquipos() {
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos creados.");
        } else {
            System.out.println("\nLista de equipos:");
            for (int i = 0; i < equipos.size(); i++) {
                System.out.println((i + 1) + ". " + equipos.get(i).getNombre());
            }
        }
    }
}


// Crear jugador: Esta opción te permitirá crear un nuevo jugador. Deberás pedir al usuario el nombre 
// del jugador y mostrar la lista de equipos disponibles para que elija uno, si no hay equipos creados 
// entonces debería mostrar un mensaje que diga que no hay equipos disponibles y setear null.

// Crear equipo: Esta opción te permitirá crear un nuevo equipo. Deberás pedir al usuario el nombre del equipo.

// Asignar jugador a equipo: Con esta opción, podrás asignar un jugador existente a un equipo existente. 
// Deberás permitir al usuario seleccionar de la lista de jugadores y equipos existentes.

// Mostrar lista de jugadores: Esta opción mostrará una lista de todos los jugadores creados, junto con el 
// nombre del equipo al que están asignados, si corresponde.

// Mostrar lista de equipos: Esta opción mostrará una lista de todos los equipos creados.

// Salir: Esta opción termina la ejecución del programa.