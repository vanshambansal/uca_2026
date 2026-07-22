package week_3_assignment;

//
//    Problem: Count Significant Reverse Pairs
//    Statement
//    You are given an integer array nums of length n. A significant reverse pair is defined as a pair of indices (i, j) such that:
//
//            0 <= i < j < n
//    nums[i] > 2 * nums[j]
//    Your task is to determine the total number of significant reverse pairs present in the array.
//
//    Constraints
//    1 <= n <= 10^5
//            -2^31 <= nums[i] <= 2^31 - 1
//    Example 1
//    Input
//    1 3 2 3 1
//
//    Output
//    2
//
//    Explanation
//    The significant reverse pairs are:
//
//            (1, 4) → 3 > 2 × 1
//            (3, 4) → 3 > 2 × 1 Hence, the answer is 2.
//    Example 2
//    Input
//    2 4 3 5 1
//
//    Output
//    3
//
//    Explanation
//    The significant reverse pairs are:
//
//            (1, 4) → 4 > 2 × 1
//            (2, 4) → 3 > 2 × 1
//            (3, 4) → 5 > 2 × 1
//    Hence, the answer is 3.


import java.util.Arrays;

public class reversePairs {
    static int count = 0;

    static void mergeHelp(int []arr, int low, int mid, int high, int []aux) {

        int n = arr.length;
        int i = low;
        int j = mid + 1;
        int k = low;

        while (k <= high) {
            if(i > mid) {
                aux[k++] = arr[j++];

            }else if (j > high) {
                aux[k++] = arr[i++];

            }else if (arr[i] <= arr[j]) {
                aux[k++] = arr[i++];

            }else{
                aux[k++] = arr[j++];
            }
        }

        for (int a = low; a <=high; a++) {
            arr[a] = aux[a];
        }

    }

    static void countReverse (int []arr, int low, int mid, int high) {
        int n = arr.length;
        int j = mid + 1;
        for(int i = low; i <= mid; i++){

            while(j <= high && (arr[i] > (2l * arr[j]))) {
                j++;
            }
            count += j - mid - 1;
        }
    }

    static void merge(int []arr, int low, int high, int []aux ) {
        if(low >= high) return;
        int mid = low - (low - high)/2;

        merge(arr, low, mid, aux);
        merge(arr, mid+1, high, aux);
        countReverse(arr, low, mid, high);

        mergeHelp(arr, low, mid, high, aux);
    }

    public static void main(String[] args) {
        int []arr = {2, 4, 3, 5, 1};
        int n = arr.length;
        int []aux = new int[n];
        merge(arr, 0, n-1, aux);
        System.out.println(Arrays.toString(arr));
        System.out.println(count);
    }
}
