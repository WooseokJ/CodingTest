package killingcamp.완탐.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class permutation_sequence {
    public static void main(String[] args) {
        System.out.println(getpermutation(3,3));
    }

    private static String getpermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for(int i = 1; i <= n ;i ++)
            nums.add(i);

        StringBuilder ans = new StringBuilder();
        while(n > 1) {
            int page = factorial(n-1);
            int idx = (k-1) / page ;
            k = (k-1) % page + 1;
            ans.append(nums.get(idx));
            nums.remove(idx);
            n--;
        }
        ans.append(nums.get(0));
        return ans.toString();
    }
    private static int factorial(int n) {
        if(n == 1 || n == 0) return 1;
        return n * factorial(n-1);
    }


}
