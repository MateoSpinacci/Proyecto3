package Project_Restaurante.model;

public class Restaurante {
    private final String nombre;
    private Mesa[] mesas;

    public Restaurante(String nombre, Mesa[] mesas) {
        this.nombre = nombre;
        this.mesas = mesas;
    }

    public void calcular_total() {
        double total = 0;
        for (Mesa mesa : mesas) {
            total += mesa.getTotal_mesa();
        }
        System.out.println("Total de dinero: " + total);
    }

    public Mesa[] getMesas() {
        return mesas;
    }
}
