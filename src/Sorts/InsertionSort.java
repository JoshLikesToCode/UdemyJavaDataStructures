package Sorts;

public class InsertionSort {

    public static void rec_insertion_sort(int[] arr, int n)
    {
        if(n <= 1)
            return;
        rec_insertion_sort(arr, n - 1);

        int newElement = arr[n-1];
        int i = n - 2;

        while(i >= 0 && arr[i] > newElement)
        {
            arr[i+1] = arr[i];
            i--;
        }
        arr[i+1] = newElement;
    }

    public static void main(String[] args)
    {
        int[] arr = {20,-25,30,35,6,9,100};
        System.out.print("Original Array: ");
        System.out.print("[ ");
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.print("]\n");

        /*for(int unsortedIndex = 1; unsortedIndex < arr.length; unsortedIndex++)
        {
            int newElement = arr[unsortedIndex];
            int i;

            for(i = unsortedIndex; i > 0 && arr[i-1] > newElement; i--)
            {
                arr[i] = arr[i-1];
            }
            arr[i] = newElement;
        }*/
        rec_insertion_sort(arr, arr.length);

        System.out.print("Final sorted array: ");
        System.out.print("[ ");
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.print("]\n");
    }
}
