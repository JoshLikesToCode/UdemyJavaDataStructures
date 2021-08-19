package Sorts;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BucketSort {
    public static void main(String[] args) {
        int[] intArr = {54, 46, 83, 66, 95, 92, 43};

        bucketSort(intArr);

        for(int i = 0; i < intArr.length; i++)
        {
            System.out.println(intArr[i]);
        }
    }

    public static void bucketSort(int[] input)
    {
        List<Integer>[] buckets = new List[10];

        for(int i = 0; i < buckets.length; i++)
        {
            /* we could also use ArrayList */
            buckets[i] = new LinkedList<Integer>();
        }

        /* scattering phase */
        for(int i = 0; i < input.length; i++)
        {
            buckets[hash(input[i])].add(input[i]);
        }

        for(List bucket: buckets)
        {
            /* Collections.sort() uses an adaptive merge sort */
            Collections.sort(bucket);
        }

        /* gathering stage. traverse the buckets array (which is now sorted)
           and copy it over
         */
        int j = 0;
        for(int i = 0; i < buckets.length; i++)
        {
            for(int value: buckets[i])
            {
                input[j++] = value;
            }
        }
    }

    private static int hash(int value)
    {
        return value / (int) 10;
    }
}
