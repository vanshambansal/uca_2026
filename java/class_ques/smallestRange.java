//
//    You have k lists of integers, each sorted in **ascending order**. Find the **smallest range** [a, b]
//    such that **at least one number from each of the k lists** is included in that range.
//
//    If there are multiple ranges of the same smallest size, return the one with the smallest a.
//
//            **Example 1:**
//    Input: nums = [[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
//    Output: [20, 24]
//
//    Explanation:
//    List 1: 15, 20, or 24 fits the range [20,24]
//    List 2: 20 fits
//    List 3: 22 fits
//    So [20, 24] has length 4, and it's the smallest such range.
//            **Example 2:**
//    nput: nums = [[1,2,3],[1,2,3],[1,2,3]]
//    Output: [1, 1]
//    Explanation: Every list contains 1, so the range [1,1] works and has length 0.
//            **Constraints:**
//            -ums.length == k`
//            - <= k <= 3500`
//            - <= nums[i].length <= 50`
//            -10^5 <= nums[i][j] <= 10^5`
//            -ach `ums[i]`is sorted in non-decreasing order
//    -ust run efficiently — target **O(N log k)**, where N is total elements across all lists
//
//    ### Method signature:
//    ava
//    public int[] smallestRange(List<List<Integer>> nums) {
//        // your code here
//    }

package class_ques;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class smallestRange {

    static class Node {
        int value;
        int listIndex;
        int elementIndex;

        Node(int value, int listIndex, int elementIndex) {
            this.value = value;
            this.listIndex = listIndex;
            this.elementIndex = elementIndex;
        }

    }

    public static int[] smallestRange(List<List<Integer>> nums) {

        int size = nums.size();
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.value - b.value);
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < size; i++) {
            int value = nums.get(i).get(0);
            pq.add(new Node(value, i, 0));
            maxValue = Math.max(maxValue, value);
        }

        int left = pq.peek().value;
        int right = maxValue;

        while (true) {

            Node n = pq.poll();
            int minValue = n.value;
            int listIndex = n.listIndex;
            int elementIndex = n.elementIndex;

            if ((maxValue - minValue) < (right - left) || (maxValue - minValue) == (right - left) && minValue < left) {
                left = minValue;
                right = maxValue;
            }

            elementIndex++;

            if (elementIndex == nums.get(listIndex).size()) {
                break;
            }

            int nextElement = nums.get(listIndex).get(elementIndex);
            pq.offer(new Node(nextElement, listIndex, elementIndex));

            maxValue = Math.max(maxValue, nextElement);
        }

        return new int[]{left, right};

    }

    public static void main(String[] args) {

        List<List<Integer>>nums = new ArrayList<>(Arrays.asList(
                Arrays.asList(4,10,15,24,26),
                Arrays.asList(0,9,12,20),
                Arrays.asList(5,18,22,30)
        ));

        int []ans = smallestRange(nums);

        System.out.println(Arrays.toString(ans));


    }

}
