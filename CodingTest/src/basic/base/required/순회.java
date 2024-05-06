package basic.base.required;

import java.util.HashMap;
import java.util.Map;

public class 순회 {
    public static void main(String[] args) {
        /** 순회방법1: for문*/
        int[] array = new int[]{4,10,1};
        // int[], List<>, Set<> 은 가능,
        // Map<>은 안된고 valueds(), keySet(), entrySet() 같이 리스트나 셋 변환후 순회
        for (int i : array) {
            System.out.println(i); // 4 10 1
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (Map.Entry<Integer, Integer> key : map.entrySet()) {
            key.getKey();
            key.getValue();
        }

        /** continue, break 간편히 쓰기위한 outer */
        int[][] arr = new int[][] {
                {10,20,30,40},
                {50,60,70,80},
                {11,22,33,44}
        };
        outer: for(int i =0; i < arr.length; i++) {
            for(int j = 0 ; j < arr[i].length; j++) {
                if(arr[i][j] == 11){
                    System.out.println(arr[i][j]);
                    break outer; // 가장 밖의 for문 벗어남.
                }
            }

        }






    }
}
