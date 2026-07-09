    #include<stdio.h>
    #include<time.h>
    #include<stdlib.h>
    #include <stdbool.h> 

    void generateRandom(int arr[], int n){
        
        for(int i=0;i<n;i++){
            arr[i] = rand() % 10000;
        }
    }
    void generateAccending(int arr[], int n){

        for(int i=0;i<n;i++){
            arr[i]=i;
        }
    }
    void generateDecending(int arr[], int n){
        
        for(int i=0;i<n;i++){
            arr[i]=n-i-1;
        }
    }
    void bubbleSort(int arr[], int n){

        for(int i=0; i<n-1; i++){
            bool swap = false;
            for(int j=0; j<n-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap = true;

                }
            }
            if(!swap)break;
        }
    }

    void selectionSort(int arr[], int n){

        for(int i=0; i<n-1; i++){
            int minIndex = i;

            for(int j=i+1; j<n; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }

            if(minIndex != i){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    void merge(int arr[], int left, int mid, int right){

        int temp[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;

        while(i <= mid && j <= right){
            if(arr[i] <= arr[j]){
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while(i <= mid){
            temp[k] = arr[i];
            i++;
            k++;
        }

        while(j <= right){
            temp[k] = arr[j];
            j++;
            k++;
        }

        for(int x = 0; x < k; x++){
            arr[left + x] = temp[x];
        }
    }

    void mergeSortHelper(int arr[], int left, int right){

        if(left < right){
            int mid = left + (right - left) / 2;
            mergeSortHelper(arr, left, mid);
            mergeSortHelper(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    void mergeSort(int arr[], int n){
        mergeSortHelper(arr, 0, n - 1);
    }

    int partition(int arr[], int low, int high){

        int pivot = arr[high];
        int i = low - 1;

        for(int j=low; j<high; j++){
            if(arr[j] <= pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    void quickSortHelper(int arr[], int low, int high){

        if(low < high){
            int pivotIndex = partition(arr, low, high);
            quickSortHelper(arr, low, pivotIndex - 1);
            quickSortHelper(arr, pivotIndex + 1, high);
        }
    }

    void quickSort(int arr[], int n){
        quickSortHelper(arr, 0, n - 1);
    }

    int main(){

        srand(time(NULL));
        int a = 3000;

        for(int i=0; i<8; i++){

            int arr[a];

            generateDecending(arr, a);
            
            clock_t start, end;

            start = clock();
            bubbleSort(arr , a);
            end = clock();

            double time = 1000.0 * (end - start)/CLOCKS_PER_SEC;

            printf("%.3f\n",time);
            a+=3000;

        }

        return 0;
    }