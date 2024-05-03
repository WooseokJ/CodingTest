package killingcamp.큐스택그래프.example;

import java.util.Stack;

public class valid_Parenthese {
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}}"));

    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int strLen = s.length();

        for(int i= 0; i < strLen; i++) {
            char keyword = s.charAt(i);
            if(keyword == '(') {
                stack.push(')');
            } else if(keyword == '{') {
                stack.push('}');
            } else if (keyword == '[') {
                stack.push(']');
            } else {
                // peek: 값만 반환 (값빼진 x)
                // pop: 값뺴고 값도 반환.
                if(!stack.isEmpty() && stack.peek() == keyword) {
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
