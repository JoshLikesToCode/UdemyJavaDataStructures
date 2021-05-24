package Sorts;

public class BubbleSort {
    public static void main(String[] args)
    {
        int[] arr = {-25,20,30,35,6,9,100,4};

        for(int unsortedIndex = arr.length - 1; unsortedIndex > 0; unsortedIndex--)
        {
            for(int i = 0; i < arr.length; i++)
            {
                if(arr[unsortedIndex] < arr[i])
                {
                    int newElement = arr[i];
                    arr[i] = arr[unsortedIndex];
                    arr[unsortedIndex] = newElement;
                }
            }
        }

        for(int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i] + " ");
        }
    }
}
