// /* 
//  * bitAnd - x&y using only ~ and | 
//  *   Example: bitAnd(6, 5) = 4
//  *   Legal ops: ~ |
//  *   Max ops: 8
//  *   Rating: 1
//  */

#include<stdio.h>

int bitAnd(int a, int b) {
    int notA = ~a;
    int notB = ~b;

    return ~(notA | notB);
}

int main() {
    int a;
    int b;
    scanf("%d %d", &a, &b);

    printf("%d\n", bitAnd(a, b));
}   