package HashTables;

import Lists.ArrayLists.Employee;

public class SimpleHashTable {

    private StoredEmployee[] hashtable;

    public SimpleHashTable() {
        hashtable = new StoredEmployee[10];
    }

    private int hashKey(String key) {
        /* this will give indices in the range of 0-9 */
        return key.length() % hashtable.length;
    }

    public void put(String key, Employee employee) {
        /* the hashed key gives us index into array */
        int hashedKey = hashKey(key);

        if (occupied(hashedKey)) {
            /* if we hit this in loop, we've gone all around loop */
            int stopIndex = hashedKey;
            /* if the position we're checking is the last position in the
               array, then we want to loop */
            if (hashedKey == hashtable.length - 1) {
                hashedKey = 0;
            } else {
                hashedKey++;
            }
            while (occupied(hashedKey) && hashedKey != stopIndex) {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }
        /* if we are still occupied after this, then the hashtable is full */
        if (occupied(hashedKey)) {
            System.out.println("Sorry, there's already an employee at position " + hashedKey);
        } else {
            hashtable[hashedKey] = new StoredEmployee(key, employee);
        }
    }

    /* get() is done in O(1) time, this is part of what makes hashtables so desirable */
    public Employee get(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null; /* no employee found with the key */
        }
        return hashtable[hashedKey].employee;
    }

    private int findKey(String key) {
        int hashedKey = hashKey(key);
        if (hashtable[hashedKey] != null &&
                hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        }
        /* we will again use linear probing */

        /* if we hit this in loop, we've gone all around loop */
        int stopIndex = hashedKey;
            /* if the position we're checking is the last position in the
               array, then we want to loop */
        if (hashedKey == hashtable.length - 1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }
        while (hashedKey != stopIndex && hashtable[hashedKey] != null
                && !hashtable[hashedKey].key.equals(key)) {
            hashedKey = (hashedKey + 1) % hashtable.length;
        }
        /* we've either now looked at the entire array,
           or have successfully found employee */
        if(hashtable[hashedKey] != null &&
                hashtable[hashedKey].key.equals(key))
        {
            /* found */
            return hashedKey;
        }
        else
        {
            /* not found */
            return -1;
        }
    }

    /* remove will use linear probing */
    public Employee remove(String key)
    {
        int hashedKey = findKey(key);
        if(hashedKey == -1) {
            return null;
        }
        Employee employee = hashtable[hashedKey].employee;
        /* null removed employee */
        hashtable[hashedKey] = null;

        /* rehash the table so we can find existing entries who
           were added through linear probing */
        StoredEmployee[] oldHashtable = hashtable;
        hashtable = new StoredEmployee[oldHashtable.length];
        for(int i = 0; i < oldHashtable.length; i++)
        {
            /* rehash all the old values in old hashtable and put in new hashtable */
            if(oldHashtable[i] != null)
            {
                put(oldHashtable[i].key, oldHashtable[i].employee);
            }
        }
        return employee;
    }

    public void printHashTable() {
        for(int i = 0; i < hashtable.length; i++)
        {
            if(hashtable[i] == null)
                continue;
            System.out.println("Position " + i + ": " + hashtable[i].employee);
        }
    }

    /* this method is for helping with collisions (by using linear probing) */
    private boolean occupied(int index)
    {
        return hashtable[index] != null;
    }
}
