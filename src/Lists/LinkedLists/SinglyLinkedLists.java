package Lists.LinkedLists;
import Lists.ArrayLists.Employee;
import java.util.ArrayList;
import java.util.List;

public class SinglyLinkedLists {



    public static void main(String[] args) {
//        Employee joshStone = new Employee("Josh", "Stone", 123);
//        Employee mollyStone = new Employee("Molly", "Stone", 456);
//        Employee steveHorner = new Employee("Steve", "Horner", 789);
//        Employee jaredAdkins = new Employee("Jared", "Adkins", 101112);
//
//        EmployeeLinkedList list = new EmployeeLinkedList();
//        System.out.println(list.isEmpty());
//        list.addToFront(joshStone);
//        list.addToFront(mollyStone);
//        list.addToFront(steveHorner);
//        list.addToFront(jaredAdkins);
//        System.out.println(list.getSize());
//        System.out.println(list.isEmpty());
//        list.printList();
//        list.removeFromFront();
//        System.out.println(list.getSize());
//        list.printList();
        IntegerLinkedList list = new IntegerLinkedList();
        list.addSorted(3);
        list.addSorted(2);
        list.addSorted(10);
        list.addSorted(9000);
        System.out.println(list.getSize());
        list.printList();
    }
}
