import java.net.Inet4Address;
import java.util.PriorityQueue;

public class SearchAlgorithmPractice {

    public static int linearSearch(int[] arr, int ele){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==ele){
                return i;
            }
        }
        return -1;
    }

    //without recursion
    public static int binarySearch(int[] arr, int ele){
        int left = 0;
        int right = arr.length-1;
        int middle;
        while(left<=right){
            middle = left+right/2;
            if(arr[middle]==ele){
                return middle;
            }else if(arr[middle]>ele){
                right = middle -1;
            }else{
                left =  middle + 1;
            }
        }
        return -1;
    }

    public static int binarySearchWithRecursion(int[] arr, int ele, int left, int right){
        if(right<left){
            return -1;
        }
        int middle = left+right/2;
        if(arr[middle]==ele){
            return middle;
        }else if(arr[middle]>ele){
            right = middle - 1;
            return binarySearchWithRecursion(arr,ele,left,right);
        }else{
            left = middle + 1;
            return binarySearchWithRecursion(arr,ele,left,right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,2,5,1,7,3};
        System.out.println("Linear Search >>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(linearSearch(arr,3));
        System.out.println("Binary Search >>>>>>>>>>>>>>>>>>>>>>>>");
        SortingAlgorithmsPractice.mergeSort(arr);
        System.out.println(binarySearch(arr,9));
        System.out.println(binarySearch(arr,3));
        System.out.println(binarySearchWithRecursion(arr,9, 0,arr.length-1));
        System.out.println(binarySearchWithRecursion(arr,3, 0,arr.length-1));
    }
}
