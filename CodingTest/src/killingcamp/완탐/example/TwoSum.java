package killingcamp.완탐.example;


public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        twoSum(nums, 9);



    }
    // 반복문(완탐)
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for(int i = 0; i < n ; i++) {
            for (int j = i + 1;j < n;j++){
                int sum = nums[i] + nums[j];
                if(sum == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}

