import java.util.*;

public class CodingQuestionPractice {

    //Question1
    //move all negative numbers to beginning and positive after that maintaining order
    //this is with stack
    public static int[] question1_approachStack(int[] arr){
        Stack<Integer> negatives = new Stack<>();
        Stack<Integer> positives = new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]<0){
                negatives.push(arr[i]);
            }else{
                positives.push(arr[i]);
            }
        }
        int[] newArr = new int[arr.length];
        for(int i=0;i<newArr.length;i++){
            if(!negatives.isEmpty()){
                newArr[i]=negatives.pop();
            }else if(!positives.isEmpty()){
                newArr[i]=positives.pop();
            }
        }
        return newArr;
    }

    //this is with n*n approach
    public static int[] question1_approachNormal(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=1;j<arr.length-i;j++){
                if(arr[j]<0 && arr[j-1]>=0){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    //Reverse a string preserving space position using n*n approach
    //input - I Am Not String
    //output- g ni rtS toNmAI

    public static String question2(String input){
        System.out.println("question2 >>>>>>>>>>>>>>>>>>");
        List<Integer> space = new ArrayList<>();
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)==' '){
                space.add(i);
            }
        }
//        System.out.println("SET: "+space);
        input = input.replace(" ","");
        StringBuilder sb = new StringBuilder(input);
        input = sb.reverse().toString();
        StringBuilder sb1 = new StringBuilder();
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<input.length();i++){
            if(space.contains(i)){
                sb1.append(" ");
                set.add(i);
                    for(int j=0;j<space.size();j++){
                        if(!set.contains(space.get(j))){
                            space.set(j,space.get(j)-1);
                        }
                    }
            }
            sb1.append(input.charAt(i));
//            System.out.println(Arrays.toString(space.toArray()));
        }
        return sb1.toString();
    }

    //Reverse a string preserving space position using stack approach
    //input - I Am Not String
    //output- g ni rtS toNmAI

    public static String question2Stack(String input){
        System.out.println("question2Stack >>>>>>>>>>>>>>>>>>");
        if(input.length()==0){
            return "Input String Blank";
        }
        Stack<Character> stack = new Stack<>();
//        Character[] output = new Character[input.length()];
        String output = "";
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)!=' '){
                stack.push(input.charAt(i));
            }
        }

        if(stack.isEmpty()){
            return input;
        }

        for(int i=0;i<input.length();i++){
            if(input.charAt(i)==' '){
                output = output + ' ';
            }else{
                output = output + stack.pop();
            }
        }
        return output;
    }

    //Given an array of strings strs, group the anagrams together.
    //(need to cover all the test cases with time and space complexity)
    // Input: strs = ["eat","tea","tan","ate","nat","bat"]
    // Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    public static List<List<String>> question3(List<String> strList){
        List<List<String>> output = new ArrayList<>();
        Set<Integer> done = new HashSet<>();
        for(int i=0;i<strList.size();i++){
            if(done.contains(i)){
                continue;
            }
            done.add(i);
            List<String> currentList = new ArrayList<>();
            if(!currentList.contains(strList.get(i))){
                currentList.add(strList.get(i));
            }
            for(int j=i;j<strList.size();j++){
                if(done.contains(j)){
                    continue;
                }
                if(j!=strList.size()-1 && anagramCheck(strList.get(i),strList.get(j))){
                    done.add(j);
                    currentList.add(strList.get(j));
                }
            }
            output.add(currentList);
        }

        return output;
    }

    public static Boolean anagramCheck(String s1, String s2){
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1,c2);
    }

    //Print all subarrays with 0 sum
    // Input: arr = [6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7]
    // Output:
    // Subarray found from Index 2 to 4
    // Subarray found from Index 2 to 6
    // Subarray found from Index 5 to 6
    // Subarray found from Index 6 to 9
    // Subarray found from Index 0 to 10
    public static void question4_subArraysWithZeroSum(int[] arr){
        List<List<Integer>> finalList = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            int sum = arr[i];
            if(sum==0){
                List<Integer> found = new ArrayList<>();
                found.add(i);
                found.add(i);
                finalList.add(found);
            }
            for(int j=i+1;j<arr.length;j++){
                sum = sum + arr[j];
                if(sum==0){
                    List<Integer> found = new ArrayList<>();
                    found.add(i);
                    found.add(j);
                    finalList.add(found);
                }
            }
        }
        if(!finalList.isEmpty()){
            for(List<Integer> ele : finalList){
                System.out.println("Subarray found from Index "+ele.get(0)+" to "+ele.get(1));
            }
        }else{
            System.out.println("No SubArray found!");
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

    }

    // Write a function in your preferred programming language to perform string compression. The function should take a string as input and return a compressed version of the string. The compression works as follows:
    //Consecutive occurrences of the same character are replaced by the character followed by the count of its occurrences.
    //If a character appears only once, it is left as is (no count is appended).
    // Input: aaabbbacfwww
    // Output: a3b3acfw3
    public static String question5_stringCompression(String input){
        String output = "";
        for(int i=0;i<input.length();i++){
            int count = 1;
            for(int j=i+1;j<input.length();j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    count++;
                    if(j==input.length()-1){
                        if(count>1){
                            output = output + input.charAt(i)+count;
                        }else{
                            output = output + input.charAt(i);
                        }
                        i = input.length();
                    }
                } else {
                    if(count>1){
                        output = output + input.charAt(i)+count;
                    }else{
                        output = output + input.charAt(i);
                    }

                    i = j - 1;
                    break;
                }
            }
        }
        return output;
    }

    //Write a function to find the first non-repeating character in a given string s and return its index. If all characters are repeating or the string is empty, return -1.
//    public static Integer firstNonRepeatingIndex(String s){
//        int count = 0;
//        for(int i=0;i<s.length();i++){
//            if(i==s.length()-1){
//                return i;
//            }
//            if(count==0 && s.charAt(i)!=s.charAt(i+1)){
//                return i+1;
//            }else{
//                count++;
//            }
//        }
//        return -1;
//    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(question1_approachStack(new int[]{-1, 2, -3, -5, 4, -6, 0})));
        System.out.println(Arrays.toString(question1_approachStack(new int[]{-12, 11, -13, -5, 6, -7, 5, -3, -6})));
        System.out.println(Arrays.toString(question1_approachNormal(new int[]{-12, 11, -13, -5, 6, -7, 5, -3, -6})));
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(question2("I Am Not String"));
        System.out.println(question2("I Am Arjit Yadav"));
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(question2Stack("I Am Not String"));
        System.out.println(question2Stack("I Am Arjit Yadav"));
        System.out.println(question2Stack(""));
        System.out.println(question2Stack(" "));
        System.out.println(question2Stack("ABC"));
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(question3(Arrays.asList("eat","tea","tan","ate","nat","bat")));
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        question4_subArraysWithZeroSum(new int[]{6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7});
        question4_subArraysWithZeroSum(new int[]{1,2,3,4,5});
        question4_subArraysWithZeroSum(new int[]{0,0,0});
        question4_subArraysWithZeroSum(new int[]{5,-5,0});
        question4_subArraysWithZeroSum(new int[]{3, -3, -3, -3, -3, -3});
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(question5_stringCompression("aaabbbacfwww"));
        System.out.println(question5_stringCompression("aaabbbcccccdddd"));
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//        System.out.println(firstNonRepeatingIndex("aabbccd"));

    }
}

