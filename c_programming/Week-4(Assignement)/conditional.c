/* 
 * conditional - same as x ? y : z 
 *   Example: conditional(2,4,5) = 4
 *   Legal ops: ! ~ & ^ | + << >>
 *   Max ops: 16
 *   Rating: 3
 */

#include <stdio.h>

int conditional(int x, int y, int z) {

    int mask = ((!!x) << 31) >> 31;
    
    return (y & mask) | (z & ~mask);
    
}

int main() {
    int a;
    int b;
    int c;
    scanf("%d %d %d", &a, &b, &c);

    printf("%d\n", conditional(a, b, c));
}

