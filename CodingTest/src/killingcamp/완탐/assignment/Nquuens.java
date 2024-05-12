package killingcamp.완탐.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Nquuens {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        // n * n
        char[][] board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        int curr_cnt = 0 ;
        backtrack(0,n,curr_cnt, board, ans);
        return ans;
    }

    public static void backtrack(int row, int n, int curr_cnt, char[][] board, List<List<String>> ans ) {
        if(curr_cnt == n) { // row가 마지막 일떄
            List<String> a = new ArrayList<>();
            for(char[] r: board)
                a.add(new String(r));
            System.out.println("a = " + a);
            ans.add(a);
            curr_cnt = 0; //초기화
            return ;

        }

        // row는 정해졋고 col을 순회
        int colLen = board[0].length;
        for(int col = 0; col < colLen ; col++) {
            if(isValid(row, col, board, n)) {
                board[row][col] = 'Q';
                backtrack(row+1, col,curr_cnt + 1, board, ans);
                board[row][col] = '.';
            }
        }

    }
    public static boolean isValid(int row, int col, char[][] board, int n) {
        // 열 확인 ⬆️
        for(int i =0 ;i < row ; i++) {
            if(board[i][col] == 'Q') return false;
        }
        // 왼쪽 대각선 확인 ↖️
        for(int i= row -1, j=col-1 ; i >= 0 && j >= 0 ; i--,j--) { // row-1 은 위로, col-1은 왼쪽, i, j >= 0 은 벽만날떄까지.
            if(board[i][j] == 'Q') return false;
        }
        //오른쪽 대각선 ↗️
        for(int i = row -1, j= col+1; i>=0 && j <n;i--,j++) { // row -1 은 위로 , col+1은 오른쪽  i>=0, j <n은 벽만날떄까지
            if(board[i][j] == 'Q') return false;
        }
        return true;

    }
}
