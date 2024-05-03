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

        System.out.println(binary_search(arr, 9));

    }
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


}
