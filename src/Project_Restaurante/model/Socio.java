package Project_Restaurante.model;

public class Socio extends Cliente implements TieneDescuento{
    private int idSocio;

    public Socio(String nombre, int idSocio) {
        super(nombre);
        this.idSocio = idSocio;
    }

    public double calcular_descuento(double total){
        total = total * 0.8;
        return total;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }
}
