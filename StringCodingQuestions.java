import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringCodingQuestions {


    //Question1
    public static String reverseOnlyCharacters(String input){
        char[] charArray = input.toCharArray();
        int left = 0;
        int right = charArray.length-1;
        while(left<right){
            if(!Character.isLetter(charArray[left])){
                left++;
            }else if(!Character.isLetter(charArray[right])) {
                right--;
            }else{
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
                left++;
                right--;
            }
        }

        return new String(charArray);
    }

    public static void reverseOnlyCharacters_tests(){
        System.out.println("Reversed Character only: "+reverseOnlyCharacters("a1b2cd3"));
        System.out.println("Reversed Character only: "+reverseOnlyCharacters("1ab2"));
        System.out.println("Reversed Character only: "+reverseOnlyCharacters("1234"));
        System.out.println("Reversed Character only: "+reverseOnlyCharacters("abcd"));
    }

    //Question2
    public static String reverseOnlyVowels(String input){
        char[] charArray = input.toCharArray();
        int left = 0;
        int right = charArray.length-1;
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        while(left<right){
            if(!vowels.contains(charArray[left])){
                left++;
            }else if(!vowels.contains(charArray[right])){
                right--;
            }else{
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
                left++;
                right--;
            }
        }
        return new String(charArray);
    }

    public static void reverseOnlyVowels_tests(){
        System.out.println("Reversed Vowels only: "+reverseOnlyCharacters("a1b2ci3"));
        System.out.println("Reversed Vowels only: "+reverseOnlyCharacters("1ei2"));
        System.out.println("Reversed Vowels only: "+reverseOnlyCharacters("1234"));
        System.out.println("Reversed Vowels only: "+reverseOnlyCharacters("ueia"));
    }

    public static void main(String[] args) {
        reverseOnlyCharacters_tests();
        reverseOnlyVowels_tests();

    }
}
