import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxHeapWithPriorityQueue {

    public static void main(String[] args){

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> b-a);

        maxHeap.add(16);
        maxHeap.add(86);
        maxHeap.add(66);
        maxHeap.add(90);
        maxHeap.add(20);
        maxHeap.add(45);
        maxHeap.add(61);

        while (!maxHeap.isEmpty()){
            System.out.print(" "+maxHeap.poll());
        }

    }
}
