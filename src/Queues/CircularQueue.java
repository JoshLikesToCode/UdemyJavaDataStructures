package Queues;

import Lists.ArrayLists.Employee;

import java.util.NoSuchElementException;

public class CircularQueue {
    /* array to back our queue */
    private Employee[] queue;
    private int front;
    private int back;

    public CircularQueue(int capacity)
    {
        queue = new Employee[capacity];
    }

    public void add(Employee employee)
    {
        /* we use size() here instead of back */
        if(size() == queue.length)
        {
            /* we will need the current size later */
            int numItems = size();
            /* we need to increase backing array capacity */
            Employee[] newArr = new Employee[2 * queue.length];
            /* when we copy the array we have to "unwrap" the queue and reseting the front back to zero */
            System.arraycopy(queue, front, newArr, 0, queue.length - front);
            System.arraycopy(queue, 0, newArr, queue.length - front, back);
            queue = newArr;

            /* we need to reset front and back here */
            front = 0;
            back = numItems;
            // what "unwrapping" the queue looks like:
        /*
            before unwrapping and copying:
            0 jane
            1 john
            2 -     <-- back
            3 mike  <-- front
            4 bill

            after unwrapping and copying the arr it now looks like:
            0 mike  <-- front
            1 bill
            2 jane
            3 john
            4       <-- back
         */
        }

        queue[back] = employee;
        if(back < queue.length - 1)
        {
            back++;
        }
        else
        {
            back = 0;
        }

    }

    /* subtracting front from back will give us the # of items
       in the queue.
    */
    public int size()
    {
        /* we need to check if queue has wrapped */
        if(front <= back)
        {
            return back - front;
        }
        else
        {
            return back - front + queue.length;
        }
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
        } /* we have to check for a wrap around when removing in a circular queue */
        else if(front == queue.length)
        {
            front = 0;
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

    public void printQueue() {
        if (front <= back)
        {
            for (int i = front; i < back; i++)
            {
                System.out.println(queue[i]);
            }
        }
        else
        {
            for(int i = front; i < queue.length; i++)
            {
                System.out.println(queue[i]);
            }
            /* remaining */
            for(int i= 0; i < back; i++)
            {
                System.out.println(queue[i]);
            }
        }
    }
}
