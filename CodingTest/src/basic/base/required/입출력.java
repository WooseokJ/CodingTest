package basic.base.required;

import java.util.*; // 필수(ArrayList, Scanner )
import java.io.*; // 입출력 사용시만. (BufferedReader, InputStreamReader)


public class 입출력 {
    public static void main(String[] args) throws IOException{ // 자바 입출력시 BufferedReader, BufferedWriter는 체크예외라 적어줌.

        /**입력: Scanner대신 BufferedReader로 입력받기**/
        Scanner sc = new Scanner(System.in);
//        sc.next(); // "hello"
//        sc.nextInt(); // 1
//        sc.nextFloat(); // 20.4
//        sc.nextLine(); // "hello word"

        // Scanner보단 입력데이터 많으면 BufferedReader를 활용하는게 더 좋아.

        // System.in: 입력과 연결된 입력스트림
        // InputStreamReader: 입력 스트림에서 문자를 읽어올수있게 해주는 클래스
        // BufferedReader: 버퍼링 이용해 입력 효용 높이는 클래스

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // 첫 줄 입력받기
        String[] line = reader.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        // 나머지 데이터 입력받기
        int[][] data = new int[n][m];
        for(int i =0 ;i < n ; i++) {
            line = reader.readLine().split(" ");
            for(int j = 0 ; j < m ; j++) {
                data[i][j] = Integer.parseInt(line[j]);
            }
        }

        /**입력: Scanner대신 BufferedReader로 입력받기**/
        // System.out.println() 대신 출력량 많을떄는 BufferedWriter 사용.
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write("AAA");
        writer.newLine(); // 줄바꿈,
        writer.flush(); // 중요(안하면 출력안됨)
    }
}
