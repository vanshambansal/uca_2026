// Problem Statement
// You are given n villages and must open k clinics across them. The population of each village is provided, and initially, no village has a clinic.

// Distribute the k clinics among the villages while satisfying the following conditions:

// Every village must have at least one clinic.
// Residents can only visit clinics within their own village (no travel between villages is allowed).
// Clinics in the same village share the village's population equally.
// Allocate the clinics such that the maximum patient load on any single clinic is minimized.
// Given that k ≥ n, return the minimum possible maximum load on any clinic.



#include <stdio.h>

int size = 0;

int sizeOf () {
    return size;
}

int largest (int *heap, int i, int j) {
    if(heap[i] >= heap[j]) {
        return i;
    }
    else {
        return j;
    }
}

void swap (int *heap, int a, int b) {
    int temp = heap[a];
    heap[a] = heap[b];
    heap[b] = temp;
}

void swim (int *heap) {

    int n = sizeOf();

    int i = n;

    while(i > 0) {
        int p1 = (i - 1) / 2;

        if(heap[i] > heap[p1]) {
            swap(heap, i, p1);
        } else {
            break;
        }
        i = p1;
    }

}

void sink (int *heap) {

    int n = sizeOf();
    int i = 0;

    while (i < n) {
        int rc = 2*i + 1;
        int lc = 2*i + 2;

        if((rc < n && lc < n) && (heap[i] < heap[rc] && heap[i] < heap[lc])) {
            int small = largest(heap, rc, lc);
            swap(heap, small, i);
            i = small;
        } 
        else if (rc < n && heap[i] < heap[rc]) {
            swap(heap, rc, i);
            i = rc;
        }
        else if (lc < n && heap[i] < heap[lc]) {
            swap(heap, lc, i);
            i = lc;
        }
        else {
            break;
        }

    }

}


int getMax (int * heap) {
    int n = sizeOf() - 1;
    if (n >= 0) {
        return heap[0];
    } else {
        return -1;
    }
}

void deleteMax(int *heap) {

    int n = sizeOf() - 1;
    swap(heap, 0 , n);

    size--;
    sink(heap);
}


void insert (int *heap, int element) {

    int n = sizeOf();
    heap[n] = element;
    int p1 = (n - 1) / 2;
    if (p1 >= 0 && heap[p1] < heap[n]) {
        swim(heap);
    }
    size++;
}

void print (int * arr) {

    for(int i = 0; i < sizeOf(); i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

int main () {

    int n = 3;
    int k = 5;
    int population[] = {200, 20, 50};

    int heap[100];
    k -= n;

    for(int i = 0; i < n; i++) {
        insert(heap, population[i]);
    }

    while (k > 0) {
        int maxi = getMax(heap);
        deleteMax(heap);
        int nextMax = getMax(heap);
        int a = 1;
        while(a <= k && nextMax < (double)(maxi / (a + 1))) {
            a++;
        }
        printf("%d \n", a);
        double divide = maxi /(double) a;
        printf("%f\n", divide);
        for(int i = 0; i <=a; i++) {
            
            insert(heap, divide);
        }
        k -= a;
    }
    print(heap);

    printf("%d\n", getMax(heap));



    return 0;
}
