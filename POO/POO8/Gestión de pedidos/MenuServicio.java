import java.util.List;
import java.util.Scanner;

public class MenuServicio {
    private final PedidoServicio pedidoServicio;
    private final Scanner scanner;

    public MenuServicio() {
        this.pedidoServicio = new PedidoServicio();
        this.scanner = new Scanner(System.in);
    }

    public void iniciarMenu() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- MENÚ DE GESTIÓN DE PEDIDOS ---");
            System.out.println("1. Crear nuevo pedido");
            System.out.println("2. Actualizar estado de pedido");
            System.out.println("3. Buscar pedidos por estado");
            System.out.println("4. Mostrar lista de pedidos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea

            switch (opcion) {
                case 1 -> crearNuevoPedido();
                case 2 -> actualizarEstadoPedido();
                case 3 -> buscarPedidosPorEstado();
                case 4 -> mostrarListaDePedidos();
                case 5 -> {
                    continuar = false;
                    System.out.println("Saliendo del sistema...");
                }
                default -> System.out.println("Opción inválida, intente nuevamente.");
            }
        }
    }

    private void crearNuevoPedido() {
        System.out.print("Ingrese el nombre del cliente: ");
        String cliente = scanner.nextLine();
        System.out.print("Ingrese la lista de productos (separados por comas): ");
        String[] listaDeProductos = scanner.nextLine().split(",");

        Pedido nuevoPedido = pedidoServicio.crearPedido(cliente, listaDeProductos);
        System.out.println("Pedido creado exitosamente: " + nuevoPedido);
    }

    private void actualizarEstadoPedido() {
        System.out.print("Ingrese el número de pedido: ");
        int numeroDePedido = scanner.nextInt();
        scanner.nextLine();  // Consumir la nueva línea

        System.out.println("Seleccione el nuevo estado:");
        System.out.println("1. Pendiente");
        System.out.println("2. Enviado");
        System.out.println("3. Entregado");
        int estadoOpcion = scanner.nextInt();
        scanner.nextLine();  // Consumir la nueva línea

        EstadoPedido nuevoEstado;
        switch (estadoOpcion) {
            case 1 -> nuevoEstado = EstadoPedido.PENDIENTE;
            case 2 -> nuevoEstado = EstadoPedido.ENVIADO;
            case 3 -> nuevoEstado = EstadoPedido.ENTREGADO;
            default -> {
                System.out.println("Opción inválida. No se actualizó el estado.");
                return;
            }
        }

        boolean actualizado = pedidoServicio.actualizarEstadoPedido(numeroDePedido, nuevoEstado);
        if (actualizado) {
            System.out.println("Estado del pedido actualizado exitosamente.");
        } else {
            System.out.println("No se encontró un pedido con ese número.");
        }
    }

    private void buscarPedidosPorEstado() {
        System.out.println("Seleccione el estado a buscar:");
        System.out.println("1. Pendiente");
        System.out.println("2. Enviado");
        System.out.println("3. Entregado");
        int estadoOpcion = scanner.nextInt();
        scanner.nextLine();  // Consumir la nueva línea

        EstadoPedido estadoBuscado;
        switch (estadoOpcion) {
            case 1 -> estadoBuscado = EstadoPedido.PENDIENTE;
            case 2 -> estadoBuscado = EstadoPedido.ENVIADO;
            case 3 -> estadoBuscado = EstadoPedido.ENTREGADO;
            default -> {
                System.out.println("Opción inválida.");
                return;
            }
        }

        List<Pedido> pedidos = pedidoServicio.buscarPedidosPorEstado(estadoBuscado);
        if (pedidos.isEmpty()) {
            System.out.println("No se encontraron pedidos con el estado seleccionado.");
        } else {
            pedidos.forEach(System.out::println);
        }
    }

    private void mostrarListaDePedidos() {
        List<Pedido> pedidos = pedidoServicio.obtenerListaDePedidos();
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
        } else {
            pedidos.forEach(System.out::println);
        }
    }
}
