//Q->
//        Given an unsorted array of integers,
//        find the length of the longest sequence of consecutive integers
//        (the numbers don't need to be adjacent in the array, just consecutive in value).
//
//        Example 1:
//
//        Input: [100, 4, 200, 1, 3, 2]
//        Output: 4
//        Explanation: The longest consecutive sequence is [1, 2, 3, 4].
//
//        Example 2:
//
//        Input: [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]
//        Output: 9
//        Explanation: [0, 1, 2, 3, 4, 5, 6, 7, 8]
//
//        Constraints:
//        Array can contain duplicates
//        Array can be empty (return 0)
//        Values can be negative
//        Expected Must be O(n) time, O(n) space
//


package class_ques;

import java.util.HashSet;

public class ques1 {

    public static void main(String[] args) {

        int []arr = { 100, 101, 2, 200, 3, 0, -1, -2, -3, -4 };

        int n = arr.length;

        HashSet<Integer>set = new HashSet<>();

        for(int i : arr){
            set.add(i);
        }

        int maxCount = 0;
        for(int i : arr){

            if(set.contains(i-1)) continue;

            int count = 0;
            int num = i;

            while(set.contains(num)){

                count++;
                num++;
            }
            maxCount = Math.max(maxCount, count);

        }

        System.out.println(maxCount);

    }
}
