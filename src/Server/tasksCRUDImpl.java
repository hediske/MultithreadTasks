package Server;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
public class tasksCRUDImpl extends UnicastRemoteObject implements IListCrud {

    int initial = 0;
    protected tasksCRUDImpl() throws RemoteException {
        super();

    }

    private tasksService tasksservice = new tasksService();

    @Override
    public String addToList(ITask task) throws RemoteException {
        return tasksservice.addToList(task);
    }

    @Override
    public String removeFromList(ITask task) throws RemoteException {
        try
            {
                return tasksservice.removeFromList(task);
            }
        catch(InterruptedException e){
            return ("Error deleting the task");
        }
    }

    @Override
    public String showList() {
        return tasksservice.showList();
    }

    @Override
    public String addToTopOfList(ITask task) throws RemoteException{
        return (tasksservice.addToTopOfList(task));
    }

    
    public ITask createTask(String... data) throws RemoteException {
        if (data.length < 3) {
            throw new IllegalArgumentException("Insufficient data provided to create task.");
        }
        return new TaskImpl(Integer.parseInt(data[0]),data[1],Long.parseLong(data[2]));
    }

    
    @Override
    public String removeFromList(int id) throws RemoteException {
        try
            {
                ITask task = tasksservice.FindTaskById(id);
                if(task!=null)
                    return tasksservice.removeFromList(task);
                return("Task not found in the list");
            }
        catch(InterruptedException e){
            return("Error deleting the task");
        }
    }
 
    
    public String enableDisableTasksExecution() throws RemoteException{

        if(initial==0){
            this.tasksservice.lauchWorkers();
            initial++;
            return "Started the execution of the tasks";
        }
        else{
            this.tasksservice.shutdown();
            initial--;
            return "Stopped the execution of the tasks";
        }
         // this is a test for the task execution using a fixedthreadpool , executors API and Executor workers 
         // however when one worker is down a new one will spawn at its old  place !! 
    }
}
