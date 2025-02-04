import java.util.*;

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
        System.out.println("Reversed Vowels only: "+reverseOnlyVowels("a1b2ci3"));
        System.out.println("Reversed Vowels only: "+reverseOnlyVowels("1ei2"));
        System.out.println("Reversed Vowels only: "+reverseOnlyVowels("1234"));
        System.out.println("Reversed Vowels only: "+reverseOnlyVowels("ueia"));
    }

    //Question3
    public static void countCharacterFrequencyInString(String input){
        char[] inputArray = input.toCharArray();
        HashMap<Character,Integer> charCount = new HashMap<Character,Integer>();
        for(int i=0;i<inputArray.length;i++){
            if(!charCount.containsKey(inputArray[i])){
                charCount.put(inputArray[i],1);
            }else{
                int count = charCount.get(inputArray[i]);
                charCount.replace(inputArray[i],count+1);
            }
        }
        for(Map.Entry<Character, Integer> map : charCount.entrySet()){
            System.out.println(map.getKey()+":"+map.getValue());
        }
        System.out.println();
    }

    public static void countCharacterFrequencyInString_tests(){
        countCharacterFrequencyInString("abcd");
        countCharacterFrequencyInString("aabbdddeec");
        countCharacterFrequencyInString("uaidad");
        countCharacterFrequencyInString("uiuiuiryryr");
    }

    //Question4
    public static String replaceVowelsWithX(String input){
        char[] inputArray = input.toCharArray();
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        for(int i=0;i<inputArray.length;i++){
            if(vowels.contains(inputArray[i])){
                inputArray[i] = 'x';
            }
        }
        return new String(inputArray);
    }

    public static void replaceVowelsWithX_tests(){
        System.out.println("Replace Vowels with x: "+replaceVowelsWithX("a1b2ci3"));
        System.out.println("Replace Vowels with x: "+replaceVowelsWithX("abcdef"));
        System.out.println("Replace Vowels with x: "+replaceVowelsWithX("uierya"));
        System.out.println("Replace Vowels with x: "+replaceVowelsWithX("123u45e678a"));
    }

    //Question5
    public static Boolean checkIfPangram(String input){
        Set<Character> pangramCheck = new HashSet<>();
        int count = 0;
        input = input.toLowerCase();
        for(int i=0;i<input.length();i++){
            if(Character.isLetter(input.charAt(i))){
                count++;
            }
        }
        if(count<26){
            System.out.println("Count is : "+count);
            return false;
        }
        for(int i=0;i<input.length();i++){
            if(!Character.isAlphabetic(input.charAt(i))){
                continue;
            }else{
                if(pangramCheck.contains(input.charAt(i))){
                    continue;
                }else{
                    pangramCheck.add(input.charAt(i));
                }
            }
        }
        if(pangramCheck.size()==26){
            return true;
        }else{
            return false;
        }
    }

    public static void checkIfPangram_tests(){
        System.out.println("Replace Vowels with x: "+checkIfPangram("a1b2ci3"));
        System.out.println("Replace Vowels with x: "+checkIfPangram("abcdef"));
        System.out.println("Replace Vowels with x: "+checkIfPangram("uierya"));
        System.out.println("Replace Vowels with x: "+checkIfPangram("123u45e678a"));
        System.out.println("Replace Vowels with x: "+checkIfPangram("The quick brown fox jumps over the lazy dog."));
        System.out.println("Replace Vowels with x: "+checkIfPangram("abcdefghijklmnopqrstuvwxyZ"));
    }

    public static void main(String[] args) {
        reverseOnlyCharacters_tests();
        reverseOnlyVowels_tests();
        countCharacterFrequencyInString_tests();
        replaceVowelsWithX_tests();
        checkIfPangram_tests();
    }
}
