/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oscar
 */
public class PedidoNoEncontradoException extends Exception{
    public PedidoNoEncontradoException(int id){
        super("No existe un pedido con id: " +id);
    }
}
