package killingcamp.큐스택그래프.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class twosum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        System.out.println(twoSum(nums, 9));


    }
    // two pointer
    public static int[] twoSum(int[] nums, int target) {

        int n = nums.length;
        // 숫자, 인덱스
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        int l =0;
        int r = arr.length - 1;
        while(l < r) {
            int sum = arr[l][0] + arr[r][0];
            if(sum == target) {
                return new int[]{arr[l][1] , arr[r][1]};
            } else if(sum < target) {
                l +=1;
            } else {
                r -=1;
            }
        }
        return new int[] {-1,-1};


    }
}
