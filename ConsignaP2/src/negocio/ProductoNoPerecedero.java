package negocio;

public class ProductoNoPerecedero extends Producto {
    private int garantiaMeses;
    private String marca;

    public ProductoNoPerecedero(int id, String nombre, double precio, int cantidad, int stockMinimo, int garantiaMeses, String marca) {
        super(id, nombre, precio, cantidad, stockMinimo);
        this.garantiaMeses = garantiaMeses;
        this.marca = marca;
    }

    @Override
    public double calcularValor() {
        return getPrecio() * getCantidad();
    }

    public void mostrarGarantia() {
        System.out.println("Garantía del producto " + getNombre() + ": " + garantiaMeses + " meses.");
    }
}
