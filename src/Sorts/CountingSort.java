package Sorts;

public class CountingSort {

    public static void main(String[] args) {
        int[] intArr = {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};

        //my_countingSort(intArr, 10);
        countingSort(intArr, 2, 10);

        for(int i = 0; i < intArr.length; i++)
        {
            System.out.println(intArr[i]);
        }
    }

    public static void countingSort(int[] input, int min, int max)
    {
        int[] countArray = new int[(max - min) + 1];

        for(int i = 0; i < input.length; i++)
        {
            countArray[input[i] - min]++;
        }

        int j = 0;
        for(int i = min; i <= max; i++)
        {
            while(countArray[i-min] > 0)
            {
                input[j++] = i;
                countArray[i - min]--;
            }
        }
    }

    // my attempt at countingSort based off theory slides
    public static void my_countingSort(int[] input, int max) {

        int[] countingArr = new int[max + 1];

        for (int j : input)
        {
            countingArr[j]++;
        }

        int index = 0;
        for (int i = 0; i < countingArr.length; i++)
        {
            while(0 < countingArr[i])
            {
                input[index++] = i;
                countingArr[i]--;
            }
        }

    }
}
