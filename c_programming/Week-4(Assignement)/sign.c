
/* 
 * sign - return 1 if positive, 0 if zero, and -1 if negative
 *  Examples: sign(130) = 1
 *            sign(-23) = -1
 *  Legal ops: ! ~ & ^ | + << >>
 *  Max ops: 10
 *  Rating: 2
 */

// concept

// !!0 → No → 0
// !!5 → Yes → 1
// !!-8 → Yes → 1

#include <stdio.h>

int sign(int x) {

    return (x >> 31) | !!x;
}

int main() {
    int a;
    scanf("%d", &a);

    printf("%d\n", sign(a));

    return 0;
}