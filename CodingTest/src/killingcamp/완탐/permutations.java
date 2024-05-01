package killingcamp.완탐;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> elements = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> preElements = new ArrayList<>();
        dfs(result, preElements, elements);


    }
    public static void dfs(List<List<Integer>> result, List<Integer> preElements, List<Integer> elements) {
        // 리프노드 도달.
        if(elements.isEmpty()) {
            // preElements 내용 결과에 삽입.
            List<Integer> collect = preElements.stream().collect(Collectors.toList());
            result.add(collect);
        }
        // 전달받은  요소들 모두 탐색.
        for(Integer e: elements) {
            // 현재 요소 뺴고 nextElements들로 새로 구성.
            List<Integer> nextElements = new ArrayList<>(elements);
            nextElements.remove(e);

            // preElements에 기존값에 현재 요소 추가
            preElements.add(e);

            //재귀 dfs
            dfs(result, preElements, nextElements);
            // preElements에 현재 요소 삭제
            preElements.remove(e);
        }

    }
}
