public class Main {
    public static void main(String[] args) {
        System.out.println("Persona");
        Persona Persona1 = new Persona("Felipe", 15);
        Persona1.imprimirDatos();

        Persona Persona2 = new Persona("Carlos", 20);
        Persona2.imprimirDatos();

        System.out.println();

        System.out.println("Auto");
        Auto Auto1 = new Auto("MarcaChafa", "ModeloCopiado", 2024);
        Auto1.imprimirDatos();
        Auto Auto2 = new Auto("MarcaChafa", "ModeloCopiado");
        Auto2.imprimirDatos();
        Auto Auto3 = new Auto("MarcaChafa");
        Auto3.imprimirDatos();
        Auto Auto4 = new Auto();
        Auto4.imprimirDatos();

     }

}
