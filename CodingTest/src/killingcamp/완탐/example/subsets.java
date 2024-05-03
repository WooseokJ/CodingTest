package killingcamp.완탐.example;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class subsets {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), 0, nums, ans);
        return ans;
    }
    public static void backtrack(List<Integer> curr, int start, int[] nums, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(curr));
        int n = nums.length;
        for(int i= start; i < n ; i++) {
            curr.add(nums[i]);
            backtrack(curr, i+1, nums, ans);
            curr.remove(curr.size() - 1);
        }
    }

}
