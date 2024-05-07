package killingcamp.완탐.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class permutations {
    public static void main(String[] args) {
        int[] nums ={1,2,3};
//        System.out.println(permute(nums));
        System.out.println(permute2(nums, 2));

    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), nums, ans);
        return ans;
    }
    public static void backtrack(List<Integer> curr, int[] nums, List<List<Integer>> ans) {
        if(curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            System.out.println(ans);
            return;
        }
        for(int num: nums) {
            if(!curr.contains(num)) {
                curr.add(num);
                backtrack(curr, nums, ans);
                curr.remove(curr.size() - 1);
            }

        }
    }



    // n개중 r개 뽑음(n!=r)
    public static List<List<Integer>> permute2(int[] nums, int r){
        List<List<Integer>> ans = new ArrayList<>();
        backtrack2(new ArrayList<>(), nums,r, ans);
        return ans;
    }
    public static void backtrack2(List<Integer> curr, int[] nums, int r, List<List<Integer>> ans) {
        if(curr.size() == r) {
            ans.add(new ArrayList<>(curr));
            return ;
        }
        for (int num : nums) {
            if(!curr.contains(num)) {
                curr.add(num);
                backtrack2(curr, nums, r, ans);
                curr.remove(curr.size()-1);
            }
        }
    }
}
