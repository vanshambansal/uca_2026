/* 
 * getByte - Extract byte n from word x
 *   Bytes numbered from 0 (LSB) to 3 (MSB)
 *   Examples: getByte(0x12345678,1) = 0x56
 *   Legal ops: ! ~ & ^ | + << >>
 *   Max ops: 6
 *   Rating: 2
 */

// read the ques carefully we need to extract the byte

#include<stdio.h>

int getByte(int a, int n) {
    
    return (a >> (n << 3)) & 0xff;
}

int main() {
    int a;
    int b;
    scanf("%d %d", &a, &b);

    printf("%d\n", getByte(a, b));
}   