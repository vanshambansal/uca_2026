/* 
 * logicalShift - shift x to the right by n, using a logical shift
 *   Can assume that 0 <= n <= 31
 *   Examples: logicalShift(0x87654321,4) = 0x08765432
 *   Legal ops: ~ & ^ | + << >>
 *   Max ops: 20
 *   Rating: 3 
 */

//  by logical shift it means if there is 1 in msb and we right shift it there should be 0 instead of 1

#include<stdio.h>

int logicalShift(int a, int n) {
    
    int mask = ((1 << 31) >> n) << 1;
    return (a >> n) & (~ mask);
}

int main() {
    int a;
    int b;
    scanf("%d %d", &a, &b);

    printf("%d\n", logicalShift(a, b));
}   