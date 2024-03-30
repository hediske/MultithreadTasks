
## Tasks Manager


This project is a java RMI application allowing the Java Clients to
    <ul>
        <li>    Adding a new Task to the Pool and Setting its priority in a BlockingPriorityQueue for thread-Safety .</li>
        <li>    Removing a Task from the Pool before its execution .
        <li>    Show all the remaining tasks before their termination .
        <li>    Executing the tasks using 16 workers threads .
        <li>    Creation of a new worker thread when a thread is interrupted or is down .
        <li>    Concurrency management of multiple clients at once .
    </ul> 

    
    
> At the beginning , when launching the client a prompt giving multiple options will be shown:<br>
   1  : Add a new task   
   2  : Remove a task  
   3  : Show all tasks  
   4  : Enable/disable tasks execution<br> 
   "#": Exit

<h2> How to run it </h2>
    
    cd src && javac Server/*.java Client/*.java
    java Server.Server
    java Client.client

<h2>
Prerequities
</h2>
Java JDK



