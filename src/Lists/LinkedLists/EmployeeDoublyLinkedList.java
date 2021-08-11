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