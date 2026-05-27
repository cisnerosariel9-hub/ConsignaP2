package negocio;

import java.util.Date;

public class Venta {
    private int idVenta;
    private Date fecha;
    private double total;

    public Venta(int idVenta, Date fecha) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.total = 0.0;
    }

    public void calcularTotal(Producto p, int cantidadVendida) {
        this.total += (p.getPrecio() * cantidadVendida);
    }

    public void generarFactura() {
        System.out.println("Factura #" + idVenta + " | Fecha: " + fecha.toString() + " | Total a pagar: $" + total);
    }
}