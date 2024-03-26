package Server;
import java.io.Serializable;
import java.rmi.*;
public abstract class ITask implements Comparable<ITask>, Remote , Serializable{
    private int id ; 
    private Object content ; 
    private long priority;


    public void setContent(Object content) {
        this.content = content;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setPriority(long priority) {
        this.priority = priority;
    }
    public Object getContent() {
        return content;
    }
    public int getId() {
        return id;
    }
    public long getPriority() {
        return priority;
    }

    public ITask(int id , Object content , Long priority){
        this.id = id;
        this.content=content;
        this.priority=priority;
    }

    @Override
    public int compareTo(ITask o) {
        if(this.priority==Long.MIN_VALUE)  
            return 1;
        if(this.priority<o.priority)
            return -1;
        else if(this.priority>o.priority)
            return 1;
        else 
            {
                if(this.id>=o.priority)
                    return 1;
                return -1;
            }


    }

    public abstract void processTask();

}