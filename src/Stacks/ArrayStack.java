package Stacks;

import Lists.ArrayLists.Employee;

import java.util.EmptyStackException;

public class ArrayStack {

    /* array for stack */
    private Employee[] stack;
    /* index for keeping track of top of stack */
    private int top;

    public ArrayStack(int capacity)
    {
        stack = new Employee[capacity];
    }

    public void push(Employee employee) {
        /* if top == stack.length then stack is full */
        if (top == stack.length) {
            /* need to resize the backing array */
            Employee[] newArray = new Employee[2 * stack.length];
            /* now we need to copy all the current elements into
               new and bigger array */
            System.arraycopy(stack, 0, newArray, 0, stack.length);
            stack = newArray;
        }
        /* we're now positive that our array is not out of bounds */
        stack[top++] = employee;
    }

    /* pop employee off stack and return it */
    public Employee pop() {
        if(isEmpty())
        {
            /* throw exception */
            throw new EmptyStackException();
        }
        /* stack isn't empty */
        Employee employee = stack[--top];
        /* null out the popped employee */
        stack[top] = null;
        /* return popped employee */
        return employee;
    }

    public int size() {
        return top;
    }

    public Employee peek() {
        if(isEmpty())
        {
            /* throw exception */
            throw new EmptyStackException();
        }
        return stack[top - 1];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void printStack() {
        for(int i = top - 1; i >= 0; i--)
        {
            System.out.println(stack[i]);
        }
    }
}
