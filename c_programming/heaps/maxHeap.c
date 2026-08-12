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

        if(heap[i] < heap[p1]) {
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

    int heap[10];
    insert(heap, 10);
    insert(heap, 7);
    print(heap);
    printf("%d\n", getMax(heap));

    insert(heap, 2);
    print(heap);
    printf("%d\n", getMax(heap));
    deleteMax(heap);
    print(heap);
    printf("%d\n", getMax(heap));

    insert(heap, -1);
    print(heap);


    return 0;
}