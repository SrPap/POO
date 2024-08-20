import java.util.Scanner;

public class Auto {
       String marca;
       String modelo;
       Integer año;

        
    // constructores
        public Auto(String marca, String modelo, int año) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
    }
        public Auto(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = 0;
    }
        public Auto(String marca) {
        this.marca = marca;
        this.modelo = "Desconocido";
        this.año = 0;
    }
    public Auto() {
        this.marca = "Desconocido";
        this.modelo = "Desconocido";
        this.año = 0;
    }  

    public void imprimirDatos() {
            System.out.println("Marca: " + marca + "    Modelo: " + modelo  + "    Año: " + año);
     }
     public static void imprimirDatos(Auto auto) {
        System.out.println("Marca: " + auto.marca + "    Modelo: " + auto.modelo  + "    Año: " + auto.año);
 }


    public static Scanner sc = new Scanner(System.in);

     public static void main(String[] args) {
        boolean salir = false;
        Auto auto = null;

        while (!salir) {
            System.out.println("MENU");
            System.out.println("1. Crear un auto");
            System.out.println("2. Mostrar el auto");
            System.out.println("3. Salir");
            System.out.println("");
            System.out.print("Elija una opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Ingrese el marca del auto: ");
                    String marca = sc.next();
                    System.out.println("Ingrese el modelo del auto: ");
                    String modelo = sc.next();
                    System.out.println("Ingrese el año del auto: ");
                    int año = sc.nextInt();
                    auto = new Auto(marca, modelo,año);

                }
                case 2 ->{
                if (auto != null) {
                    imprimirDatos(auto);}
                 else {
                System.out.println("Primero debes crear un auto (opción 1).");
                }}
                case 3 -> salir = true;
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }
}


