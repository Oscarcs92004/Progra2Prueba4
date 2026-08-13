/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oscar
 */
public class TransicionEstadoException extends Exception{
    public TransicionEstadoException(EstadoPedido actual, EstadoPedido nuevo){
        super("No se puede pasar de "+actual + " a " + nuevo + "(estado actual final: " + actual.getEsFinal() );
    }
}
