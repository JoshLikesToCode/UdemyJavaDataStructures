package HashTables;

import Lists.ArrayLists.Employee;
import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.ListIterator;

public class ChainedHashTable {
    private LinkedList<StoredEmployee>[] hashtable;

    public ChainedHashTable()
    {
        hashtable = new LinkedList[10];
        for(int i = 0; i < hashtable.length; i++)
        {
            hashtable[i] = new LinkedList<StoredEmployee>();
        }
    }

    public Employee get(String key)
    {
        int hashedKey = hashKey(key);
        ListIterator<StoredEmployee> it = hashtable[hashedKey].listIterator();
        StoredEmployee employee = null;
        while(it.hasNext())
        {
            employee = it.next();
            if(employee.key.equals(key))
            {
                return employee.employee;
            }
        }
        /* we havent found what we're looking for */
        return null;
    }

    public Employee remove(String key)
    {
        int hashedKey = hashKey(key);
        ListIterator<StoredEmployee> it = hashtable[hashedKey].listIterator();
        StoredEmployee employee = null;
        int index = -1;
        while(it.hasNext())
        {
            employee = it.next();
            index++;    /* index now starts at 0 */
            if(employee.key.equals(key))
            {
                break;
            }
        }
        /* we traversed the list and didn't find the employee
           that we were looking for */
        if(employee == null || !employee.key.equals(key))
        {
            return null;
        }
        else
        {
            hashtable[hashedKey].remove(index);
            return employee.employee;
        }
    }

    public void put(String key, Employee employee)
    {
        int hashedKey = hashKey(key);
        hashtable[hashedKey].add(new StoredEmployee(key, employee));
    }

    private int hashKey(String key)
    {
        //return key.length() % hashtable.length;
        /* let's use strings hashcode method */
        return Math.abs(key.hashCode() % hashtable.length);
    }

    public void printHashTable()
    {
        for(int i = 0; i < hashtable.length; i++)
        {
            if(hashtable[i].isEmpty())
            {
                /* spot in list is empty */
                System.out.println("Position " + i + ": empty");
            }
            else
            {
                System.out.println("Position " + i + ": ");
                ListIterator<StoredEmployee> it = hashtable[i].listIterator();
                while(it.hasNext())
                {
                    System.out.print(it.next().employee);
                    System.out.print(" -> ");
                }
                System.out.println("null");
            }
        }
    }
}
