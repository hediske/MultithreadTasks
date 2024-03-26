package Server;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ExecutorService;

public class WorkerThread implements Runnable {
    private ExecutorService executorService;
    private String number;
    private PriorityBlockingQueue<ITask> TaskList;
    public WorkerThread(String name , PriorityBlockingQueue<ITask> TaskList , ExecutorService executorService){
        this.number=name;
        this.TaskList = TaskList;
        this.executorService= executorService;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Starting worker thread number  "+this.number);
        while (true) {
            try{
                
                ITask Task = null;
                Task =  TaskList.poll();
                if(Task==null){
                    Thread.sleep(1000);

                }
                else{
                    processCommand(Task);
                    System.out.println(Thread.currentThread().getName()+" End.");
                }
                
            }
            catch(Exception e ){
                System.out.println("Exception occurred in worker thread " + this.number + ": " + e.getMessage());
                executorService.execute(new WorkerThread(number,TaskList,executorService));
                return;
            }
        }
    }

    private void processCommand(ITask task) {
        try {
            task.processTask();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return this.number;
    }
}