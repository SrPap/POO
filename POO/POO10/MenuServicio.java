import java.util.Scanner;

public class MenuServicio {
    private static final Scanner scanner = new Scanner(System.in);

    public static void mostrarMenu(Cliente cliente, Producto[] inventario) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Agregar producto al carrito");
            System.out.println("2. Ver el carrito");
            System.out.println("3. Realizar la compra");
            System.out.println("4. Salir del sistema");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> agregarProductoAlCarrito(cliente, inventario);
                case 2 -> cliente.getCarrito().mostrarCarrito();
                case 3 -> realizarCompra(cliente);
                case 4 -> {
                    continuar = false;
                    System.out.println("Saliendo del sistema...");
                }
                default -> System.out.println("Opción inválida. Inténtelo de nuevo.");
            }
        }
    }

    private static void agregarProductoAlCarrito(Cliente cliente, Producto[] inventario) {
        System.out.println("Seleccione el producto para agregar al carrito:");
        for (int i = 0; i < inventario.length; i++) {
            System.out.println((i + 1) + ". " + inventario[i]);
        }

        int productoSeleccionado = scanner.nextInt() - 1;
        if (productoSeleccionado < 0 || productoSeleccionado >= inventario.length) {
            System.out.println("Selección inválida.");
            return;
        }

        System.out.print("Ingrese la cantidad a agregar: ");
        int cantidad = scanner.nextInt();

        try {
            cliente.getCarrito().agregarProducto(inventario[productoSeleccionado], cantidad);
            System.out.println("Producto agregado al carrito.");
        } catch (ProductoAgotadoException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void realizarCompra(Cliente cliente) {
        System.out.println("Resumen de la compra:");
        cliente.getCarrito().mostrarCarrito();
        System.out.println("¿Desea realizar la compra? (1: Sí, 2: No)");
        int confirmacion = scanner.nextInt();
        if (confirmacion == 1) {
            cliente.getCarrito().vaciarCarrito();
            System.out.println("Compra realizada con éxito.");
        } else {
            System.out.println("Compra cancelada.");
        }
    }
}
