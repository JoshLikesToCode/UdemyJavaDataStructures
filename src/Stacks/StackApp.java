package Stacks;

import Lists.ArrayLists.Employee;

public class StackApp {

    public static void main(String[] args) {
        Employee joshStone = new Employee("Josh", "Stone", 123);
        Employee mollyStone = new Employee("Molly", "Stone", 456);
        Employee steveHorner = new Employee("Steve", "Horner", 789);
        Employee jaredAdkins = new Employee("Jared", "Adkins", 101112);

        /* ARRAY STACK */
//        ArrayStack stack = new ArrayStack(10);
//        stack.push(joshStone);
//        stack.push(mollyStone);
//        stack.push(steveHorner);
//        stack.push(jaredAdkins);
//        stack.printStack();
//        System.out.println(stack.size());
//        System.out.println(stack.peek());
//        stack.pop();
//        System.out.println(stack.peek());
//        System.out.println(stack.size());
//        stack.pop();
//        stack.pop();
//        System.out.println(stack.isEmpty());
//        stack.printStack();
//        stack.pop();
//        System.out.println(stack.isEmpty());
        /* END ARRAY STACK */

        /* LINKED LIST STACK */
        LinkedStack stack = new LinkedStack();
        stack.push(joshStone);
        stack.push(mollyStone);
        stack.push(steveHorner);
        stack.push(jaredAdkins);
        stack.printStack();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        stack.pop();
        System.out.println(stack.isEmpty());
        stack.printStack();
        stack.pop();
        System.out.println(stack.isEmpty());
        /* END LINK LIST STACK */
    }
}
