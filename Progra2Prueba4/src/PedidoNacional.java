/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oscar
 */
public class PedidoNacional extends Pedido{
    private static final double tarifaBase = 5000;
    private static final double costoPorKm = 100;
    private final double distancia;
    
    public PedidoNacional(int id, String cliente, double monto, double distancia){
        super(id, cliente, monto);
        this.distancia = distancia;
    }
    
    public double getDistancia(){
        return distancia;
    }
    
    @Override
    public double calcularCostoEnvio(){
        return tarifaBase + (costoPorKm*distancia);
    }

    @Override
    public String getTipo(){
        return "NACIONAL";
    }
}
