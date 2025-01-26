public class PrimeNumber {

    public static String checkPrime(Integer num){
        if(num<=1){
            return "Not Prime";
        }
        for(int i=2;i<=Math.floor(Math.sqrt(num));i++){
            if(num%i==0){
                return "Not Prime";
            }
        }
        return "Prime";
    }

    public static void main(String[] args) {
        System.out.println(checkPrime(169));
        System.out.println(checkPrime(3));
        System.out.println(checkPrime(131));
    }
}
