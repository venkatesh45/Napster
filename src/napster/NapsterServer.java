/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napster;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class NapsterServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Registry registry = null;
        
            try {
                int port = 33333;
                registry = LocateRegistry.createRegistry(port);
                System.out.println("Successfully Created Index Server!"); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        
        try {
             ServerInterface si=(ServerInterface)new ServerClass();
            registry.rebind("IndexServer", si); 
            System.out.println("Indexing server start!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
           Thread.sleep(3000000);
       } catch (InterruptedException e) {
           
           e.printStackTrace();
       }
    }
    
}
