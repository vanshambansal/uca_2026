#include<stdio.h>

int main(){

    int sum =0;
    int a =0;
    int b=1;
    int n;
    scanf("%d",&n);
    for(int i=2;i<=n;i++){
        int temp = a+b;
        a = b;
        b = temp;
        if(temp%2 == 0){
            sum+=temp;
        }
    }
    printf("sum of even no.s in fib series is %d.",sum);

    return 0;
}
