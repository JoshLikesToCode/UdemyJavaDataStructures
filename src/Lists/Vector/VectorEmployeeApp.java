package Lists.Vector;
import Lists.Vector.Employees;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class VectorEmployeeApp {

    public static void main(String[] args) {
        //List<Employee> employeeList = new LinkedList<>();
        //List<Employees> employeeList = new ArrayList<>();
        List<Employees> employeeList = new Vector<>();
        employeeList.add(new Employees("Josh", "Stone", 123));
        employeeList.add(new Employees("Molly", "Stone", 456));
        employeeList.add(new Employees("Steve", "Horner", 789));
        employeeList.add(new Employees("Jared", "Adkins", 101112));

        employeeList.forEach(employee -> System.out.println(employee));
        // print out second employee
        System.out.println(employeeList.get(1));
        // check if list is empty
        System.out.println(employeeList.isEmpty());
        // replace employee at position 0 with employee at position 1
        employeeList.set(0, employeeList.get(1));
        employeeList.forEach(System.out::println);
        // get size of list
        System.out.println(employeeList.size());
        // let's re-add the former employee
        employeeList.add(0, new Employees("Joshua", "Stone", 393939));
        employeeList.forEach(employee -> System.out.println(employee));
        System.out.println("===================================\n");
        // using toArray()
        Employees[] employeeArray = employeeList.toArray(new Employees[employeeList.size()]);
        for(Employees employee : employeeArray)
        {
            System.out.println(employee);
        }

        // employeeList.contains() won't work until we implement the equals method
        System.out.println(employeeList.contains(new Employees("Joshua", "Stone", 393939)));
        System.out.println(employeeList.indexOf(new Employees("Molly", "Stone", 456)));

        // lets remove steve horner from list
        employeeList.remove(2);
        employeeList.forEach(employee -> System.out.println(employee));
    }
}