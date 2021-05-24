package Sorts;

public class RaddixSortStringApp {

    public static void main(String[] args) {
        String[] stringsArr = { "bcdef", "dbaqc", "abcde", "cmadd", "bbbbb" };

        // do radix sort
        // radix of 26 since 26 letters in alphabet
        // width of 5, because each string is 5 in length
        radixSort(stringsArr, 26, 5);

        for(int i = 0; i < stringsArr.length; i++)
        {
            System.out.println(stringsArr[i]);
        }
    }

    public static void radixSort(String[] input, int radix, int width)
    {
        for(int i = width-1; i >= 0; i--)
        {
            radixSingleSort(input, i, radix);
        }
    }

    public static void radixSingleSort(String[] input, int position, int radix)
    {
        int numItems = input.length;
        int[] countArr = new int[radix];

        for(String value : input)
            countArr[getIndex(position, value)]++;

        // adjust the count array
        for(int i = 1; i < radix; i++)
            countArr[i] += countArr[i - 1];

        String[] temp = new String[numItems];
        for(int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--)
        {
            temp[--countArr[getIndex(position, input[tempIndex])]] =
                    input[tempIndex];
        }

        for(int tempIndex = 0; tempIndex < numItems; tempIndex++)
            input[tempIndex] = temp[tempIndex];
    }

    public static int getIndex(int position, String value)
    {
        return value.charAt(position) - 'a';    // this will give us the position in the counting array
    }
}
