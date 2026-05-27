package negocio;
import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> productos;
    private int capacidadMaxima;

    public Inventario(int capacidadMaxima) {
        this.productos = new ArrayList<>();
        this.capacidadMaxima = capacidadMaxima;
    }

    public void agregarProducto(Producto p) {
        if (productos.size() < capacidadMaxima) {
            productos.add(p);
            System.out.println("Producto agregado con éxito.");
        } else {
            System.out.println("Error: Capacidad máxima del inventario alcanzada.");
        }
    }

    public void eliminarProducto(int id) {
        productos.removeIf(p -> p.getId() == id);
    }

    public Producto buscarProducto(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void generarReporte() {
        System.out.println("--- Reporte de Inventario ---");
        double valorTotalInventario = 0;

        for (Producto p : productos) {
            double valorProducto = p.calcularValor();
            valorTotalInventario += valorProducto;
            System.out.println("- " + p.getNombre() + " | Cantidad: " + p.getCantidad() + " | Valor: $" + valorProducto);
        }
        System.out.println("Valor total del inventario: $" + valorTotalInventario);
    }
}