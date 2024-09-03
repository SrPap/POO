import java.util.Scanner;

public class PalabraClave {
    public static Scanner scanner = new Scanner(System.in);

    private String clave;


    public void ingresarPalabraClave() {
        boolean claveValida = false;

        while (!claveValida) {
            try {
                System.out.print("Ingresa una palabra clave: ");
                clave = scanner.nextLine();

                validarLongitud(clave);
                validarNumeros(clave);
                validarLetraZ(clave);

                System.out.println("La palabra clave es válida para ser utilizada.");
                claveValida = true;

            } catch (LongitudInvalidaException | CantidadNumerosException | LetraZNoEncontradaException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }

    private void validarLongitud(String clave) throws LongitudInvalidaException {
        if (clave.length() < 8) {
            throw new LongitudInvalidaException("Error: La palabra clave debe tener al menos 8 caracteres.");
        }
    }

    private void validarNumeros(String clave) throws CantidadNumerosException {
        int contadorNumeros = 0;
        for (char c : clave.toCharArray()) {
            if (Character.isDigit(c)) {
                contadorNumeros++;
            }
        }
        if (contadorNumeros != 4) {
            throw new CantidadNumerosException("Error: La palabra clave debe contener exactamente 4 números.");
        }
    }

    private void validarLetraZ(String clave) throws LetraZNoEncontradaException {
        if (!clave.contains("z")) {
            throw new LetraZNoEncontradaException("Error: La palabra clave debe contener la letra 'z'.");
        }
    }

    class LongitudInvalidaException extends Exception {
        public LongitudInvalidaException(String mensaje) {
            super(mensaje);
        }
    }
    class CantidadNumerosException extends Exception {
        public CantidadNumerosException(String mensaje) {
            super(mensaje);
        }
    }
    class LetraZNoEncontradaException extends Exception {
        public LetraZNoEncontradaException(String mensaje) {
            super(mensaje);
        }
    }

    public static void main(String[] args) {
        PalabraClave palabraClave = new PalabraClave();
        palabraClave.ingresarPalabraClave();
    }
}
