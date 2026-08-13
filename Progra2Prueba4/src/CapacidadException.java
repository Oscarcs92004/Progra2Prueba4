/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oscar
 */
public class CapacidadException extends Exception{
    public CapacidadException(int capacidad){
        super("Capacidad maxima alcanzada "+capacidad +" pedidos.");
    }
}
