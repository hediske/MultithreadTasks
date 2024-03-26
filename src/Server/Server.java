package Server;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
public class Server {

    public static void main(String[] args) {
        System.out.println("creating the server");
        try{
            tasksCRUDImpl Tasks = new tasksCRUDImpl();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("tasks", Tasks);
            System.out.println("Server Launched successfully on port 1099");
        }
        catch(Exception exception){
            System.out.println("error launching the server");
            exception.printStackTrace();
        }

    }
    
}