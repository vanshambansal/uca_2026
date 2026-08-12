#include<stdio.h>
#include<time.h>
#include<stdlib.h>
#include <stdbool.h> 

void generateRandom(int arr[], int n){
    
    for(int i=0;i<n;i++){
        arr[i] = rand() % 10000;
    }
}

