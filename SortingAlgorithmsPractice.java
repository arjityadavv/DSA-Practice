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

    public static void main(String[] args) {
        int[] arr = {3,4,1,7,5,2};
        System.out.println("Bubble Sort >>>>>>>>>>>");
        bubbleSort(arr);
        arr = new int[]{3, 4, 1, 7, 5, 2};
        System.out.println("Selection Sort >>>>>>>>>>>");
        selectionSort(arr);
    }
}
