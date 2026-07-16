#include<stdio.h>

int main(){

    // brute force

    // int a =0;
    // int b=1;
    // int n;
    // scanf("%d",&n);
    // int sum =0;

    // while(b<=n){
    //     if(b%2==0){
    //         sum+=b;
    //     }
    //     int temp = a+b;
    //     a=b;
    //     b=temp;
        
    // }

    // printf("sum of even no.s in fib series is %d.",sum);


    // optimal solution(see the pattern in even numbers)
    // E(n) = 4 × E(n−1) + E(n−2)

    int first_even =0;
    int second_even = 2;
    int n;
    scanf("%d",&n);
    int sum =0;

    while(first_even<=n){
        sum+=first_even;
        int next = 4*second_even + first_even;
        first_even = second_even;
        second_even= next;
    }

    printf("sum of even no.s in fib series is %d.",sum);
    

    return 0;
}
