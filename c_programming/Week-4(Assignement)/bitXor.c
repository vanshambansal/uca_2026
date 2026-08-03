/* 
 * bitXor - x^y using only ~ and & 
 *   Example: bitXor(4, 5) = 1
 *   Legal ops: ~ &
 *   Max ops: 14
 *   Rating: 1
 */


#include<stdio.h>

// soln -
// x ^ y = (x & ~y) | (~x & y)
// A | B = ~(~A & ~B)
// x ^ y = ~ ( ~(x & ~y) & ~(~x & y) )


int bitXor(int x, int y) {

    return ~ ( ~(x & ~y) & ~(~x & y) );
}

int main() {
    int a;
    int b;
    scanf("%d %d", &a, &b);

    printf("%d\n", bitXor(a, b));
}