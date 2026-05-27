package negocio;

import java.util.Date;

public class ProductoPerecedero extends Producto {
    private Date fechaCaducidad;
    private double temperatura;

    public ProductoPerecedero(int id, String nombre, double precio, int cantidad, int stockMinimo, Date fechaCaducidad, double temperatura) {
        super(id, nombre, precio, cantidad, stockMinimo);
        this.fechaCaducidad = fechaCaducidad;
        this.temperatura = temperatura;
    }

    @Override
    public double calcularValor() {
        double valorBase = getPrecio() * getCantidad();
        boolean cercaDeCaducar = verificarCaducidad();
        if (cercaDeCaducar) {
            return valorBase * 0.80;
        }
        return valorBase;
    }

    public boolean verificarCaducidad() {
        Date hoy = new Date();
        return fechaCaducidad.before(hoy);
    }
}