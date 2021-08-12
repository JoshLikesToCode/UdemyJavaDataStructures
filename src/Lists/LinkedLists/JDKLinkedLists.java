package Lists.LinkedLists;

import Lists.ArrayLists.Employee;

import java.util.Iterator;
import java.util.LinkedList;

public class JDKLinkedLists {
    public static void main(String[] args) {
        Employee joshStone = new Employee("Josh", "Stone", 123);
        Employee mollyStone = new Employee("Molly", "Stone", 456);
        Employee steveHorner = new Employee("Steve", "Horner", 789);
        Employee jaredAdkins = new Employee("Jared", "Adkins", 101112);

        LinkedList<Employee> list = new LinkedList<>();
        list.addFirst(joshStone);
        list.addFirst(mollyStone);
        list.addFirst(steveHorner);
        list.addFirst(jaredAdkins);

        /* the list class doesn't have a print method, but it does have iterators */
        Iterator it = list.iterator();
        System.out.print("HEAD -> ");
        while(it.hasNext())
        {
            System.out.print(it.next());
            System.out.print("<=>");
        }
        System.out.print("null");
        /* below would work too, for printing the list */
        // for (Employee employee : list) System.out.println(employee);

        Employee marcinEnd = new Employee("Marshawn", "Mazerski", 10331);
        list.add(marcinEnd);
        System.out.println("");
        for (Employee employee : list) System.out.println(employee);

        list.removeLast();
        it = list.iterator();
        System.out.print("HEAD -> ");
        while(it.hasNext())
        {
            System.out.print(it.next());
            System.out.print("<=>");
        }
        System.out.print("null");
    }
}
