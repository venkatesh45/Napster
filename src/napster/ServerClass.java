/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napster;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;



public class ServerClass implements ServerInterface,Serializable {
    
    HashMap<String,Integer> registerValue = new HashMap<>();
    int[] matchingPeerID=new int[10];
    @Override
    public void insertToRegistry(int peerID, String filename) throws RemoteException {
         registerValue.put(filename,peerID);
    }

    @Override
    public int peerSearch(String filename) throws RemoteException {
      /*int i=0;
        for (Map.Entry<String, Integer> entry : registerValue.entrySet()){
          if(entry.getKey().equals(filename)){
            matchingPeerID[i]=(int) entry.getValue();
            i++;
        }
      }        
     return matchingPeerID;*/
      if(registerValue.containsKey(filename)){
        return registerValue.get(filename);
    }
      System.out.println("The file does not exist.");
    return 0;
    }
    
}
