package killingcamp.완탐.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class binsearch {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        // int[] -> List<Intger> , Collections.sort(nums) 쓰려고 이유: int[]는 안에 못넣어
        List<Integer> arr = new ArrayList<>();
        for (int num: nums) {
            arr.add(num);
        }

        // 반복문 풀이
        System.out.println(binary_search(arr, 9));




        // 재귀 풀이
        int l = 0, r = arr.size() - 1;
        Collections.sort(arr);
        System.out.println(binary_search_recur(arr, 9, l, r));

    }
    // 반복문
    public static int binary_search(List<Integer> nums, int target) {
        Collections.sort(nums);
        int l = 0, r = nums.size() - 1;
        while(l <= r) {
            int mid = (l+r) / 2;
            if(nums.get(mid) < target) {
                l = mid - 1;
            }else if(nums.get(mid) > target) {
                r = mid - 1;
            } else{
                return mid;
            }
        }
        return -1;
    }
    // 재귀
    public static int binary_search_recur(List<Integer> nums, int target, int l , int r) {

        if(l > r ) {
            return -1;
        }
        int mid = (l + r) / 2;
        if( nums.get(mid) < target) {
            l = mid + 1;
            return binary_search_recur(nums, target, l , r);
        } else if (nums.get(mid) > target) {
            r = mid - 1;
            return binary_search_recur(nums, target, l, r);
        } else{
            return mid;
        }


    }


}
