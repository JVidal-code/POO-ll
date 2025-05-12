import java.util.Scanner;
import java.util.List;

public class ProductoUI {
    private final ProductoManager productoManager = new ProductoManager();
    private final Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        while (true) {
            mostrarMenu();
            int opcion = leerEntero("Seleccione una opción:");
            switch (opcion) {
                case 1 -> agregarProducto();
                case 2 -> mostrarProductos();
                case 3 -> buscarProducto();
                case 4 -> eliminarProducto();
                case 5 -> {
                    System.out.println("¡Hasta luego!");
                    return;
                }
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("""
                \n--- Menú Principal ---
                1. Agregar producto
                2. Ver productos
                3. Buscar producto por ID
                4. Eliminar producto
                5. Salir""");
    }

    private void agregarProducto() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        double precio = leerDecimal("Precio: ");

        System.out.print("Categoría: ");
        String categoria = scanner.nextLine();

        productoManager.agregarProducto(nombre, precio, categoria);
        System.out.println("Producto agregado exitosamente.");
    }

    private void mostrarProductos() {
        List<Producto> productos = productoManager.obtenerProductos();
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            System.out.println("\n--- Lista de Productos ---");
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        }
    }

    private void buscarProducto() {
        int id = leerEntero("Ingrese el ID del producto:");
        Producto producto = productoManager.buscarProductoPorId(id);
        if (producto != null) {
            System.out.println("Producto encontrado: " + producto);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private void eliminarProducto() {
        int id = leerEntero("Ingrese el ID del producto a eliminar:");
        boolean eliminado = productoManager.eliminarProductoPorId(id);
        if (eliminado) {
            System.out.println("Producto eliminado correctamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private int leerEntero(String mensaje) {
        System.out.print(mensaje + " ");
        while (!scanner.hasNextInt()) {
            System.out.print("Por favor ingrese un número entero válido: ");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine(); // limpiar el buffer
        return valor;
    }

    private double leerDecimal(String mensaje) {
        System.out.print(mensaje + " ");
        while (!scanner.hasNextDouble()) {
            System.out.print("Por favor ingrese un número decimal válido: ");
            scanner.next();
        }
        double valor = scanner.nextDouble();
        scanner.nextLine(); // limpiar el buffer
        return valor;
    }
}
