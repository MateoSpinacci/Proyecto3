package Project_Restaurante.app;

import Project_Restaurante.model.*;
import Project_Restaurante.service.Servicio;

public class Runner {
    public static void main(String[] args) {

        //Clientes
        Socio socio1 = new Socio("Mateo", 153);
        Socio socio2 = new Socio("Alfonsina", 172);
        Menor menor1 = new Menor("Teo", 12);
        Cliente cliente1 = new Cliente("Juanito");

        //Mesas
        Mesa mesa1 = new Mesa(2);
        Mesa mesa2 = new Mesa(5);
        Mesa[] mesas = {mesa1, mesa2};

        //Restaurante
        Restaurante restaurante1 = new Restaurante("RestoBurger", mesas);

        //Productos
        Plato plato1 = new Plato("Hamburguesa", 6.99, "Principal", 700);
        Plato plato2 = new Plato("Helado", 4, "Postre", 207);
        Plato plato3 = new Plato("Pizza", 10, "Principal", 1200);
        Plato plato4 = new Plato("Empanadas", 2.3, "Entrada", 300);
        Bebida bebida1 =  new Bebida("Coca-Cola", 2.7, "No Alcohólica", 750);
        Bebida bebida2 =  new Bebida("Cerveza", 6.5, "Alcohólica", 1000);
        Bebida bebida3 =  new Bebida("Agua", 3, "No Alcohólica", 500);
        Producto[]  productos1 = {plato2, bebida1, bebida2};
        int[] cantidades1 = {1, 2, 2};
        Producto[]  productos2 = {plato1, bebida3, plato4, bebida2};
        int[] cantidades2 = {3, 1, 2, 1};
        Producto[]  productos3 = {plato4, bebida1, bebida3, plato2, plato3};
        int[] cantidades3 = {1, 4, 2, 2, 3};
        Producto[]  productos4 = {plato1, bebida3};
        int[] cantidades4 = {1, 2, 3};

        //Servicio
        Servicio servicio = new Servicio();

        //Métodos
        servicio.sentarse(mesa1, socio1); //Acepta
        servicio.sentarse(mesa1, socio2); //Acepta
        servicio.sentarse(mesa1, cliente1); //Rechaza por falta de capacidad
        servicio.sentarse(mesa2, socio1); //Rechaza debido a que socio1 ya está en una mesa
        servicio.sentarse(mesa2, cliente1); //Acepta

        System.out.println();

        servicio.hacerPedido(socio1, productos3, cantidades3); //Acepta
        servicio.hacerPedido(socio2, productos1, cantidades1); //Acepta
        servicio.hacerPedido(cliente1, productos4, cantidades4); //Rechaza debido a la diferencia entre la cantidad de productos pedidos y la cantidad de "cantidades".
        servicio.hacerPedido(menor1, productos2, cantidades2); //Rechaza por no estar en una mesa

        System.out.println();

        servicio.pagar(mesa1, socio1); //Acepta
        servicio.pagar(mesa1, socio1); //Rechaza debido a que ya pago el pedido
        servicio.pagar(mesa2, socio2); //Rechaza debido a que socio2 no se encuentra en mesa2.

        System.out.println();

        restaurante1.calcular_total();
        System.out.println();
        socio1.mostrar_info();
        System.out.println();
        socio2.mostrar_info();
        System.out.println();
        mesa1.mostrar_info();
        System.out.println();
        mesa2.mostrar_info();
    }
}
