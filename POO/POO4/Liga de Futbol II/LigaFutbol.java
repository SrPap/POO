import java.util.ArrayList;
import java.util.Scanner;

public class LigaFutbol {
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
            System.out.println("6. Eliminar jugador.");
            System.out.println("7. Eliminar equipo.");
            System.out.println("8. Seleccionar jugador.");
            System.out.println("9. Seleccionar equipo.");
            System.out.println("10. Salir.");
            System.out.print("Elija una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();  

            switch (opcion) {
                case 1 -> crearJugador();
                case 2 -> crearEquipo();
                case 3 -> asignarJugadorAEquipo();
                case 4 -> mostrarListaJugadores();
                case 5 -> mostrarListaEquipos();
                case 6 -> eliminarJugador();
                case 7 -> eliminarEquipo();
                case 8 -> seleccionarJugador();
                case 9 -> seleccionarEquipo();
                case 10 -> salir = true;
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    private static void crearJugador() {
        System.out.print("Ingrese el nombre del jugador: ");
        String nombreJugador = sc.nextLine();
        jugadores.add(new Jugador(nombreJugador));
        System.out.println("Jugador creado exitosamente.");
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

    private static void eliminarJugador() {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores para eliminar.");
            return;
        }

        mostrarListaJugadores();
        System.out.print("Seleccione el número del jugador que desea eliminar: ");
        int opcionJugador = sc.nextInt();
        sc.nextLine();

        if (opcionJugador > 0 && opcionJugador <= jugadores.size()) {
            Jugador jugadorEliminado = jugadores.remove(opcionJugador - 1);
            if (jugadorEliminado.getEquipo() != null) {
                jugadorEliminado.getEquipo().getJugadores().remove(jugadorEliminado);
            }
            System.out.println("Jugador " + jugadorEliminado.getNombre() + " eliminado exitosamente.");
        } else {
            System.out.println("Opción inválida.");
        }
    }

    private static void eliminarEquipo() {
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos para eliminar.");
            return;
        }

        mostrarListaEquipos();
        System.out.print("Seleccione el número del equipo que desea eliminar: ");
        int opcionEquipo = sc.nextInt();
        sc.nextLine();  

        if (opcionEquipo > 0 && opcionEquipo <= equipos.size()) {
            Equipo equipoEliminado = equipos.remove(opcionEquipo - 1);
            for (Jugador jugador : equipoEliminado.getJugadores()) {
                jugador.setEquipo(null); 
            }
            System.out.println("Equipo " + equipoEliminado.getNombre() + " eliminado exitosamente.");
        } else {
            System.out.println("Opción inválida.");
        }
    }

    private static void seleccionarJugador() {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores creados.");
            return;
        }

        mostrarListaJugadores();
        System.out.print("Seleccione el número del jugador que desea ver/modificar: ");
        int opcionJugador = sc.nextInt();
        sc.nextLine(); 

        if (opcionJugador > 0 && opcionJugador <= jugadores.size()) {
            Jugador jugadorSeleccionado = jugadores.get(opcionJugador - 1);
            boolean regresar = false;

            while (!regresar) {
                System.out.println("\nSubmenú - Jugador: " + jugadorSeleccionado.getNombre());
                System.out.println("1. Ver detalles.");
                System.out.println("2. Cambiar nombre.");
                System.out.println("3. Cambiar equipo.");
                System.out.println("4. Regresar al menú principal.");
                System.out.print("Elija una opción: ");
                int opcionSubmenu = sc.nextInt();
                sc.nextLine(); 

                switch (opcionSubmenu) {
                    case 1 -> {System.out.println(jugadorSeleccionado);
                    }
                    case 2 -> {
                        System.out.print("Ingrese el nuevo nombre del jugador: ");
                        String nuevoNombre = sc.nextLine();
                        jugadorSeleccionado.setNombre(nuevoNombre);
                        System.out.println("Nombre actualizado exitosamente.");
                    }
                    case 3 -> asignarJugadorAEquipo();
                    case 4 -> regresar = true;
                    default -> System.out.println("Opción inválida.");
                }
            }
        } else {
            System.out.println("Opción de jugador no válida.");
        }
    }

    private static void seleccionarEquipo() {
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos creados.");
            return;
        }

        mostrarListaEquipos();
        System.out.print("Seleccione el número del equipo que desea ver/modificar: ");
        int opcionEquipo = sc.nextInt();
        sc.nextLine();  

        if (opcionEquipo > 0 && opcionEquipo <= equipos.size()) {
            Equipo equipoSeleccionado = equipos.get(opcionEquipo - 1);
            boolean regresar = false;

            while (!regresar) {
                System.out.println("\nSubmenú - Equipo: " + equipoSeleccionado.getNombre());
                System.out.println("1. Ver detalles.");
                System.out.println("2. Cambiar nombre.");
                System.out.println("3. Agregar jugador al equipo.");
                System.out.println("4. Mostrar jugadores del equipo.");
                System.out.println("5. Regresar al menú principal.");
                System.out.print("Elija una opción: ");
                int opcionSubmenu = sc.nextInt();
                sc.nextLine(); 

                switch (opcionSubmenu) {
                    case 1 -> System.out.println(equipoSeleccionado);
                    case 2 -> {
                        System.out.print("Ingrese el nuevo nombre del equipo: ");
                        String nuevoNombre = sc.nextLine();
                        equipoSeleccionado.setNombre(nuevoNombre);
                        System.out.println("Nombre del equipo actualizado exitosamente.");
                    }
                    case 3 -> agregarJugadorAEquipo(equipoSeleccionado);
                    case 4 -> mostrarJugadoresDeEquipo(equipoSeleccionado);
                    case 5 -> regresar = true;
                    default -> System.out.println("Opción inválida.");
                }
            }
        } else {
            System.out.println("Opción de equipo no válida.");
        }
    }

    private static void agregarJugadorAEquipo(Equipo equipoSeleccionado) {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores creados.");
            return;
        }

        mostrarListaJugadores();
        System.out.print("Seleccione el número del jugador que desea agregar al equipo: ");
        int opcionJugador = sc.nextInt();
        sc.nextLine();

        if (opcionJugador > 0 && opcionJugador <= jugadores.size()) {
            Jugador jugadorSeleccionado = jugadores.get(opcionJugador - 1);
            equipoSeleccionado.agregarJugador(jugadorSeleccionado);
            System.out.println("Jugador " + jugadorSeleccionado.getNombre() + " agregado al equipo " + equipoSeleccionado.getNombre() + ".");
        } else {
            System.out.println("Opción de jugador no válida.");
        }
    }

    private static void mostrarJugadoresDeEquipo(Equipo equipoSeleccionado) {
        ArrayList<Jugador> jugadoresEquipo = equipoSeleccionado.getJugadores();
        if (jugadoresEquipo.isEmpty()) {
            System.out.println("El equipo no tiene jugadores asignados.");
        } else {
            System.out.println("\nJugadores del equipo " + equipoSeleccionado.getNombre() + ":");
            for (Jugador jugador : jugadoresEquipo) {
                System.out.println(jugador.getNombre());
            }
        }
    }
}