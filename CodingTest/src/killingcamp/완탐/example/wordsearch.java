package killingcamp.완탐.example;

public class wordsearch {
    static char[][] board = {
            {'A', 'B','C', 'E' },
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
    };
    static String word = "ABCCED";
    static int n = board.length;
    static int m = board[0].length;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean[][] visited = new boolean[n][m];

    public static void main(String[] args) {
        System.out.println(exist(board,word));
    }

    public static boolean exist(char[][] board, String word) {

        for(int i = 0; i< n; i++) {
            for(int j = 0; j < n; j++) {
                if(backtracking(i,j,0)){
                    return true;
                }
            }
        }
        return false;



    }

    public static boolean backtracking(int i, int j, int w) {
        boolean flag = false;
        if (!visited[i][j] && board[i][j] == word.charAt(w)) {
            if (w == word.length() -1) {
                return true;
            }
            visited[i][j] = true;


            for (int r = 0; r < 4; r++) {
                int cur_x = dx[r];
                int cur_y = dy[r];
                if ((0 <= cur_x && cur_x < n) && (0 <= cur_y && cur_y < n) ) {
                    if(backtracking(cur_x+r, cur_y + r, w+1)){
                        flag = true;
                    }
                }
                visited[i][j] = false;
            }
        }
        return flag;
    }
}
