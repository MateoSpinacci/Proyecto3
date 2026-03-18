package Project_Restaurante.model;

public abstract class Producto {
    private final String nombre;
    private final double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public abstract void mostrar_info();


    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }
}
