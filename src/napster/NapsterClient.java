
package napster;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;


public class NapsterClient {
    static int ID=1;
        public static void main(String[] args) {

            NapsterClient np=new NapsterClient();
        try {

            String hostName="localhost";
            int port=33333;
            Registry registry=LocateRegistry.getRegistry(hostName,port);
            ServerInterface Si=(ServerInterface)registry.lookup("IndexServer");
            System.out.println("Successfully Connected");
            np.loadIntoRegisterMethod(Si,"C:\\Users\\venka\\OneDrive\\Documents\\My Web Sites\\sortwithoutajax");
            System.out.println("Enter the word you would like to search\n");
            Scanner sc=new Scanner(System.in);
            String fileToSearch=sc.next();
            int found=Si.peerSearch(fileToSearch);
            if(found==0){
                System.out.print("File Not Found");
            }else{
                System.out.println("File Found");
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void loadIntoRegisterMethod(ServerInterface Si, String arg) throws RemoteException {
       File folder = new File(arg);
       File[] listOfFiles = folder.listFiles();

    for (int i = 0; i < listOfFiles.length; i++) {
      if (listOfFiles[i].isFile()) {
          System.out.println(listOfFiles[i]);
        Si.insertToRegistry(ID, listOfFiles[i].getName());
      } 
    }
       
   }
    
}
