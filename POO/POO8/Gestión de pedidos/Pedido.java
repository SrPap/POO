import java.util.Arrays;

public class Pedido {
    private int numeroDePedido;
    private String cliente;
    private String[] listaDeProductos;
    private EstadoPedido estadoDelPedido;

    public Pedido() {
    }
    public Pedido(int numeroDePedido, String cliente, String[] listaDeProductos) {
        this.numeroDePedido = numeroDePedido;
        this.cliente = cliente;
        this.listaDeProductos = listaDeProductos;
        this.estadoDelPedido = EstadoPedido.PENDIENTE;
    }

    public int getNumeroDePedido() {
        return numeroDePedido;
    }
    public String getCliente() {
        return cliente;
    }
    public String[] getListaDeProductos() {
        return listaDeProductos;
    }
    public EstadoPedido getEstadoDelPedido() {
        return estadoDelPedido;
    }
    public void setEstadoDelPedido(EstadoPedido estadoDelPedido) {
        this.estadoDelPedido = estadoDelPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "numeroDePedido=" + numeroDePedido +
                ", cliente='" + cliente + '\'' +
                ", listaDeProductos=" + Arrays.toString(listaDeProductos) +
                ", estadoDelPedido=" + estadoDelPedido +
                '}';
    }
}
