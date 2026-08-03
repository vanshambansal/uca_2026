#include <stdio.h>
#include <time.h>
#include <stdlib.h>

int partion(int *arr, int low, int high) {

    int randomIndex = low + rand() % (high - low + 1);

    int temp = arr[randomIndex];
    arr[randomIndex] = arr[low];
    arr[low] = temp;

    int a = arr[low];
    int x = low;

    for(int i = low + 1; i <= high; i++) {
        if(arr[i] < a) {
            x++;
            int temp = arr[x];
            arr[x] = arr[i];
            arr[i] = temp;
        }
    }
    temp = arr[low];
    arr[low] = arr[x];
    arr[x] = temp;
    
    return x;

}

void quickSelect(int *arr, int low, int high, int k) {

    if(low < high) {
        int partionIndex = partion(arr, low, high);
        if(partionIndex == k) {
            return;
        } else if(partionIndex > k) {
            quickSelect(arr, low, partionIndex - 1, k);
        } else {

            quickSelect(arr, partionIndex + 1, high, k);            
        }
    }

}

int main() {

    srand(time(NULL));
    int arr[] = {5, 4, 3, 2, 1};
    int n = 5;
    int k = 3;

    quickSelect(arr, 0, n - 1, k - 1);

    for(int i = 0; i < k; i++) {
        printf("%d\n",arr[i]);
    }

    return 0;
}