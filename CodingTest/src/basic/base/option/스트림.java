package basic.base.option;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class 스트림 {
    public static void main(String[] args) {
        /** stream 사용전: 선언적 코딩하게 도움 */
        List<String> ls = List.of("rabbit", "tiger", "dog", "cat");
        List<String> sorted = new ArrayList<>();
        for (String l : ls) {
            if (l.length() > 3) {
                sorted.add(l.toUpperCase());
            }
        }
        sorted.sort(String:: compareTo);
        for(int i= 0; i< 2; i++) {
            System.out.println(sorted.get(i));

        }
        System.out.println("=========================");

        /** stream 사용후: */
        ls.stream()
                .filter(a -> a.length() > 3) // 조건에 맞게 추려
                .map(String::toUpperCase) // 각 아이템 다른형태로 변환.
                .sorted() // 정렬
                .limit(2) // 상위 몇개 아이템만 순회하게 제한
                .forEach(System.out::println);
        // 중간 메서드: filter, map, sorted, limit
        // 종결 메서드: forEach, toList():스트림을 불변리스트로 변환, count(): item수 반환.


        /** stream 생성 방법 */
        // String[] -> Stream<String>
        // int[], long[], double[] -> IntStream, LongStream, DoubleStream
        String[] strArr = new String[]{"a","b","c"};
        Stream<String> stream = Arrays.stream(strArr);

        int[] intarr = new int[]{1,2,3};
        IntStream intStream = Arrays.stream(intarr);

        // List, Set -> Stream<String> (스트림 생성)
        // 생성한 스트림 -> 원하는걸로 바꾸기 (List, Set은 Stream.collect()로 만들수있어)
        List<String> strList = List.of("a","b","c");
        Stream<String> listStream = strList.stream();
        List<Integer> lengthStrList = listStream
                .map(String::length)
                .collect(Collectors.toList()); // ArrayList인스턴스 생성되서 수정이가능.
//                .toList() //Stream.toList()는 불볍객체라 수정 x


        Set<Integer> intSet = Set.of(1,2,3);
        Stream<Integer> setStream = intSet.stream();

        // 참고: List, Set (interface)은 Collection(interface) 상속받음.
        // Map은 Collection(interface) 상속 x
        // Map<String, Integer> -> Stream<String> , Stream<Integer> , Stream<Map.Entry<String, Integer>>
        Map<String, Integer> map = Map.of("1", 1, "2", 2);
        Stream<String> keyStream = map.keySet().stream();
        Stream<Integer> valueStream = map.values().stream();
        Stream<Map.Entry<String, Integer>> entryStream = map.entrySet().stream();



        /** 요소들 그룹화하기 */
        List<String> str2List = List.of("one", "two", "three", "four", "five");
        Map<Integer, List<String>> group = str2List.stream()
                .collect(Collectors.groupingBy(String::length));  // 글자수따라 그루핑함. , HashMap이 구현체
        // group
        // 3: one, two
        // 4: four, five
        // 5: three

        group.forEach((key, val) -> {
            String join = String.join(",", val);
            System.out.println(join);

        });

        /**특수 스트림*/
        // 숫자형 원시타입만을 요소로 갖으므로 min, max, average, sum 통계 작업메서드 추가가짐
        int[] arr = new int[]{10,20,30,40};
        IntStream intStream1 = Arrays.stream(arr);
        int sum = intStream1.sum();
        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();
        double avg = Arrays.stream(arr).average().getAsDouble();

        // 특수 스트림에 대응하는 래퍼클래스의 일반스트림으로 바꾸고싶다면 boxed() 메서드 사용
        // int[] -> List<Intger>
        int[] arr2 = new int[]{1,2,3};
        List<Integer> list = Arrays.stream(arr2).boxed()
                .collect(Collectors.toList());



    }
}
