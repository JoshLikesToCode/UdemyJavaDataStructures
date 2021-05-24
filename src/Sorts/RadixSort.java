package Sorts;

public class RadixSort {
    public static void main(String[] args)
    {
        int[] arr = {325,120,330,345,655,999,100,450};

        radixSort(arr, 10, 3);

        for(int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i] + " ");
        }
    }

    public static void radixSort(int[] input, int radix, int width)
    {
        for(int i = 0; i < width; i++)
        {
            // sorts starting at the right most position, right most - 1, ... , right most - k
            radixSingleSort(input, i, radix);
        }
    }

    public static void radixSingleSort(int[] input, int position, int radix) {
        int numItems = input.length;
        int[] countArr = new int[radix];

        for (int value : input) {
            // increment the countArr at value
            countArr[getDigit(position, value, radix)]++;
        }
        // adjust the count array
        for (int j = 1; j < radix; j++) {
            countArr[j] += countArr[j - 1];
        }
        // copy values in temp array, going from right to left to make sure stable
        int[] temp = new int[numItems];
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--)
        {
            temp[--countArr[getDigit(position, input[tempIndex], radix)]] = input[tempIndex];
        }
        // copy back into input array
        for(int tempIndex = 0; tempIndex < numItems; tempIndex++)
        {
            input[tempIndex] = temp[tempIndex];
        }
    }

    // get value for countArr at different positions (1s, 10s, 100ths, etc)
    public static int getDigit(int position, int value, int radix)
    {
        return value / (int) Math.pow(10, position) % radix;
    }
}
