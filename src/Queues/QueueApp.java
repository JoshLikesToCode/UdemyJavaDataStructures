package Queues;

import Lists.ArrayLists.Employee;

public class QueueApp {
    public static void main(String[] args) {
        Employee joshStone = new Employee("Josh", "Stone", 123);
        Employee mollyStone = new Employee("Molly", "Stone", 456);
        Employee steveHorner = new Employee("Steve", "Horner", 789);
        Employee jaredAdkins = new Employee("Jared", "Adkins", 101112);

        //ArrQueue queue = new ArrQueue(10);
        CircularQueue queue = new CircularQueue(10);
        queue.add(joshStone);
        queue.add(mollyStone);
        queue.add(steveHorner);
        queue.add(jaredAdkins);
        queue.printQueue();

        queue.remove();
        queue.remove();
        //queue.printQueue();

        //System.out.println(queue.peek());
        //queue.printQueue();
        queue.remove();
        queue.remove();
        /* empty print b/c queue is now empty */
        queue.printQueue();
        /* should throw an exception */
        //queue.remove();
        queue.add(mollyStone);
        queue.printQueue();


    }
}
