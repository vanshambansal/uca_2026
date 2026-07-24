package week_3_assignment;

//    Count Smaller Numbers After Self
//    You are given an integer array nums of length n.
//
//    For each element nums[i], determine how many elements to its right are strictly smaller than it.
//
//    Return an array answer of length n, where answer[i] represents the number of smaller elements that appear after nums[i].
//
//    Constraints
//    1 <= n <= 10^5
//            -10^4 <= nums[i] <= 10^4
//
//    Example 1
//    Input
//
//    5 2 6 1
//
//    Output
//
//    2 1 1 0
//
//    Explanation
//
//    5 has two smaller elements after it: 2 and 1.
//            2 has one smaller element after it: 1.
//            6 has one smaller element after it: 1.
//            1 has no elements after it.
//            Hence, the output is 2 1 1 0.
//
//


import java.util.Arrays;

public class SmallerAfterSelf {

    static int []ans;
    static int[]index;

    static void mergeHelp(int []arr, int low, int mid, int high, int []aux) {

        int n = arr.length;
        int i = low;
        int j = mid + 1;
        int k = low;
        int rightCount = 0;

        while (k <= high) {
            if(i > mid) {
                aux[k++] = index[j++];

            }else if (j > high) {
                ans[index[i]] += rightCount;
                aux[k++] = index[i++];

            }else if (arr[index[i]] <= arr[index[j]]) {
                ans[index[i]] += rightCount;
                aux[k++] = index[i++];

            }else{
                rightCount++;
                aux[k++] = index[j++];
            }
        }

        for (int a = low; a <=high; a++) {
            index[a] = aux[a];
        }

    }


    static void merge(int []arr, int low, int high, int []aux ) {
        if(low >= high) return;
        int mid = low - (low - high)/2;

        merge(arr, low, mid, aux);
        merge(arr, mid+1, high, aux);

        mergeHelp(arr, low, mid, high, aux);
    }

    public static void main(String[] args) {

        int []arr = {5, 2, 6, 1};
        int n = arr.length;
        ans = new int[n];
        index = new int[n];
        for(int i = 0; i < n; i++){
            index[i] = i;
        }
        int []aux = new int[n];
        merge(arr, 0, n-1, aux);
        System.out.println(Arrays.toString(ans));

    }
}
