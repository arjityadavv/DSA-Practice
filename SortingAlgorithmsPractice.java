import java.util.Arrays;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class SortingAlgorithmsPractice {

    public static void bubbleSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=1;j<arr.length-i;j++){
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
            for(int a:arr){
                System.out.print(a+" ");
            }
            System.out.println();
        }
        for(int a:arr){
            System.out.print(a+" ");
        }
        System.out.println();
    }

    public static void selectionSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int smallest = MAX_VALUE;
            int smallIndex = i;
            for(int j=i;j<arr.length;j++){
                if(arr[j]<smallest){
                    smallest = arr[j];
                    smallIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = smallest;
            arr[smallIndex] = temp;
            for(int a:arr){
                System.out.print(a+" ");
            }
            System.out.println();
        }
        for(int a:arr){
            System.out.print(a+" ");
        }
    }

    public static void sort(int[] arr){
        if(arr.length<2){
            return;
        }
        int middle = arr.length/2;
        int[] left = new int[middle];
        int[] right = new int[arr.length-middle];
        for(int i=0;i<middle;i++){
            left[i] = arr[i];
        }
        for(int i=middle;i<arr.length;i++){
            right[i-middle] = arr[i];
        }
        sort(left);
        sort(right);
        merge(left,right,arr);
    }

    public static void merge(int[] left, int[] right, int[] arr){
        int i=0;
        int j=0;
        int k=0;
        while(i<left.length && j<right.length){
            if(left[i]<=right[j]){
                arr[k++] = left[i++];
            }else{
                arr[k++] = right[j++];
            }
        }
        while(j<right.length){
            arr[k++] = right[j++];
        }
        while(i<left.length){
            arr[k++] = left[i++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,4,1,7,5,2};
        System.out.println("Bubble Sort >>>>>>>>>>>");
        bubbleSort(arr);
        arr = new int[]{3, 4, 1, 7, 5, 2};
        System.out.println("Selection Sort >>>>>>>>>>>");
        selectionSort(arr);
        arr = new int[]{4,5,1,9,2};
        System.out.println("\nMerge Sort >>>>>>>>>>>");
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
