// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

// You must do it in-place.

// Example 1:
// Input:

// matrix = [
//   [1,1,1],
//   [1,0,1],
//   [1,1,1]
// ]
// Output:

// [
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
// ]

// Intuition - 

// We use the first row to remember which columns should become zero and the first column to remember which rows should become zero, while a and b separately remember whether the first row/column themselves originally contained zero.

#include <stdio.h>
#include <stdbool.h>

int main () {

    int matrix[3][3] ={ {1,1,1},
                      {1,0,1},
                      {1,1,1} };
                    
    int n = 3;
    int m = 3;

    bool a = false;
    bool b = false;

    for (int i = 0; i < m; i++) {
        if(matrix[0][i] == 0){
            a = true;
        }
    }

    for (int i = 0; i < n; i++) {
        if(matrix[i][0] == 0){
            b = true;
        }
    }

    for (int i = 1 ; i < n; i++) {
        for(int j = 1; j < m; j++) {
            if(matrix[i][j] == 0) {
                matrix[i][0] = 0;
                matrix[0][j] = 0;
            }
        }
    }

    for (int i = 1; i < m; i++) {
        if(matrix[0][i] == 0){
            int a = 0;
            while (a < n) {
                matrix[a][i] = 0;
                a++;
            }
        }
    }

    for (int i = 0; i < n; i++) {
        if(matrix[i][0] == 0) {
            int a = 0;
            while (a < m){
                matrix[i][a] = 0;
                a++;
            }
        }
    }

    if(a) {
        for (int i = 0; i < m; i++) {
            matrix[0][i] = 0;
        }
                
    }

    if(b) {
        for (int i = 0; i < n; i++) {
            matrix[i][0] = 0;
        }
                
    }


    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            printf("%d ", matrix[i][j]);
        }
        printf("\n");
    }

    return 0;
}

