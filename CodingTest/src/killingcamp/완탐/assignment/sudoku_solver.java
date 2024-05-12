package killingcamp.완탐.assignment;

public class sudoku_solver {
    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        solveSudoku(board);
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.printf("%c ",aChar);
            }
            System.out.println();
        }
    }

    private static void solveSudoku(char[][] board) {
        backtrack(board, 0);
    }

    private static boolean backtrack(char[][] board, int n){
        if(n== 81 ) return true;
        int row = n / 9;
        int col = n % 9;
        if(board[row][col] == '.') {
            for(char num = '1' ; num <= '9' ; num++) {
                if(isValid(row, col, num, board)) {
                    board[row][col] = num;
                    if(backtrack(board, n+1)) return true;
                    board[row][col] = '.';
                }
            }
            return false;
        } else {
            return backtrack(board, n+1);
        }

    }
    private static boolean isValid(int row, int col, char num, char[][] board) {
        for(int i =0 ;i < 9; i++) {
            // 가로, 세로 행열 숫자 판별 (이미 사용된적있는수이면 false반환)
            if( (board[i][col]) == num  || (board[row][i] == num)  ) return false;

            // 3 * 3 숫자 판별 (3*3안에서 이미 사용된적있는 수이면 false반환)
//            int in_row = 3 * (row / 3) + i /3;
//            int in_col = 3 * (col /3) + i % 3;
//            if(board[in_row][in_col] == num) return false;

            int in_row = 3 * (row / 3);
            int in_col = 3 * (col / 3);
            for(int dr = 0 ; dr <3; dr++)
                for(int dc = 0; dc <3; dc++)
                    if(board[in_row+dr][in_col+dc] == num) return false;

        }
        return true;
    }
}
