package Project_Restaurante.model;

public class Pedido {
    private Producto[] productos;
    private int[] cantidades;
    private double total;
    private boolean pagado;

    public Pedido(Producto[] productos, int[] cantidades) {
        this.productos = productos;
        this.cantidades = cantidades;
        this.pagado = false;
    }

    public double calcular_total(Cliente cliente) {
        total = 0;
        for (int i = 0; i < productos.length; i++) {
            total += productos[i].getPrecio() * cantidades[i];
        }
        if (cliente instanceof TieneDescuento) {
            total = ((TieneDescuento) cliente).calcular_descuento(total);
        }
        return total;
    }

    public void mostrar_info() {
        System.out.println("Último pedido del cliente:\n");
        for (int i=0; i<productos.length; i++) {
                System.out.print("*" + productos[i].getNombre() + " Cantidad: " +  cantidades[i] + "\n");
            }
        System.out.println();
        System.out.println("Total del pedido: " + total);
        if (getPagado()) {
            System.out.println("El pedido ya fue pagado");
        } else {
            System.out.println("El pedido no está pagado");
        }
    }

    public int[] getCantidades() {
        return cantidades;
    }

    public void setCantidades(int[] cantidades) {
        this.cantidades = cantidades;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public void setProductos(Producto[] productos) {
        this.productos = productos;
    }

    public boolean getPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }
}
