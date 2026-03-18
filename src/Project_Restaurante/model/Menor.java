package Project_Restaurante.model;

public class Menor extends Cliente implements TieneDescuento {
    private final int edad;
    private boolean menuInfantil = false;

    public Menor(String nombre, int edad) {
        super(nombre);
        this.edad = edad;
        if (edad < 14) {
            menuInfantil = true;
        }
    }

    public double calcular_descuento(double total) {
        total = total * 0.9;
        return total;
    }

    public int getEdad() {
        return edad;
    }

    public boolean isMenuInfantil() {
        return menuInfantil;
    }
}
