package killingcamp.완탐.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class combinations {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> elements = new LinkedList<>();
        // 4개중 2개 조합 선택. (1,2,3,4)
        int n = 4;
        int k = 2;
        dfs(result, elements, n,1, k);
        System.out.println(result);
    }
    public static void dfs(List<List<Integer>> result, List<Integer> elements, int n, int start, int k) {
        // k번쨰 노드 도달시 결과 추가
        if(k == 0) {
            List<Integer> collect = elements.stream().collect(Collectors.toList());
            result.add(collect);
        }

        for(int i = start; i <= n; i++) {
            elements.add(i);
            dfs(result, elements, n, i+1, k-1);
            elements.removeLast();
        }
    }
}
