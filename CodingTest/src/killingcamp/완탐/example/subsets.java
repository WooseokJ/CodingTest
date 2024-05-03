package killingcamp.완탐.example;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class subsets {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        int[] nums = {1,2,3};
        Deque<Integer> path = new ArrayDeque<>();
        dfs(result, nums,0, path);
        System.out.println(result);
    }
    public static void dfs(List<List<Integer>> result, int[] nums, int index, Deque<Integer> path) {
        // 모든 탐색경로 매번 추가
        List<Integer> addElements = new ArrayList<>(path);
        result.add(addElements);

        int n = nums.length;
        for(int i = index; i < n ; i++) {
            path.add(nums[i]);
            dfs(result, nums, i+1, path);
            path.removeLast();
        }

    }

}
