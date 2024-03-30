package Client;

import Server.IListCrud;
import Server.ITask;

import java.rmi.Naming;
import java.util.Scanner;
public class client {

    public static void main(String[] args) {
        try{
            System.out.println("creating the client");
            IListCrud mediator = (IListCrud) Naming.lookup("rmi://localhost:1099/tasks");
            boucleclient : while (true)
            {
                Scanner scanner  = new Scanner(System.in);
                System.out.println("What do you want to do ? ");
                System.out.println("1 : add a new task   \n2 : Remove a task  \n3  : Show all tasks  \n4  : enable/disable tasks execution  : ");
                System.out.println("#  : exit");
                char choice =scanner.nextLine().charAt(0);
                if (choice=='#')
                    {
                        System.out.println("exiting the program ");
                        break boucleclient;
                    }
                switch (choice) {
                    case '1'-> {
                        System.out.println("id : ");
                        String id =scanner.nextLine();
                        System.out.println("content  :  ");
                        String content = scanner.nextLine();
                        System.out.println("priority :  ");
                        String priority = scanner.nextLine();
                        ITask task = mediator.createTask(id,content,priority);
                        String log = mediator.addToList(task);
                        System.out.println(log);
                    }
                    case '2' -> {
                        System.out.println("id : ");
                        String id =scanner.nextLine();
                        String log = mediator.removeFromList(Integer.parseInt(id));
                        System.out.println(log);
                    }
                    
                    case '3' ->System.out.println(mediator.showList());
                    default->
                        System.out.println("please choose a valid option");
                    case '4' -> System.out.println(mediator.enableDisableTasksExecution());

                }
            }
            
            
        }catch(Exception e ){
            System.out.println( "Error connecting to server ");
            e.printStackTrace();
        }
    }
}
    