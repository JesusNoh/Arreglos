import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Arreglos1 {
    private String[] departamentos = {"Ropa", "Deporte", "Jugueteria"};
    private Map<String, int[]> ventas;

    public Arreglos1() {
        ventas = new HashMap<>();
        for (String departamento : departamentos) {
            ventas.put(departamento, new int[12]);
        }
    }

    public void agregarVenta(String departamento, int mes, int cantidad) {
        if (ventas.containsKey(departamento) && mes >= 1 && mes <= 12) {
            int[] ventasMes = ventas.get(departamento);
            ventasMes[mes - 1] += cantidad;
            ventas.put(departamento, ventasMes);
        }
    }

    public Integer buscarVenta(String departamento, int mes) {
        if (ventas.containsKey(departamento) && mes >= 1 && mes <= 12) {
            return ventas.get(departamento)[mes - 1];
        }
        return null;
    }

    public void eliminarVentas(String departamento) {
        if (ventas.containsKey(departamento)) {
            ventas.put(departamento, new int[12]);
        }
    }

    public void mostrarVentas() {
        for (Map.Entry<String, int[]> entry : ventas.entrySet()) {
            String departamento = entry.getKey();
            int[] ventasMes = entry.getValue();
            System.out.println("Ventas de " + departamento + ":");
            for (int mes = 0; mes < ventasMes.length; mes++) {
                System.out.println("  Mes " + (mes + 1) + ": " + ventasMes[mes] + " unidades");
            }
        }
    }

    public static void main(String[] args) {
        Arreglos1 tienda = new Arreglos1();
        Scanner scanner = new Scanner(System.in);

        // Agregar ventas
        while (true) {
            System.out.print("Ingrese el departamento (Ropa, Deporte, Jugueteria) o 'salir' para terminar: ");
            String departamento = scanner.nextLine();
            if (departamento.equalsIgnoreCase("salir")) {
                break;
            }
            System.out.print("Ingrese el mes (1-12): ");
            int mes = Integer.parseInt(scanner.nextLine());
            System.out.print("Ingrese la cantidad de ventas: ");
            int cantidad = Integer.parseInt(scanner.nextLine());
            tienda.agregarVenta(departamento, mes, cantidad);
        }

        // Buscar una venta específica
        System.out.print("Ingrese el departamento para buscar una venta: ");
        String deptBuscar = scanner.nextLine();
        System.out.print("Ingrese el mes para buscar una venta (1-12): ");
        int mesBuscar = Integer.parseInt(scanner.nextLine());
        Integer venta = tienda.buscarVenta(deptBuscar, mesBuscar);
        System.out.println("Ventas en " + deptBuscar + " para el mes " + mesBuscar + ": " + (venta != null ? venta + " unidades" : "No disponible"));

        // Eliminar ventas de un departamento
        System.out.print("Ingrese el departamento para eliminar todas las ventas: ");
        String deptEliminar = scanner.nextLine();
        tienda.eliminarVentas(deptEliminar);

        // Mostrar todas las ventas
        System.out.println("Ventas después de las operaciones:");
        tienda.mostrarVentas();

        scanner.close();
    }
}
