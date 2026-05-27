package negocio;

public class Proveedor {
    private int id;
    private String nombre;
    private String telefono;
    private String direccion;

    public Proveedor(int id, String nombre, String telefono, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public void suministrar(Producto p, int cantidad) {
        System.out.println("El proveedor " + this.nombre + " suministró " + cantidad + " unidades de " + p.getNombre());
        p.actualizar(p.getCantidad() + cantidad);
    }
}