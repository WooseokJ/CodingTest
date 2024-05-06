package basic.base.required;

public class 커스텀클래스 {
    public static void main(String[] args) {
        /**커스텀 클래스 내부에 선언*/
        Point point = new Point(1, 2);
        int x = point.x;// 접근가능 ( 이유: 커스텀클래스 안에 Point가 선언되어있어서 모든 필드,메서드 자신의 맴버처럼 접근가능)

        /** 커스텀 클래스 밖에 선언*/
        Point2 point2 = new Point2(1,2);
        int x2=  point2.x;
    }

    // 직접 클래스 구현시(그래프 노드) static 클래스로 저으이
    static class Point  {
        private int x;
        private int y;

        public Point(int x, int y ) {
            this.x = x;
            this.y = y;
        }
    }
}

class Point2  {
    public int x; // private 두면 get, set 필요.
    public int y;

    public Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
