// Heap sort
// Implement Heap Sort using the following algorithm:

// Convert the input array into a valid max heap by heapifying the array.
// Repeatedly delete the maximum element (n - 1 times) to produce the sorted array.
// Heapify Procedure:

// Starting from the element at index n/2 down to index 0, perform the sink (heapify-down) operation on each element.


#include <stdio.h>

void swap (int *heap, int i , int j) {
    int temp = heap[i];
    heap[i] = heap[j];
    heap[j] = temp;
}

void heapify (int *arr, int i, int n) {

    int left = 2*i + 1;
    int right = 2*i + 2;
    int maxi = i;

    if (left < n && arr[left] > arr[i]) {
        maxi = left;
    }

    if (right < n && arr[right] > arr[maxi]) {
        maxi = right;
    }
    
    if(maxi != i) {
        swap(arr, i, maxi);
        heapify(arr, maxi, n);
    }

}

void heapSort (int *arr, int n) {

    for (int i = n/2 - 1; i >= 0; i--) {
        heapify(arr, i, n);
    }

    for(int i = 0; i < n; i++) {
        swap(arr, 0, n - i - 1);

        heapify(arr, 0, n - i - 1);
    }

}

int main () {

    int arr[] = {3, 2, 6, 1, 7, 4, 5};
    int n = 7;

    heapSort(arr, n);

    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }

    printf("\n");

    return 0;
}