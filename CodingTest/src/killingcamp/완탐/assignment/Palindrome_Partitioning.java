package killingcamp.완탐.assignment;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning {
    public static void main(String[] args) {

        System.out.println(partition("aab"));


    }

    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        backtrack(s,0, curr, ans);
        return ans;

    }

    public static void backtrack(String s, int start, List<String> curr, List<List<String>> ans) {
        int strLen = s.length();
        if(start == strLen) {
            ans.add(new ArrayList<>(curr));
            return ;
        }
        for(int i = start; i < strLen; i++) {
            String partitionString = s.substring(start, i+1);
            if(isValid(partitionString)) {
                curr.add(partitionString);
                backtrack(s, i+1, curr, ans);
                curr.remove(curr.size() - 1);
            }

        }

    }
    public static boolean isValid(String str){
        String reverseString = new StringBuilder(str).reverse().toString();
        return str.equals(reverseString);
    }
}
