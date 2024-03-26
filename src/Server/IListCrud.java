package Server;
import java.rmi.RemoteException;
import java.rmi.Remote;

public interface IListCrud extends Remote {
    public String addToList(ITask task) throws RemoteException;
    public String addToTopOfList(ITask task) throws RemoteException;
    public String removeFromList(ITask task) throws RemoteException;
    public String removeFromList(int id) throws RemoteException;
    public String showList() throws RemoteException;
    public ITask createTask(String... data) throws RemoteException;
    
}