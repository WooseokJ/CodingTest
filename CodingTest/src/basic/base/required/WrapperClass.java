package basic.base.required;

import java.util.ArrayDeque;
import java.util.Queue;

public class WrapperClass {
    public static void main(String[] args) {
        /** 래퍼클래스 기능*/
        // 1. 원시 -> 참조 타입(래퍼클래스)로 만듬.(클래스도 참조타입이다.)
        // 2. 타입변환. ( Integer 래퍼 클래스는 String -> int로 만드는 parseInt()정적메서드 갖고있어.)
        int num = Integer.parseInt("1234");

        /** 원시 - 래퍼 클래스*/
        // int -> Integer
        // char -> Character

        // byte -> Byte
        // short -> Short
        // long -> Long
        // float -> Float
        // double -> Double
        // boolean -> Boolean


        /** 오토 박싱(autoboxing): 원시타입 -> 래퍼클래스 자동변환,
            언박싱(unboxing): 래퍼클래스 -> 원시타입
         이게 있어서 int, Integer를 같은 타입처럼 쓸수있다.
         */

        Integer wrapperInt = Integer.valueOf(3); // int -> Integer
        int primitiveInt = wrapperInt.intValue(); // Integer -> int
        // 매번해주기 귀찮다.  그래서 오토박싱, 언박싱 사용.

        // 오토박싱: 원시타입 -> 래퍼클래스 자동변환
        Integer autoboxed = 3; // Integer.valudOf(3); 과 동일.

        // 언박싱: 래퍼 클래스 -> 원시타입
        Queue<Integer> q = new ArrayDeque<>();
        int val = q.remove(); // q.remove().intValue() 와 동일.





    }
}
