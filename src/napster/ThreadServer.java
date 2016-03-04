/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napster;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author venka
 */
class ThreadServer implements Runnable {
    
    
    @Override
    public void run() {
        Registry registry = null;
        
            try {
                int portNumber=Integer.parseInt(Thread.currentThread().getName());
                registry = LocateRegistry.createRegistry(portNumber);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        
        try {
             ClientInterface ci=(ClientInterface)new ClientClass();
            registry.rebind("Server", ci); 
            //System.out.println("Server started ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
           Thread.sleep(3000000);
       } catch (InterruptedException e) {
           
           e.printStackTrace();
       }
    }
    
    public static void main(String[] args){
        ThreadServer ts=new ThreadServer();
        
        ts.run();
    }
    
}
