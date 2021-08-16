package Queues;

import Lists.ArrayLists.Employee;

import java.util.NoSuchElementException;

public class ArrQueue {
    /* array to back our queue */
    private Employee[] queue;
    private int front;
    private int back;

    public ArrQueue(int capacity)
    {
        queue = new Employee[capacity];
    }

    public void add(Employee employee)
    {
        if(back == queue.length)
        {
            /* we need to increase backing array capacity */
            Employee[] newArr = new Employee[2 * queue.length];
            System.arraycopy(queue, 0, newArr, 0, queue.length);
        }
        queue[back] = employee;
        /* back always points to the next available position in the queue */
        back++;
    }

    /* subtracting front from back will give us the # of items
       in the queue.
    */
    public int size()
    {
        return back - front;
    }

    public Employee remove()
    {
        /* We don't want to remove something from an empty queue */
        if(size() == 0)
        {
            throw new NoSuchElementException();
        }
        /* if the queue is not empty, proceed */
        Employee employee = queue[front];
        queue[front] = null;
        front++;
        /* if the queue is now empty we need to reset front and back positions */
        if(size() == 0)
        {
            front = 0;
            back = 0;
        }
        return employee;
    }

    public Employee peek()
    {
        /* We don't want to peek something from an empty queue */
        if(size() == 0)
        {
            throw new NoSuchElementException();
        }
        /* just return the employee in front of the queue */
        return queue[front];
    }

    public void printQueue()
    {
        for(int i = front; i < back; i++)
        {
            System.out.println(queue[i]);
        }
    }
}
