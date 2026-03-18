package Project_Restaurante.model;

public class Bebida extends Producto{
    private int tamanio;
    private String tipo;

    public Bebida(String nombre, double precio, String tipo, int tamanio) {
        super(nombre, precio);
        this.tamanio = tamanio;
        this.tipo = tipo;
    }

    @Override
    public void mostrar_info() {
        System.out.println("La bebida " + this.getNombre() + " de tamaño " +  this.tamanio + " cuesta $" + this.getPrecio());
    }

    public int getTamanio() {
        return tamanio;
    }

    public String getTipo() {
        return tipo;
    }
}
