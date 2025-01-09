// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class PracticeCodes {
    public static int arr[] = {1,2,3,4,5};
    public static int sumOfElement(int n){
        if(n==0){
            return arr[n];
        }
        return arr[n] + sumOfElement(n-1);
    }

    public static int factorial(int n){
        if(n==0){
            return 1;
        }
        return n * factorial(n-1);
    }

    public static int fibo(int n){
        if(n==0 || n==1){
            return n;
        }
        return fibo(n-1)+fibo(n-2);
    }

    public static void main(String[] args) {
        System.out.println("Sum of all elements = "+sumOfElement(arr.length-1));
        System.out.println("Factorial = "+factorial(5));
        System.out.println("Fibo element = "+fibo(3));
    }
}