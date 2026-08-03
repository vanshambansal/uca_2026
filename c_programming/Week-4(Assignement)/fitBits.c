/* 
 * fitsBits - return 1 if x can be represented as an 
 *  n-bit, two's complement integer.
 *   1 <= n <= 32
 *   Examples: fitsBits(5,3) = 0, fitsBits(-4,3) = 1
 *   Legal ops: ! ~ & ^ | + << >>
 *   Max ops: 15
 *   Rating: 2
 */

//  soln - 

// Idea:
// Check whether x can be represented using only n bits in Two's Complement.

// Method:
// 1. Remove the upper (32-n) bits by left shifting.
// 2. Restore the number using arithmetic right shift (sign extension).
// 3. If the restored number is equal to the original number, x fits in n bits.

// Key Concept:
// A number fits in n bits if removing the extra bits and sign-extending it back does not change its value.


#include <stdio.h>

int fitsBits(int x, int n) {

    int shift = x << (32 - n);
    int shiftBack = shift >> (32 - n);

    return ! (x ^ shiftBack); 
    
}

int main() {
    int a;
    int b;
    scanf("%d %d", &a, &b);

    printf("%d\n", fitsBits(a, b));
}

