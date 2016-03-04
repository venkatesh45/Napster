/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napster;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author venka
 */
public interface ServerInterface extends Remote{
    void insertToRegistry(int peerID, String filename) throws RemoteException;
    ArrayList<Integer> peerSearch (String filename) throws RemoteException;
    void insertPortNumber(int peerID,int port)throws RemoteException;
    int returnPortNumber(int peerID) throws RemoteException;
}
