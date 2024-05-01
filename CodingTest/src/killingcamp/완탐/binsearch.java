package killingcamp.완탐;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class binsearch {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(32);
        nums.add(93);
        nums.add(-2);
        nums.add(0);
        nums.add(84);
        nums.add(2023);
        bin_search(nums, 0);

    }
    public static void bin_search(List<Integer> nums, int target) {

        Collections.sort(nums);

        int l = 0, r = nums.size() - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if(target > nums.get(mid)) {
                l = mid + 1;
            } else if(target < nums.get(mid)) {
                r = mid - 1;
            } else {
                System.out.printf("찾음");
                return;

            }
        }

        System.out.println("target이 nums에 없다.");

    }
}
