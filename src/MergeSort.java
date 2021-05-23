public class MergeSort {

    public static void mergeSort(int[] input, int start, int end)
    {
        // this will break recursion
        if(end - start < 2)
        {
            return;
        }
        // if our array has 2 or more elements, we have work to do
        int mid = (start + end) / 2;
        // let's merge sort the left partition
        mergeSort(input, start, mid);
        // let's merge sort the right partition
        mergeSort(input, mid, end);
        // we need to merge the left and right now
        merge(input, start, mid, end);
    }

    public static void ascend_merge_sort(int[] input, int start, int end)
    {
        // this will break recursion
        if(end - start < 2)
        {
            return;
        }
        // if our array has 2 or more elements, we have work to do
        int mid = (start + end) / 2;
        // let's merge sort the left partition
        ascend_merge_sort(input, start, mid);
        // let's merge sort the right partition
        ascend_merge_sort(input, mid, end);
        // we need to merge the left and right now
        ascend_merge(input, start, mid, end);
    }

    public static void ascend_merge(int[] input, int start, int mid, int end)
    {
        // we are done if this is true, this is an optimization
        if(input[mid - 1] >= input[mid])
        {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0; // this keeps track of where we are in the temp array
        int[] temp = new int[end-start];
        // when i == mid, we finished traversing the left array and when j == mid, we finished the right
        while(i < mid && j < end)
        {
            // temp array gets the smallest out of input[i] and input[j]
            temp[tempIndex++] = input[i] >= input[j] ? input[i++] : input[j++];
        }

        // this will handle the remaining elements
        // if we have elements in the left position, we will have to copy them to temp
        // if we have remaining elements in the right position, we wont need to copy them to temp
        // start is the start of the array and tempIndex is the index of the array that we've sorted so far
        // mid - i contains the elements that we don't need to copy. If we completely traverse the array, mid - i will equal 0
        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        // we only copy the number of elements that we copied into temp array
        System.arraycopy(temp, 0, input, start, tempIndex);
    }

    public static void merge(int[] input, int start, int mid, int end)
    {
        // we are done if this is true, this is an optimization
        if(input[mid - 1] >= input[mid])
        {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0; // this keeps track of where we are in the temp array
        int[] temp = new int[end-start];
        // when i == mid, we finished traversing the left array and when j == mid, we finished the right
        while(i < mid && j < end)
        {
            // temp array gets the smallest out of input[i] and input[j]
            temp[tempIndex++] = input[i] >= input[j] ? input[i++] : input[j++];
        }

        // this will handle the remaining elements
        // if we have elements in the left position, we will have to copy them to temp
        // if we have remaining elements in the right position, we wont need to copy them to temp
        // start is the start of the array and tempIndex is the index of the array that we've sorted so far
        // mid - i contains the elements that we don't need to copy. If we completely traverse the array, mid - i will equal 0
        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        // we only copy the number of elements that we copied into temp array
        System.arraycopy(temp, 0, input, start, tempIndex);
    }


    public static void main(String[] args) {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22};

        for(int i = 0; i < intArray.length; i++)
        {
            System.out.println(intArray[i] + " ");
        }
        //mergeSort(intArray, 0, intArray.length);
        ascend_merge_sort(intArray, 0, intArray.length);
        System.out.println("====After Sort====");
        for(int i = 0; i < intArray.length; i++)
        {
            System.out.println(intArray[i] + " ");
        }
    }
}
