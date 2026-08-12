// Problem Statement
// You are given n villages and must open k clinics across them. The population of each village is provided, and initially, no village has a clinic.

// Distribute the k clinics among the villages while satisfying the following conditions:

// Every village must have at least one clinic.
// Residents can only visit clinics within their own village (no travel between villages is allowed).
// Clinics in the same village share the village's population equally.
// Allocate the clinics such that the maximum patient load on any single clinic is minimized.
// Given that k ≥ n, return the minimum possible maximum load on any clinic.


// THis ques can also be done using priority queue which i have done in java
https://github.com/vanshambansal/uca_2026/blob/main/java/week_5_assignment/villages.java


#include <stdio.h>

int isValid(int population[], int mid, int k, int n) {
    int a = 0;

    for(int i = 0; i < n; i++) {
        a += (population[i] + mid - 1) / mid;
    }
    if(a <= k) return 1;
    return 0;
}

int main () {

    int n = 3;
    int k = 5;
    int population[] = {200, 20, 50};

    int maxElement = 0;
    for (int i = 0; i < n; i++) {
        if (population[i] > maxElement) {
            maxElement = population[i];
        }
    }

    int low = 1;
    int high = maxElement;

    while ( low < high) {
        int mid = (low + high) / 2;

        if(isValid(population, mid, k, n)) {
            high = mid;
        }
        else {
            low = mid + 1;
        }
    }

    printf("%d\n",low);

    return 0;
}


