package basic.base.option;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.ToIntFunction;

public class 람다와메서드레퍼런스 {
    public static void main(String[] args) {
        // 메서드 인자로 값, 참조같이 메서드를 파라미터로 넘기려면?
        // -> 직접 파라미터 넘기는건 x
        // -> 함수형 인터페이스: 딱하나의 추상 메서드를 갖는 인터페이스를 의미.
        func((new RunnableImpl()));


        /** 여기서 매번 함수형 interface구현후 넘겨주는건 비효율.
         * 람다식사용전: 선언과 동시에 익명클래스 사용해 사용.
         *
         * */
        func(new RunnableImpl() {
           @Override
           public void run() {
               System.out.println("run B");
           }
        });


        /**람다식 사용후 (java 8 이후)
         * */
        func( () -> {
            System.out.println("run C");
        });


        /**람다 표현식 */
        // (str, arg2) -> { // 코드 }
        // str -> {return str.length()} // 파라미터 1개면 () 생략 가능
        // str -> str.length() // 한줄 return은 {}, return 생략가능.
        ToIntFunction<String> fc = (str) -> str.length();


        // 메서드 레퍼런스
        Consumer<String> consumer = str -> {
            System.out.println();
        };
        Consumer<String> consumer1 = System.out::println; // 이렇게 교체가능.(메서드 레퍼런스 사용)
        // 타입::메서드 형태로 사용함.
        // System.out(인스턴스)::println(메서드)




    }
    // 함수형 인터페이스
    @FunctionalInterface
    static public interface RunInterface {
        public abstract void run();
    }

    static public class RunnableImpl implements RunInterface {
        @Override
        public void run() {
            // RunnableImpl는 run()메서드를 넘겨받음
            System.out.println("run A");
        }
    }

    static void func(RunInterface runInterface) {
        runInterface.run();// 메서드 호출
    }
}

