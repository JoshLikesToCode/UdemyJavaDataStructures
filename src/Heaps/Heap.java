package Heaps;

public class Heap {
    /* array to hold heap */
    private int[] heap;
    private int size;

    public Heap(int cap)
    {
        heap = new int[cap];
    }

    /* FOR HEAP SORT */
    public void sort()
    {
        /* the item we want to swap the root with */
        int lastHeapIndex = size - 1;
        for(int i = 0; i < lastHeapIndex; i++)
        {
            int tmp = heap[0];  /* largest value in the heap */
            heap[0] = heap[lastHeapIndex - i];  /* the item we're now making the root of the heap */
            heap[lastHeapIndex - i] = tmp;

            /* we swapped and now we have to fix the heap */
            fixHeapBelow(0, lastHeapIndex - i - 1);
        }
    }
    /* END FOR HEAP SORT */


    /* We can either alert the user that the heap is full or resize the array */
    public boolean isFull()
    {
        return size == heap.length;
    }

    public int getParent(int index)
    {
        return (index - 1) / 2;     /* integer division automatically does floor */
    }

    public int delete(int index)
    {
        if(isEmpty())
        {
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        int parent = getParent(index);
        int deletedValue = heap[index];
        /* the right most value in the heap will now replace whatever is at index */
        heap[index] = heap[size - 1];
        /* if the value at heap[index] is greater than parent we need to fix above,
           if it's lower than it's parent than we need to look at the heap below
           b/c it's also possible that it's less than it's children
         */
        if(index == 0 || heap[index] < heap[parent])
        {
            fixHeapBelow(index, size - 1);
        }
        else
        {
            fixHeapAbove(index);
        }
        size--;
        return deletedValue;
    }

    /* lastHeapIndex holds last index of the heap */
    private void fixHeapBelow(int index, int lastHeapIndex)
    {
        int childToSwap;

        /* we're fixing below, so we're starting at index and going to the end of the heap */
        while(index <= lastHeapIndex)
        {
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);
            if(leftChild <= lastHeapIndex)      /* node has a left child */
            {
                if(rightChild > lastHeapIndex)  /* check if node has a right child */
                {
                    /* left child is what we want to swap, b/c that's all there is */
                    childToSwap = leftChild;
                }
                else
                {
                    childToSwap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);
                }

                if(heap[index] < heap[childToSwap])
                {
                    int tmp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = tmp;
                }
                else
                {
                    break; /* we're done! */
                }
                index = childToSwap;
            }
            else
            {
                break;
            }
        }
    }

    public void printHeap()
    {
        for(int i = 0; i < size; i++)
        {
            System.out.print(heap[i]);
            System.out.print(", ");
        }
        System.out.println();
    }

    /* return root */
    public int peek()
    {
        if(isEmpty())
        {
            throw new IndexOutOfBoundsException("Heap is empty");
        }
        return heap[0];
    }


    public void insert(int value)
    {
        /* heaps full, we can't add any new items to our heap */
        if(isFull())
        {
            throw new IndexOutOfBoundsException("Heap is full");
        }
        /* increment size to next available position */
        heap[size] = value;
        /* we now need to heapify the heap, because the value inserted can be greater than its parent */
        /* heapify until value is smaller than parent or we hit the heap */
        fixHeapAbove(size);
        size++;
    }

    /* looking up the tree after an insert to heapify */
    public void fixHeapAbove(int index)
    {
        /* value we just inserted */
        int newValue = heap[index];
        while(index > 0 && newValue > heap[getParent(index)])
        {
            /* bubbling up */
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }

        heap[index] = newValue;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public int getChild(int index, boolean left)
    {
        return 2 * index + (left ? 1 : 2);
    }
}
