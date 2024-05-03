package killingcamp.완탐.example;

public class wordsearch {
    static int[] dr = {0,0,1,-1};
    static int[] dc = {1,-1,0,0};
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S','F', 'C','S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board, "ABCCED"));

    }
    public static boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for(int r = 0; r < n ; r++) {
            for(int c = 0; c < m; c++) {
                if(board[r][c] == word.charAt(0)) {
                    char temp = board[r][c];
                    board[r][c] = ' ';
                    if(backtrack(board, word, r, c, 0)) {
                        return true;
                    }
                    board[r][c] = temp;
                }
            }
        }
        return false;
    }
    public static boolean backtrack(char[][] board, String word, int r, int c, int depth) {
        if(depth +1  == word.length()) {return true;}
        int n = board.length;
        int m = board[0].length;
        for(int i = 0 ; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(isValid(nr, nc, n, m)) {
                if(board[nr][nc]==word.charAt(depth+1)) {
                    char temp = board[nr][nc];
                    board[nr][nc] = ' ';
                    if(backtrack(board, word, nr, nc, depth + 1)) {
                        return true;
                    }
                    board[nr][nc] = temp;
                }
            }
        }
        return false;
    }
    public static boolean isValid(int nr, int nc, int n, int m) {
        if((0 <= nr && nr < n) && (0 <= nc && nc < m)) {
            return true;
        }
        return false;
    }
}
