import java.util.ArrayList;
import java.util.List;

public class ProductoManager {
    private List<Producto> productos = new ArrayList<>();
    private int ultimoId = 0;

    public void agregarProducto(String nombre, double precio, String categoria) {
        Producto producto = new Producto(ultimoId++, nombre, precio, categoria);
        productos.add(producto);
    }

    public List<Producto> obtenerProductos() {
        return new ArrayList<>(productos); // para no exponer la lista original
    }

    public Producto buscarProductoPorId(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    public boolean eliminarProductoPorId(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                productos.remove(producto);
                return true;
            }
        }
        return false;
    }
}
