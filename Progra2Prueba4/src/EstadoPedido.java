/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oscar
 */
public enum EstadoPedido {
    PENDIENTE("Pedido registrado, esperando procesamiento", false, 1),
    PROCESANDO("Pedido siendo preparado", false, 2),
    ENVIADO("Pedido en camino al cliente", false, 3),
    ENTREGADO("Pedido entregado al cliente",true,0),
    CANCELADO("Pedido cancelado", true, 0);
    
    private final String descripcion;
    private final boolean esFinal;
    private final int diasEstimados;
    
    EstadoPedido(String descripcion, boolean esFinal, int diasEstimados){
        this.descripcion = descripcion;
        this.esFinal = esFinal;
        this.diasEstimados = diasEstimados;
    }
    
    public boolean getEsFinal(){
        return esFinal;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public int getDiasEstimados(){
        return diasEstimados;
    }
    
    public boolean transicionarA(EstadoPedido nuevoEstado){
        if(this.esFinal){
            return false;
        }
        boolean valido = false;
        switch(this){
            case PENDIENTE:
                if(nuevoEstado == PROCESANDO || nuevoEstado.CANCELADO == CANCELADO){
                    valido = true;                
                }
                break;
            case PROCESANDO:
                if(nuevoEstado == ENVIADO || nuevoEstado.CANCELADO == CANCELADO){
                    valido = true;                
                }
                break;    
            case ENVIADO:
                if(nuevoEstado == ENTREGADO){
                    valido = true;
                }
                break;   
            default:
                valido = false;
                break;
        }
        return valido;
    }   
}
