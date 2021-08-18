package HashTables;

import Lists.ArrayLists.Employee;

public class HashTableApp {
    public static void main(String[] args) {
        Employee joshStone = new Employee("Josh", "Stone", 123);
        Employee mollyStone = new Employee("Molly", "Stone", 456);
        Employee steveHorner = new Employee("Steve", "Horner", 789);
        Employee jaredAdkins = new Employee("Jared", "Adkins", 101112);

        SimpleHashTable ht = new SimpleHashTable();
        ht.put("Stone", joshStone);
        ht.put("Stone", mollyStone);
        ht.put("SHorner", steveHorner);
        ht.put("Adkins", jaredAdkins);

        ht.printHashTable();

        System.out.println("Retrieve key Stone: " + ht.get("Stone"));
    }
}
