package week_5_assignment;

import java.util.Collections;
import java.util.PriorityQueue;

class runningMedian {

    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    static void insert(int num) {

        // this logic is also correct but better to do this with clean logic which is downwards

//        if(maxHeap.size() == 0) {
//            maxHeap.add(num);
//        }
//        else if (minHeap.size() > 0 && num > minHeap.peek()) {
//
//            if (maxHeap.size() - minHeap.size() == 0 ) {
//                maxHeap.add(minHeap.poll());
//                minHeap.add(num);
//            } else if (maxHeap.size() - minHeap.size() == 1) {
//                minHeap.add(num);
//            }
//
//        }
//        else if (num > maxHeap.peek()) {
//
//            if (maxHeap.size() - minHeap.size() == 0) {
//                maxHeap.add(num);
//            } else if (maxHeap.size() - minHeap.size() == 1) {
//                minHeap.add(num);
//            }
//
//        } else if (num < maxHeap.peek()) {
//            if (maxHeap.size() - minHeap.size() == 1) {
//                minHeap.add(maxHeap.poll());
//                maxHeap.add(num);
//            }else if (maxHeap.size() - minHeap.size() == 0 ) {
//                maxHeap.add(num);
//            }
//        }


        if(maxHeap.isEmpty() || num < maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if(maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        }
        else if(minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }


    }

    static float getMedian () {
        if(maxHeap.size() == 0){
            System.out.println("no input provided");
            return -1;
        }
        if(maxHeap.size() - minHeap.size() == 0) {
            return ((float) (maxHeap.peek() + minHeap.peek())) / 2;
        }

        if(maxHeap.size() - minHeap.size() == 1) {
            return (float) maxHeap.peek();
        }
        return 0;
    }

    public static void main(String[] args) {

    insert(1);
    System.out.println(getMedian() + "\n");

    insert(4);
    System.out.println(getMedian() + "\n");

    insert(2);
    System.out.println(getMedian() + "\n");

    insert(3);
    System.out.println(getMedian() + "\n");

    insert(6);
    System.out.println(getMedian() + "\n");

    insert(7);
    System.out.println(getMedian() + "\n");

    insert(5);
    System.out.println(getMedian() + "\n");


    }

}
