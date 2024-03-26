package Server;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class TaskExecutor {
    private final ExecutorService executor = Executors.newFixedThreadPool(16);
    private PriorityBlockingQueue<ITask> taskList;
    protected TaskExecutor(PriorityBlockingQueue<ITask> taskList) {
        this.taskList = taskList;
    }

    public void LaunchExecutor(){
        for (int i = 0; i < 16; i++) {
            executor.execute(new WorkerThread("TaskExecutor-" + i, taskList , executor));
        }
    }

    public void executeTask(ITask task) {
        executor.execute(task::processTask);
    }

    public void shutdown() {
        executor.shutdown();
    }
}
