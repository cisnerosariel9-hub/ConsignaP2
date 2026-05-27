package interfaz;
import negocio.*;

import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- INICIANDO SISTEMA DE GESTIÓN DE INVENTARIOS ---");

        Inventario miInventario = new Inventario(50);

        Calendar cal = Calendar.getInstance();

        cal.add(Calendar.DAY_OF_MONTH, -5);
        Date fechaVencida = cal.getTime();

        cal.add(Calendar.MONTH, 2);
        Date fechaBuena = cal.getTime();

        Producto p1 = new ProductoPerecedero(1, "Leche Entera", 1.50, 20, 5, fechaVencida, 4.0);
        Producto p2 = new ProductoPerecedero(2, "Queso Fresco", 3.00, 15, 3, fechaBuena, 4.0);
        Producto p3 = new ProductoNoPerecedero(3, "Arroz", 0.80, 100, 20, 12, "MarcaX");
        Producto p4 = new ProductoNoPerecedero(4, "Frijoles", 1.20, 50, 10, 24, "MarcaY");

        miInventario.agregarProducto(p1);
        miInventario.agregarProducto(p2);
        miInventario.agregarProducto(p3);
        miInventario.agregarProducto(p4);

        System.out.println("\n--- ESTADO INICIAL DEL INVENTARIO ---");
        miInventario.generarReporte();

        System.out.println("\n--- ACCIÓN DEL PROVEEDOR ---");
        Proveedor proveedor1 = new Proveedor(101, "Distribuidora del Sur", "0991234567", "Av. Principal");
        proveedor1.suministrar(p3, 30);

        System.out.println("\n--- SIMULACIÓN DE VENTA ---");
        Venta venta1 = new Venta(1001, new Date());

        int cantLecheVendida = 5;
        int cantArrozVendido = 10;

        p1.actualizar(p1.getCantidad() - cantLecheVendida);
        p3.actualizar(p3.getCantidad() - cantArrozVendido);

        venta1.calcularTotal(p1, cantLecheVendida);
        venta1.calcularTotal(p3, cantArrozVendido);

        venta1.generarFactura();

        System.out.println("\n--- ESTADO FINAL DEL INVENTARIO ---");
        miInventario.generarReporte();
    }
}