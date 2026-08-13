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
    
    public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("----- Gestion de Pedido -----");
        System.out.println("----- Ingrese la capacida maxima de pedidos -----");
        int capacidad = sc.nextInt();
    }
}
