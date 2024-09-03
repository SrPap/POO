public class Application {
    public static void main(String[] args) {

        for (Mes mes : Mes.values()) {
            EstacionDelAño.imprimirEstacion(mes);
        }
            Menu.mostrarMenu();

    }
}
