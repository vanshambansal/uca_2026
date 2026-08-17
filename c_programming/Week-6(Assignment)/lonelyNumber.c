// Given an Array of size n. It has integers where all the numbers are repeated 3 times but one number is repeated 4 times. Write a code to find the number repeating 4 times.

// Constraints:

// size of array: 0 > n > 10^5
// Each element i : 0 < i < n
// Expected Run time complexity: O(n)
// Expected Space complexity: O(1)
// Example:

// input: [1, 2, 3, 4, 1, 2, 4, 1, 2, 3, 4, 3, 3]
// Expected output: 3
// Explanation: 3 comes 4 times but others are 3 times in array.


#include <stdio.h>

int main () {

    int arr[] = {1, 2, 3, 4, 1, 2, 4, 1, 2, 4, 4, 3, 3};
    int n = 13;
    int ans = 0;

    for(int i = 31; i >= 0; i--) {
        int count = 0;
        for (int j = 0; j < n; j++) {
            if((arr[j] >> i) & 1){
                count++;
            }
        }
        ans = ans << 1;
        if(count % 3 != 0){
            ans |= 1;
        }
    }

    printf("%d\n",ans);

    return 0;
}