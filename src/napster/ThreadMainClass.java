/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napster;

/**
 *
 * @author venka
 */
import java.lang.Exception;
        
public class ThreadMainClass {
    public static void main(String[] args){
       
        String HostNumber;
        HostNumber = "8087";
        ThreadClient tc=new ThreadClient();
        ThreadServer ts=new ThreadServer();
        
        Thread t1=new Thread(tc,HostNumber);
        Thread t2=new Thread(ts,HostNumber);
        t1.start();
        t2.start();
       
       
             
    }
}
