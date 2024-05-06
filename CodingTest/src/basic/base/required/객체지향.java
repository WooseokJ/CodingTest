package basic.base.required;

import java.util.*;

public class 객체지향 {


    public static void main(String[] args) {
        /** 어떤 구현클래스가 사용되는지 상관없이 기능에만 초점을 맞춤.*/
        //연결리스트 큐
        Queue<String> linked = new LinkedList<>();
        // 동적 배열 큐
        Queue<String> dynamic = new ArrayDeque<>();
        // 우선순위 큐
        Queue<String> priority = new PriorityQueue<>();
//        linked.offer("");
//        dynamic.offer("");
//        priority.offer("");

        /** ArrayDeque(클래스): 큐,스텍,덱등 여러용도 사용가능. (쓰지마)*/
        // 이건 스택?, 큐? , 덱? 알수없어.(쓰지마)
        ArrayDeque<String> ad =new ArrayDeque<>();

        /** Deque(인터페이스) 쓰면 특정클래스 목적 분명히 가능. */
        // 큐 x , 덱으로 사용.
        Deque<String> deque = new ArrayDeque<>();




    }




}
