package basic.base;

public class 문자열처리 {
    public static void main(String[] args) {
        char c = 'a'; // '' 사용
        String str = "abc"; // "" 사용
        String num1 = String.valueOf(3);
        String num2 = String.valueOf(3.2f); // float -> String
        char[] cArr = {'a','b'};
        String s = new String(cArr); // ab
        System.out.println(s + "c"); // abc // 문자 + 문자
        System.out.println(s + 32); // ab32 // 문자 + 숫자

        // String클래스 특징: 불변성
        String str2 = "add";
        str2 = "bdd";
        System.out.println(str2); // bdd 인데 b로 수정된게아니라 새로 인스턴스 생성되서 대체된거.
        str2.replace('b', 'c'); // 이것도 인스턴스 새로 생성되서 대체된거.

        /** 문자열비교 */
        String a = "50";
        String b = String.valueOf(50);
        System.out.println(a == b); // false  == 는 참조값이 같은지 확인.
        System.out.println(a.equals(b));// true equlas는 참조값이아닌 같은값을 갖는지 확인.

        /**String 메서드*/
        String str3 = "apple V";
        str3.length();
        str3.charAt(2);
        str3.indexOf('p'); // 1
        str3.lastIndexOf('p'); // 2
        str3.substring(1,4); // ppl    (1 ~ 3)
        str3.replaceAll("[ap]", "z"); // replaceAll(정규표현식, 대체값) zzzle
        str3.replace('p', 'b'); // abble
        str3.contains("ppl"); // true;
        String[] str3Split = str3.split(" ");
        for (String string : str3Split) {
            System.out.println(string); // apple
                                        // V
        }

        str3.trim(); // 문자열 앞뒤 공백, \n 제거
        str3.toUpperCase(); // APPLE V
        str3.toLowerCase(); // apple v
        char[] charArray = str3.toCharArray(); // String -> char[]
        str3.startsWith("a"); // str3가 a로 시작하는지 확인 true, false
        str3.endsWith("b"); // str3가 b로 끝나는지 확인. true, false

        /**StringBuilder*/
        // String클래스는 매번 새로운인스턴스 생성해 대체되므로 비효율
        // 그래서 -> StringBuilder는 수정가능한 문자열 클래스(새로운 인스턴스 생성x)
        StringBuilder sb2 = new StringBuilder("hi zz c"); // 초기값 설정
        StringBuilder sb = new StringBuilder();
        sb.append("hi");
        sb.append(" my name");
        sb.reverse(); // 뒤집기 eman ym ih
        sb.delete(0,3); // 0~2 까지 범위 문자 제거 n ym ih
        sb.insert(6,"java"); // 6번쨰 위치에 삽입 n ym ijavah
        sb.deleteCharAt(2); // n m ijavah
        sb.setCharAt(2,'w'); // 2번쨰 문자 대체 n w ijavah
        sb.setLength(5); // sb는 5글자로 제한. n w i  계속 sb는 제한됨.

        /**String -> int로 변경*/
        String input = "3 -5 10.4";
        String[] split = input.split(" ");
        int num = Integer.parseInt(split[0]); // 3
        int num5 = Integer.parseInt(split[1]); // -5
        double num3 = Integer.parseInt(split[2]); // 10.4




    }
}
