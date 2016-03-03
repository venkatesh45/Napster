/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napster;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Hashtable;




public class ServerClass implements ServerInterface,Serializable {
    
    Hashtable<String,Integer> registerValue = new Hashtable<>();
    int[] matchingPeerID=new int[10];
    @Override
    public void insertToRegistry(int peerID, String filename) throws RemoteException {
        registerValue.put(filename,peerID);
    }

    @Override
    public int peerSearch(String filename) throws RemoteException {
        
        if(registerValue.containsKey(filename)){
            return registerValue.get(filename);
        }
        else 
            return 0;
    } 
}
