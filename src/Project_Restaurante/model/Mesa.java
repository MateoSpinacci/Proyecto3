package Project_Restaurante.model;

import java.util.Arrays;

public class Mesa {
    private final int numero;
    private static int numSiguiente = 1;
    private final int capacidad;
    private double total_mesa;
    private boolean llena = false;
    private final Cliente[] clientes;

    public Mesa(int capacidad) {
        this.numero = numSiguiente++;
        this.capacidad = capacidad;
        clientes = new Cliente[capacidad];
    }

    public void mostrar_info() {
        System.out.println("La mesa " + numero + " cuenta con una capacidad de " + capacidad + " personas\nLos clientes asignados son:");
        for (int i=0; i<clientes.length; i++) {
            if (clientes[i] != null) {
                System.out.println(clientes[i].getNombre());
            }
        }
        System.out.println("Total de la mesa: " + total_mesa);
    }

    public double getTotal_mesa() {
        return  total_mesa;
    }

    public void setTotal_mesa(double total_mesa) {
        this.total_mesa += total_mesa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public Cliente[] getClientes() {
        return clientes;
    }

    public int getNumero() {
        return numero;
    }

    public boolean getLlena() {
        return llena;
    }

    public void setLlena(boolean llena) {
        this.llena = llena;
    }
}
