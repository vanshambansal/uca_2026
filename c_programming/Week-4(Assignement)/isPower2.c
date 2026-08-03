/*
 * isPower2 - returns 1 if x is a power of 2, and 0 otherwise
 *   Examples: isPower2(5) = 0, isPower2(8) = 1, isPower2(0) = 0
 *   Note that no negative number is a power of 2.
 *   Legal ops: ! ~ & ^ | + << >>
 *   Max ops: 20
 *   Rating: 4
 */

//  (1 << 31) >> 31 means all 1 ==> same as ~0 or -1

#include<stdio.h>

int isPower2(int a) {
    
    return !(a >> 31) & !!(a) & !(a & (a + ~0));
}

int main() {
    int a;
    
    scanf("%d", &a);

    printf("%d\n", isPower2(a));
}   