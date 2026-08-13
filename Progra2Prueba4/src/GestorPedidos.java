/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oscar
 */
public class GestorPedidos {
    private final Pedido pedidos[];
    private int cantidad;
    
    public GestorPedidos(int size){
        pedidos = new Pedido[size];
        cantidad = 0;
    }
    
    public void agregarPedido(Pedido dato) throws CapacidadException {
        if(cantidad == pedidos.length){
            throw new CapacidadException(pedidos.length);
        }
        pedidos[cantidad] = dato;
        cantidad++;
    }
    
    public Pedido buscarPorId(int id) throws PedidoNoEncontradoException {
        for(int i = 0; i < pedidos.length;i++){
            if(pedidos[i].getId() == id){
                return pedidos[i];
            }
        }
        throw new PedidoNoEncontradoException(id);
    }
    
    public void cambiarEstado(int id, EstadoPedido nuevoEstado) throws PedidoNoEncontradoException, TransicionEstadoException{
        Pedido pedido = buscarPorId(id);
        if(!pedido.getEstado().transicionarA(nuevoEstado)){
            throw new TransicionEstadoException(pedido.getEstado(), nuevoEstado);
        }
        pedido.setEstado(nuevoEstado);
    }
    
    public Pedido[] listadoPorEstado(EstadoPedido estado){
        Pedido[] p = new Pedido[pedidos.length];
        int contador = 0;
        for(int i = 0; i < pedidos.length;i++){
            if(pedidos[i].getEstado() == estado){
                p[contador] = pedidos[i];
                contador++;
            }
        }
        return p;
    }
    
}
