package Stacks;

import Lists.ArrayLists.Employee;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedStack {

    /* We're going to use the JDK Linked List class to
       back our stack for this class.
     */
    private final LinkedList<Employee> stack;

    public LinkedStack()
    {
        /* JDK Linked List is doubly linked list */
        stack = new LinkedList<Employee>();
    }

    public void push(Employee employee)
    {
        stack.push(employee);
    }

    public Employee pop()
    {
        return stack.pop();
    }

    public Employee peek()
    {
        return stack.peek();
    }

    public boolean isEmpty()
    {
        return stack.isEmpty();
    }

    public void printStack() {
        ListIterator<Employee> it = stack.listIterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
    }
}
