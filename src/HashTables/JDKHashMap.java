package HashTables;

import Lists.ArrayLists.Employee;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JDKHashMap {
    public static void main(String[] args) {
        Employee joshStone = new Employee("Josh", "Stone", 123);
        Employee mollyStone = new Employee("Molly", "Stone", 456);
        Employee steveHorner = new Employee("Steve", "Horner", 789);
        Employee jaredAdkins = new Employee("Jared", "Adkins", 101112);

        Map<String, Employee> hashMap = new HashMap<String, Employee>();
        hashMap.put("stones",joshStone);
        hashMap.put("stone",mollyStone);
        hashMap.put("stevieboy",steveHorner);
        hashMap.put("adkins",jaredAdkins);
        //hashMap.put("adkins", steveHorner);

        /* it's always faster to search by key */
        System.out.println(hashMap.containsKey("stone"));
        System.out.println(hashMap.containsValue(jaredAdkins));

        System.out.println(hashMap.get("stone"));
        System.out.println(hashMap.getOrDefault("somone", joshStone));


//        Iterator<Employee> it = hashMap.values().iterator();
//        while(it.hasNext())
//        {
//            System.out.println(it.next());
//        }
        hashMap.forEach((k,v) -> System.out.println("Key = " + k + " Employee = " + v));
    }
}
