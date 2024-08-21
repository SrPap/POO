import java.util.ArrayList;
import java.util.Scanner;
import modelos.Empleado;

public class Application {
    public static ArrayList<Empleado> empleados = new ArrayList<>();
    public static ArrayList<Empleado> empleadosFiltrados = new ArrayList<>();

    public static void main(String[] args) {
        inicializarEmpleados();
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("MENU");
            System.out.println("1. Mostrar todos los empleados.");
            System.out.println("2. Crear empleado.");
            System.out.println("3. Filtrar empleados.");
            System.out.println("4. Ordenar empleados.");
            System.out.println("5. Incrementar salario.");
            System.out.println("6. Limpiar filtros.");
            System.out.println("7. Salir.");
            System.out.println("");
            System.out.print("Elija una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();  

            switch (opcion) {
                case 1 -> mostrarEmpleados(empleadosFiltrados.isEmpty() ? empleados : empleadosFiltrados);
                case 2 -> crearEmpleado(sc);
                case 3 -> filtrarEmpleados(sc);
                case 4 -> ordenarEmpleados(sc);
                case 5 -> incrementarSalario(sc);
                case 6 -> limpiarFiltros();
                case 7 -> salir = true;
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    public static void inicializarEmpleados() {
        empleados.add(new Empleado("Ana", 30, 3000.0, "Recursos Humanos"));
        empleados.add(new Empleado("Luis", 25, 2500.0, "Marketing"));
        empleados.add(new Empleado("Maria", 35, 3500.0, "Finanzas"));
        empleados.add(new Empleado("Juan", 28, 2800.0, "IT"));
        empleados.add(new Empleado("Pedro", 40, 4000.0, "Ventas"));
    }

    public static void mostrarEmpleados(ArrayList<Empleado> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay empleados para mostrar.");
            return;
        }

        System.out.printf("%-5s %-20s %-5s %-10s %-20s\n", "No.", "Nombre", "Edad", "Salario", "Departamento");
        System.out.println("-------------------------------------------------------------");
        for (int i = 0; i < lista.size(); i++) {
            Empleado e = lista.get(i);
            System.out.printf("%-5d %-20s %-5d %-10.2f %-20s\n", (i + 1), e.getNombre(), e.getEdad(), e.getSalario(), e.getDepartamento());
        }
    }

    public static void crearEmpleado(Scanner sc) {
        System.out.print("Ingrese el nombre del nuevo empleado: ");
        String nombre = sc.nextLine();

        if (buscarPorNombre(empleados, nombre) != null) {
            System.out.println("Error: Ya existe un empleado con ese nombre.");
            return;
        }

        System.out.print("Ingrese la edad del empleado: ");
        int edad = sc.nextInt();
        System.out.print("Ingrese el salario del empleado: ");
        double salario = sc.nextDouble();
        sc.nextLine(); 
        System.out.print("Ingrese el departamento del empleado: ");
        String departamento = sc.nextLine();

        empleados.add(new Empleado(nombre, edad, salario, departamento));
        System.out.println("Empleado creado exitosamente.");
    }

    public static void filtrarEmpleados(Scanner sc) {
        empleadosFiltrados.clear();

        System.out.print("Ingrese el atributo por el que desea filtrar (nombre, edad, salario, departamento): ");
        String atributo = sc.nextLine();

        switch (atributo.toLowerCase()) {
            case "nombre" -> {
                System.out.print("Ingrese el nombre a filtrar: ");
                String nombre = sc.nextLine();
                for (Empleado e : empleados) {
                    if (e.getNombre().equalsIgnoreCase(nombre)) {
                        empleadosFiltrados.add(e);
                    }
                }
            }
            case "edad" -> {
                System.out.print("Ingrese la edad mínima: ");
                int edadMin = sc.nextInt();
                System.out.print("Ingrese la edad máxima: ");
                int edadMax = sc.nextInt();
                for (Empleado e : empleados) {
                    if (e.getEdad() >= edadMin && e.getEdad() <= edadMax) {
                        empleadosFiltrados.add(e);
                    }
                }
            }
            case "salario" -> {
                System.out.print("Ingrese el salario mínimo: ");
                double salarioMin = sc.nextDouble();
                System.out.print("Ingrese el salario máximo: ");
                double salarioMax = sc.nextDouble();
                for (Empleado e : empleados) {
                    if (e.getSalario() >= salarioMin && e.getSalario() <= salarioMax) {
                        empleadosFiltrados.add(e);
                    }
                }
            }
            case "departamento" -> {
                System.out.print("Ingrese el departamento a filtrar: ");
                String departamento = sc.nextLine();
                for (Empleado e : empleados) {
                    if (e.getDepartamento().equalsIgnoreCase(departamento)) {
                        empleadosFiltrados.add(e);
                    }
                }
            }
            default -> System.out.println("Atributo no válido.");
        }

        if (empleadosFiltrados.isEmpty()) {
            System.out.println("No se encontraron empleados que coincidan con el filtro.");
        } else {
            mostrarEmpleados(empleadosFiltrados);
        }
    }

    //     Algoritmo de burbuja
    public static void ordenarEmpleados(Scanner sc) {
        System.out.print("Ingrese el atributo por el que desea ordenar (nombre, edad, salario, departamento): ");
        String atributo = sc.nextLine();

        ArrayList<Empleado> lista = empleadosFiltrados.isEmpty() ? empleados : empleadosFiltrados;

        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = 0; j < lista.size() - 1 - i; j++) {
                if (comparar(lista.get(j), lista.get(j + 1), atributo) > 0) {
                    Empleado temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                }
            }
        }

        mostrarEmpleados(lista);  
    }
    public static int comparar(Empleado e1, Empleado e2, String atributo) {
        return switch (atributo.toLowerCase()) {
            case "nombre" -> e1.getNombre().compareToIgnoreCase(e2.getNombre());
            case "edad" -> Integer.compare(e1.getEdad(), e2.getEdad());
            case "salario" -> Double.compare(e1.getSalario(), e2.getSalario());
            case "departamento" -> e1.getDepartamento().compareToIgnoreCase(e2.getDepartamento());
            default -> 0;
        };
    }

    public static Empleado buscarPorNombre(ArrayList<Empleado> lista, String nombre) {
        for (Empleado e : lista) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                return e;
            }
        }
        return null;
    }

    public static void incrementarSalario(Scanner sc) {
        System.out.print("Ingrese el nombre del empleado al que desea incrementar el salario: ");
        String nombre = sc.nextLine();
        Empleado empleado = buscarPorNombre(empleados, nombre);

        if (empleado != null) {
            System.out.print("Ingrese el porcentaje de aumento salarial: ");
            double porcentaje = sc.nextDouble();
            double nuevoSalario = empleado.getSalario() * (1 + porcentaje / 100);
            empleado.setSalario(nuevoSalario);
            System.out.println("Salario incrementado exitosamente.");
            imprimirEmpleado(empleado);
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    public static void limpiarFiltros() {
        empleadosFiltrados.clear();
        System.out.println("Filtros limpiados. Ahora se muestran todos los empleados.");
    }

    public static void imprimirEmpleado(Empleado empleado) {
        System.out.printf("Nombre: %s | Edad: %d | Salario: %.2f | Departamento: %s\n",
                empleado.getNombre(), empleado.getEdad(), empleado.getSalario(), empleado.getDepartamento());
    }
}