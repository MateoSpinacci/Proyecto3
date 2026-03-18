package Project_Restaurante.model;

public class Cliente {
    private final String nombre;
    private final int id;
    private static int numSiguiente = 1;
    private Pedido pedido;
    private int idMesaSentado = 0;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.id = numSiguiente++;
    }

    public void mostrar_info() {
        System.out.println("Nombre: " + this.nombre + "\nID:" + this.id);
        if (idMesaSentado == 0) {
            System.out.println("No tiene mesa asignada");
        } else {
            System.out.println("Se encuentra en la mesa número " + idMesaSentado);
        }
        if (pedido != null) {
            pedido.mostrar_info();
        }
    }

    public int getIdMesaSentado() {
        return idMesaSentado;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String getNombre() {
        return nombre;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setIdMesaSentado(int  idMesaSentado) {
        this.idMesaSentado = idMesaSentado;
    }
}
