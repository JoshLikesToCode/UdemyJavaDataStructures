package Lists.LinkedLists;

import Lists.ArrayLists.Employee;

public class EmployeeLinkedList {

    private EmployeeNode head;
    private int size;

    public void addToFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);
        head = node;
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
        head = head.getNext();
        size--;
        /* garbage collector will remove this, but this is good practice */
        removedNode.setNext(null);
        return removedNode;
    }

    public void printList()
    {
        EmployeeNode current = head;
        System.out.print("HEAD -> ");
        while(current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }
}
