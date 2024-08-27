import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Edificio> edificios = new ArrayList<>();

        Polideportivo poli1 = new Polideportivo(50, 20, 30, "Polideportivo Central", "Techado");
        Polideportivo poli2 = new Polideportivo(60, 25, 35, "Polideportivo Norte", "Abierto");

        EdificioDeOficinas edificio1 = new EdificioDeOficinas(40, 10, 60, 10, 4, 5);
        EdificioDeOficinas edificio2 = new EdificioDeOficinas(50, 12, 70, 12, 5, 8);

        edificios.add(poli1);
        edificios.add(poli2);
        edificios.add(edificio1);
        edificios.add(edificio2);

        int techados = 0;
        int abiertos = 0;

        for (Edificio edificio : edificios) {
            System.out.println("Superficie: " + edificio.calcularSuperficie());
            System.out.println("Volumen: " + edificio.calcularVolumen());

            if (edificio instanceof Polideportivo polideportivo) {
                if (polideportivo.getTipoInstalacion().equalsIgnoreCase("Techado")) {
                    techados++;
                } else if (polideportivo.getTipoInstalacion().equalsIgnoreCase("Abierto")) {
                    abiertos++;
                }
            } else if (edificio instanceof EdificioDeOficinas edificioDeOficinas) {
                System.out.println("Capacidad de personas: " + edificioDeOficinas.cantPersonas());
            }
            System.out.println();
        }

        System.out.println("Cantidad de polideportivos techados: " + techados);
        System.out.println("Cantidad de polideportivos abiertos: " + abiertos);
    }
}