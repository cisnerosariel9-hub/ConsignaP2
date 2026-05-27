package negocio;

public abstract class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int cantidad;
    private int stockMinimo;

    public Producto(int id, String nombre, double precio, int cantidad, int stockMinimo) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.stockMinimo = stockMinimo;
    }

    public abstract double calcularValor();

    public void registrar() {
        System.out.println("Registrando producto: " + this.nombre);
    }

    public void actualizar(int nuevaCantidad) {
        this.cantidad = nuevaCantidad;
        System.out.println("Inventario actualizado. Nueva cantidad: " + this.cantidad);
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getCantidad() { return cantidad; }
    public int getStockMinimo() { return stockMinimo; }

    public void setPrecio(double precio) { this.precio = precio; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}
