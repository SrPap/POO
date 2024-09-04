public class Main {
    public static void main(String[] args) {
        Producto[] inventario = {
            new ProductoElectronico("Laptop", 1000, 10, "Laptop de alta gama", 24),
            new ProductoRopa("Camiseta", 20, 50, "Camiseta 100% algodón", "M"),
            new ProductoRopa("Pantalón", 40, 30, "Pantalón de mezclilla", "L")
        };

        Cliente cliente = new Cliente("Juan");

        MenuServicio.mostrarMenu(cliente, inventario);
    }
}
