// #include <stdio.h>
// #include <stdlib.h>
// #include <time.h>

// void generate_numbers(int arr[], int n)
// {
//     for(int i = 0; i < n; i++)
//     {
//         arr[i] = rand() % 100000;
//     }
// }

// void bubble_sort(int arr[], int n)
// {
//     int temp;

//     for(int i = 0; i < n - 1; i++)
//     {
//         for(int j = 0; j < n - i - 1; j++)
//         {
//             if(arr[j] > arr[j + 1])
//             {
//                 temp = arr[j];
//                 arr[j] = arr[j + 1];
//                 arr[j + 1] = temp;
//             }
//         }
//     }
// }

// int main()
// {
//     srand(time(NULL));

//     int size1 = 50000;
//     int size2 = 100000;

//     int arr1[size1];
//     int arr2[size2];

//     generate_numbers(arr1, size1);
//     generate_numbers(arr2, size2);

//     clock_t start, end;

//     // Time for first array
//     start = clock();
//     bubble_sort(arr1, size1);
//     end = clock();

//     double time1 = (double)(end - start) / CLOCKS_PER_SEC;

//     // Time for second array
//     start = clock();
//     bubble_sort(arr2, size2);
//     end = clock();

//     double time2 = (double)(end - start) / CLOCKS_PER_SEC;

//     printf("Time for %d elements = %f seconds\n", size1, time1);
//     printf("Time for %d elements = %f seconds\n", size2, time2);

//     printf("\nRatio = %.2f\n", time2 / time1);

//     return 0;
// }

#include<stdio.h>
#include<time.h>
#include<stdlib.h>

void generate_no(int arr1[] , int n){

    for(int i=0;i<n;i++){
        arr1[i] = rand()%10000;
    }
}

void bubble_sort(int arr1[] , int n){

    for(int i=0;i<n-1;i++){
        for(int j=0;j<n-1-i;j++){
            if(arr1[j]>arr1[j+1]){
                int temp = arr1[j];
                arr1[j] = arr1[j+1];
                arr1[j+1] = temp;
            }
        }
    }

}

int main(){
    
    srand(time(NULL));

    int n1 = 10000;
    int n2 = 30000;

    int arr1[n1];
    int arr2[n2];

    generate_no(arr1 , n1);
    generate_no(arr2 , n2);

    clock_t start, end;

    start = clock();
    bubble_sort(arr1 , n1);
    end = clock();

    double a = (double) (end-start)/CLOCKS_PER_SEC;

    start = clock();
    bubble_sort(arr2 , n2);
    end = clock();

    double b = (end-start)/CLOCKS_PER_SEC;

    printf("%f" , b/a);


    return 0;
}