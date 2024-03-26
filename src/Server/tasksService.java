package Server;

import java.util.concurrent.PriorityBlockingQueue;
public class tasksService {

    private TaskExecutor taskExecutor;

    private PriorityBlockingQueue<ITask> ListQueue = new PriorityBlockingQueue<>(150);
// l'utilité de priority blocking queue est qu elle est Thread-save c'est a dire pas d'exception quand la file est vide  !
    
        
    public tasksService(){
        this.taskExecutor = new TaskExecutor(ListQueue);
    }

    public String addToList(ITask task){
        this.ListQueue.add(task);
        return "added new task with id "+task.getId()+" to the list";
    }
    public String addToTopOfList(ITask task){
        task.setPriority(Long.MIN_VALUE);
        this.ListQueue.add(task);
        return "added new task with id "+task.getId()+" to top of the list";
    }
    public String removeFromList() throws InterruptedException{
        this.ListQueue.remove();
        return("successfully removed the head of the Task List ✅");
    }
    public String removeFromList(ITask task) throws InterruptedException{
        boolean result = this.ListQueue.remove(task);
        if(result) {
            return("Task removed successfully ✅");
        }
        return("Task not found in the list  ❎");    
    }
    public String showList(){
        PriorityBlockingQueue<ITask> ListCopy =  new PriorityBlockingQueue<>(ListQueue);
        StringBuilder sb = new StringBuilder();
        while(!ListCopy.isEmpty())
            {
                sb.append(ListCopy.poll().toString());
                sb.append("\n");
            }
        return sb.toString();
    }
    public boolean findList(ITask task){
        return ListQueue.contains(task);
    }
    public ITask FindTaskById(int id){
        PriorityBlockingQueue<ITask> ListCopy =  new PriorityBlockingQueue<>(ListQueue);
        ITask elem;
        while(!ListCopy.isEmpty())
           { elem = ListCopy.poll();
                if(elem.getId()==id) 
                    return elem;
           }
        return null;
    } 

    public void lauchWorkers(){
        this.taskExecutor.LaunchExecutor();
    }
}
