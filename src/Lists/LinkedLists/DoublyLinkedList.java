package Lists.LinkedLists;

import Lists.ArrayLists.Employee;

public class DoublyLinkedList {
    public static void main(String[] args) {
        Employee joshStone = new Employee("Josh", "Stone", 123);
        Employee mollyStone = new Employee("Molly", "Stone", 456);
        Employee steveHorner = new Employee("Steve", "Horner", 789);
        Employee jaredAdkins = new Employee("Jared", "Adkins", 101112);

        EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();

        System.out.println(list.isEmpty());
        list.addToFront(joshStone);
        list.addToFront(mollyStone);
        list.addToFront(steveHorner);
        list.addToFront(jaredAdkins);
        list.removeFromEnd();
        System.out.println(list.getSize());
        list.printList();
        list.addToEnd(joshStone);
        list.printList();
        System.out.println(list.getSize());
        Employee marcinEnd = new Employee("Marshawn", "Mazerski", 10331);
        list.addBefore(marcinEnd, steveHorner);
        list.printList();
    }
}
