/* 
 * bang - Compute !x without using !
 *   Examples: bang(3) = 0, bang(0) = 1
 *   Legal ops: ~ & ^ | + << >>
 *   Max ops: 12
 *   Rating: 4 
 */

//  soln --


/*
Idea:
• x | (-x) sets the MSB for every non-zero number.
• >> 31 gives:
      Non-zero -> -1
      Zero     -> 0
• Adding 1 converts:
      -1 -> 0
       0 -> 1
Hence, it behaves exactly like !x.
*/


#include<stdio.h>

int bang(int a) {
    
    int mask = (a | (~ a + 1)) >> 31;
    return mask + 1;
}

int main() {

    int a;
    scanf("%d", &a);

    printf("%d\n", bang(a));

}   