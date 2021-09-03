package Heaps;

import java.util.PriorityQueue;

public class JDKPrioritQueuApp {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.add(25);
        pq.add(-22);
        pq.add(1343);
        pq.add(54);
        pq.add(0);
        pq.add(-3492);
        pq.add(429);

        /* Queue looks like this :
              | -3492 | -22 | 0 | 25 | 54 | 420 | 1343 |
         */

        /* returns -3492 */
        System.out.println(pq.peek());
        /* returns & removes -3492 aka head of the queue from the queue */
        System.out.println(pq.remove());
        /* -22 is the new head of the queue, this will return -22 */
        System.out.println(pq.peek());
        /* poll will remove the highest priority item, -22 is returned then removed */
        System.out.println(pq.poll());
        System.out.println(pq.peek());
        /* Let's remove 54 and peek again, which should show us 0 */
        System.out.println(pq.remove(54));

        /* Also, we could sort any object as long as it's comparable interface,
        or provide a comparitor in the constructor */
        Object[] ints = pq.toArray();
        System.out.println();
        for(Object num : ints)
        {
            System.out.println(num);
        }
        System.out.println();

        System.out.println(pq.peek());
        /* let's add something that is a higher priority than the root */
        pq.add(-1);
        /* -1 should be at root now */
        System.out.println(pq.peek());
    }
}
