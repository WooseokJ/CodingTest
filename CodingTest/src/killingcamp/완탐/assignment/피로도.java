package killingcamp.완탐.assignment;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class 피로도 {
    public static void main(String[] args) {
        int[][] dungeons = {
                {80,20},
                {50,40},
                {30,10}
        };
        System.out.println(soultion(80,dungeons));

    }

    public static int soultion(int k, int[][] dungeons) {
        int ans =0 ;
        int temp = k;
        List<List<Integer>> ls = permutations(dungeons);
        for(List<Integer> arr: ls) {
            int sum = 0;
            k = temp;
            for(Integer i: arr) {
                int minRequiredPirodo = dungeons[i][0];
                int consumePirodo = dungeons[i][1];
                if(k>= minRequiredPirodo){
                    sum++;
                    k-= consumePirodo;
                }
                ans = Math.max(ans, sum);

            }

        }
        return ans;
    }
    public static List<List<Integer>> permutations(int[][] dungeons) {
        int[] nums = new int[dungeons.length];
        for(int i= 0; i < dungeons.length; i++) {
            nums[i] = i;
        }
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), nums, ans);
        return ans;
    }
    public static void backtrack(List<Integer> curr, int[] nums, List<List<Integer>> ans) {
        if(curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return ;
        }
        for(int num: nums) {
            if(!curr.contains(num)) {
                curr.add(num);
                backtrack(curr, nums, ans);
                curr.remove(curr.size()- 1);
            }
        }
    }

}
