package Lists.LinkedLists;

import Lists.ArrayLists.Employee;

public class EmployeeDoublyLinkedList {

    private EmployeeNode head;
    private EmployeeNode tail;
    private int size;

    public void addToFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);

        if(head == null) {
            /* if adding to empty list we need to set tail */
            tail = node;
        }
        else /* we need to set the head node's previous to the current node */
        {
            head.setPrevious(node);
        }

        head = node;
        size++;
    }

    public boolean addBefore(Employee employeeToAdd, Employee existingEmployee)
    {
        if(head == null)
            return false;

        /* find existing employee */
        EmployeeNode curr = head;
        while(curr != null && !curr.getEmployee().equals(existingEmployee))
        {
            curr = curr.getNext();
        }
        /* if current equals null, we can't find the employee to insert infront of */
        if(curr == null)
            return false;

        /*  we found the employee, now we want to insert infront of it. */
        // - We're gonna have to obviously set the previous and next. fields of the new employee.
        // - We're gonna have to change the previous field of the current node,
        //   because we're inserting the new employee in front of the current node,
        //   so we're gonna want the current node's previous field to point to the new employee,
        //   and then the employee that's currently in front of current is now going to be in front of the new employee,
        //   so its next field needs to be changed.
        EmployeeNode newNode = new EmployeeNode(employeeToAdd);
        newNode.setPrevious(curr.getPrevious());
        newNode.setNext(curr);
        curr.setPrevious(newNode);
        /* check to see if inserting to head of list, then we need to change the head
           field for the list to be the new node
         */
        if(head == curr)
            head = newNode;
        else
        {
            newNode.getPrevious().setNext(newNode);
        }
        size++;
        /* if we make it down here, then we have a success */
        return true;
    }

    public void addToEnd(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        if(tail == null) {
            /* adding to empty list */
            head = node;
        }
        else
        {
            /* make the node we're adding the tail */
            tail.setNext(node);
            /* make the current node the previous node to the tail */
            node.setPrevious(tail);
        }
        /* set the tail to node and incrememnt size */
        tail = node;
        size++;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public EmployeeNode removeFromFront() {
        /* we don't have anything to do */
        if(isEmpty()) {
            return null;
        }
        EmployeeNode removedNode = head;

        /* check if this is the only node in the list */
        if(head.getNext() == null) {
            tail = null;
        }
        else
        {
            head.getNext().setPrevious(null);
        }

        head = head.getNext();
        size--;
        /* garbage collector will remove this, but this is good practice */
        removedNode.setNext(null);
        return removedNode;
    }

    public EmployeeNode removeFromEnd() {
        if (isEmpty()) {
            return null;
        }

        EmployeeNode removedNode = tail;

        if (tail.getPrevious() == null) {
            head = null;
        }
        else {
            tail.getPrevious().setNext(null);
        }

        tail = tail.getPrevious();
        size--;
        removedNode.setPrevious(null);
        return removedNode;
    }

    public void printList()
    {
        EmployeeNode current = head;
        System.out.print("HEAD -> ");
        while(current != null) {
            System.out.print(current);
            System.out.print(" <=> ");
            current = current.getNext();
        }
        System.out.println("null");
    }
}