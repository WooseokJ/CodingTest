package killingcamp.완탐.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class permutations {
    public static void main(String[] args) {
        int[] nums ={1,2,3};
        System.out.println(permute(nums));

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
}
