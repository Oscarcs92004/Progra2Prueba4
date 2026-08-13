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
    private final double costoAduana;
    private final String paisDestino;
    
    public PedidoInternacional(int id, String cliente, double monto, double costoAduana, String paisDestino){
        super(id,cliente,monto);
        this.costoAduana = costoAduana;
        this.paisDestino = paisDestino;
    }
    
    public double getCostoAduana(){
        return costoAduana;
    }
    
    public String getPaisDestino(){
        return paisDestino;
    }
    
    @Override
    public double calcularCostoEnvio(){
        return tarifaBase+costoAduana;
    }
    
    @Override 
    public String getTipo(){
        return "INTERNACIONAL - " + paisDestino;
    }
    
    @Override 
    public String toString(){
        return super.toString() + " [ Destino: " + paisDestino + "]";
    }
}
