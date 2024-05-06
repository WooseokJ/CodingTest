package basic.base.required;

import java.util.Arrays;
import java.util.Collections;

public class HelperClass {
    public static void main(String[] args) {
        // 정렬, 복사등 헬퍼 클래스에서 지원

        // Arrays: 배열 정렬, 복사, 스트림생성 등
        // Collections: 컬렉션(List, Set) 객체 정렬, 복사 스트림 생성.
        // Math: 수학 연산 메서드 제공.
        int[] nums = {3,5,2,6,7,9};
        Arrays.sort(nums); // 오름차순 2 3 5 6 7 9

        // int[]는 내림차순쓰려면 Integer[] 로 만들기
        Integer[] numsInt = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(numsInt, Collections.reverseOrder()); // 내림차순 9 7 6 5 3 2


        /*
        참고: 자바 데이터타입( 원시 타입, 참조타입)
        원시타입: Int, long, byte, short, float, double, boolean, char
        참조타입: String, ArrayList, int[] , Queue, List, (class, interface, enum ) 타입

        제네릭은 참조타입만 가능
        List<char> (x)
        List<Character> (o)
        **/
    }
}
