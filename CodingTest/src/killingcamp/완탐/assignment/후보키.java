package killingcamp.완탐.assignment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 후보키 {
    public static void main(String[] args) {
        String[][] relations = {
                {"100","ryan","music","2"},
                {"200","apeach","math","2"},
                {"300","tube","computer","3"},
                {"400","con","computer","4"},
                {"500","muzi","music","3"},
                {"600","apeach","music","2"}
        };
        System.out.println(solution(relations));
    }

    public static int solution(String[][] relations) {
        List<List<Integer>> ans = new ArrayList<>();
        int colLen = relations[0].length;
        // 1부터 n까지 부분집합
        for(int colcnt = 1; colcnt < colLen; colcnt++) {
            combinations(new ArrayList<>(), 0, colcnt, relations, ans);
        }
        return ans.size();
    }

    public static void combinations(List<Integer> curr, int start, int k,
                                    String[][] relations, List<List<Integer>> ans) {
        int rowLen = relations.length;
        int colLen = relations[0].length;
        if(curr.size() == k) {
            // 최소성, 유일성 둘중하나 만족안하면 답에 추가안함.
            if(!unique(curr, relations) || !minimalchekc(curr, ans)) {
                return;
            }
            ans.add(new ArrayList<>(curr));
            return ;

        }
        for(int i = start; i < colLen; i++) {
            curr.add(i);
            combinations(curr, i+1, k, relations, ans);
            curr.remove(curr.size()-1);
        }
    }

    // 유일성 검사
    public static boolean unique(List<Integer> curr, String[][] relations) {

        List<String> uniqueValArr = new ArrayList<>();
        int rowLen = relations.length;
        // 튜플 개수만큼 검사.
        for(int row = 0; row < rowLen; row ++ ){
            StringBuilder sb = new StringBuilder();
            for(Integer col: curr) {
                sb.append(relations[row][col]);
            }

            String element = sb.toString();

            if(!uniqueValArr.contains(element)) {
                uniqueValArr.add(element);
            } else{ //유일성을 만족안하므로 false 반환.
                return false;
            }
        }
        return true;

    }

    // 최소성 검사
    public static boolean minimalchekc(List<Integer> curr, List<List<Integer>> ans) {

        for(List<Integer> key: ans) {
            if(curr.containsAll(key)) { // 최소성을 만족안하므로 false;
                return false;
            }
        }
        return true;
    }


}
