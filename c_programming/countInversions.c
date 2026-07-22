#include<stdio.h>

int mergeHelp(int arr[], int left, int mid, int right, int aux[]) {

    int k = left;
    int i = left;
    int j = mid+1;
    int c = 0;

    while(k <= right) {
        if(i > mid){

            aux[k++] = arr[j++];

        }else if(j > right){

            aux[k++] = arr[i++];
            
        }
        else if(arr[i] <= arr[j]){

            aux[k++] = arr[i++];
            
        }else {
            
            aux[k++] = arr[j++];
            c+=(mid-i+1);

        }
        
    }

    for(int a=left; a<=right; a++){
        arr[a] = aux[a];
    }
    return c;

}

int merge(int arr[], int left, int right, int aux[]){

    if(left >= right)return 0;
    int mid = left + (right-left)/2;
    int count =0;

    count += merge(arr, left, mid, aux);
    count += merge(arr, mid+1, right, aux);
    count += mergeHelp(arr, left, mid, right, aux);

    return count;

}

int main() {

    int arr[] ={3,2,1,4};
    int n = 4;
    int aux[n];
    int ans = merge(arr, 0, n-1, aux);
    printf("%d\n", ans);


    return 0;
}