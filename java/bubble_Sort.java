import java.util.*;
public class bubble_Sort {

    static void bubble_sort(int []arr1 , int n){

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


    static void generate_no(int arr1[] , int n){

        Random random = new Random();
        for(int i=0;i<n;i++){
            arr1[i] = random.nextInt(10000);
        }
    }

    public static void main(String[] args) {

        int n1 = 20000;
        int n2 = 60000;

        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        generate_no(arr1 , n1);
        generate_no(arr2 , n2);

        long start = System.nanoTime();
        bubble_sort(arr1 , n1);
        long end = System.nanoTime();

        double a = (start-end)/1e9;

        start = System.nanoTime();
        bubble_sort(arr2 , n2);
        end = System.nanoTime();

        double b = (start-end)/1e9;

        System.out.println(b/a);

    }
}
