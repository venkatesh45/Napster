/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napster;

import java.io.File;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author venka
 */
class ThreadClient implements Runnable {
    public static int ID;
    Scanner sc;
    
    
    
    @Override
    public void run() {
       String hostName="localhost";
       int port=33333;
       String Directory=null;
       Registry registry = null;
       ServerInterface Si=null;
       String fileToSearch;
       int found=0;
       try {
            registry = LocateRegistry.getRegistry(hostName,port);
        } catch (RemoteException ex) {
            Logger.getLogger(ThreadClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Si=(ServerInterface)registry.lookup("IndexServer");
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(ThreadClient.class.getName()).log(Level.SEVERE, null, ex);
        }
       System.out.println("Successfully Connected");
       
       sc=new Scanner(System.in);
       System.out.println("Enter PeerID(except zero):");
       ID=sc.nextInt();
        switch (ID) {
            case 1:
                Directory="FileOne\\";
                break;
            case 2:
                Directory="FileTwo\\";
                break;
            case 3:
                Directory="FileThree\\";
                break;
            default:
                System.exit(-1);
        }
       try {
            loadIntoRegisterMethod(Si,Directory);
        } catch (RemoteException ex) {
            Logger.getLogger(ThreadClient.class.getName()).log(Level.SEVERE, null, ex);
        }
       System.out.println("Enter the File name to search");
       fileToSearch=sc.next();
        try {
            found=Si.peerSearch(fileToSearch);
        } catch (RemoteException ex) {
            Logger.getLogger(ThreadClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (found==0){
            System.out.println("File Not Found");
            System.exit(-1);
        }else{
            System.out.println("File:"+fileToSearch+" found on Peer Number:"+found);
          }
        
    }
    
    public static void main(String[] args){
       ThreadClient tc;
       tc=new ThreadClient();
       tc.run();
       System.out.println("Enter a peerID to get file:");
       Scanner sc=new Scanner(System.in);
       int peertoconnect=sc.nextInt();
       
    }
    public static void loadIntoRegisterMethod(ServerInterface Si, String arg) throws RemoteException {
       File folder = new File(arg);
       File[] listOfFiles = folder.listFiles();

        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                Si.insertToRegistry(ID, listOfFile.getName());
            }
        }
       
   }

    
    
}
