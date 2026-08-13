/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oscar
 */
public class PedidoInternacional extends Pedido{
    private static final double tarifaBase = 15000;
    public PedidoInternacional(int id, String cliente, double monto){
        super(id,cliente,monto);
    }
    
    @Override
    public double calcularCostoEnvio(){
        // por mientras
        return 0;
    }
    
    @Override 
    public String getTipo(){
        return "INTERNACIONAL";
    }
    
    @Override 
    public String toString(){
        return "";
    }
}
