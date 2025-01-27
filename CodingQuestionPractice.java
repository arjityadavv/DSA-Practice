import java.net.Inet4Address;
import java.util.*;
import java.util.jar.Attributes;

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

    //Reverse a string preserving space position
    //input - I Am Not String
    //output- g ni rtS toNmAI

    public static String question2(String input){
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

    public static void main(String[] args) {
        System.out.println(Arrays.toString(question1_approachStack(new int[]{-1, 2, -3, -5, 4, -6, 0})));
        System.out.println(Arrays.toString(question1_approachStack(new int[]{-12, 11, -13, -5, 6, -7, 5, -3, -6})));
        System.out.println(Arrays.toString(question1_approachNormal(new int[]{-12, 11, -13, -5, 6, -7, 5, -3, -6})));
        System.out.println(question2("I Am Not String"));
        System.out.println(question2("I Am Arjit Yadav"));
    }
}

