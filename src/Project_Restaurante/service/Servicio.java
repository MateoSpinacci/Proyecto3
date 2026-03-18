package Project_Restaurante.service;

import Project_Restaurante.model.Cliente;
import Project_Restaurante.model.Mesa;
import Project_Restaurante.model.Pedido;
import Project_Restaurante.model.Producto;

public class Servicio {

    //MÉTODOS CLIENTE
    public void hacerPedido(Cliente cliente, Producto[] productos, int[] cantidades) {
        if (cliente.getIdMesaSentado() != 0) {
            if (productos.length == cantidades.length) {
                cliente.setPedido(new Pedido(productos, cantidades));
                System.out.println("Pedido realizado");
            } else {
                System.out.println("Ingrese la misma cantidad de productos que de cantidades por favor");
            }
        } else {
            System.out.println("No se encuentra registrado en ninguna mesa, por favor siéntese para pedir");
        }
    }

    public void pagar(Mesa mesa, Cliente cliente) {
        if (cliente.getPedido() != null) {
            if (!cliente.getPedido().getPagado()) {
                if (cliente.getIdMesaSentado() == mesa.getNumero()) {
                    double pago = cliente.getPedido().calcular_total(cliente);
                    System.out.println("El pago es de " + pago);
                    System.out.println("El pedido ha sido pagado");
                    cliente.getPedido().setPagado(true);
                    this.eliminarCliente(mesa, cliente);
                    cliente.setIdMesaSentado(0);
                    mesa.setTotal_mesa(pago);
                } else {
                    System.out.println("Cliente " + cliente.getNombre() + " se encuentra en la mesa número " + cliente.getIdMesaSentado());
                }
            } else {
                System.out.println("El pedido ya ha sido pagado");
            }
        } else {
            System.out.println("No cuentas con un pedido registrado");
        }
    }

    public void sentarse(Mesa mesa, Cliente cliente) {
        if (cliente.getIdMesaSentado() == 0) {
            if (!mesa.getLlena()) {
                System.out.println("La mesa se ha reservado exitosamente");
                this.setCliente(mesa, cliente);
                cliente.setIdMesaSentado(mesa.getNumero());
            } else  {
                System.out.println("La mesa " + mesa.getNumero() + " se encuentra llena en este momento, disculpe las molestias");
            }
        } else {
            System.out.println("Cliente " + cliente.getNombre() + " ya se encuentra registrado en la mesa " + cliente.getIdMesaSentado());
        }
    }

    //MÉTODOS MESA
    private void setCliente(Mesa mesa, Cliente cliente) {
        for (int i = 0; i < mesa.getClientes().length; i++) {
            if (mesa.getClientes()[i] == null) {
                mesa.getClientes()[i] = cliente;
                if (mesa.getCapacidad() == i + 1) {
                    mesa.setLlena(true);
                }
                break;
            }
        }
    }

    private void eliminarCliente(Mesa mesa, Cliente cliente) {
        for (int i = 0; i < mesa.getClientes().length; i++) {
            if (mesa.getClientes()[i] == cliente) {
                mesa.getClientes()[i] = null;
                if (mesa.getCapacidad() == i) {
                    mesa.setLlena(false);
                }
                break;
            }
        }
    }
}
