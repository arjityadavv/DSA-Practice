public class Palindrome {
    public static void main(String[] args) {
        String input = "anamana";
        int strLen = input.length();
        Boolean flag = true;
        for(int i=0;i<input.length()/2;i++){
            if(input.charAt(i)!=input.charAt(strLen-1)){
                flag = false;
                break;
            }
            strLen--;
        }
        if(flag==true){
            System.out.println("Palindrome");
        }else{
            System.out.println("Not Palindrome");
        }

    }
}
