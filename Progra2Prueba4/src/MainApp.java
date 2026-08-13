/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author oscar
 */
public class MainApp {
    private static GestorPedidos gestor;
    private static int id = 1;
    private static void mostrarMenu(){
        System.out.println("\n----- Menu -----");
        System.out.println("1. Agregar pedido nacional");
        System.out.println("2. Agregar pedido internacional");
        System.out.println("3. Buscar pedido por id");
        System.out.println("4. Cambiar estado de un pedido");
        System.out.println("5. Listar pedidos por estado");
        System.out.println("6. Salir");
        System.out.println("Ingrese una opcion: ");
    }
    
    public static void agregarPedidoNacional(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Cliente: ");
        String cliente = sc.nextLine();
        System.out.println("Monto: ");
        double monto = sc.nextDouble();
        System.out.println("Ditancia en km: ");
        double distancia = sc.nextDouble();
        Pedido pedido = new PedidoNacional(id, cliente, monto, distancia);
        try {
            gestor.agregarPedido(pedido);
            System.out.println("Pedido agregado: " + pedido);
            id++;
        } catch (CapacidadException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void agregarPedidoInternacional(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Cliente: ");
        String cliente = sc.nextLine();
        System.out.println("Monto: ");
        double monto = sc.nextDouble();
        System.out.println("Costo Aduana: ");
        double costoAduana = sc.nextDouble();
        sc.nextLine();
        System.out.println("Pais destino: ");
        String paisDestino = sc.nextLine();
        
        Pedido pedido = new PedidoInternacional(id, cliente, monto, costoAduana, paisDestino);
        try {
            gestor.agregarPedido(pedido);
            System.out.println("Pedido agregado: " + pedido);
            id++;
        } catch (CapacidadException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void buscarPedido(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el id a buscar: ");
        int id = sc.nextInt();
        
        try {
            Pedido pedido = gestor.buscarPorId(id);
            System.out.println("Encontrado: " + pedido);
        } catch(PedidoNoEncontradoException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void cambiarEstadoPedido(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el id del pedido: ");
        int id = sc.nextInt();
        System.out.println("A que estado desea cambiar el pedido? 1. Pendiente 2. Procesando 3. Enviado 4. Entregado 5. Cancelado");
        int opcion = sc.nextInt();
        EstadoPedido nuevoEstado = null;
        switch(opcion){
            case 1:
                nuevoEstado = EstadoPedido.PROCESANDO;
                break;
            case 2:
                nuevoEstado = EstadoPedido.PENDIENTE;
                break;
            case 3:
                nuevoEstado = EstadoPedido.ENVIADO;
                break;
            case 4:
                nuevoEstado = EstadoPedido.ENTREGADO;
                break;
            case 5:
                nuevoEstado = EstadoPedido.CANCELADO;
                break;
            default:
                System.out.println("Ingreso una opcion que no es valida. ");
        }
        
        if(nuevoEstado == null){
            return;
        } 
        
        try {
            gestor.cambiarEstado(id, nuevoEstado);
            System.out.println("Estado actualizado correctamente.");
        } catch (PedidoNoEncontradoException | TransicionEstadoException e){
            System.out.println("Error: " + e.getMessage());
        }
        
    }
    
    private static void listarPorEstado(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el estado que desea listar. 1. Pendiente 2. Procesando 3. Enviado 4. Entregado 5. Cancelado");
        int opcion = sc.nextInt();
        EstadoPedido estado = null;
        switch(opcion){
            case 1:
                estado = EstadoPedido.PROCESANDO;
                break;
            case 2:
                estado = EstadoPedido.PENDIENTE;
                break;
            case 3:
                estado = EstadoPedido.ENVIADO;
                break;
            case 4:
                estado = EstadoPedido.ENTREGADO;
                break;
            case 5:
                estado = EstadoPedido.CANCELADO;
                break;
            default:
                System.out.println("Ingreso una opcion que no es valida. ");
        }
        
        if(estado == null){
            return;
        }
        
        Pedido[] resultado = gestor.listadoPorEstado(estado);
        if (resultado.length == 0) {
            System.out.println("No hay pedidos en estado " + estado + ".");
        } else {
            for (Pedido p : resultado) {
                System.out.println(p);
            }
        }
        
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("----- Gestion de Pedido -----");
        System.out.println("----- Ingrese la capacida maxima de pedidos -----");
        int capacidad = sc.nextInt();
        gestor = new GestorPedidos(capacidad);
        int opcion;
        do{
            mostrarMenu();
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    agregarPedidoNacional();
                    break;
                case 2:
                    agregarPedidoInternacional();
                    break;
                case 3:
                    buscarPedido();
                    break;
                case 4:
                    cambiarEstadoPedido();
                    break;
                case 5:
                    listarPorEstado();
                    break;
                case 6:
                    System.out.println("Gracias por usar el programa. ");
                    break;
                default:
                    System.out.println("Opcion invalida.");
                    break;
            }
        }while(opcion != 6);
    }
}
