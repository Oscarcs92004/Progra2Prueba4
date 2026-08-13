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
    
    public void buscarPedido(Pedido dato) throws PedidoNoEncontradoException {
        
    }
}
