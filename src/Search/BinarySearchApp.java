package Search;

public class BinarySearchApp {
    public static void main(String[] args) {
        int[] intArr = {-22, -15, 1, 7, 20, 35, 55};
        System.out.println(iterativeBinarySearch(intArr, -15));
    }

    public static int iterativeBinarySearch(int[] input, int value)
    {
        int start = 0;
        int end = input.length;

        /* b/c when start equals end, we've searched the entire
           array and didn't find what we were looking for. */
        while(start < end)
        {
            int midpoint = (start+end) / 2;
            if(input[midpoint] == value)
            {
                return midpoint; /* found */
            }
            else if(input[midpoint] < value)
            {
                /* search right part of array now */
                start = midpoint + 1;
            }
            else
            {
                /* search left part of array now */
                end = midpoint;
            }
        }
        /* value not found if we get here */
        return -1;
    }

    public static int recursiveBinarySearch(int[] input, int value)
    {
       return recursiveBinarySearch(input, 0, input.length, value);
    }

    public static int recursiveBinarySearch(int[] input, int start, int end, int value)
    {
        /* breaking condition */
        if(start >= end)
        {
            return -1;
        }
        int midpoint = (start + end) / 2;
        System.out.println("midpoint = " + midpoint);

        if(input[midpoint] == value)
        {
            return midpoint;
        }
        else if(input[midpoint] < value)
        {
            /* search right part of array */
            return recursiveBinarySearch(input, midpoint + 1, end, value);
        }
        else
        {
            /* search left part of array */
            return recursiveBinarySearch(input, start, midpoint, value);
        }
    }
}
