import java.util.Random;
import java.util.Scanner;

public class Application {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // DiasdelaSemana();
        Color();
    }



    //          "Días de la semana"
    public static void DiasdelaSemana() {
        System.out.println("Días de la semana");

        DiaSemana[] dias = new DiaSemana[10];
        Random random = new Random();

        for (int i = 0; i < dias.length; i++) {
            int indiceAleatorio = random.nextInt(DiaSemana.values().length);
            dias[i] = DiaSemana.values()[indiceAleatorio];
        }

        for (DiaSemana dia : dias) {
            imprimirDiaLaboral(dia);
        }
    }
    public static void imprimirDiaLaboral(DiaSemana dia) {
        String mensaje = dia.esDiaLaboral() ? "Día laboral" : "No es día laboral";
        System.out.println(dia.name() + ": " + mensaje);
    }

        //          "Color"
    public static void Color() {
        String[] coloresHexadecimales = new String[5];

         System.out.println("Ingrese 5 valores hexadecimales para verificar si son colores primarios:");
 
         for (int i = 0; i < coloresHexadecimales.length; i++) {
             System.out.print("Color " + (i + 1) + ": ");
             coloresHexadecimales[i] = scanner.nextLine();
         }
 
         for (String valorHex : coloresHexadecimales) {
             Color color = ConvertidorColor.convertirHexadecimal(valorHex);
             if (color != null) {
                 System.out.println(valorHex + " es el color primario: " + color.name());
             } else {
                 System.out.println(valorHex + " No es un color primario.");
             }
         }
    }
}

