/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napster;

import java.io.Serializable;
import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.HashMap;





public class ServerClass extends UnicastRemoteObject implements ServerInterface {
    
    ArrayList<Integer> PeerID=new ArrayList<>();
    ArrayList<String> Filename=new ArrayList<>();
    ArrayList<Integer> MatchingFilename=new ArrayList<>();
    HashMap<Integer,Integer> portNumber=new HashMap<>();
    
    ServerClass() throws RemoteException{
    super();
    }

    @Override
    public synchronized void insertToRegistry(int peerID, String filename) throws RemoteException {
        PeerID.add(peerID);
        Filename.add(filename);
    }

    @Override
    public synchronized ArrayList<Integer> peerSearch(String filename) throws RemoteException {
        int j=0;
        for(int i=0;i<PeerID.size();i++){
        if(Filename.get(i).equals(filename)){
            MatchingFilename.add(j, PeerID.get(i));
            j++;
        }
        
    }
    return MatchingFilename;    
    } 

    @Override
    public synchronized void insertPortNumber(int peerID,int port) throws RemoteException {
            portNumber.put(peerID, port);
    }

    @Override
    public synchronized int returnPortNumber(int peerID) throws RemoteException {
            if(portNumber.containsKey(peerID)){
                return portNumber.get(peerID);
            }
            return 0;
    }
}
