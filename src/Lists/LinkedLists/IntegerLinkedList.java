package Lists.LinkedLists;

/* Challenge #2 for LinkedList is to create an integer linked list that inserts values in sorted order */
public class IntegerLinkedList {
    IntNode head;
    IntNode prev;
    int size;


    public void addSorted(int val)
    {
        if(isEmpty() || val >= head.getVal())
        {
            IntNode node = new IntNode(val);
            node.setNext(head);
            head = node;
        }
        else
        {
            if(size == 1)
            {
                IntNode node = new IntNode(val);
                head.setNext(node);
                size++;
                return;
            }
            IntNode curr = head.getNext();
            IntNode prev = head;
            while(curr.getVal() < val)
            {
                curr = curr.getNext();
                prev = prev.getNext();
            }
            prev = new IntNode(val);
            prev.setNext(curr);
        }
        size++;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public IntNode getHead() {
        return head;
    }

    public void setHead(IntNode head) {
        this.head = head;
    }

    public IntNode getPrev() {
        return prev;
    }

    public void setPrev(IntNode prev) {
        this.prev = prev;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void printList()
    {
        IntNode current = head;
        System.out.print("HEAD -> ");
        while(current != null) {
            System.out.print(current.getVal());
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }
}
