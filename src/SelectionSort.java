public class SelectionSort {
    public static void main(String[] args)
    {
        int[] arr = {20,-25,30,35,6,9,100,4};

        for(int lastUnsortedIndex = arr.length-1; lastUnsortedIndex > 0; lastUnsortedIndex--)
        {
            int largest = 0;
            for(int i = 1; i <= lastUnsortedIndex; i++)
            {
                if(arr[i] > largest)
                {
                    largest = i;
                }
            }
            int temp = arr[lastUnsortedIndex];
            arr[lastUnsortedIndex] = arr[largest];
            arr[largest] = temp;
        }

        for(int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i] + " ");
        }
    }
}
