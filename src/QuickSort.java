public class QuickSort {

    public static void quickSort(int[] input, int start, int end)
    {
        // if end - start < 2 then we have a 1 element array, we do nothing
        if(end - start < 2)
        {
            return;
        }
        // this will return the position of the element in the sorted array
        int pivotIndex = partition(input, start, end);
        // we now want to do the same thing with all elements smaller than the pivot (left array)
        // and all elements larger than the pivot (right array)
        quickSort(input, start, pivotIndex); // left array
        quickSort(input, pivotIndex + 1, end); // right array
    }

    // this returns the correct position of the pivot in the sorted array
    public static int partition(int[] input, int start, int end) {
        // this is using the first element as the pivot
        int pivot = input[start];
        int i = start;
        int j = end;

        // we now do the traversals. i traverses left to right and j traverses right to left.
        // we stop when i and j cross each other
        while (i < j) {
            // we use j to look for elements that are less than the pivot
            while (i < j && input[--j] >= pivot) {
                // empty loop body
            }
            if (i < j) {
                // we want to the move the element in the array at position j to i
                input[i] = input[j];
            }
            // look for the first element that's greater than the pivot
            while (i < j && input[++i] <= pivot) {
                // empty loop body
            }
            if (i < j) {
                input[j] = input[i];
            }
        }

        // return the index where we inserted the pivot, this is how we divide the array
        // into left and right arrays in quickSort()
        input[j] = pivot;
        return j;
    }

        public static void main (String[]args){
            int[] intArray = {20, 35, -15, 7, 55, 1, -22};

            for (int i = 0; i < intArray.length; i++) {
                System.out.println(intArray[i] + " ");
            }
            quickSort(intArray, 0, intArray.length);
            System.out.println("====After Sort====");
            for (int i = 0; i < intArray.length; i++) {
                System.out.println(intArray[i] + " ");
            }
        }
}
