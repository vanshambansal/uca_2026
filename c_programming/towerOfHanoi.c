#include<stdio.h>

void toh(int n , char F , char T, char H){

    if(n==0)return;
    toh(n-1, F, H, T);
    printf("%c-%c\n",F,T);
    toh(n-1, H, T, F);
}

int main(){
    toh(3, 'A', 'B', 'C');

    return 0;
}