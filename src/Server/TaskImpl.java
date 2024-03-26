package Server;

public class TaskImpl extends ITask {
   
    public TaskImpl(int id, Object content, Long priority) {
        super(id, content, priority);
    }

    @Override
    public String toString(){
        return "id  :  "+this.getId()+" - Content  :  "+this.getContent() + "priority  :  "+this.getPriority();
    }
    @Override
    public void processTask() { 
        System.out.println("Executing task ");
        System.out.println(this.getContent());
    }
}
