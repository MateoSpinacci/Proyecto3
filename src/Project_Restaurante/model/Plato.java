package Project_Restaurante.model;

public class Plato extends Producto{
    private int calorias;
    private String tipo;

    public Plato(String nombre, double precio, String tipo, int calorias) {
        super(nombre, precio);
        this.calorias = calorias;
        this.tipo = tipo;
    }

    @Override
    public void mostrar_info() {
        System.out.println("El plato " + this.getNombre() + " cuenta con " +  this.calorias + "y cuesta $" + this.getPrecio());
    }

    public String getTipo() {
        return tipo;
    }

    public int getCalorias() {
        return calorias;
    }
}
